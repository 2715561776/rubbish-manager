package com.richeninfo.rubbish.service.quartz;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.richeninfo.mediaudit.entity.model.*;
//import com.richeninfo.mediaudit.service.*;
//import com.richeninfo.mediaudit.service.util.SpringUtils;
import com.baomidou.mybatisplus.plugins.Page;
import com.richeninfo.rubbish.entity.enums.ApplyStatusEnum;
import com.richeninfo.rubbish.entity.enums.VehicleAppointEnum;
import com.richeninfo.rubbish.entity.model.Apply;
import com.richeninfo.rubbish.entity.model.PlaceInfo;
import com.richeninfo.rubbish.entity.model.VehicleAppoint;
import com.richeninfo.rubbish.entity.model.VehicleLocu;
import com.richeninfo.rubbish.service.ApplyService;
import com.richeninfo.rubbish.service.PlaceInfoService;
import com.richeninfo.rubbish.service.VehicleAppointService;
import com.richeninfo.rubbish.service.VehicleLocuService;
import com.richeninfo.rubbish.service.util.SpringUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 定時任務
 */
public class VehicleAppointJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(VehicleAppointJob.class);

    @Resource
    private PlaceInfoService placeInfoService;

    @Resource
    private VehicleLocuService vehicleLocuService;

    @Resource
    private ApplyService applyService;

    @Resource
    private VehicleAppointService vehicleAppointService;

    public VehicleAppointJob(){
        placeInfoService  =  SpringUtils.getBean(PlaceInfoService.class);
        vehicleLocuService  =  SpringUtils.getBean(VehicleLocuService.class);
        applyService  =  SpringUtils.getBean(ApplyService.class);
        vehicleAppointService  =  SpringUtils.getBean(VehicleAppointService.class);
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        JobDataMap jobDataMap = arg0.getJobDetail().getJobDataMap();
        VehicleAppoint vehicleAppoint=(VehicleAppoint)jobDataMap.get("vehicleAppoint");
        int placeId=vehicleAppoint.getPlaceId();
        PlaceInfo placeInfo=placeInfoService.selectById(placeId);
        EntityWrapper<VehicleLocu> vehicleLocuEntityWrapper=new EntityWrapper<>();
        vehicleLocuEntityWrapper.eq("facility_no",vehicleAppoint.getFacilityNo());
        vehicleLocuEntityWrapper.orderBy("current_time desc");
        Page<VehicleLocu> vehicleLocuPage=new Page<>(1,1);
        Page<VehicleLocu> vehicleLocuPage1=vehicleLocuService.selectPage(vehicleLocuPage,vehicleLocuEntityWrapper);
        VehicleLocu vehicleLocu=vehicleLocuPage1.getRecords().size()>0?vehicleLocuPage1.getRecords().get(0):null;
        if(null!=vehicleLocu){
            double distance=GeoUtil.getDistanceOfMeter(vehicleLocu.getLatitude(),vehicleLocu.getLongitude(),placeInfo.getLatitude(),placeInfo.getLongitude());
            if(distance<100){
                //执行完成以后移除任务
                QuartzManager.removeJob(arg0.getScheduler(), arg0.getJobDetail().getName());
                //往行程单插入一条记录
                Apply apply=new Apply();
                apply.setType(0);   //0表示从垃圾源头到中转站   1 表示从中转站到焚烧厂
                apply.setCreatedTime(new Date());
                apply.setLastupdatedTime(new Date());
                apply.setStartTime(new Date());//行程单开始时间
                apply.setStatus(ApplyStatusEnum.Begin.getCode());//开始
                apply.setSimNo(vehicleLocu.getFacilityNo());
                applyService.insert(apply);
                vehicleAppoint.setApplyId(apply.getId());
                vehicleAppoint.setStatus(VehicleAppointEnum.Working.getCode());
                vehicleAppointService.updateById(vehicleAppoint);
            }
        }

    }


}