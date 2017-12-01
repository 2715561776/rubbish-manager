/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.VehicleAppointMapper;
import com.richeninfo.rubbish.entity.model.VehicleAppoint;
import com.richeninfo.rubbish.service.quartz.QuartzManager;
import com.richeninfo.rubbish.service.quartz.VehicleAppointJob;
import com.richeninfo.rubbish.service.util.CronDateUtils;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * VehicleAppoint 表数据服务层接口实现类
 *
 */
@Service("vehicleAppointService")
public class VehicleAppointService extends ServiceImpl<VehicleAppointMapper, VehicleAppoint>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

    public Page<VehicleAppoint> selectVehicleAppointWithPlaceInfo(Page page, EntityWrapper entityWrapper) {
		List<VehicleAppoint> vehicleAppointList=baseMapper.selectVehicleAppointWithPlaceInfo(page,entityWrapper);
        page.setRecords(vehicleAppointList);
        return page;
	}

	/**
     * 注册定时任务
	 */
    public void addVehicleAppointJob(VehicleAppoint vehicleappoint) throws SchedulerException {

        SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
        Scheduler sche = gSchedulerFactory.getScheduler();
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("vehicleAppoint", vehicleappoint);
        Date date=vehicleappoint.getArrivalTime();
        Long dateTime=date.getTime()-30*60*1000;
        Date cronDate=new Date(dateTime);
        String cronDateTemp= CronDateUtils.getCron(cronDate);
        String cronDateTrue=cronDateTemp.substring(0,5)+"/1"+cronDateTemp.substring(5);
        QuartzManager.addJob(sche,String.valueOf(vehicleappoint.getId()), VehicleAppointJob.class, cronDateTrue, jobDataMap);
        System.out.println(11);
    }
}