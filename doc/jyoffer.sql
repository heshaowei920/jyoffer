/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : jyoffer

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-10-13 17:57:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for catagroy
-- ----------------------------
DROP TABLE IF EXISTS `catagroy`;
CREATE TABLE `catagroy` (
  `theID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`theID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业分类';

-- ----------------------------
-- Records of catagroy
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `theID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `property` varchar(255) DEFAULT NULL,
  `buildDate` varchar(30) DEFAULT NULL,
  `createDate` varchar(20) DEFAULT NULL,
  `workCount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`theID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司表';

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `theID` int(11) NOT NULL AUTO_INCREMENT,
  `jobName` varchar(100) DEFAULT NULL,
  `workNum` int(11) DEFAULT NULL,
  `pay` varchar(100) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `companyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`theID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `theID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`theID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `theID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `appraise` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`theID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of worker
-- ----------------------------
