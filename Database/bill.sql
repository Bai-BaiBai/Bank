/*
 Navicat MySQL Data Transfer

 Source Server         : MYSQL80_3306
 Source Server Type    : MySQL
 Source Server Version : 80003
 Source Host           : localhost:3306
 Source Schema         : bank

 Target Server Type    : MySQL
 Target Server Version : 80003
 File Encoding         : 65001

 Date: 21/03/2019 16:23:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `bill_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_money` int(20) NULL DEFAULT NULL,
  `bill_record` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`bill_id`) USING BTREE,
  INDEX `user_password`(`bill_password`) USING BTREE,
  INDEX `user_account`(`user_account`) USING BTREE,
  CONSTRAINT `user_account` FOREIGN KEY (`user_account`) REFERENCES `user` (`user_account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1001', '001', '001', 100, 'Sat Dec 22 12:31:51 CST 2018存100元;');
INSERT INTO `bill` VALUES ('1002', '002', '002', 0, '');
INSERT INTO `bill` VALUES ('1004', '004', '111', 52, 'Sat Dec 22 18:52:41 CST 2018存100元;Sat Dec 22 18:52:52 CST 2018缴纳电话费50元;Sat Dec 22 18:53:23 CST 2018存1元;');
INSERT INTO `bill` VALUES ('1005', '005', '111', 130, 'Sun Dec 23 08:11:23 CST 2018存100元;Sun Dec 23 08:11:32 CST 2018缴纳电话费20元;Sun Dec 23 08:19:42 CST 2018存100元;Sun Dec 23 08:20:08 CST 2018缴纳水电费50元;');
INSERT INTO `bill` VALUES ('1006', '006', '007', 1, '');

SET FOREIGN_KEY_CHECKS = 1;
