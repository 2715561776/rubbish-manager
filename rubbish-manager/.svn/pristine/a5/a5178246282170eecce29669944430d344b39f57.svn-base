/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.model;

import java.io.Serializable;
import java.util.Date;

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
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * */
@TableName(value = "rz_apply")
@KeySequence(value = "rz_apply_SEQ")
public class Apply extends Model<Apply> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "Apply";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TYPE = "类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）";
	public static final String ALIAS_WEIGHT = "垃圾重量（吨）";
	public static final String ALIAS_VEHICLE_ID = "车辆ID";
	public static final String ALIAS_LICENSE_PLAT_NUMBER = "车牌号码";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "createdTime";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "lastupdatedTime";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_TYPE = "Type";
	public static final String FIELD_WEIGHT = "WEIGHT";
	public static final String FIELD_VEHICLE_ID = "VEHICLE_ID";
	public static final String FIELD_LICENSE_PLAT_NUMBER = "LICENSE_PLAT_NUMBER";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * id       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）       db_column: Type
	 */
	@TableField(value = "Type")
	private Integer type;
	/**
	 * 垃圾重量（吨）       db_column: WEIGHT
	 */
	@TableField(value = "WEIGHT")
	private Double weight;
	/**
	 * 车辆ID       db_column: VEHICLE_ID
	 */
	@TableField(value = "VEHICLE_ID")
	private Integer vehicleId;
	/**
	 * 车牌号码       db_column: LICENSE_PLAT_NUMBER
	 */
	@TableField(value = "LICENSE_PLAT_NUMBER")
	private String licensePlatNumber;
	/**
	 * sim卡号       db_column: SIM_NO
	 */
	@TableField(value = "SIM_NO")
	private String simNo;
	/**
	 * 行程单状态       db_column: status
	 */
	@TableField(value = "status")
	private Integer status;
	/**
	 * 创建人       db_column: Created_By
	 */
	@TableField(value = "Created_By")
	private Integer createdBy;
	/**
	 * createdTime       db_column: CREATED_TIME
	 */
	@TableField(value = "CREATED_TIME")
	private java.util.Date createdTime;
	/**
	 * 最后修改人账号       db_column: LASTUPDATED_BY
	 */
	@TableField(value = "LASTUPDATED_BY")
	private Integer lastupdatedBy;
	/**
	 * lastupdatedTime       db_column: LASTUPDATED_TIME
	 */
	@TableField(value = "LASTUPDATED_TIME")
	private java.util.Date lastupdatedTime;

	/**
	 * createdTime       db_column: CREATED_TIME
	 */
	@TableField(value = "START_TIME")
	private java.util.Date startTime;

	/**
	 * createdTime       db_column: CREATED_TIME
	 */
	@TableField(value = "END_TIME")
	private java.util.Date endTime;

	@TableId(value = "start_place")
	private Integer startPlace;

	@TableId(value = "end_place")
	private Integer endPlace;

	private transient PlaceInfo startPlaceInfo;

	private transient PlaceInfo endPlaceInfo;
	//columns END


	public Apply(){
	}

	public Apply(
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

	public Double getWeight() {
			return this.weight;
			}

	public void setWeight(Double value) {
			this.weight = value;
			}

	public Integer getVehicleId() {
			return this.vehicleId;
			}

	public void setVehicleId(Integer value) {
			this.vehicleId = value;
			}

	public String getLicensePlatNumber() {
			return this.licensePlatNumber;
			}

	public void setLicensePlatNumber(String value) {
			this.licensePlatNumber = value;
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
		.append("Type",getType())
		.append("Weight",getWeight())
		.append("VehicleId",getVehicleId())
		.append("LicensePlatNumber",getLicensePlatNumber())
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
		if(obj instanceof Apply == false) return false;
		if(this == obj) return true;
		Apply other = (Apply)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSimNo() {
		return simNo;
	}

	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(Integer startPlace) {
		this.startPlace = startPlace;
	}

	public Integer getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(Integer endPlace) {
		this.endPlace = endPlace;
	}

	public PlaceInfo getStartPlaceInfo() {
		return startPlaceInfo;
	}

	public void setStartPlaceInfo(PlaceInfo startPlaceInfo) {
		this.startPlaceInfo = startPlaceInfo;
	}

	public PlaceInfo getEndPlaceInfo() {
		return endPlaceInfo;
	}

	public void setEndPlaceInfo(PlaceInfo endPlaceInfo) {
		this.endPlaceInfo = endPlaceInfo;
	}
}
