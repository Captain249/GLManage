/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : zggl

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-09 11:15:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lxy`
-- ----------------------------
DROP TABLE IF EXISTS `lxy`;
CREATE TABLE `lxy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `grouptype` varchar(20) DEFAULT NULL COMMENT '类型：公司、学校、医院',
  `name` varchar(60) DEFAULT NULL COMMENT '名称',
  `numcount` int(11) DEFAULT NULL COMMENT '人数',
  `principal` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phonenum` varchar(60) DEFAULT NULL COMMENT '联系电话',
  `price` decimal(11,2) DEFAULT NULL COMMENT '价格',
  `profit` decimal(11,2) DEFAULT NULL COMMENT '利润',
  `startDate` date DEFAULT NULL COMMENT '出发日期',
  `finishDate` date DEFAULT NULL COMMENT '结束日期',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `more` varchar(600) DEFAULT NULL COMMENT '其他信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='疗休养表';

-- ----------------------------
-- Records of lxy
-- ----------------------------
INSERT INTO `lxy` VALUES ('6', '医院', '医院疗休养测试', '50', '奥松', '17858323112', '20000.00', '2222.00', '2019-08-09', null, '0', null);

-- ----------------------------
-- Table structure for `lxy_member`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_member`;
CREATE TABLE `lxy_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lxyId` int(11) DEFAULT NULL,
  `memberId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_member
-- ----------------------------
INSERT INTO `lxy_member` VALUES ('68', '6', '116');
INSERT INTO `lxy_member` VALUES ('69', '6', '117');
INSERT INTO `lxy_member` VALUES ('70', '6', '118');
INSERT INTO `lxy_member` VALUES ('71', '6', '119');
INSERT INTO `lxy_member` VALUES ('72', '6', '120');
INSERT INTO `lxy_member` VALUES ('73', '6', '121');
INSERT INTO `lxy_member` VALUES ('74', '6', '122');
INSERT INTO `lxy_member` VALUES ('75', '6', '123');
INSERT INTO `lxy_member` VALUES ('76', '6', '124');
INSERT INTO `lxy_member` VALUES ('77', '6', '125');
INSERT INTO `lxy_member` VALUES ('78', '6', '126');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phonenum` varchar(60) DEFAULT NULL COMMENT '电话',
  `address` varchar(600) DEFAULT NULL COMMENT '地址',
  `idcard` varchar(60) DEFAULT NULL COMMENT '身份证',
  `passport` varchar(60) DEFAULT NULL COMMENT '护照',
  `more` varchar(600) DEFAULT NULL COMMENT '其他信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COMMENT='成员表';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('83', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('84', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('85', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('86', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('87', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('88', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('89', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('90', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('91', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('92', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('93', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('94', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('95', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('96', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('97', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('98', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('99', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('100', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('101', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('102', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('103', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('104', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('105', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('106', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('107', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('108', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('109', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('110', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('111', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('112', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('113', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('114', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('115', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('116', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('117', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('118', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('119', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('120', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('121', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('122', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('123', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('124', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('125', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');
INSERT INTO `member` VALUES ('126', '孙志涛', '1231231231', '3123123123后所', '213123123', '123123123', '无');

-- ----------------------------
-- Table structure for `scattered`
-- ----------------------------
DROP TABLE IF EXISTS `scattered`;
CREATE TABLE `scattered` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL COMMENT '��������',
  `endDate` date DEFAULT NULL COMMENT '��������',
  `principal` varchar(20) DEFAULT NULL COMMENT '������',
  `phonenum` varchar(20) DEFAULT NULL COMMENT '�ֻ���',
  `num` int(11) DEFAULT NULL COMMENT '����',
  `name` varchar(60) DEFAULT NULL COMMENT '�г���',
  `receivable` decimal(11,2) DEFAULT NULL COMMENT 'Ӧ�տ�',
  `received` decimal(11,2) DEFAULT NULL COMMENT 'ʵ�տ�',
  `b2b` decimal(11,2) DEFAULT NULL COMMENT 'b2b�۸�',
  `operator` varchar(20) DEFAULT NULL COMMENT '����',
  `salesroom` varchar(200) DEFAULT NULL COMMENT '����',
  `contract` varchar(200) DEFAULT NULL COMMENT '��ͬ',
  `invoice` varchar(50) DEFAULT NULL COMMENT '��Ʊ',
  `more` varchar(600) DEFAULT NULL COMMENT '����',
  `type` varchar(20) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='ɢ�ͱ�';

-- ----------------------------
-- Records of scattered
-- ----------------------------
INSERT INTO `scattered` VALUES ('3', '2019-08-09', '2019-08-09', '孙志涛', '17858936213', '50', '出境测试', '20000.00', '20000.00', '20000.00', '小邹', '北仑富邦', '231312', '中国国旅', '无', '出境', '1');
INSERT INTO `scattered` VALUES ('4', '2019-08-09', '2019-08-09', '陈明宇', '17858936121', '50', '国内航空线测试', '20000.00', '20000.00', '20000.50', '小邹', '北仑富邦', '1231', '中国国旅', '无', '国内航空线', '1');
INSERT INTO `scattered` VALUES ('5', '2019-08-09', '2019-08-09', '乔妹', '17589371231', '50', '短线测试', '22000.00', '20000.00', '20000.00', '小邹', '北仑富邦', '123', '中国国旅', '', '短线', '1');

-- ----------------------------
-- Table structure for `scattered_member`
-- ----------------------------
DROP TABLE IF EXISTS `scattered_member`;
CREATE TABLE `scattered_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scatteredId` int(11) DEFAULT NULL,
  `memberId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scattered_member
-- ----------------------------
INSERT INTO `scattered_member` VALUES ('16', '5', '83');
INSERT INTO `scattered_member` VALUES ('17', '5', '84');
INSERT INTO `scattered_member` VALUES ('18', '5', '85');
INSERT INTO `scattered_member` VALUES ('19', '5', '86');
INSERT INTO `scattered_member` VALUES ('20', '5', '87');
INSERT INTO `scattered_member` VALUES ('21', '5', '88');
INSERT INTO `scattered_member` VALUES ('22', '5', '89');
INSERT INTO `scattered_member` VALUES ('23', '5', '90');
INSERT INTO `scattered_member` VALUES ('24', '5', '91');
INSERT INTO `scattered_member` VALUES ('25', '5', '92');
INSERT INTO `scattered_member` VALUES ('26', '5', '93');
INSERT INTO `scattered_member` VALUES ('27', '4', '94');
INSERT INTO `scattered_member` VALUES ('28', '4', '95');
INSERT INTO `scattered_member` VALUES ('29', '4', '96');
INSERT INTO `scattered_member` VALUES ('30', '4', '97');
INSERT INTO `scattered_member` VALUES ('31', '4', '98');
INSERT INTO `scattered_member` VALUES ('32', '4', '99');
INSERT INTO `scattered_member` VALUES ('33', '4', '100');
INSERT INTO `scattered_member` VALUES ('34', '4', '101');
INSERT INTO `scattered_member` VALUES ('35', '4', '102');
INSERT INTO `scattered_member` VALUES ('36', '4', '103');
INSERT INTO `scattered_member` VALUES ('37', '4', '104');
INSERT INTO `scattered_member` VALUES ('38', '3', '105');
INSERT INTO `scattered_member` VALUES ('39', '3', '106');
INSERT INTO `scattered_member` VALUES ('40', '3', '107');
INSERT INTO `scattered_member` VALUES ('41', '3', '108');
INSERT INTO `scattered_member` VALUES ('42', '3', '109');
INSERT INTO `scattered_member` VALUES ('43', '3', '110');
INSERT INTO `scattered_member` VALUES ('44', '3', '111');
INSERT INTO `scattered_member` VALUES ('45', '3', '112');
INSERT INTO `scattered_member` VALUES ('46', '3', '113');
INSERT INTO `scattered_member` VALUES ('47', '3', '114');
INSERT INTO `scattered_member` VALUES ('48', '3', '115');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(60) DEFAULT NULL COMMENT '账号',
  `password` varchar(60) DEFAULT NULL COMMENT '账号',
  `role` varchar(60) DEFAULT NULL COMMENT '角色',
  `phonenum` varchar(60) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin123', '管理员', '17858936213');
INSERT INTO `user` VALUES ('2', 'admin', 'admin123', '管理员', '17858936213');
INSERT INTO `user` VALUES ('3', 'admin', 'admin123', '管理员', '17858936213');
