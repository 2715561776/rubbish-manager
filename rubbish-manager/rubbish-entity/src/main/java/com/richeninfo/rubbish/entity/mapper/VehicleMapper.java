/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.richeninfo.rubbish.entity.model.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * VehicleMapper
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.0.9-SNAPSHOT
 * @since 1.0.9
 * */
public interface VehicleMapper extends BaseMapper<Vehicle> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();

	List<Vehicle> findVehicleByCompanyId(int id);

	List<Vehicle> selectVehicleListWithBiddingCompany(Page page, @Param("ew")EntityWrapper<Vehicle> vehicleEntityWrapper);
}