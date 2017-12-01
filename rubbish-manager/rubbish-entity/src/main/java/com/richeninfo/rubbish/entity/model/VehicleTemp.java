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
@TableName(value = "rz_vehicle_temp")
@KeySequence(value = "rz_vehicle_temp_SEQ")
public class VehicleTemp extends Model<VehicleTemp> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "VehicleTemp";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CAR_NUM = "carNum";
	public static final String ALIAS_SIM_NO = "simNo";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_PLACE_ID = "placeId";
	public static final String ALIAS_TEMP_NUM = "tempNum";

	//field
	public static final String FIELD_ID = "id";
	public static final String FIELD_CAR_NUM = "car_num";
	public static final String FIELD_SIM_NO = "sim_no";
	public static final String FIELD_CREATE_TIME = "create_time";
	public static final String FIELD_PLACE_ID = "place_id";
	public static final String FIELD_TEMP_NUM = "temp_num";

	//date formats
	public static final String FORMAT_CREATE_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * id       db_column: id
	 */
	@TableId(value = "id")
	private Integer id;
	/**
	 * carNum       db_column: car_num
	 */
	@TableField(value = "car_num")
	private String carNum;
	/**
	 * simNo       db_column: sim_no
	 */
	@TableField(value = "sim_no")
	private String simNo;
	/**
	 * createTime       db_column: create_time
	 */
	@TableField(value = "create_time")
	private java.util.Date createTime;
	/**
	 * placeId       db_column: place_id
	 */
	@TableField(value = "place_id")
	private Integer placeId;
	/**
	 * tempNum       db_column: temp_num
	 */
	@TableField(value = "temp_num")
	private Integer tempNum;

	@TableField(value = "flag")
	private Integer flag;
	//columns END


	public VehicleTemp(){
	}

	public VehicleTemp(
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

	public String getCarNum() {
			return this.carNum;
			}

	public void setCarNum(String value) {
			this.carNum = value;
			}

	public String getSimNo() {
			return this.simNo;
			}

	public void setSimNo(String value) {
			this.simNo = value;
			}

	public java.util.Date getCreateTime() {
			return this.createTime;
			}

	public void setCreateTime(java.util.Date value) {
			this.createTime = value;
			}

	public Integer getPlaceId() {
			return this.placeId;
			}

	public void setPlaceId(Integer value) {
			this.placeId = value;
			}

	public Integer getTempNum() {
			return this.tempNum;
			}

	public void setTempNum(Integer value) {
			this.tempNum = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("CarNum",getCarNum())
		.append("SimNo",getSimNo())
		.append("CreateTime",getCreateTime())
		.append("PlaceId",getPlaceId())
		.append("TempNum",getTempNum())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof VehicleTemp == false) return false;
		if(this == obj) return true;
		VehicleTemp other = (VehicleTemp)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
