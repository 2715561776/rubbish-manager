/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.entity.model;

import java.io.Serializable;
import java.util.List;

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
@TableName(value = "rz_user")
@KeySequence(value = "rz_user_SEQ")
public class User extends Model<User> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "User";
	public static final String ALIAS_ID = "系统用户ID";
	public static final String ALIAS_USER_NAME = "姓名";
	public static final String ALIAS_LOGIN_NAME = "登录用户名";
	public static final String ALIAS_PASSWORD = "密码";
	public static final String ALIAS_POST_NAME = "岗位名称";
	public static final String ALIAS_STATUS = "状态（启用、冻结）";
	public static final String ALIAS_MEMO = "备注信息";
	public static final String ALIAS_CREATED_BY = "创建人账号";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "id";
	public static final String FIELD_USER_NAME = "User_Name";
	public static final String FIELD_LOGIN_NAME = "Login_Name";
	public static final String FIELD_PASSWORD = "Password";
	public static final String FIELD_POST_NAME = "Post_Name";
	public static final String FIELD_STATUS = "Status";
	public static final String FIELD_MEMO = "Memo";
	public static final String FIELD_CREATED_BY = "CREATED_BY";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 系统用户ID       db_column: id
	 */
	@TableId(value = "id")
	private Integer id;
	/**
	 * 姓名       db_column: User_Name
	 */
	@TableField(value = "User_Name")
	private String userName;
	/**
	 * 登录用户名       db_column: Login_Name
	 */
	@TableField(value = "Login_Name")
	private String loginName;
	/**
	 * 密码       db_column: Password
	 */
	@TableField(value = "Password")
	private String password;
	/**
	 * 岗位名称       db_column: Post_Name
	 */
	@TableField(value = "Post_Name")
	private String postName;
	/**
	 * 状态（启用、冻结）       db_column: Status
	 */
	@TableField(value = "Status")
	private String status;
	/**
	 * 备注信息       db_column: Memo
	 */
	@TableField(value = "Memo")
	private String memo;
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

	private transient List<SysMenu> sysMenuList;
	//columns END


	public User(){
	}

	public User(
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

	public String getUserName() {
			return this.userName;
			}

	public void setUserName(String value) {
			this.userName = value;
			}

	public String getLoginName() {
			return this.loginName;
			}

	public void setLoginName(String value) {
			this.loginName = value;
			}

	public String getPassword() {
			return this.password;
			}

	public void setPassword(String value) {
			this.password = value;
			}

	public String getPostName() {
			return this.postName;
			}

	public void setPostName(String value) {
			this.postName = value;
			}

	public String getStatus() {
			return this.status;
			}

	public void setStatus(String value) {
			this.status = value;
			}

	public String getMemo() {
			return this.memo;
			}

	public void setMemo(String value) {
			this.memo = value;
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
		.append("UserName",getUserName())
		.append("LoginName",getLoginName())
		.append("Password",getPassword())
		.append("PostName",getPostName())
		.append("Status",getStatus())
		.append("Memo",getMemo())
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
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

	public List<SysMenu> getSysMenuList() {
		return sysMenuList;
	}

	public void setSysMenuList(List<SysMenu> sysMenuList) {
		this.sysMenuList = sysMenuList;
	}
}
