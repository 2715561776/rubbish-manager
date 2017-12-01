/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.richeninfo.rubbish.entity.model.*;

import com.richeninfo.rubbish.service.VehicleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import java.util.Date;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /vehicle/query      	=> query()		分页查询
 * /vehicle/findById       => findById()	查询单条数据
 * /vehicle/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /vehicle/delete	POST    => delete()		单条数据删除
 * /vehicle/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleService vehicleService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String input=request.getString("input","");
		EntityWrapper<Vehicle> vehicleEntityWrapper=new EntityWrapper<>();
		if(!input.equals("")){
			input="%"+input+"%";
			vehicleEntityWrapper.and("rv.MOTORCADE_NAME like {0}  or rv.LICENSE_PLAT_NUMBER like {0} or rv.FACILITY_NAME like {0} or rv.FACILITY_ID like {0} or rv.SIM_NO like {0} or DRIVER_NAME like {0} or rbci.company_name like {0}",input);
		}
		Vehicle vehicle = request.getObject(Vehicle.class);
		Page<Vehicle> pageList = this.vehicleService.selectVehicleListWithBiddingCompany(page, vehicleEntityWrapper);
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody Vehicle vehicle){
		vehicle = this.vehicleService.selectById(vehicle.getId());
		return JsonResult.newSuccess(vehicle);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody Vehicle vehicle){
		try {
			Date date=new Date();
			if(vehicle.getId()!=null) {
				vehicle.setLastupdatedTime(date);
				vehicle.setLastupdatedBy("admin");
			}else {
				vehicle.setCreatedTime(date);
				vehicle.setLastupdatedTime(date);
				vehicle.setCreatedBy("admin");
				vehicle.setLastupdatedBy("admin");
			}
			this.vehicleService.insertOrUpdate(vehicle);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(vehicle);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody Vehicle vehicle) {
		this.vehicleService.deleteById(vehicle.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.vehicleService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	/** 按驾驶员姓名模糊查询 */
	@RequestMapping(value="/queryByDriverName",method=RequestMethod.POST)
	public JsonResult queryByDriverName(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String inputDriverName=request.getString("inputDriverName","");
		EntityWrapper<Vehicle> vehicleEntityWrapper=new EntityWrapper<>();
		vehicleEntityWrapper.like("DRIVER_NAME",inputDriverName);
		List<Vehicle> vehicleList=this.vehicleService.selectList(vehicleEntityWrapper);
		return JsonResult.newSuccess(vehicleList);
	}

}

