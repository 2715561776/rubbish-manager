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
@TableName(value = "rz_sys_parameter")
@KeySequence(value = "rz_sys_parameter_SEQ")
public class SysParameter extends Model<SysParameter> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysParameter";
	public static final String ALIAS_ID = "参数ID";
	public static final String ALIAS_PARAM_CODE = "参数代码";
	public static final String ALIAS_PARAM_NAME = "参数名称";
	public static final String ALIAS_MODULE_NAME = "模块名称";
	public static final String ALIAS_PARAMTYPE_CODE = "参数类型CODE";
	public static final String ALIAS_PARAMTYPE_NAME = "参数类型名称";
	public static final String ALIAS_PARAM_DESC = "参数描述";
	public static final String ALIAS_PARAM_VALUE = "参数值";
	public static final String ALIAS_IS_SYSTEM = "是否是系统参数";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_PARAM_CODE = "PARAM_CODE";
	public static final String FIELD_PARAM_NAME = "PARAM_NAME";
	public static final String FIELD_MODULE_NAME = "MODULE_NAME";
	public static final String FIELD_PARAMTYPE_CODE = "PARAMTYPE_CODE";
	public static final String FIELD_PARAMTYPE_NAME = "PARAMTYPE_NAME";
	public static final String FIELD_PARAM_DESC = "PARAM_DESC";
	public static final String FIELD_PARAM_VALUE = "PARAM_VALUE";
	public static final String FIELD_IS_SYSTEM = "IS_SYSTEM";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 参数ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 参数代码       db_column: PARAM_CODE
	 */
	@TableField(value = "PARAM_CODE")
	private String paramCode;
	/**
	 * 参数名称       db_column: PARAM_NAME
	 */
	@TableField(value = "PARAM_NAME")
	private String paramName;
	/**
	 * 模块名称       db_column: MODULE_NAME
	 */
	@TableField(value = "MODULE_NAME")
	private String moduleName;
	/**
	 * 参数类型CODE       db_column: PARAMTYPE_CODE
	 */
	@TableField(value = "PARAMTYPE_CODE")
	private String paramtypeCode;
	/**
	 * 参数类型名称       db_column: PARAMTYPE_NAME
	 */
	@TableField(value = "PARAMTYPE_NAME")
	private String paramtypeName;
	/**
	 * 参数描述       db_column: PARAM_DESC
	 */
	@TableField(value = "PARAM_DESC")
	private String paramDesc;
	/**
	 * 参数值       db_column: PARAM_VALUE
	 */
	@TableField(value = "PARAM_VALUE")
	private String paramValue;
	/**
	 * 是否是系统参数       db_column: IS_SYSTEM
	 */
	@TableField(value = "IS_SYSTEM")
	private Integer isSystem;
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


	public SysParameter(){
	}

	public SysParameter(
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

	public String getParamCode() {
			return this.paramCode;
			}

	public void setParamCode(String value) {
			this.paramCode = value;
			}

	public String getParamName() {
			return this.paramName;
			}

	public void setParamName(String value) {
			this.paramName = value;
			}

	public String getModuleName() {
			return this.moduleName;
			}

	public void setModuleName(String value) {
			this.moduleName = value;
			}

	public String getParamtypeCode() {
			return this.paramtypeCode;
			}

	public void setParamtypeCode(String value) {
			this.paramtypeCode = value;
			}

	public String getParamtypeName() {
			return this.paramtypeName;
			}

	public void setParamtypeName(String value) {
			this.paramtypeName = value;
			}

	public String getParamDesc() {
			return this.paramDesc;
			}

	public void setParamDesc(String value) {
			this.paramDesc = value;
			}

	public String getParamValue() {
			return this.paramValue;
			}

	public void setParamValue(String value) {
			this.paramValue = value;
			}

	public Integer getIsSystem() {
			return this.isSystem;
			}

	public void setIsSystem(Integer value) {
			this.isSystem = value;
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
		.append("ParamCode",getParamCode())
		.append("ParamName",getParamName())
		.append("ModuleName",getModuleName())
		.append("ParamtypeCode",getParamtypeCode())
		.append("ParamtypeName",getParamtypeName())
		.append("ParamDesc",getParamDesc())
		.append("ParamValue",getParamValue())
		.append("IsSystem",getIsSystem())
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
		if(obj instanceof SysParameter == false) return false;
		if(this == obj) return true;
		SysParameter other = (SysParameter)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
