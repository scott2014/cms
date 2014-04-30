/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2014-04-30 18:15:07
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
  `left` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicinal
-- ----------------------------
INSERT INTO `medicinal` VALUES ('1', 'CH4', '甲烷', 'CC01', '无色、无味', null, '远离易燃物', '0.53kg/包', '1', '/upload/1398573314780.gif', 'm01', '低温存放', '1', null, null);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repository
-- ----------------------------
INSERT INTO `repository` VALUES ('1', 'A01', '西北大学化学系', '西北大学', '1', '西北大学化学实验室', null);
INSERT INTO `repository` VALUES ('2', 'A02', '西北大学物理系', '西北大学', '1', '西北大学物理实验室', null);
INSERT INTO `repository` VALUES ('3', 'dssc1', 'FUDAN', '713药品柜', '4', '713', null);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '809113633@qq.com', '626306805', null, '13572459570');
INSERT INTO `user` VALUES ('2', 'scott', '50f1725279347cd1e04bf016026ae1b9', null, null, null, null);
INSERT INTO `user` VALUES ('3', 'we', 'ff1ccf57e98c817df1efcd9fe44a8aeb', null, null, null, null);
INSERT INTO `user` VALUES ('4', 'lam713', 'e10adc3949ba59abbe56e057f20f883e', 'ydy3128@126.com', '821836717', null, '18721323885');
INSERT INTO `user` VALUES ('5', 'abc', '900150983cd24fb0d6963f7d28e17f72', null, null, null, null);
INSERT INTO `user` VALUES ('6', 'nayangnianhua', '50f1725279347cd1e04bf016026ae1b9', null, null, null, null);
INSERT INTO `user` VALUES ('7', '李王娜', '202cb962ac59075b964b07152d234b70', null, null, null, null);
INSERT INTO `user` VALUES ('8', 'xuesheng', '81dc9bdb52d04dc20036dbd8313ed055', null, null, null, null);
INSERT INTO `user` VALUES ('9', 'admin2010', '81dc9bdb52d04dc20036dbd8313ed055', null, null, null, null);
INSERT INTO `user` VALUES ('10', 'a2', '0cc175b9c0f1b6a831c399e269772661', null, null, null, null);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_medicinal
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_right
-- ----------------------------
INSERT INTO `user_right` VALUES ('1', '10', '1');

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
INSERT INTO `_right` VALUES ('1', '1', '学生');
INSERT INTO `_right` VALUES ('2', '2', '管理员');
