package com.richeninfo.rubbish.service.quartz;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.richeninfo.rubbish.entity.enums.ApplyStatusEnum;
import com.richeninfo.rubbish.entity.enums.TransferStationApplyEnum;
import com.richeninfo.rubbish.entity.enums.VehicleAppointEnum;
import com.richeninfo.rubbish.entity.model.*;
import com.richeninfo.rubbish.service.*;
import com.richeninfo.rubbish.service.util.SpringUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

//import com.richeninfo.mediaudit.entity.model.*;
//import com.richeninfo.mediaudit.service.*;
//import com.richeninfo.mediaudit.service.util.SpringUtils;

/**
 * 定時任務
 */
public class TransferStationApplyJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(TransferStationApplyJob.class);

    @Resource
    private PlaceInfoService placeInfoService;

    @Resource
    private VehicleLocuService vehicleLocuService;

    @Resource
    private ApplyService applyService;

    @Resource
    private VehicleAppointService vehicleAppointService;

    @Resource
    private TransferStationApplyService transferStationApplyService;

    public TransferStationApplyJob(){
        placeInfoService  =  SpringUtils.getBean(PlaceInfoService.class);
        vehicleLocuService  =  SpringUtils.getBean(VehicleLocuService.class);
        applyService  =  SpringUtils.getBean(ApplyService.class);
        vehicleAppointService  =  SpringUtils.getBean(VehicleAppointService.class);
        transferStationApplyService=SpringUtils.getBean(TransferStationApplyService.class);
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        JobDataMap jobDataMap = arg0.getJobDetail().getJobDataMap();
        TransferStationApply transferStationApply=(TransferStationApply)jobDataMap.get("transferstationapply");
        int placeId=106;
        PlaceInfo placeInfo=placeInfoService.selectById(placeId);
        EntityWrapper<VehicleLocu> vehicleLocuEntityWrapper=new EntityWrapper<>();
        vehicleLocuEntityWrapper.eq("facility_no",transferStationApply.getFacilityNo());
        vehicleLocuEntityWrapper.orderBy("current_time desc");
        Page<VehicleLocu> vehicleLocuPage=new Page<>(1,1);
        Page<VehicleLocu> vehicleLocuPage1=vehicleLocuService.selectPage(vehicleLocuPage,vehicleLocuEntityWrapper);
        VehicleLocu vehicleLocu=vehicleLocuPage1.getRecords().size()>0?vehicleLocuPage1.getRecords().get(0):null;
        if(null!=vehicleLocu){
            double distance=GeoUtil.getDistanceOfMeter(vehicleLocu.getLatitude(),vehicleLocu.getLongitude(),placeInfo.getLatitude(),placeInfo.getLongitude());
            if(distance<100){
                //执行完成以后移除任务
                QuartzManager.removeJob(arg0.getScheduler(), arg0.getJobDetail().getName());
                transferStationApply.setStatus(TransferStationApplyEnum.End.getCode());
                transferStationApply.setLastupdatedTime(new Date());
                transferStationApplyService.updateById(transferStationApply);
            }
        }

    }


}