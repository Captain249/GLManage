/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : gl

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-07-10 13:54:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lxy`
-- ----------------------------
DROP TABLE IF EXISTS `lxy`;
CREATE TABLE `lxy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grouptype` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `countmem` int(11) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `memberlist` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `profit` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy
-- ----------------------------
INSERT INTO `lxy` VALUES ('3', '医院', '人民医院', '50', '小明', '11111111111', '1,2,3,4,5', '10000', '2000', '2019.03.21', '未完结');
INSERT INTO `lxy` VALUES ('4', '医院', '中医院', '50', '小明', '11111111111', '1,2,3,4,5', '10000', '2000', '2019.03.21', '已完结');

-- ----------------------------
-- Table structure for `lxy_member`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_member`;
CREATE TABLE `lxy_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_member
-- ----------------------------
INSERT INTO `lxy_member` VALUES ('1', '3', '1');
INSERT INTO `lxy_member` VALUES ('2', '3', '2');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `passport` varchar(255) DEFAULT NULL,
  `family` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `more` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '名字1', '11111111111', '中国', '330206111111111111', '112233', null, '银行', null);
INSERT INTO `member` VALUES ('2', '名字2', '11111111111', '中国', '330206111111111111', '112233', null, '银行', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '17858936213', 'china');
INSERT INTO `user` VALUES ('103', 'admin', 'admin123', '1', '123123123', 'beilun');
INSERT INTO `user` VALUES ('104', 'admin', 'admin123', '1', '123123123', 'beilun');
INSERT INTO `user` VALUES ('105', 'admin', 'admin123', '1', '123123123', 'beilun');
