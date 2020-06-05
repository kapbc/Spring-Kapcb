/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80018
Source Host           : 192.168.80.1:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-06-05 19:15:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_key
-- ----------------------------
DROP TABLE IF EXISTS `t_key`;
CREATE TABLE `t_key` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyname` varchar(255) DEFAULT NULL,
  `lockid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_key_lock` (`lockid`),
  CONSTRAINT `fk_key_lock` FOREIGN KEY (`lockid`) REFERENCES `t_lock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_key
-- ----------------------------
INSERT INTO `t_key` VALUES ('1', '1号钥匙', '1');
INSERT INTO `t_key` VALUES ('2', '2号钥匙', '2');
INSERT INTO `t_key` VALUES ('3', '3号钥匙1', '3');
INSERT INTO `t_key` VALUES ('4', '3号钥匙1', '3');
INSERT INTO `t_key` VALUES ('5', '3号钥匙3', '3');

-- ----------------------------
-- Table structure for t_lock
-- ----------------------------
DROP TABLE IF EXISTS `t_lock`;
CREATE TABLE `t_lock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lockname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_lock
-- ----------------------------
INSERT INTO `t_lock` VALUES ('1', '1号锁');
INSERT INTO `t_lock` VALUES ('2', '2号锁');
INSERT INTO `t_lock` VALUES ('3', '3号锁');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `login_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'kapcb', '男', 'eircccallroot@163.com', 'a');
INSERT INTO `t_user` VALUES ('2', 'hahah', '男', 'eircccallroot@yeah.net', null);
INSERT INTO `t_user` VALUES ('5', 'ccc', '男', 'eircccallroot@yeah.net', null);
INSERT INTO `t_user` VALUES ('6', 'ccc', '男', 'eircccallroot@yeah.net', null);
INSERT INTO `t_user` VALUES ('7', 'ccc', '男', '2530628867@qq.com', 'abc');
INSERT INTO `t_user` VALUES ('8', 'ccc', '男', '2530628867@qq.com', 'abc');
INSERT INTO `t_user` VALUES ('9', 'aaa', '男', '123456@qq.com', 'ddsds');
INSERT INTO `t_user` VALUES ('10', 'aaa', '男', '123456@qq.com', 'ddsds');
INSERT INTO `t_user` VALUES ('11', 'aaa', '男', '123456@qq.com', 'ddsds');
