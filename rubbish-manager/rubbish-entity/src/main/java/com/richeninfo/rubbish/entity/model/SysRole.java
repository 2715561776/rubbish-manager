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
@TableName(value = "rz_sys_role")
@KeySequence(value = "rz_sys_role_SEQ")
public class SysRole extends Model<SysRole> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysRole";
	public static final String ALIAS_ID = "系统角色ID";
	public static final String ALIAS_ROLE_CODE = "系统角色代码";
	public static final String ALIAS_ROLE_NAME = "系统角色名称";
	public static final String ALIAS_ROLE_DESC = "系统角色描述";
	public static final String ALIAS_IS_ACTIVE = "是否有效";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_ROLE_CODE = "ROLE_CODE";
	public static final String FIELD_ROLE_NAME = "ROLE_NAME";
	public static final String FIELD_ROLE_DESC = "ROLE_DESC";
	public static final String FIELD_IS_ACTIVE = "IS_ACTIVE";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 系统角色ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 系统角色代码       db_column: ROLE_CODE
	 */
	@TableField(value = "ROLE_CODE")
	private String roleCode;
	/**
	 * 系统角色名称       db_column: ROLE_NAME
	 */
	@TableField(value = "ROLE_NAME")
	private String roleName;
	/**
	 * 系统角色描述       db_column: ROLE_DESC
	 */
	@TableField(value = "ROLE_DESC")
	private String roleDesc;
	/**
	 * 是否有效       db_column: IS_ACTIVE
	 */
	@TableField(value = "IS_ACTIVE")
	private String isActive;
	/**
	 * 创建人       db_column: Created_By
	 */
	@TableField(value = "Created_By")
	private Integer createdBy;
	/**
	 * 创建时间       db_column: CREATED_TIME
	 */
	@TableField(value = "CREATED_TIME")
	private java.util.Date createdTime;
	/**
	 * 最后修改人账号       db_column: LASTUPDATED_BY
	 */
	@TableField(value = "LASTUPDATED_BY")
	private Integer lastupdatedBy;
	/**
	 * 最后修改时间       db_column: LASTUPDATED_TIME
	 */
	@TableField(value = "LASTUPDATED_TIME")
	private java.util.Date lastupdatedTime;
	//columns END


	public SysRole(){
	}

	public SysRole(
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

	public String getRoleCode() {
			return this.roleCode;
			}

	public void setRoleCode(String value) {
			this.roleCode = value;
			}

	public String getRoleName() {
			return this.roleName;
			}

	public void setRoleName(String value) {
			this.roleName = value;
			}

	public String getRoleDesc() {
			return this.roleDesc;
			}

	public void setRoleDesc(String value) {
			this.roleDesc = value;
			}

	public String getIsActive() {
			return this.isActive;
			}

	public void setIsActive(String value) {
			this.isActive = value;
			}

	public Integer getCreatedBy() {
			return this.createdBy;
			}

	public void setCreatedBy(Integer value) {
			this.createdBy = value;
			}

	public java.util.Date getCreatedTime() {
			return this.createdTime;
			}

	public void setCreatedTime(java.util.Date value) {
			this.createdTime = value;
			}

	public Integer getLastupdatedBy() {
			return this.lastupdatedBy;
			}

	public void setLastupdatedBy(Integer value) {
			this.lastupdatedBy = value;
			}

	public java.util.Date getLastupdatedTime() {
			return this.lastupdatedTime;
			}

	public void setLastupdatedTime(java.util.Date value) {
			this.lastupdatedTime = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("RoleCode",getRoleCode())
		.append("RoleName",getRoleName())
		.append("RoleDesc",getRoleDesc())
		.append("IsActive",getIsActive())
		.append("CreatedBy",getCreatedBy())
		.append("CreatedTime",getCreatedTime())
		.append("LastupdatedBy",getLastupdatedBy())
		.append("LastupdatedTime",getLastupdatedTime())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysRole == false) return false;
		if(this == obj) return true;
		SysRole other = (SysRole)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
