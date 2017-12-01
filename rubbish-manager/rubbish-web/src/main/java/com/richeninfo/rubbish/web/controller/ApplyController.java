/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.richeninfo.rubbish.entity.enums.ApplyStatusEnum;
import com.richeninfo.rubbish.entity.model.Apply;
import com.richeninfo.rubbish.entity.model.VehicleAppoint;
import com.richeninfo.rubbish.service.ApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import java.util.Date;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /apply/query      	=> query()		分页查询
 * /apply/findById       => findById()	查询单条数据
 * /apply/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /apply/delete	POST    => delete()		单条数据删除
 * /apply/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/apply")
public class ApplyController {
	private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);

	@Autowired
	private ApplyService applyService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String input=request.getString("input","");
		EntityWrapper<Apply> applyEntityWrapper=new EntityWrapper<Apply>();
		applyEntityWrapper.eq("type",0);
		if(!input.equals("")){
			input="%"+input+"%";
			applyEntityWrapper.and("WEIGHT like {0}  or LICENSE_PLAT_NUMBER like {0} or sim_no like {0}",input);
		}
		applyEntityWrapper.orderBy("created_time desc");
		Page<Apply> pageList = this.applyService.selectApplyInOrOut(page, applyEntityWrapper);
//		Page<Apply> pageList = this.applyService.selectPage(page, applyEntityWrapper);
		return JsonResult.newSuccess(pageList);
	}

	/** 分页查询 */
	@RequestMapping(value="/queryOut",method=RequestMethod.POST)
	public JsonResult queryOut(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String input=request.getString("input","");
		EntityWrapper<Apply> applyEntityWrapper=new EntityWrapper<Apply>();
		applyEntityWrapper.eq("type",1);
		if(!input.equals("")){
			input="%"+input+"%";
			applyEntityWrapper.and("WEIGHT like {0}  or LICENSE_PLAT_NUMBER like {0} or sim_no like {0}",input);
		}
		applyEntityWrapper.orderBy("created_time desc");
		Page<Apply> pageList = this.applyService.selectApplyInOrOut(page, applyEntityWrapper);
//		Page<Apply> pageList = this.applyService.selectPage(page, applyEntityWrapper);
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody Apply apply){
		apply = this.applyService.selectById(apply.getId());
		return JsonResult.newSuccess(apply);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody Apply apply){
		try {
			if(null!=apply.getId()){
				apply.setStatus(ApplyStatusEnum.End.getCode());
				apply.setEndTime(new Date());
			}
			this.applyService.insertOrUpdate(apply);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(apply);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody Apply apply) {
		this.applyService.deleteById(apply.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.applyService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	/** 分页查询 */
	@RequestMapping(value="/queryById",method=RequestMethod.POST)
	public JsonResult queryById(@RequestBody JsonRequest request) {
		EntityWrapper<Apply> applyEntityWrapper=new EntityWrapper<>();
		String id=request.getString("applyId");
		applyEntityWrapper.like("id",id);
		applyEntityWrapper.eq("status",1);
		List<Apply> applyList=this.applyService.selectList(applyEntityWrapper);
		Page<Apply> pageList = new Page<>();
		pageList.setRecords(applyList);
		return JsonResult.newSuccess(pageList);
	}
}

