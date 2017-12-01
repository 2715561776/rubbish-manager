/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.richeninfo.rubbish.entity.enums.PlaceInfoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.richeninfo.rubbish.entity.model.*;

import com.richeninfo.rubbish.service.PlaceInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import java.util.Date;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /placeinfo/query      	=> query()		分页查询
 * /placeinfo/findById       => findById()	查询单条数据
 * /placeinfo/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /placeinfo/delete	POST    => delete()		单条数据删除
 * /placeinfo/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/placeinfo")
public class PlaceInfoController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceInfoController.class);

	@Autowired
	private PlaceInfoService placeInfoService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String input=request.getString("input","");

		PlaceInfo placeinfo = request.getObject(PlaceInfo.class);
		EntityWrapper<PlaceInfo> placeInfoEntityWrapper=new EntityWrapper<>();
		if(!input.equals("")){
			input="%"+input+"%";
			placeInfoEntityWrapper.and("name like {0}  or contacter like {0}",input);
		}
		Page<PlaceInfo> pageList = this.placeInfoService.selectPage(page, placeInfoEntityWrapper);
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody PlaceInfo placeinfo){
		placeinfo = this.placeInfoService.selectById(placeinfo.getId());
		return JsonResult.newSuccess(placeinfo);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody PlaceInfo placeinfo){
		try {
			Date date=new Date();
			if(placeinfo.getId()!=null) {
				placeinfo.setLastupdatedTime(date);
				placeinfo.setLastupdatedBy("admin");
			}else {
				placeinfo.setCreatedTime(date);
				placeinfo.setLastupdatedTime(date);
				placeinfo.setCreatedBy("admin");
				placeinfo.setLastupdatedBy("admin");
			}
			this.placeInfoService.insertOrUpdate(placeinfo);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(placeinfo);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody PlaceInfo placeinfo) {
		this.placeInfoService.deleteById(placeinfo.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.placeInfoService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	/** 按场地名称查询 */
	@RequestMapping(value="/queryPlaceInfoByName",method=RequestMethod.POST)
	public JsonResult queryPlaceInfoByName(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String inputName=request.getString("inputPlaceInfoName","");
		EntityWrapper<PlaceInfo> placeInfoEntityWrapper=new EntityWrapper<>();
		if(inputName!=null && !inputName.trim().equals("")) {
			inputName="%"+inputName+"%";
			placeInfoEntityWrapper.and("(type = {0}  or type = {1}) and name like {2}", PlaceInfoEnum.BusinessArea.getCode(), PlaceInfoEnum.ResidentialArea.getCode(),inputName);
		}
		List<PlaceInfo> placeInfoList=this.placeInfoService.selectList(placeInfoEntityWrapper);
		return JsonResult.newSuccess(placeInfoList);
	}

	/** 按场地名称查询 */
	@RequestMapping(value="/queryPlaceInfoByName1",method=RequestMethod.GET)
	public List<PlaceInfo> queryPlaceInfoByName1(String inputPlaceInfoName) {
		Page page = new Page(1,10);
		String inputName=inputPlaceInfoName;
		EntityWrapper<PlaceInfo> placeInfoEntityWrapper=new EntityWrapper<>();
		if(inputName!=null && !inputName.trim().equals("")) {
			inputName="%"+inputName+"%";
			placeInfoEntityWrapper.and("(type = {0}  or type = {1}) and name like {2}", PlaceInfoEnum.BusinessArea.getCode(), PlaceInfoEnum.ResidentialArea.getCode(),inputName);
		}
		List<PlaceInfo> placeInfoList=this.placeInfoService.selectList(placeInfoEntityWrapper);
		return placeInfoList;
	}
}

