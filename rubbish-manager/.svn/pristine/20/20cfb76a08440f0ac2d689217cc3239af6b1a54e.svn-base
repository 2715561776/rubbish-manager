/*
 * Author xuliangjun
 * Copyright (c) 2006 - 2017 RICHENINFO All Rights Reserved
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
 * @version 1.1.0-SNAPSHOT
 * @since 1.1.0
 * */
@TableName(value = "rz_vehicle_appoint")
@KeySequence(value = "rz_vehicle_appoint_SEQ")
public class VehicleAppoint extends Model<VehicleAppoint> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "VehicleAppoint";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_APPLY_ID = "关联apply表ID";
	public static final String ALIAS_ESTIMATE_WEIGHT = "预计垃圾重量（吨）";
	public static final String ALIAS_VEHICLE_ID = "车辆ID";
	public static final String ALIAS_CARD_NUMBER = "车牌号码";
	public static final String ALIAS_ESTIMATE_DRIVER = "预约司机";
	public static final String ALIAS_ESTIMATE_DRIVER_PHONE = "预约司机手机号";
	public static final String ALIAS_FACILITY_ID = "设备ID";
	public static final String ALIAS_FACILITY_NO = "设备卡号";
	public static final String ALIAS_ARRIVAL_TIME = "最早到达时间，可填写提前30分钟，便于收集经纬度";
	public static final String ALIAS_ACTUAL_TIME = "实际到达时间";
	public static final String ALIAS_PLACE_ID = "预约场地ID";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "createdTime";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "lastupdatedTime";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_APPLY_ID = "apply_id";
	public static final String FIELD_ESTIMATE_WEIGHT = "ESTIMATE_WEIGHT";
	public static final String FIELD_VEHICLE_ID = "VEHICLE_ID";
	public static final String FIELD_CARD_NUMBER = "CARD_NUMBER";
	public static final String FIELD_ESTIMATE_DRIVER = "ESTIMATE_DRIVER";
	public static final String FIELD_ESTIMATE_DRIVER_PHONE = "ESTIMATE_DRIVER_PHONE";
	public static final String FIELD_FACILITY_ID = "FACILITY_ID";
	public static final String FIELD_FACILITY_NO = "FACILITY_NO";
	public static final String FIELD_ARRIVAL_TIME = "ARRIVAL_TIME";
	public static final String FIELD_ACTUAL_TIME = "ACTUAL_TIME";
	public static final String FIELD_PLACE_ID = "PLACE_ID";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_ARRIVAL_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_ACTUAL_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 关联apply表ID       db_column: apply_id
	 */
	@TableField(value = "apply_id")
	private Integer applyId;
	/**
	 * 预计垃圾重量（吨）       db_column: ESTIMATE_WEIGHT
	 */
	@TableField(value = "ESTIMATE_WEIGHT")
	private Double estimateWeight;
	/**
	 * 车辆ID       db_column: VEHICLE_ID
	 */
	@TableField(value = "VEHICLE_ID")
	private Integer vehicleId;
	/**
	 * 车牌号码       db_column: CARD_NUMBER
	 */
	@TableField(value = "CARD_NUMBER")
	private String cardNumber;
	/**
	 * 预约司机       db_column: ESTIMATE_DRIVER
	 */
	@TableField(value = "ESTIMATE_DRIVER")
	private String estimateDriver;
	/**
	 * 预约司机手机号       db_column: ESTIMATE_DRIVER_PHONE
	 */
	@TableField(value = "ESTIMATE_DRIVER_PHONE")
	private String estimateDriverPhone;
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
	 * 最早到达时间，可填写提前30分钟，便于收集经纬度       db_column: ARRIVAL_TIME
	 */
	@TableField(value = "ARRIVAL_TIME")
	private java.util.Date arrivalTime;
	/**
	 * 实际到达时间       db_column: ACTUAL_TIME
	 */
	@TableField(value = "ACTUAL_TIME")
	private java.util.Date actualTime;
	/**
	 * 预约场地ID       db_column: PLACE_ID
	 */
	@TableField(value = "PLACE_ID")
	private Integer placeId;
	/**
	 * 预约场地ID       db_column: PLACE_ID
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
	//columns END

	private transient PlaceInfo placeInfo;


	public VehicleAppoint(){
	}

	public VehicleAppoint(
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

	public Integer getApplyId() {
			return this.applyId;
			}

	public void setApplyId(Integer value) {
			this.applyId = value;
			}

	public Double getEstimateWeight() {
			return this.estimateWeight;
			}

	public void setEstimateWeight(Double value) {
			this.estimateWeight = value;
			}

	public Integer getVehicleId() {
			return this.vehicleId;
			}

	public void setVehicleId(Integer value) {
			this.vehicleId = value;
			}

	public String getCardNumber() {
			return this.cardNumber;
			}

	public void setCardNumber(String value) {
			this.cardNumber = value;
			}

	public String getEstimateDriver() {
			return this.estimateDriver;
			}

	public void setEstimateDriver(String value) {
			this.estimateDriver = value;
			}

	public String getEstimateDriverPhone() {
			return this.estimateDriverPhone;
			}

	public void setEstimateDriverPhone(String value) {
			this.estimateDriverPhone = value;
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

	public java.util.Date getArrivalTime() {
			return this.arrivalTime;
			}

	public void setArrivalTime(java.util.Date value) {
			this.arrivalTime = value;
			}

	public java.util.Date getActualTime() {
			return this.actualTime;
			}

	public void setActualTime(java.util.Date value) {
			this.actualTime = value;
			}

	public Integer getPlaceId() {
			return this.placeId;
			}

	public void setPlaceId(Integer value) {
			this.placeId = value;
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
		.append("ApplyId",getApplyId())
		.append("EstimateWeight",getEstimateWeight())
		.append("VehicleId",getVehicleId())
		.append("CardNumber",getCardNumber())
		.append("EstimateDriver",getEstimateDriver())
		.append("EstimateDriverPhone",getEstimateDriverPhone())
		.append("FacilityId",getFacilityId())
		.append("FacilityNo",getFacilityNo())
		.append("ArrivalTime",getArrivalTime())
		.append("ActualTime",getActualTime())
		.append("PlaceId",getPlaceId())
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
		if(obj instanceof VehicleAppoint == false) return false;
		if(this == obj) return true;
		VehicleAppoint other = (VehicleAppoint)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public PlaceInfo getPlaceInfo() {
		return placeInfo;
	}

	public void setPlaceInfo(PlaceInfo placeInfo) {
		this.placeInfo = placeInfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
