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

import com.richeninfo.rubbish.service.BiddingCompanyInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /biddingcompanyinfo/query      	=> query()		分页查询
 * /biddingcompanyinfo/findById       => findById()	查询单条数据
 * /biddingcompanyinfo/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /biddingcompanyinfo/delete	POST    => delete()		单条数据删除
 * /biddingcompanyinfo/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/biddingcompanyinfo")
public class BiddingCompanyInfoController {
	private static final Logger logger = LoggerFactory.getLogger(BiddingCompanyInfoController.class);

	@Autowired
	private BiddingCompanyInfoService biddingCompanyInfoService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		BiddingCompanyInfo biddingcompanyinfo = request.getObject(BiddingCompanyInfo.class);
		Page<BiddingCompanyInfo> pageList = this.biddingCompanyInfoService.selectPage(page, new EntityWrapper(biddingcompanyinfo));
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody BiddingCompanyInfo biddingcompanyinfo){
		biddingcompanyinfo = this.biddingCompanyInfoService.selectById(biddingcompanyinfo.getId());
		return JsonResult.newSuccess(biddingcompanyinfo);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody BiddingCompanyInfo biddingcompanyinfo){
		try {
			Date date=new Date();
			if(biddingcompanyinfo.getId()!=null) {
				biddingcompanyinfo.setCreatedTime(date);
				biddingcompanyinfo.setLastupdatedTime(date);
			}else {
				biddingcompanyinfo.setLastupdatedTime(date);
			}
			this.biddingCompanyInfoService.insertOrUpdate(biddingcompanyinfo);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(biddingcompanyinfo);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody BiddingCompanyInfo biddingcompanyinfo) {
		this.biddingCompanyInfoService.deleteById(biddingcompanyinfo.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.biddingCompanyInfoService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	@RequestMapping(value = "/queryBiddingCompanyInfoWithVehicle")
	public JsonResult queryBiddingCompanyInfoWithVehicle(@RequestBody JsonResult result){
		EntityWrapper<BiddingCompanyInfo> biddingCompanyInfoEntityWrapper=new EntityWrapper<>();
		List<BiddingCompanyInfo> biddingCompanyInfoList=biddingCompanyInfoService.queryBiddingCompanyInfoWithVehicle(biddingCompanyInfoEntityWrapper);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("vehicleList",biddingCompanyInfoList);
		jsonObject.put("name","方松街道");
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(jsonObject);
		return JsonResult.newSuccess(jsonArray);
	}


	/** 按场地名称查询 */
	@RequestMapping(value="/findBiddingCompanyInfo",method=RequestMethod.POST)
	public JsonResult findBiddingCompanyInfo(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		String inputName=request.getString("inputBiddingCompanyInfoName","");
		EntityWrapper<BiddingCompanyInfo> biddingCompanyInfoEntityWrapper=new EntityWrapper<>();
		if(inputName!=null && !inputName.trim().equals("")) {
			inputName="%"+inputName+"%";
			biddingCompanyInfoEntityWrapper.like("company_name",inputName);
		}
		List<BiddingCompanyInfo> biddingCompanyInfoList=this.biddingCompanyInfoService.selectList(biddingCompanyInfoEntityWrapper);
		return JsonResult.newSuccess(biddingCompanyInfoList);
	}

}

