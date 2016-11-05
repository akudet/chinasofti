/*
Navicat MySQL Data Transfer

Source Server         : jtwu
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : tp4

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-09-22 16:56:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `checkin`
-- ----------------------------
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin` (
  `checkin_id` varchar(32) NOT NULL,
  `room_id` varchar(64) NOT NULL,
  `cus_info_id` varchar(64) NOT NULL,
  `checkin_time` timestamp NOT NULL,
  `checkin_type` varchar(16) NOT NULL,
  `price` float NOT NULL,
  `num_of_days` int(11) NOT NULL,
  `deposit` float NOT NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`checkin_id`),
  KEY `fk_room_id` (`room_id`),
  KEY `fk_cus_info_id` (`cus_info_id`),
  CONSTRAINT `fk_cus_info_id` FOREIGN KEY (`cus_info_id`) REFERENCES `cus_info` (`cus_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkin
-- ----------------------------
INSERT INTO `checkin` VALUES ('in20160921034322', '1000', '30c3e414cfc140c990163546b0b2c375', '2016-09-21 03:43:22', '1', '10', '123', '12312', '1');
INSERT INTO `checkin` VALUES ('in20160921034419', '1000', '4cf6091d6484426b828bc827f85fae0b', '2016-09-21 03:44:19', '1', '10', '33', '12324', '1');
INSERT INTO `checkin` VALUES ('in20160921043655', '1000', '3043210d8b494ec794f3f1be520cc62c', '2016-09-21 04:36:55', '1', '10', '123', '12312', '1');
INSERT INTO `checkin` VALUES ('in20160922085315', '1000', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 08:53:15', '1', '4.9', '12', '1221', '1');
INSERT INTO `checkin` VALUES ('in20160922085536', '1000', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 08:55:36', '1', '4.9', '10', '1111', '1');
INSERT INTO `checkin` VALUES ('in20160922085859', '1000', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 08:58:59', '1', '4.9', '10', '1111', '1');
INSERT INTO `checkin` VALUES ('in20160922085921', '1000', '904272d3554f4584a48ab949cc38c20f', '2016-09-22 08:59:21', '1', '10', '10', '1111', '1');
INSERT INTO `checkin` VALUES ('in20160922085929', '1000', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 08:59:29', '1', '4.9', '10', '1111', '1');
INSERT INTO `checkin` VALUES ('in20160922125637', '111', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 12:56:37', '1', '4.9', '10', '120', '1');
INSERT INTO `checkin` VALUES ('in20160922133203', '1000', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 13:32:03', '1', '4.9', '10', '1000', '0');
INSERT INTO `checkin` VALUES ('in20160922142859', '222', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 14:28:59', '0', '140', '12', '700', '1');
INSERT INTO `checkin` VALUES ('in20160922143524', '22211', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 14:35:24', '1', '35', '10', '1000', '0');
INSERT INTO `checkin` VALUES ('in20160922143623', '100044', 'ed617d267fd340498cff503fd9b41bcb', '2016-09-22 14:36:23', '1', '35', '10', '1000', '0');

-- ----------------------------
-- Table structure for `checkout`
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout` (
  `checkout_id` varchar(32) NOT NULL default '',
  `checkout_amount` float default NULL,
  `checkout_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `comment` text,
  `checkin_id` varchar(32) default NULL,
  PRIMARY KEY  (`checkout_id`),
  KEY `fk_checkin_id` (`checkin_id`),
  CONSTRAINT `fk_checkin_id` FOREIGN KEY (`checkin_id`) REFERENCES `checkin` (`checkin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkout
-- ----------------------------
INSERT INTO `checkout` VALUES ('out20160921034346', '120', '2016-09-21 15:43:46', '0', 'in20160921034322');
INSERT INTO `checkout` VALUES ('out20160921042132', '125', '2016-09-21 16:21:32', '10', 'in20160921034419');
INSERT INTO `checkout` VALUES ('out20160922033954', '140', '2016-09-22 15:39:54', '0', 'in20160922142859');
INSERT INTO `checkout` VALUES ('out20160922035540', '14.7', '2016-09-22 15:55:40', '211', 'in20160922125637');
INSERT INTO `checkout` VALUES ('out20160922085222', '285', '2016-09-22 08:52:22', '1', 'in20160921043655');
INSERT INTO `checkout` VALUES ('out20160922085433', '0', '2016-09-22 08:54:33', '0', 'in20160922085315');
INSERT INTO `checkout` VALUES ('out20160922085943', '0', '2016-09-22 08:59:43', '1', 'in20160922085536');
INSERT INTO `checkout` VALUES ('out20160922085947', '0', '2016-09-22 08:59:47', '1', 'in20160922085859');
INSERT INTO `checkout` VALUES ('out20160922085951', '0', '2016-09-22 08:59:51', '1', 'in20160922085921');
INSERT INTO `checkout` VALUES ('out20160922085957', '0', '2016-09-22 08:59:57', '1', 'in20160922085929');

-- ----------------------------
-- Table structure for `cus_info`
-- ----------------------------
DROP TABLE IF EXISTS `cus_info`;
CREATE TABLE `cus_info` (
  `cus_info_id` varchar(64) NOT NULL,
  `cert_type` varchar(16) NOT NULL,
  `cert_number` varchar(32) NOT NULL,
  `name` varchar(16) NOT NULL,
  `phone` varchar(16) default NULL,
  `address` varchar(32) NOT NULL,
  `sex` varchar(16) NOT NULL,
  `cus_type_no` int(11) NOT NULL,
  `comment` text,
  PRIMARY KEY  (`cus_info_id`),
  KEY `fk_cert_type_no` (`cert_type`),
  KEY `fk_cus_type_no` (`cus_type_no`),
  CONSTRAINT `fk_cus_type_no` FOREIGN KEY (`cus_type_no`) REFERENCES `cus_type` (`cus_type_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cus_info
-- ----------------------------
INSERT INTO `cus_info` VALUES ('0064405e4f434ffa9a194ace5f974743', '11', '11', '111             ', null, '11', '111', '0', '11');
INSERT INTO `cus_info` VALUES ('3043210d8b494ec794f3f1be520cc62c', '123', '123', '-', null, '123', '213', '0', '123');
INSERT INTO `cus_info` VALUES ('30c3e414cfc140c990163546b0b2c375', '123', '123', '123', null, '123', '213', '0', '123');
INSERT INTO `cus_info` VALUES ('4cf6091d6484426b828bc827f85fae0b', '123', 'xxx', '123', null, 'xxx', '123', '0', 'xxx');
INSERT INTO `cus_info` VALUES ('904272d3554f4584a48ab949cc38c20f', '身份证', '', '', null, '', '男', '0', '');
INSERT INTO `cus_info` VALUES ('ed617d267fd340498cff503fd9b41bcb', '身份证', 'XXXX', '巫金桐', '17768100357', '重庆市璧山县', '男(men)', '1', '1221');
INSERT INTO `cus_info` VALUES ('f070f9f160b5496db44ab463852b9c43', '777', '777', '巫金桐', '', '777', '男', '0', '777');
INSERT INTO `cus_info` VALUES ('fe9698eff91440a2ba3c7aa94f39d31f', '身份证', '123123', '12', '12', '1231212', '男', '1', '121');

-- ----------------------------
-- Table structure for `cus_type`
-- ----------------------------
DROP TABLE IF EXISTS `cus_type`;
CREATE TABLE `cus_type` (
  `cus_type_no` int(11) NOT NULL,
  `cus_type_desc` varchar(255) NOT NULL,
  `discount` int(11) NOT NULL,
  PRIMARY KEY  (`cus_type_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cus_type
-- ----------------------------
INSERT INTO `cus_type` VALUES ('0', '普通用户', '10');
INSERT INTO `cus_type` VALUES ('1', '会员', '7');
INSERT INTO `cus_type` VALUES ('2', '团队组织', '5');
INSERT INTO `cus_type` VALUES ('3', '内部人事', '7');
INSERT INTO `cus_type` VALUES ('5', '协议单位', '9');

-- ----------------------------
-- Table structure for `reservation`
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `reservation_id` varchar(64) NOT NULL,
  `name` varchar(16) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `arrive_time` datetime NOT NULL,
  `reserve_time` datetime NOT NULL,
  `reservation_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `comment` text,
  `room_id` varchar(64) default NULL,
  PRIMARY KEY  (`reservation_id`),
  KEY `reservation_ibfk_1` (`room_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('d86eb46cd97d4a79a6eaad3bbf82c008', '1231123', '213', '2016-09-23 00:00:00', '2016-09-23 10:00:00', '2016-09-22 20:55:00', '', '122121');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` varchar(64) NOT NULL,
  `room_type_no` int(11) NOT NULL,
  `floor` varchar(16) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `status` int(11) NOT NULL,
  `comment` text,
  PRIMARY KEY  (`room_id`),
  KEY `fk_room_type` (`room_type_no`),
  CONSTRAINT `fk_room_type` FOREIGN KEY (`room_type_no`) REFERENCES `room_type` (`room_type_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1000', '1', '10', '110', '1', '');
INSERT INTO `room` VALUES ('100044', '1', '45', '45', '1', '45');
INSERT INTO `room` VALUES ('111', '1', '1212', '12321', '0', '21');
INSERT INTO `room` VALUES ('122121', '1', '12', '21', '2', '12');
INSERT INTO `room` VALUES ('21', '4', '1212', '12', '3', '');
INSERT INTO `room` VALUES ('222', '4', '12', '12312', '0', '');
INSERT INTO `room` VALUES ('22211', '1', '123', '12312', '1', '');

-- ----------------------------
-- Table structure for `room_type`
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `room_type_no` int(11) NOT NULL,
  `room_type_desc` varchar(16) NOT NULL,
  `beds` int(11) NOT NULL,
  `price` float default NULL,
  `isHourRoom` int(11) NOT NULL,
  `hourRoomPrice` float default NULL,
  `comment` text,
  PRIMARY KEY  (`room_type_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('1', '标准单人间', '2', '50', '0', '10', '');
INSERT INTO `room_type` VALUES ('2', '标准双人间', '2', '100', '0', '20', '');
INSERT INTO `room_type` VALUES ('3', '豪华单人间', '1', '150', '0', '20', '');
INSERT INTO `room_type` VALUES ('4', '豪华双人间', '1', '200', '0', '200', '');
INSERT INTO `room_type` VALUES ('5', '商务套房', '1', '500', '0', '50', '12312');
INSERT INTO `room_type` VALUES ('110', '豪华双人gai', '22', '123', '1', '1000', '');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(64) NOT NULL,
  `username` varchar(32) NOT NULL,
  `userpass` varchar(32) NOT NULL,
  `privilege` int(11) NOT NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jt', 'jt', '1');
INSERT INTO `user` VALUES ('2', 'jtwu', 'jtwu', '0');
INSERT INTO `user` VALUES ('389179822a264876bc2d9534d0a13d5c', '巫金桐', '123', '0');

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `vip_no` int(11) NOT NULL,
  `cus_info_id` varchar(64) default NULL,
  PRIMARY KEY  (`vip_no`),
  KEY `fk_cus_info` (`cus_info_id`),
  CONSTRAINT `fk_cus_info` FOREIGN KEY (`cus_info_id`) REFERENCES `cus_info` (`cus_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1000', 'ed617d267fd340498cff503fd9b41bcb');
INSERT INTO `vip` VALUES ('12112', 'fe9698eff91440a2ba3c7aa94f39d31f');
