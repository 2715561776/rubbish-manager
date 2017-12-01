/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.VehicleMapper;
import com.richeninfo.rubbish.entity.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("vehicleService")
public class VehicleService extends ServiceImpl<VehicleMapper, Vehicle>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

    public Page<Vehicle> selectVehicleListWithBiddingCompany(Page page, EntityWrapper<Vehicle> vehicleEntityWrapper) {
		List<Vehicle> vehicleList=baseMapper.selectVehicleListWithBiddingCompany(page,vehicleEntityWrapper);
		page.setRecords(vehicleList);
		return page;
    }
}