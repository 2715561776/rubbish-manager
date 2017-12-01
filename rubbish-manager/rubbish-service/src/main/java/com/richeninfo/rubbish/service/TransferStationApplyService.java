/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.TransferStationApplyMapper;
import com.richeninfo.rubbish.entity.model.TransferStationApply;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.service.quartz.QuartzManager;
import com.richeninfo.rubbish.service.quartz.TransferStationApplyJob;
import com.richeninfo.rubbish.service.quartz.VehicleAppointJob;
import com.richeninfo.rubbish.service.util.CronDateUtils;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * TransferStationApply 表数据服务层接口实现类
 *
 */
@Service("transferStationApplyService")
public class TransferStationApplyService extends ServiceImpl<TransferStationApplyMapper, TransferStationApply>{

	@Autowired
	private TransferStationApplyService transferStationApplyService;

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

    public boolean  insertTransferStationApply(Double weight, Vehicle vehicle, int placeInfoId) {
		TransferStationApply transferStationApply=new TransferStationApply();
		transferStationApply.setWeight(weight);
		transferStationApply.setVehicleId(vehicle.getId());
		transferStationApply.setCardNumber(vehicle.getLicensePlatNumber()); //车牌号
		transferStationApply.setDriver(vehicle.getDriverName());
		transferStationApply.setDriverPhone(vehicle.getDriverPhone());
		transferStationApply.setFacilityId(vehicle.getFacilityId());
		transferStationApply.setFacilityNo(vehicle.getFacilityNo());
		transferStationApply.setFacilityName(vehicle.getFacilityName());
		transferStationApply.setPlaceId(placeInfoId);
		transferStationApply.setCreatedTime(new Date());
		transferStationApply.setLastupdatedTime(new Date());
		if(null==transferStationApply.getApplyId()){
			//注册定时任务
			try {
				transferStationApplyService.addTransferStationApplyJob(transferStationApply);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return  this.insertOrUpdate(transferStationApply);
    }

    public List<TransferStationApply> selectListByStutus(EntityWrapper<TransferStationApply> transferStationApplyEntityWrapper) {
		return this.baseMapper.selectListByStutus(transferStationApplyEntityWrapper);
    }

    public void addTransferStationApplyJob(TransferStationApply transferstationapply)  throws SchedulerException {

		SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
		Scheduler sche = gSchedulerFactory.getScheduler();
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("transferstationapply", transferstationapply);
		Date date=new Date(new Date().getTime()+60*1000);
		String cronDateTemp= CronDateUtils.getCron(date);
		String cronDateTrue=cronDateTemp.substring(0,5)+"/1"+cronDateTemp.substring(5);
		QuartzManager.addJob(sche,String.valueOf(transferstationapply.getId()), TransferStationApplyJob.class, cronDateTrue, jobDataMap);
		System.out.println(11);
    }

}