/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.ApplyMapper;
import com.richeninfo.rubbish.entity.model.Apply;
import org.springframework.stereotype.Service;

/**
 *
 * Apply 表数据服务层接口实现类
 *
 */
@Service("applyService")
public class ApplyService extends ServiceImpl<ApplyMapper, Apply>{

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

    public Page<Apply> selectApplyInOrOut(Page page, EntityWrapper<Apply> applyEntityWrapper) {
		page.setRecords(this.baseMapper.selectApplyInOrOut(page, applyEntityWrapper));
		return page;
    }
}