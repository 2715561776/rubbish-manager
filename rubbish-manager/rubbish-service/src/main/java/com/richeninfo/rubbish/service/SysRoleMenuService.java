/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.SysRoleMenuMapper;
import com.richeninfo.rubbish.entity.model.SysRoleMenu;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("sysRoleMenuService")
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}
}