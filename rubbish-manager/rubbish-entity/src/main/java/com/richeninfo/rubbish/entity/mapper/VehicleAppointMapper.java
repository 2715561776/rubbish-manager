/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.richeninfo.rubbish.entity.model.VehicleAppoint;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * VehicleAppointMapper
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * */
public interface VehicleAppointMapper extends BaseMapper<VehicleAppoint> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();

    List<VehicleAppoint> selectVehicleAppointWithPlaceInfo(Pagination page, @Param("ew")EntityWrapper entityWrapper);

    public VehicleAppoint selectByIDDD(String id);
}