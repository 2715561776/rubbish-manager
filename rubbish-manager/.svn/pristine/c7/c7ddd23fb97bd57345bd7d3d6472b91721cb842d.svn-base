/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.itcloudinfo.commons.util.DateUtil;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author xlj email:ahxuliangjun(a)gmail.com
 * @version 1.0.9-SNAPSHOT
 * @since 1.0.9
 * */
@TableName(value = "rz_bidding_company_info")
@KeySequence(value = "rz_bidding_company_info_SEQ")
public class BiddingCompanyInfo extends Model<BiddingCompanyInfo> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "BiddingCompanyInfo";
	public static final String ALIAS_ID = "主键ID";
	public static final String ALIAS_COMPANY_NAME = "企业名称";
	public static final String ALIAS_CONTACTER = "联系人";
	public static final String ALIAS_STATUS = "联系人";
	public static final String ALIAS_CREATED_BY = "创建人账号";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_COMPANY_NAME = "COMPANY_NAME";
	public static final String FIELD_CONTACTER = "CONTACTER";
	public static final String FIELD_STATUS = "STATUS";
	public static final String FIELD_CREATED_BY = "CREATED_BY";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 主键ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 企业名称       db_column: COMPANY_NAME
	 */
	@TableField(value = "COMPANY_NAME")
	private String companyName;
	/**
	 * 联系人       db_column: CONTACTER
	 */
	@TableField(value = "CONTACTER")
	private String contacter;
	/**
	 * 联系人       db_column: STATUS
	 */
	@TableField(value = "STATUS")
	private String status;
	/**
	 * 创建人账号       db_column: CREATED_BY
	 */
	@TableField(value = "CREATED_BY")
	private String createdBy;
	/**
	 * 创建时间       db_column: CREATED_TIME
	 */
	@TableField(value = "CREATED_TIME")
	private java.util.Date createdTime;
	/**
	 * 最后修改人账号       db_column: LASTUPDATED_BY
	 */
	@TableField(value = "LASTUPDATED_BY")
	private String lastupdatedBy;
	/**
	 * 最后修改时间       db_column: LASTUPDATED_TIME
	 */
	@TableField(value = "LASTUPDATED_TIME")
	private java.util.Date lastupdatedTime;

	private transient List<Vehicle> vehicleList;

	private transient String name;
	//columns END


	public BiddingCompanyInfo(){
	}

	public BiddingCompanyInfo(
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

	public String getCompanyName() {
			return this.companyName;
			}

	public void setCompanyName(String value) {
			this.companyName = value;
			}

	public String getContacter() {
			return this.contacter;
			}

	public void setContacter(String value) {
			this.contacter = value;
			}

	public String getStatus() {
			return this.status;
			}

	public void setStatus(String value) {
			this.status = value;
			}

	public String getCreatedBy() {
			return this.createdBy;
			}

	public void setCreatedBy(String value) {
			this.createdBy = value;
			}

	public java.util.Date getCreatedTime() {
			return this.createdTime;
			}

	public void setCreatedTime(java.util.Date value) {
			this.createdTime = value;
			}

	public String getLastupdatedBy() {
			return this.lastupdatedBy;
			}

	public void setLastupdatedBy(String value) {
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
		.append("CompanyName",getCompanyName())
		.append("Contacter",getContacter())
		.append("Status",getStatus())
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
		if(obj instanceof BiddingCompanyInfo == false) return false;
		if(this == obj) return true;
		BiddingCompanyInfo other = (BiddingCompanyInfo)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
