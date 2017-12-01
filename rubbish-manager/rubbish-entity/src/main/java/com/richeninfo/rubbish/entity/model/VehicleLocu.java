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
@TableName(value = "rz_vehicle_locus")
@KeySequence(value = "rz_vehicle_locus_SEQ")
public class VehicleLocu extends Model<VehicleLocu> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "VehicleLocu";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CARD_NUMBER = "车牌号码";
	public static final String ALIAS_FACILITY_ID = "设备ID";
	public static final String ALIAS_FACILITY_NO = "设备卡号";
	public static final String ALIAS_CURRENT_TIME = "设备卡号";
	public static final String ALIAS_LATITUDE = "车辆经度";
	public static final String ALIAS_LONGITUDE = "车辆纬度";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_CARD_NUMBER = "CARD_NUMBER";
	public static final String FIELD_FACILITY_ID = "FACILITY_ID";
	public static final String FIELD_FACILITY_NO = "FACILITY_NO";
	public static final String FIELD_CURRENT_TIME = "CURRENT_TIME";
	public static final String FIELD_LATITUDE = "LATITUDE";
	public static final String FIELD_LONGITUDE = "LONGITUDE";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CURRENT_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;

	/**
	 * ID       db_column: ID
	 */
	@TableId(value = "apply_ID")
	private Integer applyId;
	/**
	 * 车牌号码       db_column: CARD_NUMBER
	 */
	@TableField(value = "CARD_NUMBER")
	private String cardNumber;
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
	 * 设备卡号       db_column: CURRENT_TIME
	 */
	@TableField(value = "CURRENT_TIME")
	private java.util.Date currentTime;
	/**
	 * 车辆经度       db_column: LATITUDE
	 */
	@TableField(value = "LATITUDE")
	private float latitude;
	/**
	 * 车辆纬度       db_column: LONGITUDE
	 */
	@TableField(value = "LONGITUDE")
	private float longitude;
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

	@TableField(value = "place_id")
	private Integer placeId;

	@TableField(value = "temp_num")
	private Integer tempNum;
	//columns END


	public VehicleLocu(){
	}

	public VehicleLocu(
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

	public String getCardNumber() {
			return this.cardNumber;
			}

	public void setCardNumber(String value) {
			this.cardNumber = value;
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

	public java.util.Date getCurrentTime() {
			return this.currentTime;
			}

	public void setCurrentTime(java.util.Date value) {
			this.currentTime = value;
			}

	public float getLatitude() {
			return this.latitude;
			}

	public void setLatitude(float value) {
			this.latitude = value;
			}

	public float getLongitude() {
			return this.longitude;
			}

	public void setLongitude(float value) {
			this.longitude = value;
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
		.append("CardNumber",getCardNumber())
		.append("FacilityId",getFacilityId())
		.append("FacilityNo",getFacilityNo())
		.append("CurrentTime",getCurrentTime())
		.append("Latitude",getLatitude())
		.append("Longitude",getLongitude())
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
		if(obj instanceof VehicleLocu == false) return false;
		if(this == obj) return true;
		VehicleLocu other = (VehicleLocu)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}


	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public Integer getTempNum() {
		return tempNum;
	}

	public void setTempNum(Integer tempNum) {
		this.tempNum = tempNum;
	}
}
