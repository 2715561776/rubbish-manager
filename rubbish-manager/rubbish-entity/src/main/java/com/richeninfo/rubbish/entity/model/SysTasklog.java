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
@TableName(value = "rz_sys_tasklog")
@KeySequence(value = "rz_sys_tasklog_SEQ")
public class SysTasklog extends Model<SysTasklog> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysTasklog";
	public static final String ALIAS_ID = "任务ID";
	public static final String ALIAS_TASK_CODE = "任务代码";
	public static final String ALIAS_TASK_NAME = "任务名称";
	public static final String ALIAS_METHOD_NAME = "执行的方法名";
	public static final String ALIAS_LAST_PERFORM_TIME = "上次执行日期";
	public static final String ALIAS_LAST_CONSUME_TIME = "消耗时间";
	public static final String ALIAS_PERFORM_RESULT = "执行结果0:失败；1：成功；2：异常";
	public static final String ALIAS_MESSAGE = "日志执行详细信息";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_ADDITION1 = "备用1";
	public static final String ALIAS_ADDITION2 = "备用2";
	public static final String ALIAS_ADDITION3 = "备用3";
	public static final String ALIAS_ADDITION4 = "备用4";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_TASK_CODE = "Task_Code";
	public static final String FIELD_TASK_NAME = "Task_Name";
	public static final String FIELD_METHOD_NAME = "Method_Name";
	public static final String FIELD_LAST_PERFORM_TIME = "LastPerform_Time";
	public static final String FIELD_LAST_CONSUME_TIME = "LastConsume_Time";
	public static final String FIELD_PERFORM_RESULT = "Perform_Result";
	public static final String FIELD_MESSAGE = "Message";
	public static final String FIELD_CREATED_TIME = "Created_Time";
	public static final String FIELD_ADDITION1 = "Addition1";
	public static final String FIELD_ADDITION2 = "Addition2";
	public static final String FIELD_ADDITION3 = "Addition3";
	public static final String FIELD_ADDITION4 = "Addition4";

	//date formats
	public static final String FORMAT_LAST_PERFORM_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;

	//columns START
	/**
	 * 任务ID       db_column: ID
	 */
	@TableId(value = "ID")
	private Integer id;
	/**
	 * 任务代码       db_column: Task_Code
	 */
	@TableField(value = "Task_Code")
	private String taskCode;
	/**
	 * 任务名称       db_column: Task_Name
	 */
	@TableField(value = "Task_Name")
	private String taskName;
	/**
	 * 执行的方法名       db_column: Method_Name
	 */
	@TableField(value = "Method_Name")
	private String methodName;
	/**
	 * 上次执行日期       db_column: LastPerform_Time
	 */
	@TableField(value = "LastPerform_Time")
	private java.util.Date lastPerformTime;
	/**
	 * 消耗时间       db_column: LastConsume_Time
	 */
	@TableField(value = "LastConsume_Time")
	private String lastConsumeTime;
	/**
	 * 执行结果0:失败；1：成功；2：异常       db_column: Perform_Result
	 */
	@TableField(value = "Perform_Result")
	private Integer performResult;
	/**
	 * 日志执行详细信息       db_column: Message
	 */
	@TableField(value = "Message")
	private String message;
	/**
	 * 创建时间       db_column: Created_Time
	 */
	@TableField(value = "Created_Time")
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
	/**
	 * 备用3       db_column: Addition3
	 */
	@TableField(value = "Addition3")
	private String addition3;
	/**
	 * 备用4       db_column: Addition4
	 */
	@TableField(value = "Addition4")
	private String addition4;
	//columns END


	public SysTasklog(){
	}

	public SysTasklog(
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

	public String getTaskCode() {
			return this.taskCode;
			}

	public void setTaskCode(String value) {
			this.taskCode = value;
			}

	public String getTaskName() {
			return this.taskName;
			}

	public void setTaskName(String value) {
			this.taskName = value;
			}

	public String getMethodName() {
			return this.methodName;
			}

	public void setMethodName(String value) {
			this.methodName = value;
			}

	public java.util.Date getLastPerformTime() {
			return this.lastPerformTime;
			}

	public void setLastPerformTime(java.util.Date value) {
			this.lastPerformTime = value;
			}

	public String getLastConsumeTime() {
			return this.lastConsumeTime;
			}

	public void setLastConsumeTime(String value) {
			this.lastConsumeTime = value;
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

	public String getAddition3() {
			return this.addition3;
			}

	public void setAddition3(String value) {
			this.addition3 = value;
			}

	public String getAddition4() {
			return this.addition4;
			}

	public void setAddition4(String value) {
			this.addition4 = value;
			}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		.append("Id",getId())
		.append("TaskCode",getTaskCode())
		.append("TaskName",getTaskName())
		.append("MethodName",getMethodName())
		.append("LastPerformTime",getLastPerformTime())
		.append("LastConsumeTime",getLastConsumeTime())
		.append("PerformResult",getPerformResult())
		.append("Message",getMessage())
		.append("CreatedTime",getCreatedTime())
		.append("Addition1",getAddition1())
		.append("Addition2",getAddition2())
		.append("Addition3",getAddition3())
		.append("Addition4",getAddition4())
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		.append(getId())
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysTasklog == false) return false;
		if(this == obj) return true;
		SysTasklog other = (SysTasklog)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
