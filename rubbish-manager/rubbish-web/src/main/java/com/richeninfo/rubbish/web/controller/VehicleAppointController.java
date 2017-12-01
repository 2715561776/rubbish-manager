/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.entity.model.VehicleAppoint;
import com.richeninfo.rubbish.service.PlaceInfoService;
import com.richeninfo.rubbish.service.VehicleAppointService;
import com.richeninfo.rubbish.service.quartz.QuartzManager;
import com.richeninfo.rubbish.service.quartz.VehicleAppointJob;
import com.richeninfo.rubbish.service.util.CronDateUtils;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import javax.annotation.Resource;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /vehicleappoint/query      	=> query()		分页查询
 * /vehicleappoint/findById       => findById()	查询单条数据
 * /vehicleappoint/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /vehicleappoint/delete	POST    => delete()		单条数据删除
 * /vehicleappoint/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@Controller
@RequestMapping("/vehicleappoint")
public class VehicleAppointController {
	private static final Logger logger = LoggerFactory.getLogger(VehicleAppointController.class);

	@Autowired
	private VehicleAppointService vehicleAppointService;

	@Resource
	private PlaceInfoService placeInfoService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		VehicleAppoint vehicleappoint = request.getObject(VehicleAppoint.class);
		String input=request.getString("input","");
		EntityWrapper<VehicleAppoint> vehicleAppointEntityWrapper=new EntityWrapper<VehicleAppoint>();
		if(!input.equals("")){
			input="%"+input+"%";
			vehicleAppointEntityWrapper.and("rva.ESTIMATE_WEIGHT like {0}  or rva.CARD_NUMBER like {0} or rva.ESTIMATE_DRIVER like {0} or rva.ESTIMATE_DRIVER_PHONE like {0} or rva.FACILITY_NO like {0} or rpi.NAME like {0}",input);
		}
		Page<VehicleAppoint> pageList = this.vehicleAppointService.selectVehicleAppointWithPlaceInfo(page, vehicleAppointEntityWrapper);
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody VehicleAppoint vehicleappoint){
		vehicleappoint = this.vehicleAppointService.selectById(vehicleappoint.getId());
		return JsonResult.newSuccess(vehicleappoint);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody VehicleAppoint vehicleappoint){
		try {
			this.vehicleAppointService.insertOrUpdate(vehicleappoint);
			vehicleAppointService.addVehicleAppointJob(vehicleappoint);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(vehicleappoint);
	}



	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody VehicleAppoint vehicleappoint) {
		this.vehicleAppointService.deleteById(vehicleappoint.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.vehicleAppointService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}
}

