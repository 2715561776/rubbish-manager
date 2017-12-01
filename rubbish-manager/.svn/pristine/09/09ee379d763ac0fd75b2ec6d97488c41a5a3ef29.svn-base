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
@TableName(value = "rz_vehicle_arrive_place")
@KeySequence(value = "rz_vehicle_arrive_place_SEQ")
public class VehicleArrivePlace extends Model<VehicleArrivePlace> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "VehicleArrivePlace";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_VEHICLE_ID = "车辆ID";
	public static final String ALIAS_CARD_NUMBER = "车牌号码";
	public static final String ALIAS_FACILITY_NO = "设备卡号";
	public static final String ALIAS_ARRIVE_TIME = "到达场地时间";
	public static final String ALIAS_ARRIVE_PLACE_ID = "arrivePlaceId";
	public static final String ALIAS_ARRIVE_PLACE_NAME = "arrivePlaceName";
	public static final String ALIAS_ARRIVE_PLACE_TYPE = "arrivePlaceType";
	public static final String ALIAS_STATUS = "状态";

	//field
	public static final String FIELD_ID = "id";
	public static final String FIELD_VEHICLE_ID = "vehicle_id";
	public static final String FIELD_CARD_NUMBER = "CARD_NUMBER";
	public static final String FIELD_FACILITY_NO = "FACILITY_NO";
	public static final String FIELD_ARRIVE_TIME = "arrive_time";
	public static final String FIELD_ARRIVE_PLACE_ID = "arrive_place_id";
	public static final String FIELD_ARRIVE_PLACE_NAME = "arrive_place_name";
	public static final String FIELD_ARRIVE_PLACE_TYPE = "arrive_place_type";
	public static final String FIELD_STATUS = "status";

	//date formats
	public static final String FORMAT_ARRIVE_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * id       db_column: id
	 */
	@TableId(value = "id")
	private Integer id;
	/**
	 * 车辆ID       db_column: vehicle_id
	 */
	@TableField(value = "vehicle_id")
	private Integer vehicleId;
	/**
	 * 车牌号码       db_column: CARD_NUMBER
	 */
	@TableField(value = "CARD_NUMBER")
	private String cardNumber;
	/**
	 * 设备卡号       db_column: FACILITY_NO
	 */
	@TableField(value = "FACILITY_NO")
	private String facilityNo;
	/**
	 * 到达场地时间       db_column: arrive_time
	 */
	@TableField(value = "arrive_time")
	private java.util.Date arriveTime;
	/**
	 * arrivePlaceId       db_column: arrive_place_id
	 */
	@TableField(value = "arrive_place_id")
	private Integer arrivePlaceId;
	/**
	 * arrivePlaceName       db_column: arrive_place_name
	 */
	@TableField(value = "arrive_place_name")
	private String arrivePlaceName;
	/**
	 * arrivePlaceType       db_column: arrive_place_type
	 */
	@TableField(value = "arrive_place_type")
	private Integer arrivePlaceType;
	/**
	 * 状态       db_column: status
	 */
	@TableField(value = "status")
	private Integer status;
	//columns END


	public VehicleArrivePlace(){
	}

	public VehicleArrivePlace(
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

	public String getFacilityNo() {
			return this.facilityNo;
			}

	public void setFacilityNo(String value) {
			this.facilityNo = value;
			}

	public java.util.Date getArriveTime() {
			return this.arriveTime;
			}

	public void setArriveTime(java.util.Date value) {
			this.arriveTime = value;
			}

	public Integer getArrivePlaceId() {
			return this.arrivePlaceId;
			}

	public void setArrivePlaceId(Integer value) {
			this.arrivePlaceId = value;
			}

	public String getArrivePlaceName() {
			return this.arrivePlaceName;
			}

	public void setArrivePlaceName(String value) {
			this.arrivePlaceName = value;
			}

	public Integer getArrivePlaceType() {
			return this.arrivePlaceType;
			}

	public void setArrivePlaceType(Integer value) {
			this.arrivePlaceType = value;
			}

	public Integer getStatus() {
			return this.status;
			}

	public void setStatus(Integer value) {
			this.status = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("VehicleId",getVehicleId())
		.append("CardNumber",getCardNumber())
		.append("FacilityNo",getFacilityNo())
		.append("ArriveTime",getArriveTime())
		.append("ArrivePlaceId",getArrivePlaceId())
		.append("ArrivePlaceName",getArrivePlaceName())
		.append("ArrivePlaceType",getArrivePlaceType())
		.append("Status",getStatus())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof VehicleArrivePlace == false) return false;
		if(this == obj) return true;
		VehicleArrivePlace other = (VehicleArrivePlace)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
