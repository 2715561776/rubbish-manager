/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.richeninfo.rubbish.entity.model.VehicleTemp;

/**
 * VehicleTempMapper
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * */
public interface VehicleTempMapper extends BaseMapper<VehicleTemp> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();
}