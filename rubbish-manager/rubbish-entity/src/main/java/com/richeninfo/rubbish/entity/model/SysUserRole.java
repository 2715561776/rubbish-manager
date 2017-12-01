/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.model;

import java.io.Serializable;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.itcloudinfo.commons.util.DateUtil;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.0.9-SNAPSHOT
 * @since 1.0.9
 * */
@TableName(value = "rz_sys_user_role")
@KeySequence(value = "rz_sys_user_role_SEQ")
public class SysUserRole extends Model<SysUserRole> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysUserRole";
	public static final String ALIAS_ID = "用户角色ID";
	public static final String ALIAS_USER_NUM = "系统用户工号";
	public static final String ALIAS_ROLE_CODE = "系统角色编码";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_USER_NUM = "USER_NUM";
	public static final String FIELD_ROLE_CODE = "ROLE_CODE";

	//date formats

	//columns START
	/**
	 * 用户角色ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 系统用户工号       db_column: USER_NUM
	 */
	@TableField(value = "USER_NUM")
	private String userNum;
	/**
	 * 系统角色编码       db_column: ROLE_CODE
	 */
	@TableField(value = "ROLE_CODE")
	private String roleCode;
	//columns END


	public SysUserRole(){
	}

	public SysUserRole(
		Integer id
	){
		this.id = id;
	}



	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	public void setId(Integer value) {
			this.id = value;
			}

	public Integer getId() {
			return this.id;
			}

	public String getUserNum() {
			return this.userNum;
			}

	public void setUserNum(String value) {
			this.userNum = value;
			}

	public String getRoleCode() {
			return this.roleCode;
			}

	public void setRoleCode(String value) {
			this.roleCode = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("UserNum",getUserNum())
		.append("RoleCode",getRoleCode())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysUserRole == false) return false;
		if(this == obj) return true;
		SysUserRole other = (SysUserRole)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
