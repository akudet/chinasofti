/*
Navicat MySQL Data Transfer

Source Server         : jtwu
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : tp4

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-09-09 15:03:28
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
INSERT INTO `bill` VALUES ('58f7f74818f94c64ba5350a5d8eae0ed', '883.79', '2016-09-09 02:59:51', 'bkirzx1k693h9bayq0wcztk');
INSERT INTO `bill` VALUES ('6b94bc7005d04dbea9e5e26483fc0e01', '168.741', '2016-09-09 02:59:51', 'uvvxv1g0q3jxmtqc3wbljxixawxpudmc91y503jw2b1llhm');
INSERT INTO `bill` VALUES ('89d2aac01c4740b3ab67d2d8133822cc', '803.181', '2016-09-09 02:59:51', 'ihq711moegqtolmoosa4eswi8l0bt79os2gbgfd78rm3g7l4uh');
INSERT INTO `bill` VALUES ('8a922c251f7d40509e5d9a35bc95211a', '411.845', '2016-09-09 02:59:51', 'fme8ucnoptftuyewe1vh176h6kbi1gmhuxz9ulmjoubka4');
INSERT INTO `bill` VALUES ('916e12cadfd7465297514155331e24d5', '863.967', '2016-09-09 02:59:51', 'rtfvsvpw5ltoa24iagiqlgma6npqx0wvbr2j1or7');
INSERT INTO `bill` VALUES ('a812d39eca054c2abbeafffee215d195', '651.143', '2016-09-09 02:59:51', 'm7l5o3l6qfe7iltn8b1ysn6u6joox9w4hs59out3xy76n25b8qe');
INSERT INTO `bill` VALUES ('beb463d6a5f64adc825ee7bac1a03892', '245.747', '2016-09-09 02:59:51', 'vshoyc40ci8n24gn4iw5ucok7dony1jb6ygfua2dq1wucv79');
INSERT INTO `bill` VALUES ('c0275913e2024501b6a9f999a685a256', '216.487', '2016-09-09 02:59:51', 'ryjtsrfxzqkquptgg7zeap8zqan5gvuq678');
INSERT INTO `bill` VALUES ('c02b93bc45674c4093aa8ed3000dffb9', '438.887', '2016-09-09 02:59:51', '4o0ci8uu2hccjjlaxkjxi');
INSERT INTO `bill` VALUES ('d8ae5f95da8a43579953163f09e971cc', '958.899', '2016-09-09 02:59:51', 'c7utbpb1sog74bx3pur0pj3nf1pc0io1p51l219m4f1c07p3ksdf');

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
  PRIMARY KEY  (`checkin_id`),
  KEY `fk_room_id` (`room_id`),
  KEY `fk_cus_info_id` (`cus_info_id`),
  CONSTRAINT `fk_cus_info_id` FOREIGN KEY (`cus_info_id`) REFERENCES `cus_info` (`cus_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
INSERT INTO `cus_info` VALUES ('08dafe8f082b4bf49e7cdfeaaf978e82', '军官证', '6jzplgqyijils1vqaisb2ximxsw', '4', 'h6v3yyyc5j1', 'l121l7ulb4lmxd3uikw0gwgqurj', '女', '1', '1svh69gp7ct1lhaj8');
INSERT INTO `cus_info` VALUES ('3ac35bbf27cb4204ae2c832c9a9e3a5d', '护照', '7qdsso0qpqt5783k1', '3', 'gm4hwpnyeh7m', 'ib0tvg1egatpzcpm40kihpo', '男', '1', 'ze2j2ev9b2fck85fvj');
INSERT INTO `cus_info` VALUES ('59fcdaf3447d425184b87b0d8265305a', '护照', 'wkicifb8qncpquur1', 'f6', '6624xnd7vtf1', 'mpz3dueqjeno0grcirdwsdydd', '女', '1', 'udrokdak41er9');
INSERT INTO `cus_info` VALUES ('6f74756ea2ef47a19a5d233a57d25c0a', '身份证', 'exjxed1nlqa2lms2vwlg0oo', '94', 'twwkoegzp1iv', '9ft8zyrutcyh24vrfruzrwngkiqj', '女', '1', 'op6sfn4fjfhp3scqs');
INSERT INTO `cus_info` VALUES ('7b4cd8b19299482994efa4b4a84375f0', '其他', '9o2oym9id1859fd8zda1', 'sd', 'l616bf45ja4h', '49gvlshvfbufbta12lbh8', '男', '1', 'rht3tuaiiztwf');
INSERT INTO `cus_info` VALUES ('97fe082547824ea490b1905889022adc', '其他', 'brst52uywiqiytcc3r6qi5cjb8', '5', '0hw7s29rr0ph', 'd2ywg4kru60gowgjthl6tu38', '女', '1', 'gyqpzwa8zvij');
INSERT INTO `cus_info` VALUES ('b998ad847b354c7393dff14c3a135537', '军官证', 'riyv2ul3', 'w', 'xzhl17zoqup', 'rgpppltxl2v1oq87d4hmq7uvjai5b', '男', '1', 'xheatp3sypo2l3');
INSERT INTO `cus_info` VALUES ('e7bd749546924285adf0dd06f83c396c', '身份证', '1nu2tenl55qjeefxj07', 'jx', 'zokca8br57v', 'jobno5w82z4vhfenrmpn3rbptebek', '女', '1', 'e85l1vkhwr26');
INSERT INTO `cus_info` VALUES ('efbea955e2434519862e8523711d12fb', '身份证', 'o1gnfxgqf1xe', 'm', '7qvnklcbarn', 'ex4y3ngls125w3vr7v0sxgm2bomdt', '男', '1', '6krx0g0odyhy');
INSERT INTO `cus_info` VALUES ('fe3d307141034030af6ff14f1df38749', '军官证', 'im6jjviwl0pce1bw4du4', '4', '93djand18sm', 'ajvinw9buxfh8tzuozsz1sthi', '男', '1', 'oia0g7m8dkddqk8');

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
INSERT INTO `cus_type` VALUES ('0', '普通客户', '10');
INSERT INTO `cus_type` VALUES ('1', '会员', '5');
INSERT INTO `cus_type` VALUES ('2', '团体组织', '7');
INSERT INTO `cus_type` VALUES ('3', '内部人事', '5');
INSERT INTO `cus_type` VALUES ('4', '协议单位', '10');

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
  `room_id` varchar(64) default NULL,
  PRIMARY KEY  (`reservation_id`),
  KEY `reservation_ibfk_1` (`room_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
INSERT INTO `room` VALUES ('2083997c1923475892c192306e351ca0', '1', '15', '92109534879', '0', 'znf1wda75vte');
INSERT INTO `room` VALUES ('20e38d2839ed485e88f007fb4d153fbb', '1', '2', '96897699271', '0', 'jomk04kuhsxa9');
INSERT INTO `room` VALUES ('449d8c72d0674bc09f6f5358259ee59c', '1', '11', '86601468449', '0', '26m77a91lpa9au01zqv');
INSERT INTO `room` VALUES ('4f4c5ae8024d45bea8e0c4161e2fc6e5', '1', '10', '60169079764', '0', 'ibyukmvrb8q7');
INSERT INTO `room` VALUES ('53005a0dff874953883e1820dfa8471d', '1', '13', '38187361974', '0', 'zunhgyz42ittf');
INSERT INTO `room` VALUES ('5f375c224ebd48e38ad0d4d62acf72b2', '1', '8', '07014587057', '0', 'qw3i9br7c44kvjab');
INSERT INTO `room` VALUES ('63eb38010264476db24d9d4f47e049a2', '1', '16', '18215632588', '0', 'sp42je1m09c0');
INSERT INTO `room` VALUES ('645d5563d0e3456f8022f5d28f185c9e', '1', '3', '40930394815', '0', '6u5c4nt9zwe9');
INSERT INTO `room` VALUES ('6960c2ed24fa454db3b844f6c22e581e', '1', '31', '68348146425', '0', 'qa1josxegm899wogar3t');
INSERT INTO `room` VALUES ('6bb6669a092643409db255b7d4e5c5d4', '1', '18', '30214134826', '0', 'clwh8qk94g6');
INSERT INTO `room` VALUES ('7a1adb1fbf514175b731fe183a4a1e59', '1', '25', '17488863567', '0', 'lbshns80n8u248ocqvnbf');
INSERT INTO `room` VALUES ('a8fe48e50a2248188de2eea3b19c6f9a', '1', '25', '22025684844', '0', '0l086zieose4vjf');
INSERT INTO `room` VALUES ('aa0afa3e187b48548f75f4a405761b0a', '1', '20', '98916032292', '0', 'muoozhjuhc4awhpkl');
INSERT INTO `room` VALUES ('ed23854f8d544efa89d63e00a1e650b1', '1', '18', '28298949416', '0', 'p75shp250ztjetd01ghv');
INSERT INTO `room` VALUES ('f8cb8ee4457f4081923aeaa1c890e398', '1', '30', '24335161088', '0', '199k7hk80mzslkwrmqmfu');

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
INSERT INTO `room_type` VALUES ('0', '标准单人间', '1', '61.2254', '1', '5.0105', 'vol36n1p9hp2f0yowixyq1f22');
INSERT INTO `room_type` VALUES ('1', '标准双人间', '2', '41.7787', '0', '2.97274', '5qfv3uu58t6x1gpta7q');
INSERT INTO `room_type` VALUES ('2', '豪华单人间', '3', '31.1571', '1', '5.47802', '6p3bam4e23nt');
INSERT INTO `room_type` VALUES ('3', '豪华双人间', '2', '90.2562', '0', '2.40963', 'mvtkwiamfyvj1oer');
INSERT INTO `room_type` VALUES ('4', '商务套房', '1', '63.901', '1', '1.9615', 'enr7ruyk113gx2yeu5wpevvz5h');
INSERT INTO `room_type` VALUES ('5', '总统套房', '2', '55.5286', '0', '7.63085', 'yxvfoyzedg');

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
INSERT INTO `user` VALUES ('0f9fbb6ddc9045faac961a27a99cbbe1', '4nnjjc5kph', 'ukq0fy55ava4', '0');
INSERT INTO `user` VALUES ('4060c82b6117436fb243dbf1cd178a13', 'pzqlyna', 'zfkfp1ifkql', '0');
INSERT INTO `user` VALUES ('40b794f395b14644ad3676aeb94ec1a1', 'f2u3exb1g', 'eznsvwf', '0');
INSERT INTO `user` VALUES ('45aae83ffe3f4c52b0a19f4cfeaffda3', 'v09bzqkn', '17iwm750i2obg', '0');
INSERT INTO `user` VALUES ('5dba266bdb634f4080b8eeb8e40d4a86', 'lglbzizj', 'orpeyywd9', '0');
INSERT INTO `user` VALUES ('5ea83770ba574b6a80c7bfe167dc529f', 'mo3g7eyx', 'ix0k4ezbw2', '0');
INSERT INTO `user` VALUES ('5fe75904a62c4791bba650f0266e73c3', 'lob0mm6', 'fguehe4r3', '0');
INSERT INTO `user` VALUES ('6c6a4b0f817845a0a3a930172b19dd07', 'cyfruz', 'b3xd0x51vs5', '0');
INSERT INTO `user` VALUES ('877743f0fb774ecb8db660dba05ac102', '8m1sk', '2q7rit7i7t', '0');
INSERT INTO `user` VALUES ('8cabafb5bc2e49108760c9517e68bb93', '85othnhowc', 'kdzzj9tn1xc9mo', '0');
INSERT INTO `user` VALUES ('c4e7d97838834014acca2ab6ce234fd4', '88i02cz', 'roa7zjr399f0db', '0');
INSERT INTO `user` VALUES ('e591d9b15478439e96d4c26ba1634137', 's27j6g', 'ckwlzeibmm9u', '0');
INSERT INTO `user` VALUES ('e61948c884c047b2aaed6b5bfa0057e2', 'djbcf6', 'zspp6fsfgc93dq', '0');
INSERT INTO `user` VALUES ('e8766a54d5734a6781dd9007446e9409', '67wzv', 'gd0yxglsvjd', '0');
INSERT INTO `user` VALUES ('ee6b97dd57c14dc7909279881b30bd15', 'wzwa09b', 'dvvr96', '0');

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
