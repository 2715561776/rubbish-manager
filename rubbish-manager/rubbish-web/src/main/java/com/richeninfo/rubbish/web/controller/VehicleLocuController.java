/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.richeninfo.rubbish.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.richeninfo.rubbish.entity.model.*;

import com.richeninfo.rubbish.service.VehicleLocuService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /vehiclelocu/query      	=> query()		分页查询
 * /vehiclelocu/findById       => findById()	查询单条数据
 * /vehiclelocu/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /vehiclelocu/delete	POST    => delete()		单条数据删除
 * /vehiclelocu/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/vehiclelocu")
public class VehicleLocuController {
	private static final Logger logger = LoggerFactory.getLogger(VehicleLocuController.class);

	@Autowired
	private VehicleLocuService vehicleLocuService;

	@Resource
	private VehicleService vehicleService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		VehicleLocu vehiclelocu = request.getObject(VehicleLocu.class);
		int id=request.getInteger("id");
		EntityWrapper<VehicleLocu> vehicleLocuEntityWrapper=new EntityWrapper<>();
		vehicleLocuEntityWrapper.eq("apply_id",id);
		List<VehicleLocu> vehicleLocuList=vehicleLocuService.selectList(vehicleLocuEntityWrapper);
//		Page<VehicleLocu> pageList = this.vehicleLocuService.selectPage(page,vehicleLocuEntityWrapper);
		page.setRecords(vehicleLocuList);
		return JsonResult.newSuccess(page);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody VehicleLocu vehiclelocu){
		vehiclelocu = this.vehicleLocuService.selectById(vehiclelocu.getId());
		return JsonResult.newSuccess(vehiclelocu);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody VehicleLocu vehiclelocu){
		try {
			this.vehicleLocuService.insertOrUpdate(vehiclelocu);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(vehiclelocu);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody VehicleLocu vehiclelocu) {
		this.vehicleLocuService.deleteById(vehiclelocu.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.vehicleLocuService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	@RequestMapping(value="queryLastVehicleLocu",method=RequestMethod.POST)
	public JsonResult queryLastVehicleLocu(@RequestBody JsonRequest request) {
		int id = request.getIntValue("id");
		Vehicle vehicle=vehicleService.selectById(id);
		EntityWrapper<VehicleLocu> entityWrapper=new EntityWrapper<>();
		entityWrapper.eq("facility_no",vehicle.getFacilityNo());
		entityWrapper.orderBy("created_time desc");
		Page<VehicleLocu> vehicleLocuPage=vehicleLocuService.selectPage(new Page<>(1,1),entityWrapper);
		VehicleLocu vehicleLocu=vehicleLocuPage.getRecords().size()>0?vehicleLocuPage.getRecords().get(0):null;
		return JsonResult.newSuccess(vehicleLocu);
	}
}

