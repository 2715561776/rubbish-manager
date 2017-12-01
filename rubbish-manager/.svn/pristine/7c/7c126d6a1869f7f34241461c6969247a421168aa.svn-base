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
@TableName(value = "rz_sys_parameter_type")
@KeySequence(value = "rz_sys_parameter_type_SEQ")
public class SysParameterType extends Model<SysParameterType> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysParameterType";
	public static final String ALIAS_ID = "参数ID";
	public static final String ALIAS_TYPE = "参数类型";
	public static final String ALIAS_PARAMTYPE_CODE = "参数类型编码";
	public static final String ALIAS_PARAMTYPE_NAME = "参数类型名称";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_TYPE = "TYPE";
	public static final String FIELD_PARAMTYPE_CODE = "PARAMTYPE_CODE";
	public static final String FIELD_PARAMTYPE_NAME = "PARAMTYPE_NAME";

	//date formats

	//columns START
	/**
	 * 参数ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 参数类型       db_column: TYPE
	 */
	@TableField(value = "TYPE")
	private Integer type;
	/**
	 * 参数类型编码       db_column: PARAMTYPE_CODE
	 */
	@TableField(value = "PARAMTYPE_CODE")
	private String paramtypeCode;
	/**
	 * 参数类型名称       db_column: PARAMTYPE_NAME
	 */
	@TableField(value = "PARAMTYPE_NAME")
	private String paramtypeName;
	//columns END


	public SysParameterType(){
	}

	public SysParameterType(
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

	public Integer getType() {
			return this.type;
			}

	public void setType(Integer value) {
			this.type = value;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("Type",getType())
		.append("ParamtypeCode",getParamtypeCode())
		.append("ParamtypeName",getParamtypeName())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysParameterType == false) return false;
		if(this == obj) return true;
		SysParameterType other = (SysParameterType)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
