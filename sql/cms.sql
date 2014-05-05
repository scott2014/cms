/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2014-05-05 17:08:26
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
INSERT INTO `favorite` VALUES ('1', '2', '1', null, '2014-05-05 12:09:27');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('1', '1', '1', null, '2014-05-05 16:35:48');
INSERT INTO `history` VALUES ('2', '2', '1', null, '2014-05-05 16:37:06');

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

-- ----------------------------
-- Records of medicinal
-- ----------------------------
INSERT INTO `medicinal` VALUES ('1', 'CH4', '甲烷', 'jw01', '无色无味气体\r<br/>试试换行', '可以用作燃气\r<br/>试试换行', '可以用作燃气\r<br/>试试换行', '0.005g', '1', '/upload/1399256159218.jpg', 'hx01', '常温保存\r<br/>试试换行', '1', '2014-05-05 10:15:59', '10');
INSERT INTO `medicinal` VALUES ('2', 'C2H2', '乙炔', 'yq01', '无色无味气体', '合成其它有机化合物', '易燃，易爆', '0.0005g/瓶', '1', '/upload/1399256309223.jpg', 'yq01', '常温保存', '1', '2014-05-05 10:18:29', '16');
INSERT INTO `medicinal` VALUES ('4', 'C2H6', '乙烷', 'cc02', '无色无味\r<br/>气体', '我也不知道？\r<br/>可以合成其它有机物吧！', '安全\r<br/>很安全', '0.007g/袋', '1', '/upload/1399278762766.jpg', 'cc02', '气体\r<br/>气体\r<br/>气体', '1', '2014-05-05 16:32:42', '100');

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
INSERT INTO `repository` VALUES ('1', '1', '化学研究所', null, '1', 'xdwl01', '2014-05-05 10:15:26', '厦门大学', '化学系', 'hx01', '干燥仓库', '及时更换室内干燥剂，保持室内干燥\r<br/>测试一下\r<br/>可以吗\r<br/>	      		  \r<br/>	      		  ');

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
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '626306805@qq.com', '626306805', 'yuanhoujun', '13572459570', '2', null, '西安北池头', '西北大学', '物理所', '物理系', '计算机科学爱好者，喜欢编程，爬山，跑步，乒乓球等等\r<br/>', '/upload/1399255829535.jpg', '2014-05-05 16:43:39', '2014-05-05 10:07:27');
INSERT INTO `user` VALUES ('2', 'xs', '44d610b3325b4aa08f32d925bc693149', '809113633@qq.com', '809113633', '张靓颖', '13572459571', '2', null, '陕西西安', '西工大', '化学研究所', '化学系', '一个漂亮女生', '/upload/1399278993211.jpg', '2014-05-05 16:36:21', '2014-05-05 11:16:57');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_medicinal
-- ----------------------------
INSERT INTO `user_medicinal` VALUES ('6', '2', '1', '2', '2014-05-05 11:17:15', '2014-05-05 11:17:15', '5', '1');
INSERT INTO `user_medicinal` VALUES ('7', '2', '2', '1', '2014-05-05 11:22:55', '2014-05-05 11:22:55', '15', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_right
-- ----------------------------
INSERT INTO `user_right` VALUES ('5', '1', '1');
INSERT INTO `user_right` VALUES ('6', '2', '2');

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
