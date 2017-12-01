/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.richeninfo.rubbish.entity.model.*;

import com.richeninfo.rubbish.service.VehicleArrivePlaceService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /vehiclearriveplace/query      	=> query()		分页查询
 * /vehiclearriveplace/findById       => findById()	查询单条数据
 * /vehiclearriveplace/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /vehiclearriveplace/delete	POST    => delete()		单条数据删除
 * /vehiclearriveplace/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/vehiclearriveplace")
public class VehicleArrivePlaceController {
	private static final Logger logger = LoggerFactory.getLogger(VehicleArrivePlaceController.class);

	@Autowired
	private VehicleArrivePlaceService vehiclearriveplaceService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		VehicleArrivePlace vehiclearriveplace = request.getObject(VehicleArrivePlace.class);
		Page<VehicleArrivePlace> pageList = this.vehiclearriveplaceService.selectPage(page, new EntityWrapper(vehiclearriveplace));
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody VehicleArrivePlace vehiclearriveplace){
		vehiclearriveplace = this.vehiclearriveplaceService.selectById(vehiclearriveplace.getId());
		return JsonResult.newSuccess(vehiclearriveplace);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody VehicleArrivePlace vehiclearriveplace){
		try {
			this.vehiclearriveplaceService.insertOrUpdate(vehiclearriveplace);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(vehiclearriveplace);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody VehicleArrivePlace vehiclearriveplace) {
		this.vehiclearriveplaceService.deleteById(vehiclearriveplace.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.vehiclearriveplaceService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}
}

