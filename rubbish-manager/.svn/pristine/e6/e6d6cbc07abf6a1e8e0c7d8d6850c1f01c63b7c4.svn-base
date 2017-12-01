/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.richeninfo.rubbish.entity.model.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ApplyMapper
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * */
public interface ApplyMapper extends BaseMapper<Apply> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();

    List selectApplyInOrOut(Page page, @Param("ew")EntityWrapper<Apply> applyEntityWrapper);
}