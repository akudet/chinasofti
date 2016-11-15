/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : teacher

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-08-17 16:51:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `score_test`
-- ----------------------------
DROP TABLE IF EXISTS `score_test`;
CREATE TABLE `score_test` (
  `id` int(10) NOT NULL auto_increment,
  `stu_id` int(10) NOT NULL,
  `c_name` varchar(20) collate utf8_unicode_ci default NULL,
  `grade` int(10) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of score_test
-- ----------------------------
INSERT INTO `score_test` VALUES ('1', '901', '计算机', '98');
INSERT INTO `score_test` VALUES ('2', '901', '英语', '80');
INSERT INTO `score_test` VALUES ('3', '902', '计算机', '65');
INSERT INTO `score_test` VALUES ('4', '902', '中文', '88');
INSERT INTO `score_test` VALUES ('5', '903', '中文', '95');
INSERT INTO `score_test` VALUES ('6', '904', '计算机', '70');
INSERT INTO `score_test` VALUES ('7', '904', '英语', '92');
INSERT INTO `score_test` VALUES ('8', '905', '英语', '94');
INSERT INTO `score_test` VALUES ('9', '906', '计算机', '90');
INSERT INTO `score_test` VALUES ('10', '906', '英语', '85');

-- ----------------------------
-- Table structure for `student_test`
-- ----------------------------
DROP TABLE IF EXISTS `student_test`;
CREATE TABLE `student_test` (
  `id` int(10) NOT NULL,
  `name` varchar(20) collate utf8_unicode_ci NOT NULL,
  `sex` varchar(4) collate utf8_unicode_ci default NULL,
  `birth` year(4) default NULL,
  `department` varchar(20) collate utf8_unicode_ci default NULL,
  `address` varchar(50) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student_test
-- ----------------------------
INSERT INTO `student_test` VALUES ('901', '张老大', '男', '1985', '计算机系', '北京市海淀区');
INSERT INTO `student_test` VALUES ('902', '张老二', '男', '1986', '中文系', '北京市昌平区');
INSERT INTO `student_test` VALUES ('903', '张三', '女', '1990', '中文系', '湖南省永州市');
INSERT INTO `student_test` VALUES ('904', '李四', '男', '1990', '英语系', '辽宁省阜新市');
INSERT INTO `student_test` VALUES ('905', '王五', '女', '1991', '英语系', '福建省厦门市');
INSERT INTO `student_test` VALUES ('906', '王六', '男', '1988', '计算机系', '湖南省衡阳市');
