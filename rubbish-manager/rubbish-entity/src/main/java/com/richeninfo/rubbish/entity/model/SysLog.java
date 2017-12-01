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
@TableName(value = "rz_sys_log")
@KeySequence(value = "rz_sys_log_SEQ")
public class SysLog extends Model<SysLog> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysLog";
	public static final String ALIAS_ID = "系统操作日志ID";
	public static final String ALIAS_LOG_SOURCE = "日志来源（PC、IOS、Android）";
	public static final String ALIAS_METHOD_NAME = "执行的方法名";
	public static final String ALIAS_USER_NUM = "操作人工号";
	public static final String ALIAS_USER_NAME = "操作人姓名";
	public static final String ALIAS_LASTCONSUME_TIME = "消耗时间";
	public static final String ALIAS_PERFORM_RESULT = "执行结果";
	public static final String ALIAS_MESSAGE = "日志执行详细信息";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_ADDITION1 = "备用1";
	public static final String ALIAS_ADDITION2 = "备用2";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_LOG_SOURCE = "LOG_SOURCE";
	public static final String FIELD_METHOD_NAME = "METHOD_NAME";
	public static final String FIELD_USER_NUM = "USER_NUM";
	public static final String FIELD_USER_NAME = "USER_NAME";
	public static final String FIELD_LASTCONSUME_TIME = "LASTCONSUME_TIME";
	public static final String FIELD_PERFORM_RESULT = "PERFORM_RESULT";
	public static final String FIELD_MESSAGE = "MESSAGE";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_ADDITION1 = "Addition1";
	public static final String FIELD_ADDITION2 = "Addition2";

	//date formats
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 系统操作日志ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 日志来源（PC、IOS、Android）       db_column: LOG_SOURCE
	 */
	@TableField(value = "LOG_SOURCE")
	private String logSource;
	/**
	 * 执行的方法名       db_column: METHOD_NAME
	 */
	@TableField(value = "METHOD_NAME")
	private String methodName;
	/**
	 * 操作人工号       db_column: USER_NUM
	 */
	@TableField(value = "USER_NUM")
	private String userNum;
	/**
	 * 操作人姓名       db_column: USER_NAME
	 */
	@TableField(value = "USER_NAME")
	private String userName;
	/**
	 * 消耗时间       db_column: LASTCONSUME_TIME
	 */
	@TableField(value = "LASTCONSUME_TIME")
	private String lastconsumeTime;
	/**
	 * 执行结果       db_column: PERFORM_RESULT
	 */
	@TableField(value = "PERFORM_RESULT")
	private Integer performResult;
	/**
	 * 日志执行详细信息       db_column: MESSAGE
	 */
	@TableField(value = "MESSAGE")
	private String message;
	/**
	 * 创建时间       db_column: CREATED_TIME
	 */
	@TableField(value = "CREATED_TIME")
	private java.util.Date createdTime;
	/**
	 * 备用1       db_column: Addition1
	 */
	@TableField(value = "Addition1")
	private String addition1;
	/**
	 * 备用2       db_column: Addition2
	 */
	@TableField(value = "Addition2")
	private String addition2;
	//columns END


	public SysLog(){
	}

	public SysLog(
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

	public String getLogSource() {
			return this.logSource;
			}

	public void setLogSource(String value) {
			this.logSource = value;
			}

	public String getMethodName() {
			return this.methodName;
			}

	public void setMethodName(String value) {
			this.methodName = value;
			}

	public String getUserNum() {
			return this.userNum;
			}

	public void setUserNum(String value) {
			this.userNum = value;
			}

	public String getUserName() {
			return this.userName;
			}

	public void setUserName(String value) {
			this.userName = value;
			}

	public String getLastconsumeTime() {
			return this.lastconsumeTime;
			}

	public void setLastconsumeTime(String value) {
			this.lastconsumeTime = value;
			}

	public Integer getPerformResult() {
			return this.performResult;
			}

	public void setPerformResult(Integer value) {
			this.performResult = value;
			}

	public String getMessage() {
			return this.message;
			}

	public void setMessage(String value) {
			this.message = value;
			}

	public java.util.Date getCreatedTime() {
			return this.createdTime;
			}

	public void setCreatedTime(java.util.Date value) {
			this.createdTime = value;
			}

	public String getAddition1() {
			return this.addition1;
			}

	public void setAddition1(String value) {
			this.addition1 = value;
			}

	public String getAddition2() {
			return this.addition2;
			}

	public void setAddition2(String value) {
			this.addition2 = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("LogSource",getLogSource())
		.append("MethodName",getMethodName())
		.append("UserNum",getUserNum())
		.append("UserName",getUserName())
		.append("LastconsumeTime",getLastconsumeTime())
		.append("PerformResult",getPerformResult())
		.append("Message",getMessage())
		.append("CreatedTime",getCreatedTime())
		.append("Addition1",getAddition1())
		.append("Addition2",getAddition2())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysLog == false) return false;
		if(this == obj) return true;
		SysLog other = (SysLog)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
