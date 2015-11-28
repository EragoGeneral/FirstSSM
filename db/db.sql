/*
SQLyog Job Agent Version 10.2 Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.7.9-log : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis`;

/*Table structure for table `system_menus` */

DROP TABLE IF EXISTS `system_menus`;

CREATE TABLE `system_menus` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Link` varchar(100) DEFAULT NULL,
  `Display_Order` int(11) DEFAULT NULL,
  `Parent_ID` int(11) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  `Path` varchar(200) DEFAULT NULL,
  `Is_Deleted` bit(1) DEFAULT NULL,
  `Create_By` int(11) DEFAULT NULL,
  `Create_Date` datetime DEFAULT NULL,
  `Update_By` int(11) DEFAULT NULL,
  `Update_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `system_menus` */

insert  into `system_menus` values (1,'系统管理','system',4,-1,1,'1','\0',1,'2015-11-16 17:35:50',1,'2015-11-16 17:35:58'),(2,'客户管理','customers',1,-1,1,'2','\0',1,'2015-11-16 17:56:50',1,'2015-11-16 17:57:12'),(3,'会员管理','members',2,-1,1,'3','\0',1,'2015-11-16 17:56:54',1,'2015-11-16 17:57:15'),(4,'租车管理','renting',3,-1,1,'4','\0',1,'2015-11-16 17:57:06',1,'2015-11-16 17:57:17'),(5,'菜单管理','system/menumanagement',1,1,2,'1.5','\0',1,'2015-11-16 17:58:07',1,'2015-11-16 17:58:10'),(6,'用户管理','system/usermanagement',2,1,2,'1.6','\0',1,'2015-11-16 17:59:15',1,'2015-11-16 17:59:18'),(7,'数据字典','system/basedata',3,1,2,'1.7','\0',1,'2015-11-16 18:00:16',1,'2015-11-16 18:00:18'),(8,'权限管理','system/rights',4,1,2,'1.8','\0',1,'2015-11-16 18:11:35',1,'2015-11-16 18:11:37'),(19,'组织机构','system/org',5,1,2,NULL,'',NULL,NULL,NULL,NULL),(22,'组织机构','system/org110',5,1,2,'1.22','',1,'2015-11-23 23:41:55',1,'2015-11-23 23:41:55'),(23,'车辆管理','renting/vehicle',1,4,11,'4.23','\0',1,'2015-11-23 23:48:41',1,'2015-11-23 23:48:42');

/*Table structure for table `system_users` */

DROP TABLE IF EXISTS `system_users`;

CREATE TABLE `system_users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Login_Name` varchar(30) NOT NULL,
  `User_Name` varchar(30) DEFAULT NULL,
  `Password` varchar(18) NOT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Birth` datetime DEFAULT NULL,
  `Dept_No` int(11) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Mobile` varchar(11) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Create_By` int(11) DEFAULT NULL,
  `Create_Date` datetime DEFAULT NULL,
  `Update_By` int(11) DEFAULT NULL,
  `Update_Date` datetime DEFAULT NULL,
  `Is_Deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `system_users` */

insert  into `system_users` values (1,'admin','系统管理员','admin','M','1990-07-20 00:00:00',1,'nice@gmail.com','13306255532','广东广州',1,'2015-11-25 15:28:18',1,'2015-11-28 18:47:03','\0'),(2,'zs','张三','123456','M','1992-05-18 00:00:00',2,'zs@163.com','18902225536','广东深圳',1,'1989-08-19 17:31:33',1,'2015-11-28 18:46:51',''),(5,'Steve','史蒂夫','123456','M','1991-03-21 00:00:00',3,'Steve@163.com','13365210026','广东惠州',1,'2015-11-27 23:07:18',1,'2015-11-27 23:07:18',''),(7,'Tony','托尼','123456','M','1989-08-06 00:00:00',4,'Tony@163.com','18922520036','广东珠海',1,'2015-11-27 23:08:36',1,'2015-11-27 23:08:36','\0'),(8,'Nacy','南希','123456','F','1993-07-24 00:00:00',1,'Nacy@sina.com','13800211153','广东潮阳',1,'2015-11-27 23:12:50',1,'2015-11-27 23:12:50',''),(9,'Jesicca','杰西卡','12345678','F','1990-01-09 00:00:00',2,'Jesi@yahoo.com','13400299863','广东潮州',1,'2015-11-27 23:16:07',1,'2015-11-27 23:16:07','\0'),(10,'Tiffiny','蒂芬妮','123456','F','1992-06-19 00:00:00',3,'Tiffiny@sina.com','13025632249','广东湛江',1,'2015-11-27 23:21:36',1,'2015-11-27 23:21:36','\0'),(12,'Kitty','刘琪','123456','F','1989-11-02 00:00:00',1,'Kiity@sina.com','13566203320','广东广州',1,'2015-11-28 12:59:17',1,'2015-11-28 12:59:17','\0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
