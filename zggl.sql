/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : zggl

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-07-31 18:17:44
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='疗休养表';

-- ----------------------------
-- Records of lxy
-- ----------------------------
INSERT INTO `lxy` VALUES ('1', '学校', '后所小学 北仑一日游', '50', '孙志涛', '17858936213', '2000.50', '200.50', '2019-07-02', '2019-07-30', '1', null);
INSERT INTO `lxy` VALUES ('2', '医院', '柴桥医院 北仑一日', '22', '孙志涛', '1231231231', '111.00', '11.00', '2019-07-15', null, '0', null);
INSERT INTO `lxy` VALUES ('3', '医院', '奥松 是', '22', '22', '222', '22.00', '22.00', '2019-07-01', '2019-07-30', '1', null);
INSERT INTO `lxy` VALUES ('4', '医院', '柴桥医院 北仑一日', '22', '孙志涛', '1231231231', '111.00', '11.00', '2019-07-17', null, '0', null);
INSERT INTO `lxy` VALUES ('5', '学校', '111', '11', '1111', '11', '111.00', '11.00', '2019-07-30', null, '0', null);
INSERT INTO `lxy` VALUES ('6', '医院', '111', '11', '111', '111', '1111.00', '11.00', '2019-07-30', null, '0', null);
INSERT INTO `lxy` VALUES ('10', '医院', '测试 数据', '11', '孙志涛', '1231231231', '11111.00', '11.00', '2019-07-30', null, '0', null);
INSERT INTO `lxy` VALUES ('11', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('12', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('13', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('14', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('15', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('16', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('17', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('18', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('19', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);
INSERT INTO `lxy` VALUES ('20', '医院', '测试数据', '50', '孙志涛', '17858937213', '100.00', '10.00', '2019-07-08', null, '0', null);

-- ----------------------------
-- Table structure for `lxy_member`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_member`;
CREATE TABLE `lxy_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lxyId` int(11) DEFAULT NULL,
  `memberId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_member
-- ----------------------------
INSERT INTO `lxy_member` VALUES ('2', '1', '2');
INSERT INTO `lxy_member` VALUES ('3', '1', '3');
INSERT INTO `lxy_member` VALUES ('4', '1', '4');
INSERT INTO `lxy_member` VALUES ('6', '2', '6');
INSERT INTO `lxy_member` VALUES ('10', '1', '19');
INSERT INTO `lxy_member` VALUES ('11', '6', '20');
INSERT INTO `lxy_member` VALUES ('12', '2', '21');
INSERT INTO `lxy_member` VALUES ('13', '2', '22');
INSERT INTO `lxy_member` VALUES ('14', '2', '23');
INSERT INTO `lxy_member` VALUES ('15', '2', '24');
INSERT INTO `lxy_member` VALUES ('16', '2', '25');
INSERT INTO `lxy_member` VALUES ('17', '2', '26');
INSERT INTO `lxy_member` VALUES ('18', '2', '27');
INSERT INTO `lxy_member` VALUES ('19', '2', '28');
INSERT INTO `lxy_member` VALUES ('20', '2', '29');
INSERT INTO `lxy_member` VALUES ('21', '2', '30');
INSERT INTO `lxy_member` VALUES ('22', '10', '31');
INSERT INTO `lxy_member` VALUES ('23', '3', '32');
INSERT INTO `lxy_member` VALUES ('24', '3', '33');

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='成员表';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('2', '孙志涛2', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('3', '孙志涛3', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('4', '沈卓钧', '17858936213', '浙江省宁波市北仑区拆桥街道后所村城西70号', '330206199504091433', 'hz123123123', '备注一下');
INSERT INTO `member` VALUES ('6', '孙志涛6', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('7', '孙志涛7', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('8', '孙志涛8', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('9', '孙志涛9', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('10', '孙志涛10', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('11', '孙志涛11', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('12', '孙志涛12', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('13', '孙志涛13', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('14', '孙志涛14', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('15', '孙志涛15', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('16', '孙志涛16', '17858936213', '后所村', '33020212321321321', '10086', null);
INSERT INTO `member` VALUES ('17', '周恒利', '1111111111111', '梅山', '111111111111111111111', '1111111111111111111', '1111111111111');
INSERT INTO `member` VALUES ('19', '螃蟹', '1213213213', '北仑区梅山岛', '3302026123129491732', '1123123', '123123');
INSERT INTO `member` VALUES ('20', '试试看测试', '231232', '1232131', '123123', '13123', '21313');
INSERT INTO `member` VALUES ('21', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('22', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('23', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('24', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('25', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('26', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('27', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('28', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('29', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('30', '孙志涛', '1123213213123', '后所', '330206123124124124', '123213213', '无');
INSERT INTO `member` VALUES ('31', '李嘉欣', '123213213', '后所', '123123213213', '213213213', '21313');
INSERT INTO `member` VALUES ('32', '李嘉欣', '123213213', '后所', '123123213213', '213213213', '21313');
INSERT INTO `member` VALUES ('33', '李嘉欣', '123213213', '后所', '123123213213', '213213213', '21313');

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
