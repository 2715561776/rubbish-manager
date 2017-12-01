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
@TableName(value = "rz_place_info")
@KeySequence(value = "rz_place_info_SEQ")
public class PlaceInfo implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "PlaceInfo";
	public static final String ALIAS_ID = "主键ID";
	public static final String ALIAS_TYPE = "类型（消纳场，小区，商业地区）";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_CONTACTER = "联系人";
	public static final String ALIAS_STATUS = "状态";
	public static final String ALIAS_PLACES = "场地信息，经纬度集合（经度1,维度1;经度2,维度2;...）";
	public static final String ALIAS_CREATED_BY = "创建人账号";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "id";
	public static final String FIELD_TYPE = "Type";
	public static final String FIELD_NAME = "NAME";
	public static final String FIELD_CONTACTER = "CONTACTER";
	public static final String FIELD_STATUS = "STATUS";
	public static final String FIELD_PLACES = "PLACES";
	public static final String FIELD_CREATED_BY = "CREATED_BY";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 主键ID       db_column: id
	 */
	@TableId(value = "id")
	private Integer id;
	/**
	 * 类型（消纳场，小区，商业地区）       db_column: Type
	 */
	@TableField(value = "Type")
	private String type;
	/**
	 * 名称       db_column: NAME
	 */
	@TableField(value = "NAME")
	private String name;
	/**
	 * 联系人       db_column: CONTACTER
	 */
	@TableField(value = "CONTACTER")
	private String contacter;
	/**
	 * 状态       db_column: STATUS
	 */
	@TableField(value = "STATUS")
	private String status;
	/**
	 * 场地信息，经纬度集合（经度1,维度1;经度2,维度2;...）       db_column: PLACES
	 */
	@TableField(value = "PLACES")
	private String places;
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

	/**
	 * 纬度       db_column: latitude
	 */
	@TableField(value = "latitude")
	private Double latitude;

	/**
	 * 经度       db_column: longitude
	 */
	@TableField(value = "longitude")
	private Double longitude;
	//columns END


	public PlaceInfo(){
	}

	public PlaceInfo(
		Integer id
	){
		this.id = id;
	}



	protected Serializable pkVal() {
		return this.id;
	}


	public void setId(Integer value) {
			this.id = value;
			}

	public Integer getId() {
			return this.id;
			}

	public String getType() {
			return this.type;
			}

	public void setType(String value) {
			this.type = value;
			}

	public String getName() {
			return this.name;
			}

	public void setName(String value) {
			this.name = value;
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

	public String getPlaces() {
			return this.places;
			}

	public void setPlaces(String value) {
			this.places = value;
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
		.append("Type",getType())
		.append("Name",getName())
		.append("Contacter",getContacter())
		.append("Status",getStatus())
		.append("Places",getPlaces())
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
		if(obj instanceof PlaceInfo == false) return false;
		if(this == obj) return true;
		PlaceInfo other = (PlaceInfo)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
