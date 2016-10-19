/*
Navicat MySQL Data Transfer

Source Server         : jtwu
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : ssh

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-10-19 12:06:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jtwu');
INSERT INTO `user` VALUES ('2', 'jtwu');
INSERT INTO `user` VALUES ('3', 'jtwu');
INSERT INTO `user` VALUES ('4', 'jtwu');
INSERT INTO `user` VALUES ('5', 'jtwu');
INSERT INTO `user` VALUES ('6', 'jtwu');
