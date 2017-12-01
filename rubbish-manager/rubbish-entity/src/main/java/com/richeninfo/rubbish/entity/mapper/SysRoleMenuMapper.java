/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.richeninfo.rubbish.entity.model.SysRoleMenu;

/**
 * SysRoleMenuMapper
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.0.9-SNAPSHOT
 * @since 1.0.9
 * */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();
}