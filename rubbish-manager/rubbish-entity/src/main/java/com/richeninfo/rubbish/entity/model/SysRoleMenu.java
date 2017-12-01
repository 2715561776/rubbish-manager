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
@TableName(value = "rz_sys_role_menu")
@KeySequence(value = "rz_sys_role_menu_SEQ")
public class SysRoleMenu extends Model<SysRoleMenu> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysRoleMenu";
	public static final String ALIAS_ID = "角色菜单ID";
	public static final String ALIAS_ROLE_CODE = "系统角色编码";
	public static final String ALIAS_MENU_CODE = "系统菜单CODE";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_ROLE_CODE = "ROLE_CODE";
	public static final String FIELD_MENU_CODE = "MENU_CODE";

	//date formats

	//columns START
	/**
	 * 角色菜单ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 系统角色编码       db_column: ROLE_CODE
	 */
	@TableField(value = "ROLE_CODE")
	private String roleCode;
	/**
	 * 系统菜单CODE       db_column: MENU_CODE
	 */
	@TableField(value = "MENU_CODE")
	private String menuCode;
	//columns END


	public SysRoleMenu(){
	}

	public SysRoleMenu(
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

	public String getRoleCode() {
			return this.roleCode;
			}

	public void setRoleCode(String value) {
			this.roleCode = value;
			}

	public String getMenuCode() {
			return this.menuCode;
			}

	public void setMenuCode(String value) {
			this.menuCode = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("RoleCode",getRoleCode())
		.append("MenuCode",getMenuCode())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysRoleMenu == false) return false;
		if(this == obj) return true;
		SysRoleMenu other = (SysRoleMenu)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
