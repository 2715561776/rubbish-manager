/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.VehicleTempMapper;
import com.richeninfo.rubbish.entity.model.VehicleTemp;
import org.springframework.stereotype.Service;

/**
 *
 * VehicleTemp 表数据服务层接口实现类
 *
 */
@Service("vehicleTempService")
public class VehicleTempService extends ServiceImpl<VehicleTempMapper, VehicleTemp>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}
}