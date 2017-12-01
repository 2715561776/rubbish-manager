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
@TableName(value = "rz_sys_menu")
@KeySequence(value = "rz_sys_menu_SEQ")
public class SysMenu extends Model<SysMenu> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysMenu";
	public static final String ALIAS_ID = "权限菜单ID";
	public static final String ALIAS_MENU_CODE = "菜单CODE";
	public static final String ALIAS_MENU_NAME = "菜单名称";
	public static final String ALIAS_MENU_DESC = "菜单描述";
	public static final String ALIAS_MENU_TYPE = "菜单类型, M:目录菜单 F:带链接的菜单 B:按钮";
	public static final String ALIAS_MENU_HREF = "菜单路径";
	public static final String ALIAS_PARENT_ID = "父菜单ID，默认为0";
	public static final String ALIAS_SORT = "排序";
	public static final String ALIAS_LEVEL = "菜单等级";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_MENU_CODE = "MENU_CODE";
	public static final String FIELD_MENU_NAME = "MENU_NAME";
	public static final String FIELD_MENU_DESC = "MENU_DESC";
	public static final String FIELD_MENU_TYPE = "MENU_TYPE";
	public static final String FIELD_MENU_HREF = "MENU_HREF";
	public static final String FIELD_PARENT_ID = "PARENT_ID";
	public static final String FIELD_SORT = "SORT";
	public static final String FIELD_LEVEL = "LEVEL";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 权限菜单ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 菜单CODE       db_column: MENU_CODE
	 */
	@TableField(value = "MENU_CODE")
	private String menuCode;
	/**
	 * 菜单名称       db_column: MENU_NAME
	 */
	@TableField(value = "MENU_NAME")
	private String menuName;
	/**
	 * 菜单描述       db_column: MENU_DESC
	 */
	@TableField(value = "MENU_DESC")
	private String menuDesc;
	/**
	 * 菜单类型, M:目录菜单 F:带链接的菜单 B:按钮       db_column: MENU_TYPE
	 */
	@TableField(value = "MENU_TYPE")
	private String menuType;
	/**
	 * 菜单路径       db_column: MENU_HREF
	 */
	@TableField(value = "MENU_HREF")
	private String menuHref;
	/**
	 * 父菜单ID，默认为0       db_column: PARENT_ID
	 */
	@TableField(value = "PARENT_ID")
	private String parentId;
	/**
	 * 排序       db_column: SORT
	 */
	@TableField(value = "SORT")
	private Integer sort;
	/**
	 * 菜单等级       db_column: LEVEL
	 */
	@TableField(value = "LEVEL")
	private Integer level;
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
	//columns END


	public SysMenu(){
	}

	public SysMenu(
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

	public String getMenuCode() {
			return this.menuCode;
			}

	public void setMenuCode(String value) {
			this.menuCode = value;
			}

	public String getMenuName() {
			return this.menuName;
			}

	public void setMenuName(String value) {
			this.menuName = value;
			}

	public String getMenuDesc() {
			return this.menuDesc;
			}

	public void setMenuDesc(String value) {
			this.menuDesc = value;
			}

	public String getMenuType() {
			return this.menuType;
			}

	public void setMenuType(String value) {
			this.menuType = value;
			}

	public String getMenuHref() {
			return this.menuHref;
			}

	public void setMenuHref(String value) {
			this.menuHref = value;
			}

	public String getParentId() {
			return this.parentId;
			}

	public void setParentId(String value) {
			this.parentId = value;
			}

	public Integer getSort() {
			return this.sort;
			}

	public void setSort(Integer value) {
			this.sort = value;
			}

	public Integer getLevel() {
			return this.level;
			}

	public void setLevel(Integer value) {
			this.level = value;
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
		.append("MenuCode",getMenuCode())
		.append("MenuName",getMenuName())
		.append("MenuDesc",getMenuDesc())
		.append("MenuType",getMenuType())
		.append("MenuHref",getMenuHref())
		.append("ParentId",getParentId())
		.append("Sort",getSort())
		.append("Level",getLevel())
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
		if(obj instanceof SysMenu == false) return false;
		if(this == obj) return true;
		SysMenu other = (SysMenu)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
