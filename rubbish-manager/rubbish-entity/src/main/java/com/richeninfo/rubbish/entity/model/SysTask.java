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
@TableName(value = "rz_sys_task")
@KeySequence(value = "rz_sys_task_SEQ")
public class SysTask extends Model<SysTask> implements Serializable{

	//alias
	public static final String TABLE_ALIAS = "SysTask";
	public static final String ALIAS_ID = "任务ID";
	public static final String ALIAS_TASK_CODE = "任务代码";
	public static final String ALIAS_TASK_NAME = "任务名称";
	public static final String ALIAS_TASK_DESC = "任务描述";
	public static final String ALIAS_TASK_VALUE = "任务调度参数值";
	public static final String ALIAS_TASK_CLASS_NAME = "任务类名";
	public static final String ALIAS_TASK_STATUS = "任务状态";
	public static final String ALIAS_LAST_RUN_TIME = "最后运行成功时间";
	public static final String ALIAS_ADDITION1 = "备用1";
	public static final String ALIAS_ADDITION2 = "备用2";
	public static final String ALIAS_CREATED_BY = "创建人";
	public static final String ALIAS_CREATED_TIME = "创建时间";
	public static final String ALIAS_LASTUPDATED_BY = "最后修改人账号";
	public static final String ALIAS_LASTUPDATED_TIME = "最后修改时间";

	//field
	public static final String FIELD_ID = "ID";
	public static final String FIELD_TASK_CODE = "Task_Code";
	public static final String FIELD_TASK_NAME = "Task_Name";
	public static final String FIELD_TASK_DESC = "Task_Desc";
	public static final String FIELD_TASK_VALUE = "Task_value";
	public static final String FIELD_TASK_CLASS_NAME = "TaskClass_Name";
	public static final String FIELD_TASK_STATUS = "Task_Status";
	public static final String FIELD_LAST_RUN_TIME = "LastRun_Time";
	public static final String FIELD_ADDITION1 = "Addition1";
	public static final String FIELD_ADDITION2 = "Addition2";
	public static final String FIELD_CREATED_BY = "Created_By";
	public static final String FIELD_CREATED_TIME = "CREATED_TIME";
	public static final String FIELD_LASTUPDATED_BY = "LASTUPDATED_BY";
	public static final String FIELD_LASTUPDATED_TIME = "LASTUPDATED_TIME";

	//date formats
	public static final String FORMAT_LAST_RUN_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_CREATED_TIME = DateUtil.DATETIME_PATTERN;
	public static final String FORMAT_LASTUPDATED_TIME = DateUtil.DATETIME_PATTERN;

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
	 * 任务描述       db_column: Task_Desc
	 */
	@TableField(value = "Task_Desc")
	private String taskDesc;
	/**
	 * 任务调度参数值       db_column: Task_value
	 */
	@TableField(value = "Task_value")
	private String taskValue;
	/**
	 * 任务类名       db_column: TaskClass_Name
	 */
	@TableField(value = "TaskClass_Name")
	private String taskClassName;
	/**
	 * 任务状态       db_column: Task_Status
	 */
	@TableField(value = "Task_Status")
	private String taskStatus;
	/**
	 * 最后运行成功时间       db_column: LastRun_Time
	 */
	@TableField(value = "LastRun_Time")
	private java.util.Date lastRunTime;
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


	public SysTask(){
	}

	public SysTask(
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

	public String getTaskDesc() {
			return this.taskDesc;
			}

	public void setTaskDesc(String value) {
			this.taskDesc = value;
			}

	public String getTaskValue() {
			return this.taskValue;
			}

	public void setTaskValue(String value) {
			this.taskValue = value;
			}

	public String getTaskClassName() {
			return this.taskClassName;
			}

	public void setTaskClassName(String value) {
			this.taskClassName = value;
			}

	public String getTaskStatus() {
			return this.taskStatus;
			}

	public void setTaskStatus(String value) {
			this.taskStatus = value;
			}

	public java.util.Date getLastRunTime() {
			return this.lastRunTime;
			}

	public void setLastRunTime(java.util.Date value) {
			this.lastRunTime = value;
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
		.append("TaskCode",getTaskCode())
		.append("TaskName",getTaskName())
		.append("TaskDesc",getTaskDesc())
		.append("TaskValue",getTaskValue())
		.append("TaskClassName",getTaskClassName())
		.append("TaskStatus",getTaskStatus())
		.append("LastRunTime",getLastRunTime())
		.append("Addition1",getAddition1())
		.append("Addition2",getAddition2())
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
		if(obj instanceof SysTask == false) return false;
		if(this == obj) return true;
		SysTask other = (SysTask)obj;
		return new EqualsBuilder()
		.append(getId(),other.getId())
		.isEquals();
	}

}
