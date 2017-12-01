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
@TableName(value = "rz_vehicle")
@KeySequence(value = "rz_vehicle_SEQ")
public class Vehicle extends Model<Vehicle> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "Vehicle";
	public static final String ALIAS_ID = "主键ID";
	public static final String ALIAS_COMPANY_ID = "通行证编号（关联中标公司id）";
	public static final String ALIAS_SEQ = "序号";
	public static final String ALIAS_MOTORCADE_NAME = "车队名称";
	public static final String ALIAS_LICENSE_PLAT_NUMBER = "车牌号码";
	public static final String ALIAS_FACILITY_NAME = "设备名称";
	public static final String ALIAS_FACILITY_ID = "设备ID";
	public static final String ALIAS_FACILITY_NO = "设备卡号";
	public static final String ALIAS_DRIVER_NAME = "驾驶员姓名";
	public static final String ALIAS_DRIVER_PHONE = "驾驶员电话";
	public static final String ALIAS_CREATED_BY = "创建人账号";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_COMPANY_ID = "COMPANY_ID";
	public static final String FIELD_SEQ = "SEQ";
	public static final String FIELD_MOTORCADE_NAME = "MOTORCADE_NAME";
	public static final String FIELD_LICENSE_PLAT_NUMBER = "LICENSE_PLAT_NUMBER";
	public static final String FIELD_FACILITY_NAME = "FACILITY_NAME";
	public static final String FIELD_FACILITY_ID = "FACILITY_ID";
	public static final String FIELD_FACILITY_NO = "FACILITY_NO";
	public static final String FIELD_DRIVER_NAME = "DRIVER_NAME";
	public static final String FIELD_DRIVER_PHONE = "DRIVER_PHONE";
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
	 * 通行证编号（关联中标公司id）       db_column: COMPANY_ID
	 */
	@TableField(value = "COMPANY_ID")
	private Integer companyId;
	/**
	 * 序号       db_column: SEQ
	 */
	@TableField(value = "SEQ")
	private String seq;
	/**
	 * 车队名称       db_column: MOTORCADE_NAME
	 */
	@TableField(value = "MOTORCADE_NAME")
	private String motorcadeName;
	/**
	 * 车牌号码       db_column: LICENSE_PLAT_NUMBER
	 */
	@TableField(value = "LICENSE_PLAT_NUMBER")
	private String licensePlatNumber;
	/**
	 * 设备名称       db_column: FACILITY_NAME
	 */
	@TableField(value = "FACILITY_NAME")
	private String facilityName;
	/**
	 * 设备ID       db_column: FACILITY_ID
	 */
	@TableField(value = "FACILITY_ID")
	private String facilityId;
	/**
	 * 设备卡号       db_column: FACILITY_NO
	 */
	@TableField(value = "FACILITY_NO")
	private String facilityNo;
	/**
	 * 驾驶员姓名       db_column: DRIVER_NAME
	 */
	@TableField(value = "DRIVER_NAME")
	private String driverName;
	/**
	 * 驾驶员电话       db_column: DRIVER_PHONE
	 */
	@TableField(value = "DRIVER_PHONE")
	private String driverPhone;
	/**
	 * 驾驶员电话       db_column: DRIVER_PHONE
	 */
	@TableField(value = "SIM_NO")
	private String simNo;
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


	@TableField(value = "upload")
	private String upload;

	private transient String name;

	private transient BiddingCompanyInfo biddingCompanyInfo;
	//columns END


	public Vehicle(){
	}

	public Vehicle(
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

	public Integer getCompanyId() {
			return this.companyId;
			}

	public void setCompanyId(Integer value) {
			this.companyId = value;
			}

	public String getSeq() {
			return this.seq;
			}

	public void setSeq(String value) {
			this.seq = value;
			}

	public String getMotorcadeName() {
			return this.motorcadeName;
			}

	public void setMotorcadeName(String value) {
			this.motorcadeName = value;
			}

	public String getLicensePlatNumber() {
			return this.licensePlatNumber;
			}

	public void setLicensePlatNumber(String value) {
			this.licensePlatNumber = value;
			}

	public String getFacilityName() {
			return this.facilityName;
			}

	public void setFacilityName(String value) {
			this.facilityName = value;
			}

	public String getFacilityId() {
			return this.facilityId;
			}

	public void setFacilityId(String value) {
			this.facilityId = value;
			}

	public String getFacilityNo() {
			return this.facilityNo;
			}

	public void setFacilityNo(String value) {
			this.facilityNo = value;
			}

	public String getDriverName() {
			return this.driverName;
			}

	public void setDriverName(String value) {
			this.driverName = value;
			}

	public String getDriverPhone() {
			return this.driverPhone;
			}

	public void setDriverPhone(String value) {
			this.driverPhone = value;
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
		.append("CompanyId",getCompanyId())
		.append("Seq",getSeq())
		.append("MotorcadeName",getMotorcadeName())
		.append("LicensePlatNumber",getLicensePlatNumber())
		.append("FacilityName",getFacilityName())
		.append("FacilityId",getFacilityId())
		.append("FacilityNo",getFacilityNo())
		.append("DriverName",getDriverName())
		.append("DriverPhone",getDriverPhone())
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
		if(obj instanceof Vehicle == false) return false;
		if(this == obj) return true;
		Vehicle other = (Vehicle)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public String getSimNo() {
		return simNo;
	}

	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BiddingCompanyInfo getBiddingCompanyInfo() {
		return biddingCompanyInfo;
	}

	public void setBiddingCompanyInfo(BiddingCompanyInfo biddingCompanyInfo) {
		this.biddingCompanyInfo = biddingCompanyInfo;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}
}
