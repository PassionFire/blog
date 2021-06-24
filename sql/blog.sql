/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2021-06-22 09:15:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `type_fk` int(11) DEFAULT NULL COMMENT '类别',
  `u_fk` int(11) DEFAULT NULL COMMENT '博主',
  `date` date DEFAULT NULL COMMENT '日期',
  `content` text NOT NULL COMMENT '内容',
  PRIMARY KEY (`bid`),
  KEY `u_fk` (`u_fk`),
  KEY `type_fk` (`type_fk`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`u_fk`) REFERENCES `user` (`id`),
  CONSTRAINT `blog_ibfk_2` FOREIGN KEY (`type_fk`) REFERENCES `type` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='博客文章表';

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '绿色校园', '1', '1', '2020-03-15', '绿色校园,玉兰花开,塑胶操场,校园南墙外花开似锦');
INSERT INTO `blog` VALUES ('2', '北大校园名人', '2', '1', '2020-03-15', '北大好运，我也好运');
INSERT INTO `blog` VALUES ('3', '学习雷锋校园活动', '1', '1', '2020-03-15', '学习雷锋好榜样');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(200) DEFAULT NULL COMMENT '评价内容',
  `b_fk` int(11) DEFAULT NULL COMMENT '博客外键',
  `u_fk` int(11) DEFAULT NULL COMMENT '评价用户外键',
  `addtime` date DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`),
  KEY `b_fk` (`b_fk`),
  KEY `u_fk` (`u_fk`),
  CONSTRAINT `evaluate_ibfk_1` FOREIGN KEY (`b_fk`) REFERENCES `blog` (`bid`),
  CONSTRAINT `evaluate_ibfk_2` FOREIGN KEY (`u_fk`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '测试数据', '1', '1', '2020-03-15');
INSERT INTO `evaluate` VALUES ('2', '这是测试数据', '1', '1', '2020-03-15');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键值',
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `roledes` varchar(32) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理整个博客网站');
INSERT INTO `role` VALUES ('2', '普通用户', '浏览博客网站');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(32) DEFAULT NULL,
  `type_pid` int(11) DEFAULT NULL,
  `typedes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`typeid`),
  KEY `type_pid` (`type_pid`),
  CONSTRAINT `type_ibfk_1` FOREIGN KEY (`type_pid`) REFERENCES `type` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='类别表';

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '生活类博客', null, '记录博主的生活经历和日常感悟');
INSERT INTO `type` VALUES ('2', '技术类博客', null, '分享转载或原创的网络赚钱教程为主要内容');
INSERT INTO `type` VALUES ('3', '校园类博客', null, '记录校园风采');
INSERT INTO `type` VALUES ('4', '综合型博客', null, '内容比较杂,生活、网赚、技术都包含在内,关注的领域和范围较广222');
INSERT INTO `type` VALUES ('5', '北大校园学雷锋', '3', '学习雷锋好榜样');
INSERT INTO `type` VALUES ('6', '学习java小技巧', '3', 'java注重理论和实践相结合');
INSERT INTO `type` VALUES ('7', '清华大学3G天翼校园活动', '3', '3G无处不在');
INSERT INTO `type` VALUES ('8', '测试类型1', '3', '3G无处不在');
INSERT INTO `type` VALUES ('19', '中公教育', '3', '北京五方桥基地');
INSERT INTO `type` VALUES ('21', '美食街', '1', '吃货的世界');
INSERT INTO `type` VALUES ('22', 'java学习小技巧', '2', '学习java 就来中公教育u就业');
INSERT INTO `type` VALUES ('25', '综合类博客', '4', '综合类博客，包括方方面面');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `addtime` date DEFAULT NULL COMMENT '注册日期',
  `type` int(11) DEFAULT NULL COMMENT '用户类型',
  `truename` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utype` (`type`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`type`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '彩虹', '123', 'zhangcai@163.com', '2021-03-01', '1', '张彩', null);
INSERT INTO `user` VALUES ('2', '明明', '123', 'mingming@163.com', '2021-03-03', '1', '吴明明', null);
