/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.richeninfo.rubbish.entity.model.BiddingCompanyInfo;

import java.util.List;

/**
 * BiddingCompanyInfoMapper
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.0.9-SNAPSHOT
 * @since 1.0.9
 * */
public interface BiddingCompanyInfoMapper extends BaseMapper<BiddingCompanyInfo> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();

    List<BiddingCompanyInfo> queryBiddingCompanyInfoWithVehicle(EntityWrapper<BiddingCompanyInfo> biddingCompanyInfoEntityWrapper);

    BiddingCompanyInfo findBiddingCompany(int id);
}