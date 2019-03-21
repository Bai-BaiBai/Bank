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

 Date: 21/03/2019 16:23:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_account`) USING BTREE,
  INDEX `user_password`(`user_password`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', '1号储户', '001');
INSERT INTO `user` VALUES ('002', '2号储户', '002');
INSERT INTO `user` VALUES ('004', '张三', '111');
INSERT INTO `user` VALUES ('005', '李四', '111');
INSERT INTO `user` VALUES ('006', '6号', '006');
INSERT INTO `user` VALUES ('admin', 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
