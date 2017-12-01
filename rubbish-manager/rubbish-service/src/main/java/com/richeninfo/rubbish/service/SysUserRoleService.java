/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.SysUserRoleMapper;
import com.richeninfo.rubbish.entity.model.SysUserRole;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("sysUserRoleService")
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}
}