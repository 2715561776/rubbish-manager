/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.richeninfo.rubbish.entity.model.PlaceInfo;
import com.richeninfo.rubbish.entity.model.TransferStationApply;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.service.PlaceInfoService;
import com.richeninfo.rubbish.service.TransferStationApplyService;
import com.richeninfo.rubbish.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /transferstationapply/query      	=> query()		分页查询
 * /transferstationapply/findById       => findById()	查询单条数据
 * /transferstationapply/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /transferstationapply/delete	POST    => delete()		单条数据删除
 * /transferstationapply/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/transferstationapply")
public class TransferStationApplyController {
	private static final Logger logger = LoggerFactory.getLogger(TransferStationApplyController.class);

	@Autowired
	private TransferStationApplyService transferStationApplyService;

	@Resource
	private VehicleService vehicleService;

	@Resource
	private PlaceInfoService placeInfoService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		TransferStationApply transferstationapply = request.getObject(TransferStationApply.class);
		Page<TransferStationApply> pageList = this.transferStationApplyService.selectPage(page, new EntityWrapper(transferstationapply));
		List<TransferStationApply> transferStationApplyList=new ArrayList<TransferStationApply>();

		for(TransferStationApply transferStationApply:pageList.getRecords()){
			PlaceInfo placeInfo=placeInfoService.selectById(transferStationApply.getPlaceId());
			transferStationApply.setPlaceInfo(placeInfo);
//			transferStationApplyList.add(transferStationApply);
		}
//		pageList.setRecords(transferStationApplyList);
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody TransferStationApply transferstationapply){
		transferstationapply = this.transferStationApplyService.selectById(transferstationapply.getId());
		return JsonResult.newSuccess(transferstationapply);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody TransferStationApply transferstationapply){
		try {
			this.transferStationApplyService.insertOrUpdate(transferstationapply);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(transferstationapply);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody TransferStationApply transferstationapply) {
		this.transferStationApplyService.deleteById(transferstationapply.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.transferStationApplyService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	/** 新增TransferStationApply */
	@RequestMapping(value="/insertTransferStationApply",method=RequestMethod.POST)
	public JsonResult insertTransferStationApply(@RequestBody JsonRequest request){
		try {
			Vehicle vehicle=vehicleService.selectById(request.getInteger("vehicleId",10));
			boolean b=this.transferStationApplyService.insertTransferStationApply(request.getDouble("weight"),vehicle,request.getInteger("placeInfoId",10));
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess("");
	}
}

