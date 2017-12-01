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
@TableName(value = "rz_vehicle_place")
@KeySequence(value = "rz_vehicle_place_SEQ")
public class VehiclePlace extends Model<VehiclePlace> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "VehiclePlace";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PLACE_ID = "placeId";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_SIM_NO = "simNo";
	public static final String ALIAS_ARRIVE_TIME = "arriveTime";
	public static final String ALIAS_WEIGHT = "weight";

	//field
	public static final String FIELD_ID = "id";
	public static final String FIELD_PLACE_ID = "place_id";
	public static final String FIELD_TYPE = "type";
	public static final String FIELD_SIM_NO = "sim_no";
	public static final String FIELD_ARRIVE_TIME = "arrive_time";
	public static final String FIELD_WEIGHT = "weight";

	//date formats
	public static final String FORMAT_ARRIVE_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * id       db_column: id
	 */
	@TableId(value = "id")
	private Integer id;
	/**
	 * placeId       db_column: place_id
	 */
	@TableField(value = "place_id")
	private Integer placeId;
	/**
	 * type       db_column: type
	 */
	@TableField(value = "type")
	private Integer type;
	/**
	 * simNo       db_column: sim_no
	 */
	@TableField(value = "sim_no")
	private String simNo;
	/**
	 * arriveTime       db_column: arrive_time
	 */
	@TableField(value = "arrive_time")
	private java.util.Date arriveTime;
	/**
	 * weight       db_column: weight
	 */
	@TableField(value = "weight")
	private Double weight;
	//columns END


	public VehiclePlace(){
	}

	public VehiclePlace(
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

	public Integer getPlaceId() {
			return this.placeId;
			}

	public void setPlaceId(Integer value) {
			this.placeId = value;
			}

	public Integer getType() {
			return this.type;
			}

	public void setType(Integer value) {
			this.type = value;
			}

	public String getSimNo() {
			return this.simNo;
			}

	public void setSimNo(String value) {
			this.simNo = value;
			}

	public java.util.Date getArriveTime() {
			return this.arriveTime;
			}

	public void setArriveTime(java.util.Date value) {
			this.arriveTime = value;
			}

	public Double getWeight() {
			return this.weight;
			}

	public void setWeight(Double value) {
			this.weight = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("PlaceId",getPlaceId())
		.append("Type",getType())
		.append("SimNo",getSimNo())
		.append("ArriveTime",getArriveTime())
		.append("Weight",getWeight())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof VehiclePlace == false) return false;
		if(this == obj) return true;
		VehiclePlace other = (VehiclePlace)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
