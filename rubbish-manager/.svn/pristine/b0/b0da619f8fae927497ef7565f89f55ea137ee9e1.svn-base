/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.BiddingCompanyInfoMapper;
import com.richeninfo.rubbish.entity.model.BiddingCompanyInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("biddingCompanyInfoService")
public class BiddingCompanyInfoService extends ServiceImpl<BiddingCompanyInfoMapper, BiddingCompanyInfo>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

    public List<BiddingCompanyInfo> queryBiddingCompanyInfoWithVehicle(EntityWrapper<BiddingCompanyInfo> biddingCompanyInfoEntityWrapper) {
		List<BiddingCompanyInfo> biddingCompanyInfoList=baseMapper.queryBiddingCompanyInfoWithVehicle(biddingCompanyInfoEntityWrapper);
		biddingCompanyInfoList.stream()
				.map((biddingCompanyInfo) -> {
					biddingCompanyInfo.setName(biddingCompanyInfo.getCompanyName());
					biddingCompanyInfo.setVehicleList(biddingCompanyInfo.getVehicleList().stream()
					.map(vehicle -> {vehicle.setName(vehicle.getLicensePlatNumber());
					return vehicle;
					}).collect(Collectors.toList()));
				return biddingCompanyInfo;}).collect(Collectors.toList());

		return biddingCompanyInfoList;
    }
}