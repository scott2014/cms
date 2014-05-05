/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2014-05-05 09:50:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `repositoryId` bigint(64) DEFAULT NULL,
  `medicinalId` bigint(64) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES ('1', '2', '1', null, '2014-04-27 14:16:55');
INSERT INTO `favorite` VALUES ('2', '2', '2', null, '2014-04-27 14:16:58');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `repositoryId` bigint(64) DEFAULT NULL,
  `medicinalId` bigint(64) DEFAULT NULL,
  `lastViewTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('1', '1', '1', null, '2014-04-27 12:29:44');
INSERT INTO `history` VALUES ('2', '1', '2', null, '2014-04-27 12:42:58');
INSERT INTO `history` VALUES ('3', '1', '3', null, '2014-04-27 19:34:42');

-- ----------------------------
-- Table structure for medicinal
-- ----------------------------
DROP TABLE IF EXISTS `medicinal`;
CREATE TABLE `medicinal` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `formula` varchar(64) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `cas` varchar(16) DEFAULT NULL,
  `shape` varchar(16) DEFAULT NULL,
  `mUsage` varchar(16) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicinal
-- ----------------------------
INSERT INTO `medicinal` VALUES ('1', '', '', '', '', '', '', '', '1', '/upload/1398878467809.gif', '', '', '1', '2014-05-01 01:21:07', null);
INSERT INTO `medicinal` VALUES ('2', '', '', '', '', null, '', '', '1', '/upload/1398917162646.gif', '', '', '1', '2014-05-01 12:06:02', null);

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
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

-- ----------------------------
-- Records of repository
-- ----------------------------
INSERT INTO `repository` VALUES ('1', 'a01', '化学实验室', '西北大学老校区', '1', '我的试剂库', null, null, null, null, null, null);
INSERT INTO `repository` VALUES ('2', 'a1a', 'aa12e', null, '9', 'a1w', '2014-05-04 14:09:41', 'a1c', 'aa1ab', 'a1', 'a', '	      				      				      				      				      				      				      			\r\n	      	saa	  \r\n	      		  \r\n	      		  \r\n	      		  \r\n	      		  \r\n	      		  \r\n	      		  ');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, '809113633@qq.com', '626306805', 'aa', '13572459570', null, null, 'aa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', '/upload/1399130701944.gif', null, null);
INSERT INTO `user` VALUES ('2', 'scott', '50f1725279347cd1e04bf016026ae1b9', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('3', 'we', 'ff1ccf57e98c817df1efcd9fe44a8aeb', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', 'lam713', 'e10adc3949ba59abbe56e057f20f883e', 'ydy3128@126.com', '821836717', null, '18721323885', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', 'abc', '900150983cd24fb0d6963f7d28e17f72', 'a', 'a', 'a', 'a', null, null, 'aa', 'aaaa', 'aa', 'aa', 'aa', '/upload/1399131290920.gif', null, null);
INSERT INTO `user` VALUES ('6', 'nayangnianhua', '50f1725279347cd1e04bf016026ae1b9', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', 'admin2', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', 'xuesheng', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', 'admin', '21232f297a57a5a743894a0e4a801fc3', null, null, null, null, '2', null, null, null, null, null, null, null, '2014-05-05 09:49:36', null);

-- ----------------------------
-- Table structure for user_medicinal
-- ----------------------------
DROP TABLE IF EXISTS `user_medicinal`;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_medicinal
-- ----------------------------
INSERT INTO `user_medicinal` VALUES ('2', '1', '1', '3', null, '2014-05-01 08:20:15', '12', null);
INSERT INTO `user_medicinal` VALUES ('3', '9', '1', '2', null, '2014-05-01 11:13:32', '13', '1');
INSERT INTO `user_medicinal` VALUES ('4', '1', '2', '1', null, '2014-05-01 12:07:43', '0', '1');
INSERT INTO `user_medicinal` VALUES ('5', '5', '1', '2', null, '2014-05-01 22:55:00', '10', '1');

-- ----------------------------
-- Table structure for user_right
-- ----------------------------
DROP TABLE IF EXISTS `user_right`;
CREATE TABLE `user_right` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userId` bigint(64) DEFAULT NULL,
  `rightId` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `rightId` (`rightId`),
  CONSTRAINT `user_right_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `user_right_ibfk_2` FOREIGN KEY (`rightId`) REFERENCES `_right` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_right
-- ----------------------------
INSERT INTO `user_right` VALUES ('2', '7', '1');
INSERT INTO `user_right` VALUES ('3', '8', '1');
INSERT INTO `user_right` VALUES ('4', '9', '1');

-- ----------------------------
-- Table structure for _right
-- ----------------------------
DROP TABLE IF EXISTS `_right`;
CREATE TABLE `_right` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `rightCode` int(4) DEFAULT NULL,
  `rightName` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _right
-- ----------------------------
INSERT INTO `_right` VALUES ('1', '1', '管理员');
INSERT INTO `_right` VALUES ('2', '2', '学生');
