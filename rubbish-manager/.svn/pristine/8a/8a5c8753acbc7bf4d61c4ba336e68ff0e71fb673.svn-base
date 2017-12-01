/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.UserMapper;
import com.richeninfo.rubbish.entity.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("userService")
public class UserService extends ServiceImpl<UserMapper, User>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

    public User selectOneByLoginNameAndPassWord(EntityWrapper<User> userEntityWrapper) {
			return baseMapper.selectOneByLoginNameAndPassWord(userEntityWrapper);
    }
}