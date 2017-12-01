# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.23)
# Database: rubbish-manager
# Generation Time: 2017-10-10 07:44:28 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table rz_bidding_company_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_bidding_company_info`;

CREATE TABLE `rz_bidding_company_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `COMPANY_NAME` varchar(100) NOT NULL COMMENT '企业名称',
  `CONTACTER` varchar(100) NOT NULL COMMENT '联系人',
  `STATUS` varchar(100) NOT NULL COMMENT '联系人',
  `CREATED_BY` varchar(32) NOT NULL COMMENT '创建人账号',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(32) DEFAULT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运输公司信息表';



# Dump of table rz_place_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_place_info`;

CREATE TABLE `rz_place_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `Type` varchar(2) NOT NULL COMMENT '类型（消纳场，小区，商业地区）',
  `NAME` varchar(100) NOT NULL COMMENT '名称',
  `CONTACTER` varchar(100) NOT NULL COMMENT '联系人',
  `STATUS` varchar(100) NOT NULL COMMENT '状态',
  `PLACES` varchar(100) NOT NULL COMMENT '场地信息，经纬度集合（经度1,维度1;经度2,维度2;...）',
  `CREATED_BY` varchar(32) NOT NULL COMMENT '创建人账号',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(32) DEFAULT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='场地信息表';



# Dump of table rz_sys_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_log`;

CREATE TABLE `rz_sys_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统操作日志ID',
  `LOG_SOURCE` varchar(30) DEFAULT NULL COMMENT '日志来源（PC、IOS、Android）',
  `METHOD_NAME` varchar(30) DEFAULT NULL COMMENT '执行的方法名',
  `USER_NUM` varchar(100) DEFAULT NULL COMMENT '操作人工号',
  `USER_NAME` varchar(30) DEFAULT NULL COMMENT '操作人姓名',
  `LASTCONSUME_TIME` varchar(200) DEFAULT NULL COMMENT '消耗时间',
  `PERFORM_RESULT` int(1) DEFAULT NULL COMMENT '执行结果',
  `MESSAGE` varchar(4000) DEFAULT NULL COMMENT '日志执行详细信息',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `Addition1` varchar(240) DEFAULT NULL COMMENT '备用1',
  `Addition2` varchar(240) DEFAULT NULL COMMENT '备用2',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志';



# Dump of table rz_sys_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_menu`;

CREATE TABLE `rz_sys_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限菜单ID',
  `MENU_CODE` varchar(30) DEFAULT NULL COMMENT '菜单CODE',
  `MENU_NAME` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `MENU_DESC` varchar(100) DEFAULT NULL COMMENT '菜单描述',
  `MENU_TYPE` varchar(1) DEFAULT NULL COMMENT '菜单类型, M:目录菜单 F:带链接的菜单 B:按钮',
  `MENU_HREF` varchar(50) DEFAULT NULL COMMENT '菜单路径',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父菜单ID，默认为0',
  `SORT` int(5) DEFAULT NULL COMMENT '排序',
  `LEVEL` int(1) DEFAULT NULL COMMENT '菜单等级',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单表';



# Dump of table rz_sys_parameter
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_parameter`;

CREATE TABLE `rz_sys_parameter` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
  `PARAM_CODE` varchar(30) DEFAULT NULL COMMENT '参数代码',
  `PARAM_NAME` varchar(240) DEFAULT NULL COMMENT '参数名称',
  `MODULE_NAME` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `PARAMTYPE_CODE` varchar(30) DEFAULT NULL COMMENT '参数类型CODE',
  `PARAMTYPE_NAME` varchar(255) DEFAULT NULL COMMENT '参数类型名称',
  `PARAM_DESC` varchar(240) DEFAULT NULL COMMENT '参数描述',
  `PARAM_VALUE` varchar(200) DEFAULT NULL COMMENT '参数值',
  `IS_SYSTEM` int(1) DEFAULT NULL COMMENT '是否是系统参数',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';



# Dump of table rz_sys_parameter_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_parameter_type`;

CREATE TABLE `rz_sys_parameter_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
  `TYPE` int(1) DEFAULT NULL COMMENT '参数类型',
  `PARAMTYPE_CODE` varchar(32) DEFAULT NULL COMMENT '参数类型编码',
  `PARAMTYPE_NAME` varchar(240) DEFAULT NULL COMMENT '参数类型名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数类型表';



# Dump of table rz_sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_role`;

CREATE TABLE `rz_sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统角色ID',
  `ROLE_CODE` varchar(30) DEFAULT NULL COMMENT '系统角色代码',
  `ROLE_NAME` varchar(200) DEFAULT NULL COMMENT '系统角色名称',
  `ROLE_DESC` varchar(500) DEFAULT NULL COMMENT '系统角色描述',
  `IS_ACTIVE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';



# Dump of table rz_sys_role_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_role_menu`;

CREATE TABLE `rz_sys_role_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色菜单ID',
  `ROLE_CODE` varchar(32) DEFAULT NULL COMMENT '系统角色编码',
  `MENU_CODE` varchar(32) DEFAULT NULL COMMENT '系统菜单CODE',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色菜单关联表';



# Dump of table rz_sys_task
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_task`;

CREATE TABLE `rz_sys_task` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `Task_Code` varchar(32) NOT NULL COMMENT '任务代码',
  `Task_Name` varchar(240) NOT NULL COMMENT '任务名称',
  `Task_Desc` varchar(240) DEFAULT NULL COMMENT '任务描述',
  `Task_value` varchar(500) NOT NULL COMMENT '任务调度参数值',
  `TaskClass_Name` varchar(60) NOT NULL COMMENT '任务类名',
  `Task_Status` varchar(30) NOT NULL COMMENT '任务状态',
  `LastRun_Time` datetime DEFAULT NULL COMMENT '最后运行成功时间',
  `Addition1` varchar(240) DEFAULT NULL COMMENT '备用1',
  `Addition2` varchar(240) DEFAULT NULL COMMENT '备用2',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表';



# Dump of table rz_sys_tasklog
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_tasklog`;

CREATE TABLE `rz_sys_tasklog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `Task_Code` varchar(32) NOT NULL COMMENT '任务代码',
  `Task_Name` varchar(240) NOT NULL COMMENT '任务名称',
  `Method_Name` varchar(30) NOT NULL COMMENT '执行的方法名',
  `LastPerform_Time` datetime DEFAULT NULL COMMENT '上次执行日期',
  `LastConsume_Time` varchar(200) NOT NULL COMMENT '消耗时间',
  `Perform_Result` int(11) NOT NULL COMMENT '执行结果0:失败；1：成功；2：异常',
  `Message` varchar(4000) DEFAULT NULL COMMENT '日志执行详细信息',
  `Created_Time` datetime DEFAULT NULL COMMENT '创建时间',
  `Addition1` varchar(240) DEFAULT NULL COMMENT '备用1',
  `Addition2` varchar(240) DEFAULT NULL COMMENT '备用2',
  `Addition3` varchar(240) DEFAULT NULL COMMENT '备用3',
  `Addition4` varchar(240) DEFAULT NULL COMMENT '备用4',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口执行日志表';



# Dump of table rz_sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_sys_user_role`;

CREATE TABLE `rz_sys_user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `USER_NUM` varchar(32) DEFAULT NULL COMMENT '系统用户工号',
  `ROLE_CODE` varchar(32) DEFAULT NULL COMMENT '系统角色编码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色关系表';



# Dump of table rz_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_user`;

CREATE TABLE `rz_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户ID',
  `User_Name` varchar(100) NOT NULL COMMENT '姓名',
  `Login_Name` varchar(100) DEFAULT NULL COMMENT '登录用户名',
  `Password` varchar(100) DEFAULT NULL COMMENT '密码',
  `Post_Name` varchar(200) DEFAULT NULL COMMENT '岗位名称',
  `Status` varchar(20) NOT NULL COMMENT '状态（启用、冻结）',
  `Memo` varchar(400) DEFAULT NULL COMMENT '备注信息',
  `CREATED_BY` varchar(32) NOT NULL COMMENT '创建人账号',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(32) DEFAULT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

LOCK TABLES `rz_user` WRITE;
/*!40000 ALTER TABLE `rz_user` DISABLE KEYS */;

INSERT INTO `rz_user` (`id`, `User_Name`, `Login_Name`, `Password`, `Post_Name`, `Status`, `Memo`, `CREATED_BY`, `CREATED_TIME`, `LASTUPDATED_BY`, `LASTUPDATED_TIME`)
VALUES
	(1,'test','t1@test.com','123','11111','123',NULL,'123','2017-10-10 15:25:24',NULL,NULL);

/*!40000 ALTER TABLE `rz_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rz_vehicle
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_vehicle`;

CREATE TABLE `rz_vehicle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `COMPANY_ID` int(11) NOT NULL COMMENT '通行证编号（关联中标公司id）',
  `SEQ` varchar(100) NOT NULL COMMENT '序号',
  `MOTORCADE_NAME` varchar(100) DEFAULT NULL COMMENT '车队名称',
  `LICENSE_PLAT_NUMBER` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `FACILITY_NAME` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `FACILITY_ID` varchar(100) DEFAULT NULL COMMENT '设备ID',
  `FACILITY_NO` varchar(100) DEFAULT NULL COMMENT '设备卡号',
  `DRIVER_NAME` varchar(100) NOT NULL COMMENT '驾驶员姓名',
  `DRIVER_PHONE` varchar(100) NOT NULL COMMENT '驾驶员电话',
  `CREATED_BY` varchar(32) NOT NULL COMMENT '创建人账号',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(32) DEFAULT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息表';



# Dump of table rz_vehicle_appoint
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_vehicle_appoint`;

CREATE TABLE `rz_vehicle_appoint` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CARD_NUMBER` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `FACILITY_ID` varchar(100) DEFAULT NULL COMMENT '设备ID',
  `FACILITY_NO` varchar(100) DEFAULT NULL COMMENT '设备卡号',
  `ARRIVAL_TIME` datetime DEFAULT NULL COMMENT '最早到达时间，可填写提前30分钟，便于收集经纬度',
  `ACTUAL_TIME` datetime DEFAULT NULL COMMENT '实际到达时间',
  `PLACE_ID` int(11) DEFAULT NULL COMMENT '预约场地ID',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆清运预约表';



# Dump of table rz_vehicle_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_vehicle_detail`;

CREATE TABLE `rz_vehicle_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CARD_NUMBER` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `FACILITY_ID` varchar(100) DEFAULT NULL COMMENT '设备ID',
  `FACILITY_NO` varchar(100) DEFAULT NULL COMMENT '设备卡号',
  `APPROVE_NO` varchar(100) DEFAULT NULL COMMENT '清运资质证书编号',
  `EFFECTIVE_DATE` date DEFAULT NULL COMMENT '截止有效日期',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆审核详细信息表';



# Dump of table rz_vehicle_locus
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_vehicle_locus`;

CREATE TABLE `rz_vehicle_locus` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CARD_NUMBER` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `FACILITY_ID` varchar(100) DEFAULT NULL COMMENT '设备ID',
  `FACILITY_NO` varchar(100) DEFAULT NULL COMMENT '设备卡号',
  `CURRENT_TIME` datetime DEFAULT NULL COMMENT '设备卡号',
  `LATITUDE` varchar(100) DEFAULT NULL COMMENT '车辆经度',
  `LONGITUDE` varchar(100) DEFAULT NULL COMMENT '车辆纬度',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆行驶轨迹表';



# Dump of table rz_vehicle_weight
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rz_vehicle_weight`;

CREATE TABLE `rz_vehicle_weight` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `LICENSE_PLAT_NUMBER` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `FACILITY_ID` varchar(100) DEFAULT NULL COMMENT '设备ID',
  `FACILITY_NO` varchar(100) DEFAULT NULL COMMENT '设备卡号',
  `CURRENT_TIME` datetime DEFAULT NULL COMMENT '最早到达时间，可填写提前30分钟，便于收集经纬度',
  `PLACE_ID` int(11) DEFAULT NULL COMMENT '垃圾来源场地ID',
  `WEIGHT` int(11) DEFAULT NULL COMMENT '垃圾重量（吨）',
  `Created_By` int(11) NOT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` int(11) NOT NULL COMMENT '最后修改人账号',
  `LASTUPDATED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆分捡站记录表';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
