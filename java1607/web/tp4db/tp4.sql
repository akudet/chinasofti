/*
Navicat MySQL Data Transfer

Source Server         : jtwu
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : tp1

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-09-09 10:25:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bill_id` varchar(255) NOT NULL,
  `bill_amount` float NOT NULL,
  `bill_time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `comment` text,
  PRIMARY KEY  (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for `cert_type`
-- ----------------------------
DROP TABLE IF EXISTS `cert_type`;
CREATE TABLE `cert_type` (
  `cert_type_no` int(11) NOT NULL,
  `cert_type_desc` varchar(16) NOT NULL,
  `cert_number` varchar(32) NOT NULL,
  PRIMARY KEY  (`cert_type_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cert_type
-- ----------------------------

-- ----------------------------
-- Table structure for `checkin`
-- ----------------------------
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin` (
  `checkin_id` varchar(32) NOT NULL,
  `room_id` varchar(64) NOT NULL,
  `cus_info_id` varchar(64) NOT NULL,
  `checkin_time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `checkin_type` varchar(16) NOT NULL,
  `price` float NOT NULL,
  `num_of_days` int(11) NOT NULL,
  `deposit` float NOT NULL,
  PRIMARY KEY  (`checkin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkin
-- ----------------------------

-- ----------------------------
-- Table structure for `cus_info`
-- ----------------------------
DROP TABLE IF EXISTS `cus_info`;
CREATE TABLE `cus_info` (
  `cus_info_id` varchar(64) NOT NULL,
  `cert_type_no` int(11) NOT NULL,
  `name` varchar(16) NOT NULL,
  `phone` varchar(16) default NULL,
  `address` varchar(32) NOT NULL,
  `sex` varchar(16) NOT NULL,
  `vip_no` int(11) default NULL,
  `cus_type_no` int(11) NOT NULL,
  `comment` text,
  PRIMARY KEY  (`cus_info_id`),
  KEY `fk_cert_type_no` (`cert_type_no`),
  KEY `fk_cus_type_no` (`cus_type_no`),
  KEY `fk_vip_no` (`vip_no`),
  CONSTRAINT `fk_cert_type_no` FOREIGN KEY (`cert_type_no`) REFERENCES `cert_type` (`cert_type_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cus_type_no` FOREIGN KEY (`cus_type_no`) REFERENCES `cus_type` (`cus_type_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vip_no` FOREIGN KEY (`vip_no`) REFERENCES `vip` (`vip_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cus_info
-- ----------------------------

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

-- ----------------------------
-- Table structure for `reservation`
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `reservation_id` varchar(64) NOT NULL,
  `name` varchar(16) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `arrive_time` datetime NOT NULL,
  `reserve_time` time NOT NULL,
  `reservation_time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `comment` text,
  PRIMARY KEY  (`reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------

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

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `vip_no` int(11) NOT NULL,
  `cus_info_id` varchar(64) NOT NULL,
  PRIMARY KEY  (`vip_no`),
  KEY `fk_cus_info` (`cus_info_id`),
  CONSTRAINT `fk_cus_info` FOREIGN KEY (`cus_info_id`) REFERENCES `cus_info` (`cus_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
