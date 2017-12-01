/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.itcloudinfo.commons.json.bean.JsonRequest;
import com.itcloudinfo.commons.json.bean.JsonResult;
import com.richeninfo.rubbish.entity.model.User;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 基于return JSON的spring mvc方法列表
 * <pre>
 * /user/query      	=> query()		分页查询
 * /user/findById       => findById()	查询单条数据
 * /user/saveOrUpdate POST   => saveOrUpdate()	根据ID(识别)保存或者更新数据
 * /user/delete	POST    => delete()		单条数据删除
 * /user/batchDelete POST  => batchDelete()		批量数据删除
 * </pre>
 *
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * * */
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/** 分页查询 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JsonResult query(@RequestBody JsonRequest request) {
		Page page = new Page(request.getInteger("page",1),request.getInteger("size",10));
		User user = request.getObject(User.class);


		String input=request.getString("input","");
		EntityWrapper<User> userEntityWrapper=new EntityWrapper<>();
		if(!input.equals("")){
			input="%"+input+"%";
			userEntityWrapper.and("User_Name like {0}  or Login_Name like {0} or Post_Name like {0} or Memo like {0}",input);
		}
		Page<User> pageList = this.userService.selectPage(page,userEntityWrapper);
		return JsonResult.newSuccess(pageList);
	}

	/** 显示 */
	@RequestMapping(value="/findById",method=RequestMethod.POST)
	public JsonResult findById(@RequestBody User user){
		user = this.userService.selectById(user.getId());
		return JsonResult.newSuccess(user);
	}
	
	/** 新增 or 更新，根据ID识别 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public JsonResult saveOrUpdate(@RequestBody User user){
		try {
			Date date=new Date();
			if(user.getId()!=null) {
//				user.setCreatedTime(date);
				user.setLastupdatedTime(date);
			}else {
				user.setCreatedTime(date);
				user.setLastupdatedTime(date);
			}
			user.setCreatedBy("system");
			this.userService.insertOrUpdate(user);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return JsonResult.newError(e.getMessage());
		}
		return JsonResult.newSuccess(user);
	}

	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult delete(@RequestBody User user) {
		this.userService.deleteById(user.getId());
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	public JsonResult batchDelete(@RequestBody JsonRequest request) {
		JSONArray items = request.getJSONArray("items");
		for(int i = 0; i < items.size(); i++) {
		this.userService.deleteById(items.getInteger(i));
		}
		return JsonResult.newSuccess("删除成功");
	}

	/** 批量删除 */
	@RequestMapping(value="/findUserByLoginNameAndPassWord",method=RequestMethod.POST)
	public JsonResult findUserByLoginNameAndPassWord(@RequestBody JsonRequest request) {
		String loginName=request.getString("loginName","");
		String passWord=request.getString("passWord","");
		EntityWrapper<User> userEntityWrapper=new EntityWrapper<>();
		userEntityWrapper.eq("login_Name",loginName).eq("passWord",passWord);
//		User user=userService.selectOne(userEntityWrapper);
		User user=userService.selectOneByLoginNameAndPassWord(userEntityWrapper);
		if(null !=user){
			return JsonResult.newSuccess(user);
		}
		return JsonResult.newSuccess(null);
	}
}

