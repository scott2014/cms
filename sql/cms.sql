CREATE DATABASE  IF NOT EXISTS `cms` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cms`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: cms
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `_right`
--

DROP TABLE IF EXISTS `_right`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `_right` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `rightCode` int(4) DEFAULT NULL,
  `rightName` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_right`
--

LOCK TABLES `_right` WRITE;
/*!40000 ALTER TABLE `_right` DISABLE KEYS */;
INSERT INTO `_right` VALUES (1,1,'管理员'),(2,2,'学生');
/*!40000 ALTER TABLE `_right` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorite` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `repositoryId` bigint(64) DEFAULT NULL,
  `medicinalId` bigint(64) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES (1,2,1,NULL,'2014-05-05 12:09:27');
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `repositoryId` bigint(64) DEFAULT NULL,
  `medicinalId` bigint(64) DEFAULT NULL,
  `lastViewTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,1,1,NULL,'2014-05-07 07:49:15'),(2,2,1,NULL,'2014-05-05 16:37:06');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicinal`
--

DROP TABLE IF EXISTS `medicinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicinal` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `formula` varchar(64) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `cas` varchar(16) DEFAULT NULL,
  `shape` varchar(16) DEFAULT NULL,
  `mUsage` varchar(255) DEFAULT NULL,
  `security` varchar(32) DEFAULT NULL,
  `standard` varchar(32) DEFAULT NULL,
  `repositoryId` bigint(64) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `no` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `userId` bigint(64) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `_left` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicinal`
--

LOCK TABLES `medicinal` WRITE;
/*!40000 ALTER TABLE `medicinal` DISABLE KEYS */;
INSERT INTO `medicinal` VALUES (1,'CH4','甲烷','jw01','无色无味气体\r<br/>试试换行','可以用作燃气\r<br/>试试换行','可以用作燃气\r<br/>试试换行','0.005g',1,'/upload/1399256159218.jpg','hx01','常温保存\r<br/>试试换行',1,'2014-05-05 10:15:59',10),(2,'C2H2','乙炔','yq01','无色无味气体','合成其它有机化合物','易燃，易爆','0.0005g/瓶',1,'/upload/1399256309223.jpg','yq01','常温保存',1,'2014-05-05 10:18:29',16),(4,'C2H6','乙烷','cc02','无色无味\r<br/>气体','我也不知道？\r<br/>可以合成其它有机物吧！','安全\r<br/>很安全','0.007g/袋',1,'/upload/1399278762766.jpg','cc02','气体\r<br/>气体\r<br/>气体',1,'2014-05-05 16:32:42',100);
/*!40000 ALTER TABLE `medicinal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repository`
--

DROP TABLE IF EXISTS `repository`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repository` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `repoNo` varchar(16) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `userId` bigint(64) DEFAULT NULL,
  `repoName` varchar(64) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `faculty` varchar(255) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `fields` varchar(100) DEFAULT NULL,
  `advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repository`
--

LOCK TABLES `repository` WRITE;
/*!40000 ALTER TABLE `repository` DISABLE KEYS */;
INSERT INTO `repository` VALUES (1,'1','化学研究所',NULL,1,'xdwl01','2014-05-05 10:15:26','厦门大学','化学系','hx01','干燥仓库','及时更换室内干燥剂，保持室内干燥\r<br/>测试一下\r<br/>可以吗\r<br/>	      		  \r<br/>	      		  ');
/*!40000 ALTER TABLE `repository` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `QQ` varchar(16) DEFAULT NULL,
  `realName` varchar(16) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `gender` int(4) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `faculty` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','626306805@qq.com','626306805','yuanhoujun','13572459570',2,NULL,'西安北池头','西北大学','物理所','物理系','计算机科学爱好者，喜欢编程，爬山，跑步，乒乓球等等\r<br/>','/upload/1399255829535.jpg','2014-05-07 07:45:58','2014-05-05 10:07:27'),(2,'xs','44d610b3325b4aa08f32d925bc693149','809113633@qq.com','809113633','张靓颖','13572459571',2,NULL,'陕西西安','西工大','化学研究所','化学系','一个漂亮女生','/upload/1399278993211.jpg','2014-05-05 16:36:21','2014-05-05 11:16:57'),(3,'admin2','c84258e9c39059a89ab77d846ddab909',NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-05-07 07:53:00','2014-05-07 07:49:44'),(4,'admin3','32cacb2f994f6b42183a1300d9a3e8d6',NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-05-07 07:50:54');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_medicinal`
--

DROP TABLE IF EXISTS `user_medicinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_medicinal` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `medicinalId` bigint(64) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `checkTime` datetime DEFAULT NULL,
  `applyTime` datetime DEFAULT NULL,
  `applyNumber` float(10,0) DEFAULT NULL,
  `appId` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_medicinal`
--

LOCK TABLES `user_medicinal` WRITE;
/*!40000 ALTER TABLE `user_medicinal` DISABLE KEYS */;
INSERT INTO `user_medicinal` VALUES (6,2,1,2,'2014-05-05 11:17:15','2014-05-05 11:17:15',5,1),(7,2,2,1,'2014-05-05 11:22:55','2014-05-05 11:22:55',15,1);
/*!40000 ALTER TABLE `user_medicinal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_right`
--

DROP TABLE IF EXISTS `user_right`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_right` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `rightId` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `rightId` (`rightId`),
  CONSTRAINT `user_right_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `user_right_ibfk_2` FOREIGN KEY (`rightId`) REFERENCES `_right` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_right`
--

LOCK TABLES `user_right` WRITE;
/*!40000 ALTER TABLE `user_right` DISABLE KEYS */;
INSERT INTO `user_right` VALUES (5,1,1),(6,2,2),(7,3,1),(8,4,1);
/*!40000 ALTER TABLE `user_right` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-07  8:03:11
