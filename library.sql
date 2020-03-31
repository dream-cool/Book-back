/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 31/03/2020 17:24:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍id',
  `category_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别id',
  `book_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍名称',
  `book_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍描述',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍作者',
  `published` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出版社',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `book_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍状态  在库 已借 损坏',
  `img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍封面',
  `ebook` int(11) NULL DEFAULT NULL COMMENT '是否是电子书',
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍位置',
  `zan_number` int(11) NULL DEFAULT NULL COMMENT '点赞数量',
  `score` decimal(2, 1) NULL DEFAULT NULL COMMENT '得分',
  `input_time` timestamp(0) NULL DEFAULT NULL COMMENT '录入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `borrowing_number` int(11) NULL DEFAULT NULL COMMENT '借阅数量',
  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('10d88d1b5409433db00d871370ce7fd6', '1', '141', '1421', '14421', '12412', 11.00, '1', '20200310190101380111.jpg', 0, '', 0, NULL, '2020-02-29 00:00:00', '2020-03-10 19:01:03', 2, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('10fb3f', '4', '海贼之我是大', '不知道', '不知道', '不知', 1.00, '0', '20200329143644797111.jpg', 1, '20200309203156844魔道祖师.txt', 0, NULL, '2020-03-02 01:33:19', '2020-03-29 14:36:45', 2, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('26fd2b762c9646f49e1cf6f40566b7d8', '21', 'hello', 'hello', 'hello', 'hello', 11.00, '0', '20200310201535486桌面.jpg', 0, '', 1, 3.0, '2020-02-29 00:00:00', '2020-03-10 20:15:37', 6, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('3c40be903534470aa102788712cfe99e', '2', '14141', '1414', '4141', '4141', 11.00, '0', '20200329143027964403.png', 0, '', 0, NULL, '2020-03-06 00:00:00', '2020-03-29 14:30:28', 6, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('543adcda63bd4938a57cc86e072ec380', '1', '真龙真龙', '真龙真龙', '真龙真龙', '真龙真龙', 0.00, '0', '20200310193819136QQ截图20200226194757.jpg', 1, '20200309203156844魔道祖师.txt', 1, NULL, '2020-03-09 20:31:59', '2020-03-10 19:38:23', 7, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('613b4c3c7a39414d803bdd190bfc3ff2', '3', '4141', '141', '4114', '4141', 1.00, '0', '20200310201731506QQ截图20200310190128.jpg', 1, '20200309203156844魔道祖师.txt', 0, NULL, '2020-02-15 01:33:26', '2020-03-10 20:17:38', 8, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('6372631134b64a25941c2f80958b980b', '4', '真龙真龙', '真龙真龙真龙真龙', '真龙真龙', '真龙真龙', 0.00, '0', '20200310201915779403.png', 1, '20200309203156844魔道祖师.txt', 0, NULL, '2020-03-05 21:30:56', '2020-03-10 20:19:17', 4, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('a135df0ea5014c90bba0e4c6a7c82cab', '4', '狼图腾', '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', '姜绒1', '北京十月文艺出版社', 44.90, '0', '20200314203719290QQ截图20200310190128.jpg', 0, '111414', 0, NULL, '2020-03-20 00:00:00', '2020-03-14 20:37:21', 9, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('b57a9128631743239a41817936f5d7bb', '1', '1441', '41', '144141', '4141', 111.00, '0', '20200310201513046QQ截图20200226194757.jpg', 0, '1141', 0, NULL, '2020-03-21 00:00:00', '2020-03-10 20:15:14', 4, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('bf5d445abd77406fa433c72c683b10f2', '4', 'windows', 'windows', 'windows', 'windows', 1.00, '0', '20200310201102722QQ截图20200310190128.jpg', 1, '20200309203156844魔道祖师.txt', 2, 3.8, '2020-02-10 01:33:37', '2020-03-10 20:11:10', 8, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('c8dea18c7b924a9ba3af8ca5270ec64e', '1', '111', '1', '1111', '1111', 1.00, '0', '20200310194958133桌面.jpg', 1, '20200309203156844魔道祖师.txt', 0, 1.0, '2020-02-05 21:03:12', '2020-03-10 19:50:08', 4, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('d58a37c26ed2456c9f566768afc1d4ae', '9', '1111', '4141', '4141', '1441', 1441.00, '0', '20200310195324162QQ截图20200310190952.jpg', 0, '1441', 0, NULL, '2020-03-20 00:00:00', '2020-03-10 19:53:35', 9, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('d80b2ce8a65d438e942b60e0352dda84', '1', '122', '1', '1222', '1222', 1.00, '0', '20200310201826603QQ截图20200226194757.jpg', 1, '20200309203156844魔道祖师.txt', 0, 1.0, '2020-02-05 21:03:12', '2020-03-10 20:18:28', 7, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('dd445e68a24f40459266aedb395e5817', '1', '122', '1', '122', '122', 1.00, '0', '20200310201353073QQ截图20200226194757.jpg', 1, '20200309203156844魔道祖师.txt', 0, 1.0, '2020-02-05 21:03:12', '2020-03-10 20:14:02', 8, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('f65f5a4768694472b70715fd73bca2f5', '12', '111', '111', '111', '111', 11.00, '0', '20200310194929794桌面.jpg', 0, '111', 0, NULL, '2020-02-22 00:00:00', '2020-03-10 19:49:30', 7, NULL, NULL, NULL, NULL);
INSERT INTO `book` VALUES ('fd05624d73214dedaabe3dc0f00cd1f8', '1', '124', '11111', '24211', '124', 1.00, '0', '20200310194739112桌面.jpg', 1, '20200309203156844魔道祖师.txt', 0, NULL, '2020-03-13 18:24:12', '2020-03-10 19:48:17', 7, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for borrowing
-- ----------------------------
DROP TABLE IF EXISTS `borrowing`;
CREATE TABLE `borrowing`  (
  `borrowing_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '借阅id',
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `book_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍名称',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `duration` int(11) NULL DEFAULT NULL COMMENT '借阅时长',
  `application_time` timestamp(0) NULL DEFAULT NULL COMMENT '申请时间',
  `handle_time` timestamp(0) NULL DEFAULT NULL COMMENT '处理时间',
  `borrowing_time` timestamp(0) NULL DEFAULT NULL COMMENT '借阅时间',
  `return_time` timestamp(0) NULL DEFAULT NULL COMMENT '归还时间',
  `borrowing_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态  申请、驳回、已借、逾期、归还',
  `borrowing_operator` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '借阅操作人',
  `return_operator` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '归还操作人',
  `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `cancel_time` timestamp(0) NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`borrowing_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowing
-- ----------------------------
INSERT INTO `borrowing` VALUES ('009cf8f7d2c24943ab46da3e14d1913d', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:46:27', '2020-03-25 20:47:01', '2020-03-26 20:46:24', NULL, '2', 'admin', NULL, '111111', '2020-03-25 20:46:27', '2020-03-25 20:47:01', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('13932489ebb14f77aa771ad8279efe33', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:48:40', '2020-03-25 20:49:41', '2020-03-26 20:48:38', NULL, '2', 'admin', NULL, '11111', '2020-03-25 20:48:40', '2020-03-25 20:49:41', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('139c9519ca884ffba2f23225a5bdc193', '10d88d1b5409433db00d871370ce7fd6', '2', '141', '3', 30, '2020-03-04 22:28:30', '2020-03-04 22:29:32', '2020-03-05 22:28:28', NULL, '3', '3', NULL, NULL, '2020-03-04 22:28:30', '2020-03-04 22:29:32', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('1414114', '1414', '141414', 'www', 'ww', 11, '2020-03-14 22:59:32', '2020-03-04 22:24:52', '2020-03-13 22:59:47', '2020-03-04 22:25:20', '6', '3', '3', NULL, NULL, '2020-03-04 22:25:20', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('1ceedf3a35e74e6ea68f423c1f80d0b8', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-09 20:26:49', '2020-03-10 19:24:11', '2020-03-10 20:26:47', NULL, '2', 'admin', NULL, '11222', '2020-03-09 20:26:49', '2020-03-10 19:24:11', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('2', '2', '1', '1', '1', 11, '2020-02-05 21:05:19', '2020-03-07 10:54:35', '2020-02-21 21:05:21', '2020-03-08 11:02:03', '5', 'cl', '3', NULL, NULL, '2020-03-08 11:02:03', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('24', '24', '24', '24', '24', 11, '2020-02-06 04:59:37', NULL, '2020-02-24 04:59:39', '2020-02-27 04:59:43', '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('38829ec66b81450584c138808455574c', '044cf67fbcce4a9fa1feef2098103cbc', '2', '111', '3', 30, '2020-03-04 21:08:01', '2020-03-04 21:30:45', '2020-03-05 21:07:22', '2020-03-04 22:15:11', '6', '3', '3', NULL, '2020-03-04 21:08:01', '2020-03-04 22:15:11', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('4a09f036548a4d56810f74708e195dfc', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-27 22:04:48', NULL, '2020-03-28 22:04:46', NULL, '0', NULL, NULL, NULL, '2020-03-27 22:04:48', '2020-03-27 22:04:48', '2020-03-28 13:52:08', NULL, NULL);
INSERT INTO `borrowing` VALUES ('502eadc37faf4e549785eb2e58f9c409', 'b57a9128631743239a41817936f5d7bb', '2', '1441', '3', 30, '2020-03-04 22:00:49', '2020-03-04 22:23:54', '2020-03-05 22:00:44', NULL, '3', '3', NULL, NULL, '2020-03-04 22:00:49', '2020-03-04 22:23:54', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('58b705d38100491da0ec9b32a386d350', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:56:00', '2020-03-25 20:56:07', '2020-03-26 20:55:59', '2020-03-25 20:57:22', '6', 'admin', 'admin', NULL, '2020-03-25 20:56:00', '2020-03-25 20:57:22', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('5c203ea2752542198bd78f7e2ca28b55', '3c40be903534470aa102788712cfe99e', '2', '14141', '3', 30, '2020-03-04 21:46:25', '2020-03-04 21:55:40', '2020-03-05 21:46:19', '2020-03-04 22:16:51', '6', '3', '3', '信誉不够', '2020-03-04 21:46:25', '2020-03-04 22:16:51', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('5d8750264e524ac292f90aa22d72e174', 'd58a37c26ed2456c9f566768afc1d4ae', '1', '1111', 'admin', 30, '2020-03-28 16:47:25', NULL, '2020-03-29 16:47:24', NULL, '0', NULL, NULL, NULL, '2020-03-28 16:47:25', '2020-03-28 16:47:25', '2020-03-28 16:47:35', NULL, NULL);
INSERT INTO `borrowing` VALUES ('5f417b5da7a34a00bab15135c8c63b10', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:51:04', '2020-03-25 20:51:38', '2020-03-26 20:51:02', NULL, '2', 'admin', NULL, '11111', '2020-03-25 20:51:04', '2020-03-25 20:51:38', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('7411fd8d643d422ab78b29073b824e05', 'bf5d445abd77406fa433c72c683b10f2', '2', 'windows', '3', 30, '2020-03-04 23:05:20', '2020-03-08 11:21:30', '2020-03-05 23:05:14', NULL, '2', '3', NULL, '我日', '2020-03-04 23:05:20', '2020-03-08 11:21:30', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('78b2019271c347dab2424ad093afa436', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-25 20:37:38', '2020-03-25 20:38:52', '2020-03-26 20:37:36', NULL, '2', 'admin', NULL, 'bugou', '2020-03-25 20:37:38', '2020-03-25 20:38:52', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('800cbe5148914ecf824f414c3ebf150d', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:54:43', '2020-03-25 20:54:49', '2020-03-26 20:54:41', NULL, '2', 'admin', NULL, '1111111111111', '2020-03-25 20:54:43', '2020-03-25 20:54:49', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('8a164a148ca84414ab846a37cd288a4a', '089238da2d864fb6a35b73aeec1b478a', '2', '5421', '3', 30, '2020-03-04 22:22:29', '2020-03-04 22:22:51', '2020-03-05 22:22:27', '2020-03-04 22:31:25', '6', '3', '3', NULL, '2020-03-04 22:22:29', '2020-03-04 22:31:25', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('8a7232527af04d2aa193cf0daf7914e2', '10d88d1b5409433db00d871370ce7fd6', '1', '141', 'admin', 30, '2020-03-28 17:42:45', NULL, '2020-03-29 17:42:43', NULL, '1', NULL, NULL, NULL, '2020-03-28 17:42:45', '2020-03-28 17:42:45', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a2d409e4aebd46fda301ff4e67e37fd5', 'a135df0ea5014c90bba0e4c6a7c82cab', '2', '损坏损坏', '3', 30, '2020-03-04 21:57:06', '2020-03-04 21:58:06', '2020-03-05 21:57:03', NULL, '2', '3', NULL, '信誉不够', '2020-03-04 21:57:06', '2020-03-04 21:58:06', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a591b5369a4e45e0a2160d0c9eefbc3a', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2', '1', '3', 7, '2020-03-04 22:44:05', '2020-03-04 22:44:16', '2019-03-06 08:00:00', '2020-03-04 22:56:31', '5', '3', '3', NULL, '2020-03-04 22:44:05', '2020-03-04 22:56:31', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a997e25f9a9c472c954e418188a203a3', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-27 22:02:58', '2020-03-28 14:22:03', '2020-01-15 22:02:55', NULL, '3', 'admin', NULL, NULL, '2020-03-27 22:02:58', '2020-03-28 14:22:03', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('b2ffe3b78ad444ff9fb4da5bd81b7f48', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-08 13:21:07', '2020-03-08 13:21:20', '2020-03-09 13:21:04', NULL, '2', 'admin', NULL, '信誉不够', '2020-03-08 13:21:07', '2020-03-08 13:21:20', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('d14875bcc01c40d2aa3f9864aa47d96b', 'a135df0ea5014c90bba0e4c6a7c82cab', '1', '狼图腾', 'admin', 30, '2020-03-28 12:52:46', NULL, '2020-03-29 12:52:43', NULL, '0', NULL, NULL, NULL, '2020-03-28 12:52:46', '2020-03-28 12:52:46', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('d680ce170f1d49ed8d3bb8725d1957b9', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:52:33', '2020-03-25 20:52:59', '2020-03-26 20:52:31', NULL, '2', 'admin', NULL, '111111111111111111111', '2020-03-25 20:52:33', '2020-03-25 20:52:59', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('d96fa9e9d05e40da99af8f80a6718cb5', 'b57a9128631743239a41817936f5d7bb', '2', '1441', '3', 30, '2020-03-04 21:58:34', '2020-03-04 21:59:40', '2020-03-05 21:58:32', NULL, '2', '3', NULL, '信誉不够', '2020-03-04 21:58:34', '2020-03-04 21:59:43', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('deccedc6a367412eaab753d3948fdea1', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:57:31', '2020-03-25 20:57:38', '2020-03-26 20:57:28', NULL, '2', 'admin', NULL, '123', '2020-03-25 20:57:31', '2020-03-25 20:57:38', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('f96ce9de21bb4552b31324a7ada317de', 'f65f5a4768694472b70715fd73bca2f5', '1', '111', 'admin', 30, '2020-03-25 20:49:49', '2020-03-25 20:50:28', '2020-03-26 20:49:46', NULL, '2', 'admin', NULL, '1111', '2020-03-25 20:49:49', '2020-03-25 20:50:28', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('fa781239f24540f3801e8137d2c75828', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-08 13:12:55', '2020-03-08 13:13:07', '2020-03-09 13:12:52', '2020-03-08 13:16:12', '6', 'admin', 'admin', NULL, '2020-03-08 13:12:55', '2020-03-08 13:16:12', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('ffa3d8c5a64643ea87756821ded2f3da', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-27 22:01:52', NULL, '2020-03-28 22:01:50', NULL, '0', NULL, NULL, NULL, '2020-03-27 22:01:52', '2020-03-27 22:01:52', '2020-03-28 16:41:16', NULL, NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别id',
  `first_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '一级分类',
  `second_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '二级分类',
  `third_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '三级分类',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('01001001', '小说', '中国小说', '武侠');
INSERT INTO `category` VALUES ('01001002', '小说', '中国小说', '科幻');
INSERT INTO `category` VALUES ('01001003', '小说', '中国小说', '军事');
INSERT INTO `category` VALUES ('01001004', '小说', '中国小说', '情感');
INSERT INTO `category` VALUES ('01001005', '小说', '中国小说', '古典');
INSERT INTO `category` VALUES ('01002000', '小说', '外国小说', NULL);
INSERT INTO `category` VALUES ('02002001', '文学', '传记', '军事人物');
INSERT INTO `category` VALUES ('02002002', '文学', '传记', '政治人物');
INSERT INTO `category` VALUES ('02002003', '文学', '传记', '文学家');
INSERT INTO `category` VALUES ('02002004', '文学', '传记', '科学家');
INSERT INTO `category` VALUES ('02002005', '文学', '传记', '哲学家');
INSERT INTO `category` VALUES ('02003000', '文学', '影视文学', NULL);
INSERT INTO `category` VALUES ('02004000', '文学', '戏曲文学', NULL);
INSERT INTO `category` VALUES ('02005000', '文学', '散文', NULL);

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `collection_time` timestamp(0) NULL DEFAULT NULL,
  `book_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `book_img` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection_group
-- ----------------------------
DROP TABLE IF EXISTS `collection_group`;
CREATE TABLE `collection_group`  (
  `collection_group_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏分组id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分组名称',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`collection_group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection_group
-- ----------------------------
INSERT INTO `collection_group` VALUES ('49bfd04915ec4d2893cdd5bdd0a3aaa4', '1', 'haha', '2020-04-02 06:34:33', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `collection_group` VALUES ('6c088924b89d4c0fa2349cbb01ccc28a', '1', 'eeee', '2020-03-30 06:34:30', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `collection_group` VALUES ('84f2c84d9692410d9a8216a5f44dd472', '1', 'aaa', '2020-03-28 06:34:25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `collection_group` VALUES ('9f3e33bf9180418798d60ef80741be09', '1', '444', '2020-03-28 06:34:22', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `collection_group` VALUES ('a1373dcebdb74f85a3283c8f6f12f080', '1', '11111111', '2020-03-23 21:31:34', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `collection_group` VALUES ('a232a3ee96184ada9366471b5e88ac29', '1', '默认收藏夹', '2020-03-17 06:33:02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `collection_group` VALUES ('ae7d3f1372774a62a2ce9d75934de14b', '1', '1111111144141', '2020-03-23 21:33:23', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论id',
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `comment_time` timestamp(0) NOT NULL COMMENT '评论时间',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '评论内容',
  `score` int(11) NULL DEFAULT NULL COMMENT '评分',
  `reply_flag` int(11) NULL DEFAULT NULL,
  `reply_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zan_number` int(11) NULL DEFAULT NULL,
  `comment_pid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reply_user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('00af7cd5206041f7aba5463987d37833', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:22:53', '真的强', 3, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('07824d6597514168aa5cf043e80b9c0b', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:07', '11111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('0fa7a8215870476fae6d17e71ba44faa', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 23:05:40', '我是回复3', NULL, 1, '1b35122c6f9b44d296b938615422f211', 0, 'd4a31f957d554b22b451f31d8224e03a', 'admin');
INSERT INTO `comment` VALUES ('14a4835581bf4f019a24b6ff944cb900', '543adcda63bd4938a57cc86e072ec380', '1', '2020-03-25 20:25:32', '我日你妈', 1, 0, NULL, 1, NULL, NULL);
INSERT INTO `comment` VALUES ('14abd47291db49eaa585771d2f0c5c66', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:02:44', '我也是回复2 的 4', NULL, 1, '268f9f687de6441297a9e22f8d310f4c', 0, '00af7cd5206041f7aba5463987d37833', 'admin');
INSERT INTO `comment` VALUES ('14b9776315994cab9523d15cbfc3ab98', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:50:22', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', 1, 0, NULL, 3, NULL, NULL);
INSERT INTO `comment` VALUES ('14ef6d97a30543a1bb5a3c002f121c6a', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:31:57', '真的', NULL, 1, 'f0a144101ef94f81b3b8ecc9540248db', 0, '2685cf81587849d5a064dfea0df18e1c', 'clt');
INSERT INTO `comment` VALUES ('163d7ccbb80f4fb9a4ea2fbad6e0068b', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:14:15', '我是admin啊', NULL, 1, 'fa65e38a5eac4ea28cc9157756e3a7e1', 0, '07824d6597514168aa5cf043e80b9c0b', 'clt');
INSERT INTO `comment` VALUES ('1c703327fe2c41c2aef53c038fe78ac6', '26fd2b762c9646f49e1cf6f40566b7d8', '1', '2020-03-28 19:59:51', '1111', 2, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('201a01475a864c8eb43d962dbdb3f0fb', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 21:32:49', '我也日', NULL, 1, '8fa99ca01f3a4e66b7b8e081011a8409', 0, '3faa0166674b4ceaa32e8436035e29c7', 'admin');
INSERT INTO `comment` VALUES ('2685cf81587849d5a064dfea0df18e1c', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:52:24', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('268f9f687de6441297a9e22f8d310f4c', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:02:23', '我是回复1 的 2', NULL, 1, 'c61572784f55449bb722fe148b49d421', 0, '00af7cd5206041f7aba5463987d37833', 'admin');
INSERT INTO `comment` VALUES ('26d1c441fe2f4151b927890771d12780', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:32:39', '一点都不好', NULL, 1, 'ec19c755d311401f83a862b59aef6b23', 0, '2685cf81587849d5a064dfea0df18e1c', 'clt');
INSERT INTO `comment` VALUES ('3193574fb4e64fc48714fbbebc8f8830', '26fd2b762c9646f49e1cf6f40566b7d8', '1', '2020-03-28 18:42:35', '111111111111111', NULL, 1, '451349b0610b498085a22c08542c88b4', 0, 'e8330dc45bcd412a9343579baacec977', 'admin');
INSERT INTO `comment` VALUES ('31e3a332536841a38cea56423ccfdcf1', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:57:20', 'qlmlgb', NULL, 1, 'd4cfad55dd06415aad92b253d18e00b9', 0, '31ef7b257c0d427bbb869c1bbae81f66', 'clt');
INSERT INTO `comment` VALUES ('31ef7b257c0d427bbb869c1bbae81f66', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:25:05', '我艹', 3, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('3d7dd2d1af084c0593171992c21796cb', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:52:04', '1111111111111 ', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('3faa0166674b4ceaa32e8436035e29c7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:22', '呜呜呜呜呜呜呜呜呜呜呜无无无无无无无无无无无无无无无无无无无无无无无无', 1, 0, NULL, 2, NULL, NULL);
INSERT INTO `comment` VALUES ('451349b0610b498085a22c08542c88b4', '26fd2b762c9646f49e1cf6f40566b7d8', '1', '2020-03-28 18:42:31', '111111111111111', NULL, 1, 'e8330dc45bcd412a9343579baacec977', 0, 'e8330dc45bcd412a9343579baacec977', NULL);
INSERT INTO `comment` VALUES ('4521692991464a1183cb763c1594d28e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:02:03', '我是1', NULL, 1, '00af7cd5206041f7aba5463987d37833', 0, '00af7cd5206041f7aba5463987d37833', NULL);
INSERT INTO `comment` VALUES ('45d2e2ea6be3417ba31bb52d023a86ac', '543adcda63bd4938a57cc86e072ec380', '1', '2020-03-25 20:30:12', 'i fuck you', NULL, 1, '78c8c4886aa94fb985def1419e5e2975', 0, '14a4835581bf4f019a24b6ff944cb900', 'admin');
INSERT INTO `comment` VALUES ('47714ffc10374d29885fc70100dd3f93', '26fd2b762c9646f49e1cf6f40566b7d8', '1', '2020-03-28 18:41:33', '哈哈', NULL, 1, '1ffcacf2d9a647148b8d9db8f1f966d0', 0, '1ffcacf2d9a647148b8d9db8f1f966d0', NULL);
INSERT INTO `comment` VALUES ('4f28d03f1f1b4b4db124d92260547822', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 21:05:44', '法萨芬撒分散个搭嘎当时搞公案', NULL, 1, '9cf23e607f524cf99c90c20ed2ce3625', 0, '9cf23e607f524cf99c90c20ed2ce3625', NULL);
INSERT INTO `comment` VALUES ('53a15344aeb5475297dd7bef25123c32', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:56:35', 'nmsl', NULL, 1, 'f76d92e8c0a14e7cbde5eb52443897e3', 0, '31ef7b257c0d427bbb869c1bbae81f66', 'clt');
INSERT INTO `comment` VALUES ('576f0934768f4439947bb27dc87c67e5', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:35', '发撒阿萨法', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('594a7b9548954f51b7c9691ce8bd93c7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:17:13', '我回复我还是admin', NULL, 1, 'd60765d7e87144f08fb79c9021e0d994', 0, '07824d6597514168aa5cf043e80b9c0b', 'admin');
INSERT INTO `comment` VALUES ('613d94423ba54927ba27b0a165c417f9', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 19:17:36', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', NULL, 1, '14b9776315994cab9523d15cbfc3ab98', -1, '14b9776315994cab9523d15cbfc3ab98', NULL);
INSERT INTO `comment` VALUES ('693d949b39714fc6ac8f27191c719fba', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:38', '划分煽风点火', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('6a53eb3899ca4c6d9840560f6efd41da', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:52:43', '呜呜呜呜呜呜呜呜呜呜呜无无无无无无无无', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('6cb59c59a422465ca0465f9b06de30b8', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 23:05:34', '我是回复6', NULL, 1, '5a481746680b450284ed47fa9a45b59c', 0, 'd4a31f957d554b22b451f31d8224e03a', 'admin');
INSERT INTO `comment` VALUES ('700fd12bd7a54fbfa554de448b6a51ca', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 21:04:06', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', NULL, 1, '613d94423ba54927ba27b0a165c417f9', 0, '613d94423ba54927ba27b0a165c417f9', NULL);
INSERT INTO `comment` VALUES ('707cd223e4f34db3a6a325b151d7cb32', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 21:19:32', 'wwwwwrrrrrr', NULL, 1, '613d94423ba54927ba27b0a165c417f9', 0, '14b9776315994cab9523d15cbfc3ab98', 'admin');
INSERT INTO `comment` VALUES ('70dcfe0d65bf45d2884dd95637d65f47', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:14:38', '我还是clt啊', NULL, 1, '163d7ccbb80f4fb9a4ea2fbad6e0068b', 0, '07824d6597514168aa5cf043e80b9c0b', 'admin');
INSERT INTO `comment` VALUES ('78c8c4886aa94fb985def1419e5e2975', '543adcda63bd4938a57cc86e072ec380', '1', '2020-03-25 20:30:02', 'fuck', NULL, 1, '14a4835581bf4f019a24b6ff944cb900', 0, '14a4835581bf4f019a24b6ff944cb900', NULL);
INSERT INTO `comment` VALUES ('7c0a7e4081bc474c87b4e774432768d2', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 23:05:24', '我是回复4', NULL, 1, '1b35122c6f9b44d296b938615422f211', 0, 'd4a31f957d554b22b451f31d8224e03a', 'admin');
INSERT INTO `comment` VALUES ('8637665dadaa41fa82f1dbc92bd6c590', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 23:08:13', 'haaaaaa', NULL, 1, '3faa0166674b4ceaa32e8436035e29c7', 0, '3faa0166674b4ceaa32e8436035e29c7', NULL);
INSERT INTO `comment` VALUES ('873f0b9f57b2401d80f911faf1dda6bb', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:27:35', '给爸爸成啊', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8919d8f90d9d434a831963eb28d25088', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:38', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('898926c288314c88a306cdb0c7c8ff47', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 19:18:55', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', NULL, 1, '14b9776315994cab9523d15cbfc3ab98', 0, '14b9776315994cab9523d15cbfc3ab98', NULL);
INSERT INTO `comment` VALUES ('8c14a4a90c454e3db345c8b7e1058c23', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:23:37', '真的不错', 3, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8c26bca3e5da4957bef5a434f186c5fc', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:20', '1111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8e29bfc9a0ad4eeabc529a1de56031de', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:15', '嘻嘻嘻嘻嘻嘻嘻嘻xxxxxxxxxxx', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('939ea9e971eb4d7b82dc58a6e03a7465', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:49:03', '返回搜狐覆盖数分公司hoi9awf很大时额按规定洒', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('962fec3cc41445fd9616234633e4c2c5', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:45', '呜呜呜呜呜呜呜呜呜呜呜无无无无无无无无无无', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('97040a84d5b3421ba1e5d90458bb237e', '543adcda63bd4938a57cc86e072ec380', '1', '2020-03-25 20:25:46', '11111111111111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('9947263a3d69463bb494feae0b8db8d5', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 22:45:51', '1', NULL, 1, 'd4a31f957d554b22b451f31d8224e03a', 0, 'd4a31f957d554b22b451f31d8224e03a', NULL);
INSERT INTO `comment` VALUES ('9cf23e607f524cf99c90c20ed2ce3625', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 19:18:26', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', NULL, 1, '14b9776315994cab9523d15cbfc3ab98', 0, '14b9776315994cab9523d15cbfc3ab98', NULL);
INSERT INTO `comment` VALUES ('9e657aaca850476a9a69935c4b21d9be', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:42', '划分煽风点火凄凄切切群群群群群群群群', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('a6e478905ac1434daa922b44ded30058', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:46', '111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('aaf15cb362e64e8790d74b363ca2ebe4', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:05', '2222222', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('b7338fb08d1b4fabbec2950466f8312e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:44', '11111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('ba015bab7b4a41abbb6286f2e00a9d62', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:11:31', '我是回复clt  的admin', NULL, 1, 'd3bd3973c358420599eb803879c6cb21', 0, '00af7cd5206041f7aba5463987d37833', 'clt');
INSERT INTO `comment` VALUES ('bcc37e982ef54e00a321d2b59fdd2e0a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:24:27', '我艹', 3, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c0f36493ea9e40e8b3dbe7e0e6d84a35', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:35', '还不能女女女女女女女女女女女女女女女女女女女女女过过过过过过过', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c13f25dc68804338baf9ef4fb114477e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:48', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', 4, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c20a65996e874952b430279d9798d7e6', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:26:59', '给爸爸成啊', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c61572784f55449bb722fe148b49d421', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:02:12', '我是回复1', NULL, 1, '4521692991464a1183cb763c1594d28e', 0, '00af7cd5206041f7aba5463987d37833', 'admin');
INSERT INTO `comment` VALUES ('c7031468a1144d1e9aabe956b8df1e5a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 21:23:22', 'wshf', NULL, 1, '14b9776315994cab9523d15cbfc3ab98', 0, '14b9776315994cab9523d15cbfc3ab98', NULL);
INSERT INTO `comment` VALUES ('cbbf77e249504cc498d834de017b224c', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:31', '我发玩法', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('cc347104056d4dc6994abbbbfba1e2b4', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 17:56:39', '很好很好', 3, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('ce69499ea7f24ce88df6939de37cd89a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:02:33', '我是回复2 的 3', NULL, 1, '268f9f687de6441297a9e22f8d310f4c', 0, '00af7cd5206041f7aba5463987d37833', 'admin');
INSERT INTO `comment` VALUES ('cfd901919a524d86ad2bd3a2e9eccb7f', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:29', '哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('d0ee236a0c8140a3aa8dabcb9c18163d', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 21:23:36', 'wyeshf', NULL, 1, 'c7031468a1144d1e9aabe956b8df1e5a', 0, '14b9776315994cab9523d15cbfc3ab98', 'admin');
INSERT INTO `comment` VALUES ('d1212e8d6bb0454aa2354a3d622bceed', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-25 19:16:24', '我也回复3楼', NULL, 1, '70dcfe0d65bf45d2884dd95637d65f47', 0, '07824d6597514168aa5cf043e80b9c0b', 'clt');
INSERT INTO `comment` VALUES ('d3bd3973c358420599eb803879c6cb21', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:11:00', '我是回复2 的clt', NULL, 1, '268f9f687de6441297a9e22f8d310f4c', 0, '00af7cd5206041f7aba5463987d37833', 'admin');
INSERT INTO `comment` VALUES ('d4568e74428c470fb1292228af38dc7e', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:31:32', '我也觉得', NULL, 1, 'ec19c755d311401f83a862b59aef6b23', 0, '2685cf81587849d5a064dfea0df18e1c', 'clt');
INSERT INTO `comment` VALUES ('d4a31f957d554b22b451f31d8224e03a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 19:36:28', '13131', 5, 0, NULL, 1, NULL, NULL);
INSERT INTO `comment` VALUES ('d4cfad55dd06415aad92b253d18e00b9', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:57:04', 'wrnmlgb', NULL, 1, '53a15344aeb5475297dd7bef25123c32', 0, '31ef7b257c0d427bbb869c1bbae81f66', 'admin');
INSERT INTO `comment` VALUES ('dbaaaf7faf2245c88c023f7c831033df', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:15:11', '我回复3楼', NULL, 1, '70dcfe0d65bf45d2884dd95637d65f47', 0, '07824d6597514168aa5cf043e80b9c0b', 'clt');
INSERT INTO `comment` VALUES ('e2b01fbde530439295b4eca3b0e0de67', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 19:06:19', 'wwwwwwww', 1, 0, NULL, 1, NULL, NULL);
INSERT INTO `comment` VALUES ('e2bfdce13d1049069eecf395de2186b7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:26', '凄凄切切群群群群群群群群群群群群群群群群群群群群群群群群群群群群', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('e3c4b73c101a48f8b7b9c52a24e5c65d', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:19', '哒哒哒哒哒哒多多多多多多多多多多多多多多多多多多多多多', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('e5102d1a021d49e1990c16a5aef5326e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:10', '11111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('e64c987801044d6bb20da611e07995b7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:13', '111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('ec19c755d311401f83a862b59aef6b23', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:31:18', '这书很好', NULL, 1, '2685cf81587849d5a064dfea0df18e1c', 0, '2685cf81587849d5a064dfea0df18e1c', NULL);
INSERT INTO `comment` VALUES ('f0349926343341e5b75aa06494679539', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 19:27:38', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', NULL, 1, '14b9776315994cab9523d15cbfc3ab98', 0, '14b9776315994cab9523d15cbfc3ab98', NULL);
INSERT INTO `comment` VALUES ('f0a144101ef94f81b3b8ecc9540248db', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:31:46', '真的吗', NULL, 1, 'd4568e74428c470fb1292228af38dc7e', 0, '2685cf81587849d5a064dfea0df18e1c', 'clt');
INSERT INTO `comment` VALUES ('f14a8a30ee4241f394373fa0c33d7a17', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:48', '111', 1, 0, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('f4d34010329849898dfb871457f6c83d', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:57:42', 'cao', NULL, 1, '53a15344aeb5475297dd7bef25123c32', 0, '31ef7b257c0d427bbb869c1bbae81f66', 'admin');
INSERT INTO `comment` VALUES ('f76d92e8c0a14e7cbde5eb52443897e3', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:56:21', 'wdnmd', NULL, 1, '31ef7b257c0d427bbb869c1bbae81f66', 0, '31ef7b257c0d427bbb869c1bbae81f66', NULL);
INSERT INTO `comment` VALUES ('f8b0e7876c764a1fa67acc7d61d4733c', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-24 23:08:37', 'wcao', NULL, 1, '8fa99ca01f3a4e66b7b8e081011a8409', 0, '3faa0166674b4ceaa32e8436035e29c7', 'admin');
INSERT INTO `comment` VALUES ('fa65e38a5eac4ea28cc9157756e3a7e1', 'bf5d445abd77406fa433c72c683b10f2', '4d6d14e1b9e149aa89567a70ad723778', '2020-03-25 19:13:59', '我是clt 啊', NULL, 1, '07824d6597514168aa5cf043e80b9c0b', 0, '07824d6597514168aa5cf043e80b9c0b', NULL);

-- ----------------------------
-- Table structure for comment_like
-- ----------------------------
DROP TABLE IF EXISTS `comment_like`;
CREATE TABLE `comment_like`  (
  `comment_like_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `comment_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `is_like` int(11) NULL DEFAULT NULL,
  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_like_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_like
-- ----------------------------
INSERT INTO `comment_like` VALUES ('1222612b0cba49f19ed6966dc1e70c91', '613d94423ba54927ba27b0a165c417f9', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('1cec9e5479be47d38003272f09c4d8c7', '14a4835581bf4f019a24b6ff944cb900', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('255d643edd8949fdb16e228a0bec4512', '9cf23e607f524cf99c90c20ed2ce3625', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('25e2706aa723452087777677d445b4e7', 'd4a31f957d554b22b451f31d8224e03a', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('3c2258bc03b74b188376085f91dd53cc', '14b9776315994cab9523d15cbfc3ab98', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('47054e9fa99f4677940b6f043a88889e', 'e2b01fbde530439295b4eca3b0e0de67', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('508a6716038645c7901635e3c598076e', '3d7dd2d1af084c0593171992c21796cb', '1', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('5d288602e2d34dafafdfa55751fa0f80', '3faa0166674b4ceaa32e8436035e29c7', '4d6d14e1b9e149aa89567a70ad723778', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('63870a0130184c619619f0a2f430b207', 'cc347104056d4dc6994abbbbfba1e2b4', '1', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('7ef4d0ae1e42466db8fad9b69c9253d4', '14b9776315994cab9523d15cbfc3ab98', '4d6d14e1b9e149aa89567a70ad723778', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('f2bd2d44ed5b46b38e7dc4d6d0c7eb92', '898926c288314c88a306cdb0c7c8ff47', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('f63b993c0d98464d99a712a50e930fe7', '3faa0166674b4ceaa32e8436035e29c7', '1', 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典id',
  `number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典名称',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典类型',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段3',
  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段4',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('3e4be16b360d4efe87008ad69e0842d5', NULL, '院系', 'sys_depart', 1, '院系列表', '2020-03-31 14:00:18', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dictionary` VALUES ('8d113063fcc4478e898388825e4045f3', NULL, '专业', 'sys_major', 1, '专业列表', '2020-03-31 10:21:32', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dictionary` VALUES ('9fffa299f7a24331a5f0f4760988e06a', NULL, '班级', 'sys_class_number', 1, '班级列表', '2020-03-31 10:23:56', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dictionary` VALUES ('fced055171e74ab7898edc2659a1bd49', NULL, '年级', 'sys_grade', 1, '年级列表', '2020-03-31 10:05:50', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for dictionary_data
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_data`;
CREATE TABLE `dictionary_data`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典数据id',
  `number` int(11) NULL DEFAULT NULL COMMENT '字典数据编号',
  `label` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典数据标签',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典数据键值',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序号',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属类型',
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被用字段3',
  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被用字段4',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary_data
-- ----------------------------
INSERT INTO `dictionary_data` VALUES ('007502ff233f4fe18449cd5fd4dbed1d', NULL, '2019级', '2019', 19, 1, '111111', '2020-03-31 11:20:01', NULL, 'sys_grade', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('0ac94b89273241aa80011832300298e3', NULL, '2017级', '2017', 17, 1, NULL, '2020-03-31 11:21:34', NULL, 'sys_grade', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('14b4b4b132fc47118f5c25da61e41c84', NULL, '2016级', '2016', 16, 1, NULL, '2020-03-31 11:21:39', NULL, 'sys_grade', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('17256c8b3c524bac9b00b2031b0a2fd5', NULL, '法学院', '06', 6, 1, '法学院', '2020-03-31 15:07:17', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('2354452187d843bb9ac7d49b96522da8', NULL, '音乐学院', '11', 11, 1, '音乐学院', '2020-03-31 15:08:26', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('27fd1537f44d4ca9a51b5f11ed3a458a', NULL, '体育学院', '13', 13, 1, '体育学院', '2020-03-31 15:14:26', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('2a4d3a72836345f0b83759ad691f3b60', NULL, '1111', '1111', 999, 1, '1111', '2020-03-31 17:19:16', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('2d692dee11bc4a82b1ac63b3e58a3c7d', NULL, '信科', '0303', 303, 1, '信息与计算科学', '2020-03-31 15:16:49', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('2ff90b38b7314769a6e44e0c81faf1a5', NULL, '五班', '05', 5, 1, NULL, '2020-03-31 14:25:22', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('38014983d96d4b4d94b7ffe64b45cab7', NULL, '软件', '0302', 302, 1, '软件工程', '2020-03-31 15:48:35', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('3fe3b51095ef458a873a17407554489d', NULL, '物联网', '0304', 304, 1, '物联网工程', '2020-03-31 15:49:29', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('4225914202a34a2ba6cf8280bfe064fa', NULL, '2015级', '2015', 15, 1, NULL, '2020-03-31 13:45:45', NULL, 'sys_grade', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('56c3474875c44ea3abef48015fa1eabc', NULL, '机电院', '02', 2, 1, '机电工程学院', '2020-03-31 14:20:54', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('5a0816862e76449bacbba1aa2f8f4292', NULL, '影视摄影与制作', '0704', 704, 1, '影视摄影与制作', '2020-03-31 17:16:07', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('5af31a38068443099fc53d08d96710ce', NULL, '八班', '08', 8, 1, NULL, '2020-03-31 15:15:58', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('6720db6befac40dbadea73a22c1a905b', NULL, '计数院', '03', 3, 1, '计算机工程与应用数学', '2020-03-31 14:10:41', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('6d20e20f01874004afcd107d590b3368', NULL, '通信工程', '0402', 402, 1, '通信工程', '2020-03-31 17:12:27', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('7269b60336f14e22ae1228a3179ce7a8', NULL, '外语院', '08', 8, 1, '外国语学院', '2020-03-31 15:07:37', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('7b2df0e447b146a1adcb91d959be9ce9', NULL, '马克思主义学院', '12', 12, 1, '马克思主义学院', '2020-03-31 15:08:38', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('7b8a575dc6d944c698a51e9cda183e70', NULL, '电气工程及其自动化', '0404', 404, 1, '电气工程及其自动化', '2020-03-31 17:12:54', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('843de29d16c74a7f92248555b36e7e23', NULL, '经管院', '09', 9, 1, '经济与管理学院', '2020-03-31 15:07:49', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('89b15e84972d4dd5817b8c6fe961a876', NULL, '土木院', '01', 1, 1, '土木工程学院', '2020-03-31 14:14:06', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('8aa0f0086cd14c258fb00dabe9a42806', NULL, '乡村振兴研究院', '99', 99, 1, '乡村振兴研究院', '2020-03-31 15:14:39', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('8ebe81e5f6c546e6b4de17fad87f7236', NULL, '一班', '01', 1, 1, NULL, '2020-03-31 14:24:01', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('98fc499b94a64fe9931d45d648adc035', NULL, '通天塔', '1111', 0, 1, NULL, '2020-03-31 17:19:23', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('9c39dca7a8af43668800ae89f7f6bf80', NULL, '播音与主持艺术', '0702', 702, 1, '播音与主持艺术', '2020-03-31 17:15:25', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('a7bdc225879940899b2f7587b929e043', NULL, '广播电视编导', '0703', 703, 1, '广播电视编导', '2020-03-31 17:15:44', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('ac695ccc636442f184334e5b018010d7', NULL, '六班', '06', 6, 1, NULL, '2020-03-31 14:25:30', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('ba25f2117eb4450cb11029ff330126e2', NULL, '2020级', '2020', 20, 1, NULL, '2020-03-31 11:18:22', NULL, 'sys_grade', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('bb9fff2f95a74b52bab69e0f45867076', NULL, '艺术院', '10', 10, 1, '艺术设计学院', '2020-03-31 15:08:03', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('bc99bdfc38764e4e8da2a1a04d0a41ee', NULL, '七班', '07', 7, 1, NULL, '2020-03-31 14:25:40', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('bd58fa9b0edf484d831de36d3772bd72', NULL, '三班', '03', 3, 1, NULL, '2020-03-31 14:25:08', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('be8f7b348fae4c6981c6897985fd711b', NULL, '应用数学', '0305', 305, 1, '应用数学', '2020-03-31 15:49:52', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('c0c62a8e08ab42b6b9e4a6c1d36ded51', NULL, '新闻专业', '0701', 701, 1, '新闻专业', '2020-03-31 17:14:30', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('c1d670d715554dd9a5d511fcfce7320a', NULL, '2018级', '2018', 18, 1, NULL, '2020-03-31 11:21:27', NULL, 'sys_grade', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('c46571b966ee4a5ba72bedec4694b9a0', NULL, '生环院', '05', 5, 1, '生物与环境工程学院', '2020-03-31 15:05:35', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('cbf6700b83bb4b4db43e15ccbf6d5597', NULL, '电子信息工程', '0401', 401, 1, '电子信息工程', '2020-03-31 17:12:12', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('d32c18f4655d479793c5090ffa4bf38e', NULL, '电气院', '04', 4, 1, '电子信息与电气工程学院', '2020-03-31 15:10:52', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('d4960802efda450b8584aa0236aded3f', NULL, '四班', '04', 4, 1, NULL, '2020-03-31 14:25:15', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('dc950cfab3c94d56aebc9e85352dd08e', NULL, '光电信息工程', '0403', 403, 1, '光电信息工程', '2020-03-31 17:12:41', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('e01bc30352d145028e6fa937f624d0ac', NULL, '计科', '0301', 301, 1, '计算机科学与方法', '2020-03-31 15:48:07', NULL, 'sys_major', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('e857729edb904269ac5bd86a4347f4e6', NULL, '影视院', '07', 7, 1, '影视艺术与文化传播学院', '2020-03-31 15:12:18', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('ef364f1e887f49d9a515915485d03419', NULL, '研究生学院', '98', 98, 1, '研究生学院', '2020-03-31 15:13:38', NULL, 'sys_depart', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('f4ce8ce258a840f49baf386fe5e26be3', NULL, '二班', '02', 2, 1, NULL, '2020-03-31 14:24:58', NULL, 'sys_class_number', NULL, NULL, NULL);
INSERT INTO `dictionary_data` VALUES ('f57c2e29ba44400690bec912eb942d47', NULL, 'test', 'test', 999, 1, NULL, '2020-03-31 17:19:34', NULL, 'sys_major', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '信息id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `send_user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发送用户id',
  `sending_time` timestamp(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '信息内容',
  `status` int(11) NULL DEFAULT NULL COMMENT '信息状态  已读、未读',
  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', NULL, '2020-03-02 05:12:02', '1', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('1414131', '1', NULL, '2020-03-06 01:10:24', 'fg', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('1414fdszhgd', '1', NULL, '2020-03-06 01:10:26', 'g', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('1f058edf357147609a9aa90de3b0b81f', '1', '系统管理员', '2020-03-25 20:49:41', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：11111', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('1fafsafsasafsa', '1', NULL, '2020-03-07 01:09:09', 'sfafs', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('2', '2', NULL, '2020-02-27 21:09:58', '1', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('25r2asdf2saf2', '1', NULL, '2020-03-07 01:10:13', 'af', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('2r2dsf3q34tsv3', '1', NULL, '2020-03-13 01:10:16', 'd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('4144yhu5644', '1', NULL, '2020-03-06 01:10:29', 's', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('5eafc6457db84b44a2dff00f1816987e', '1', '系统管理员', '2020-03-25 20:51:38', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：11111', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('735bf7223ede4e498e70c3a93e0ff699', '1', NULL, '2020-03-08 13:21:20', 'admin,您好，你申请借阅的书籍《hello》被驳回，驳回理由：信誉不够', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('78c5c614660947e78d1c637ad62f8055', '1', '系统管理员', '2020-03-25 20:38:52', 'admin,您好，你申请借阅的书籍《hello》被驳回，驳回理由：bugou', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('8272af1cdb6e4cda8a23b955aca6c998', '1', '系统管理员', '2020-03-25 20:50:28', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：1111', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('8ca2936d45fd4ce09f8bed3483e26129', '1', '系统管理员', '2020-03-25 20:54:49', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：1111111111111', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('ad6f8ba6bed744978c3a0a5c97ee3fb9', '1', '系统管理员', '2020-03-28 14:22:03', 'admin,您好，你申请借阅的书籍《hello》已通过批准,请于借阅日期前往领取！', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('afdwqr2dhg4wt', '1', NULL, '2020-02-29 01:10:10', 'wf', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('b033df2b987d41fd8ef20da1d66edb33', '1', '系统管理员', '2020-03-25 20:56:07', 'admin,您好，你申请借阅的书籍《111》已通过批准,请于借阅日期前往领取！', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('b25ae49e1d484cc1bffc87bed4de7cfe', '1', '系统管理员', '2020-03-25 20:52:59', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：111111111111111111111', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('b63e85a1752b411cacccd862ff923852', '1', '系统管理员', '2020-03-25 20:57:38', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：123', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('cea616c0a0d34f6f9ac02425367879f2', '1', '系统管理员', '2020-03-25 20:47:01', 'admin,您好，你申请借阅的书籍《111》被驳回，驳回理由：111111', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('d11ddsad12xcz', '1', NULL, '2020-03-06 01:10:21', 's', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('d141dfs3', '1', NULL, '2020-03-06 01:10:18', 'fs', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('e1aa227261c146c1aa58b5643d0de6e0', '1', NULL, '2020-03-08 13:13:07', 'admin,您好，你申请借阅的hello书籍已通过批准', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('f1154893bd6944cc8d5d5f7e20af02bd', '1', NULL, '2020-03-10 19:24:11', 'admin,您好，你申请借阅的书籍《hello》被驳回，驳回理由：11222', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('fafsafgdhg', '1', NULL, '2020-03-07 01:10:08', 'a', 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `book_r` int(11) NULL DEFAULT NULL COMMENT '书籍信息读权限',
  `book_w` int(11) NULL DEFAULT NULL COMMENT '书籍信息写权限',
  `user_r` int(11) NULL DEFAULT NULL COMMENT '用户信息读权限',
  `user_w` int(11) NULL DEFAULT NULL COMMENT '用户信息写权限',
  `borrowing_r` int(11) NULL DEFAULT NULL COMMENT '借阅信息读权限',
  `borrowing_w` int(11) NULL DEFAULT NULL COMMENT '借阅信息写权限',
  `category_w` int(11) NULL DEFAULT NULL COMMENT '类别信息写权限',
  `statistics_r` int(11) NULL DEFAULT NULL COMMENT '统计信息读权限',
  `privilege` int(11) NULL DEFAULT NULL,
  `admin` int(11) NULL DEFAULT NULL,
  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('3d982ffe5bae492b941d4f4649a873b5', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('4d6d14e1b9e149aa89567a70ad723778', 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('5184c589a08245268de9b871d26dfd3c', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('5948ecef174e40d3af8be7c5c24cc361', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('7067fc3b84804c699f196e383700c393', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('79c691410e6e49f793a31842ded42953', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('9cb70c525d044739985aa1eeeb2e3e52', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('9df68aafa8c14a369b5043b5c80f3e42', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('afa6567870834a70bca5690db70b5cc8', 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('b20109964ed0456688218a6e3ad3d4de', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('d5c807fc853347648c4eb8a66d335d77', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('fd5f05cb95bd438781d6c5e3b542a2b3', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `record_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '记录id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍id',
  `browsing_time` timestamp(0) NOT NULL COMMENT '浏览时间',
  `book_img` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍封面',
  `book_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍名称',
  `book_page` int(11) NULL DEFAULT NULL COMMENT '电子书行数',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('0413258086b6439fa5ef5dcefbb4910e', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-17 21:12:19', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('091733fa11924e048b785ce73fc71dd4', '1', 'd58a37c26ed2456c9f566768afc1d4ae', '2020-03-18 22:28:51', '20200310195324162QQ截图20200310190952.jpg', '1111', NULL, '4141', NULL, NULL);
INSERT INTO `record` VALUES ('0981ee35aa4446b7a2a220b441b3d9d0', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-15 15:13:40', '20200310201535486桌面.jpg', 'hello', NULL, 'hello', NULL, NULL);
INSERT INTO `record` VALUES ('198c825ebffe4b4191a52d51b81c2df9', '1', '613b4c3c7a39414d803bdd190bfc3ff2', '2020-03-23 20:52:33', '20200310201731506QQ截图20200310190128.jpg', '4141', NULL, '141', NULL, NULL);
INSERT INTO `record` VALUES ('1a666670bda54596b9c7cf56e69542f3', '1', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2020-03-23 20:52:39', '20200310194958133桌面.jpg', '111', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('221403f27f1442a9ab7dbe5d3d176637', '1', '3c40be903534470aa102788712cfe99e', '2020-03-23 20:52:53', '20200309202406690QQ截图20200226194757.jpg', '14141', NULL, '1414', NULL, NULL);
INSERT INTO `record` VALUES ('2ad4e22324ba4707b991f8415491f19e', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-29 16:09:14', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('2b90429ef36346ef8d098de4d9df341b', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:20:11', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('30ef4f25623549cbbd12d637300abf4e', '1', 'd80b2ce8a65d438e942b60e0352dda84', '2020-03-18 22:29:01', '20200310201826603QQ截图20200226194757.jpg', '122', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('3381695d4cc4437bb91a5122ba91a904', '1', '6372631134b64a25941c2f80958b980b', '2020-03-15 15:06:37', '20200310201915779403.png', '真龙真龙', NULL, '真龙真龙真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('33b5b260a6034405b17a2e5d1a678914', '1', 'd80b2ce8a65d438e942b60e0352dda84', '2020-03-23 20:52:24', '20200310201826603QQ截图20200226194757.jpg', '122', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('362cff87e4934444a87f0257b380e903', '1', '3c40be903534470aa102788712cfe99e', '2020-03-29 18:12:59', '20200309202406690QQ截图20200226194757.jpg', '14141', NULL, '1414', NULL, NULL);
INSERT INTO `record` VALUES ('38a84e6fcb304ab6ab85d08e946f3e04', '1', '543adcda63bd4938a57cc86e072ec380', '2020-03-23 21:33:15', '20200310193819136QQ截图20200226194757.jpg', '真龙真龙', NULL, '真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('395f6e2f923e45d585268e803bb434db', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-25 20:37:36', '20200310201535486桌面.jpg', 'hello', NULL, 'hello', NULL, NULL);
INSERT INTO `record` VALUES ('3db3712c14694610bb852e53b336a0e3', '1', 'fd05624d73214dedaabe3dc0f00cd1f8', '2020-03-18 22:28:32', '20200310194739112桌面.jpg', '124', NULL, '11111', NULL, NULL);
INSERT INTO `record` VALUES ('40d6dfd32908408d9266df8dfbffb5ef', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-16 23:00:43', '20200310201535486桌面.jpg', 'hello', NULL, 'hello', NULL, NULL);
INSERT INTO `record` VALUES ('412aa0bdc12046e0ad4e6f1960b4a5b6', '1', '613b4c3c7a39414d803bdd190bfc3ff2', '2020-03-25 20:46:17', '20200310201731506QQ截图20200310190128.jpg', '4141', NULL, '141', NULL, NULL);
INSERT INTO `record` VALUES ('42d10395ee5d48298a0d554ea620eef1', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-29 16:08:59', '20200310201535486桌面.jpg', 'hello', NULL, 'hello', NULL, NULL);
INSERT INTO `record` VALUES ('4374c69bf1e8472ea77689a0e063ae7f', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-16 23:26:39', '20200310190101380111.jpg', '141', NULL, '1421', NULL, NULL);
INSERT INTO `record` VALUES ('4e359045bb5a4af6be4268945c62ddaa', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:15:49', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('50560e44fd6a404184bb122e2876452d', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-28 18:19:19', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('542f40bfb9e7475b9306ba57c1a05aa2', '1', '6372631134b64a25941c2f80958b980b', '2020-03-29 15:52:33', '20200310201915779403.png', '真龙真龙', NULL, '真龙真龙真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('54da97b405b4426690725d18d1455389', '1', '6372631134b64a25941c2f80958b980b', '2020-03-17 20:32:32', '20200310201915779403.png', '真龙真龙', NULL, '真龙真龙真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('5835746e4ed2481a802014f33cdc2184', '1', 'b57a9128631743239a41817936f5d7bb', '2020-03-29 16:09:06', '20200310201513046QQ截图20200226194757.jpg', '1441', NULL, '41', NULL, NULL);
INSERT INTO `record` VALUES ('59107fe689de4a3ca7cf02a684d4abd5', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-28 13:22:22', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('5e9b57f7b2d24cc085cab408f0ca6006', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-24 18:32:50', '20200310190101380111.jpg', '141', NULL, '1421', NULL, NULL);
INSERT INTO `record` VALUES ('6658a267bcda4b268eb992f231cb6244', '1', '10fb3f', '2020-03-29 15:59:59', '20200329143644797111.jpg', '海贼之我是大', 1, '不知道', NULL, NULL);
INSERT INTO `record` VALUES ('6fabe6183d80466eb95c8429be76fca6', '1', 'd80b2ce8a65d438e942b60e0352dda84', '2020-03-25 20:37:29', '20200310201826603QQ截图20200226194757.jpg', '122', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('6fdf2234b6b44f0cba858ab94275f9ee', '1', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2020-03-18 22:28:42', '20200310194958133桌面.jpg', '111', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('723e73cc26af44139f3da1241cc9b4c1', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-25 21:00:22', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('727f8c0641b148d2a1a78efc67ba0d4b', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:22:35', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('7721e0f443e741cdb6df17742f486555', '1', '10fb3f', '2020-03-16 23:00:37', '20200310184728170QQ截图20200226194757.jpg', '海贼之我是大', NULL, '不知道', NULL, NULL);
INSERT INTO `record` VALUES ('8e3fa7ac0526451ba3cc9b3d9e67f987', '1', 'dd445e68a24f40459266aedb395e5817', '2020-03-25 20:46:21', '20200310201353073QQ截图20200226194757.jpg', '122', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('9a6b4cc0321a4004a10b8658544555dd', '1', 'fd05624d73214dedaabe3dc0f00cd1f8', '2020-03-23 20:52:28', '20200310194739112桌面.jpg', '124', NULL, '11111', NULL, NULL);
INSERT INTO `record` VALUES ('aa3a133ada4240268f865165e2ff4a39', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-15 15:13:18', '20200310190101380111.jpg', '141', NULL, NULL, NULL, NULL);
INSERT INTO `record` VALUES ('ae8a09d3e859476983336b1bf4f98205', '1', 'd58a37c26ed2456c9f566768afc1d4ae', '2020-03-29 16:09:08', '20200310195324162QQ截图20200310190952.jpg', '1111', NULL, '4141', NULL, NULL);
INSERT INTO `record` VALUES ('af63b1dc75da4195a0050ca8a953f927', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:20:52', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('b0dc1603f57a46f3be2ca83d39a71db9', '4d6d14e1b9e149aa89567a70ad723778', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-16 19:34:52', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('bc3f6cbc6b594187916af7b63e310cbd', '1', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2020-03-25 20:37:08', '20200310194958133桌面.jpg', '111', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('bd21110f218f443c864ca822f7f39ca7', '1', 'dd445e68a24f40459266aedb395e5817', '2020-03-16 23:01:23', '20200310201353073QQ截图20200226194757.jpg', '122', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('c0ca01e2583344da8e95fc5a176096a0', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-29 13:48:14', '20200310190101380111.jpg', '141', NULL, '1421', NULL, NULL);
INSERT INTO `record` VALUES ('c37e29a07344481bbb02695cfccd3bd3', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:40:25', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('c68967f528e24aa6adcf1e78df0a69c0', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:20:46', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('c9453a347c0249e3b93db6e80841089a', '1', '3c40be903534470aa102788712cfe99e', '2020-03-16 23:00:48', '20200309202406690QQ截图20200226194757.jpg', '14141', NULL, '1414', NULL, NULL);
INSERT INTO `record` VALUES ('d8561771643b4d68ba7ba18746c9798b', '1', 'f65f5a4768694472b70715fd73bca2f5', '2020-03-16 23:01:18', '20200310194929794桌面.jpg', '111', NULL, '111', NULL, NULL);
INSERT INTO `record` VALUES ('d962c3d7b66348efb95e6c28dec8993c', '1', '543adcda63bd4938a57cc86e072ec380', '2020-03-25 20:37:20', '20200310193819136QQ截图20200226194757.jpg', '真龙真龙', NULL, '真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('de5a361695664ccd996d07c2b628373f', '1', 'fd05624d73214dedaabe3dc0f00cd1f8', '2020-03-16 23:28:02', '20200310194739112桌面.jpg', '124', NULL, '11111', NULL, NULL);
INSERT INTO `record` VALUES ('e7cc9afae79e45d29d4d088c30ca692d', '1', 'f65f5a4768694472b70715fd73bca2f5', '2020-03-29 16:09:12', '20200310194929794桌面.jpg', '111', NULL, '111', NULL, NULL);
INSERT INTO `record` VALUES ('eee9c4d9dc274a4ea20d170e9748268d', '1', '613b4c3c7a39414d803bdd190bfc3ff2', '2020-03-16 23:00:57', '20200310201731506QQ截图20200310190128.jpg', '4141', NULL, '141', NULL, NULL);
INSERT INTO `record` VALUES ('f06e6ada2677436a8f0a05a358cddb5f', '1', '543adcda63bd4938a57cc86e072ec380', '2020-03-16 23:00:53', '20200310193819136QQ截图20200226194757.jpg', '真龙真龙', NULL, '真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('f0f9415f94be4d188f57d2ecf0cc9f9c', '1', 'b57a9128631743239a41817936f5d7bb', '2020-03-16 23:01:10', '20200310201513046QQ截图20200226194757.jpg', '1441', NULL, '41', NULL, NULL);
INSERT INTO `record` VALUES ('f1543883681b4dd3a2770686692fbc07', '4d6d14e1b9e149aa89567a70ad723778', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-25 19:53:47', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('f57ee5bc90374ae099be99ec87045fbe', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-18 22:28:28', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('fb5c96f90ab242b1bfaa6c7f63196106', '1', 'f65f5a4768694472b70715fd73bca2f5', '2020-03-25 20:57:28', '20200310194929794桌面.jpg', '111', NULL, '111', NULL, NULL);

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics`  (
  `id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hidden` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, NULL, '', 1, 0, '小说啊', NULL, NULL, '2020-02-29 05:19:16');
INSERT INTO `type` VALUES (2, NULL, '', 1, 0, '文学', NULL, NULL, '2020-02-29 05:23:40');
INSERT INTO `type` VALUES (3, 1, NULL, 2, NULL, '中国小说', NULL, NULL, '2020-03-01 06:24:26');
INSERT INTO `type` VALUES (4, 3, NULL, 3, NULL, '武侠', NULL, NULL, '2020-02-29 11:17:31');
INSERT INTO `type` VALUES (5, 3, NULL, 3, NULL, '科幻', NULL, NULL, '2020-02-29 11:17:43');
INSERT INTO `type` VALUES (6, 3, NULL, 3, NULL, '军事', NULL, NULL, '2020-02-29 11:17:49');
INSERT INTO `type` VALUES (7, 3, NULL, 3, NULL, '情感', NULL, NULL, '2020-02-29 11:17:56');
INSERT INTO `type` VALUES (8, 3, NULL, 3, NULL, '古典', NULL, NULL, '2020-02-29 11:18:04');
INSERT INTO `type` VALUES (9, 1, NULL, 2, NULL, '外国小说', NULL, NULL, '2020-02-29 22:12:07');
INSERT INTO `type` VALUES (10, 2, NULL, 2, NULL, '传记', NULL, NULL, '2020-02-29 11:18:32');
INSERT INTO `type` VALUES (11, 2, NULL, 2, NULL, '影视文学', NULL, NULL, '2020-02-29 11:18:46');
INSERT INTO `type` VALUES (12, 2, NULL, 2, NULL, '戏曲文学', NULL, NULL, '2020-02-29 11:18:55');
INSERT INTO `type` VALUES (13, 2, NULL, 2, NULL, '散文', NULL, NULL, '2020-02-29 11:19:03');
INSERT INTO `type` VALUES (15, 10, NULL, 3, NULL, '政治人物', NULL, NULL, '2020-02-29 11:19:32');
INSERT INTO `type` VALUES (16, 10, NULL, 3, NULL, '文学家', NULL, NULL, '2020-02-29 11:19:39');
INSERT INTO `type` VALUES (17, 10, NULL, 3, NULL, '科学家', NULL, NULL, '2020-02-29 11:19:45');
INSERT INTO `type` VALUES (18, 10, NULL, 3, NULL, '哲学家', NULL, NULL, '2020-02-29 11:19:52');
INSERT INTO `type` VALUES (21, 9, NULL, 3, NULL, '恐怖小说', NULL, NULL, '2020-02-29 11:47:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `class_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级编号',
  `stu_No` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `IDcard` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `tel` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户地址',
  `credit` int(11) NULL DEFAULT NULL COMMENT '信用分',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户状态',
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色',
  `register_time` timestamp(0) NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `remark2` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `remark3` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '[\"2020\",\"03\",\"0303\",\"01\"]', '1', 'admin', '3a14a4a110d859f1481b142a1a5b4e39', '0', '123456789123456789', '12345678912', '1142170725@qq.com', '[\"120000\",\"120100\",\"120102\"]', 60, '1', '3', '2020-03-07 19:23:04', '2020-03-29 21:29:59', '2020-03-07 19:23:04', '2020-03-07 19:23:04', '20200329154134088桌面.jpg', NULL, NULL);
INSERT INTO `user` VALUES ('3d982ffe5bae492b941d4f4649a873b5', 'asfsa', '3d982ffe5bae492b941d4f4649a873b5', 'fsafsa', '98548b70813d802a967c5fb3d3780cea', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:35', NULL, '2020-03-15 22:08:35', '2020-03-15 22:08:35', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('4d6d14e1b9e149aa89567a70ad723778', 'clt', '4d6d14e1b9e149aa89567a70ad723778', 'clt', 'b7d0ff96f3810b7b48cf0b5aad033605', '1', NULL, NULL, NULL, NULL, 80, '1', '2', '2020-03-07 20:08:02', '2020-03-27 20:12:00', '2020-03-07 20:08:02', '2020-03-07 20:08:02', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('5184c589a08245268de9b871d26dfd3c', 'asfsa', '5184c589a08245268de9b871d26dfd3c', 'aaaaa', 'b7da50fb58fad358f6c721b9c95b396d', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:39', NULL, '2020-03-15 22:08:39', '2020-03-15 22:08:39', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('5948ecef174e40d3af8be7c5c24cc361', NULL, '5948ecef174e40d3af8be7c5c24cc361', NULL, '5f7b02e30a73741fb1b9587f8efde83b', '1', NULL, NULL, NULL, NULL, 60, '1', '0', '2020-03-08 19:57:30', NULL, '2020-03-08 19:57:30', '2020-03-08 19:57:30', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('7067fc3b84804c699f196e383700c393', 'asfsa', '7067fc3b84804c699f196e383700c393', 'ccccc', '73061789d8d71f99bc993fe98d4392db', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:43', NULL, '2020-03-15 22:08:43', '2020-03-15 22:08:43', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('79c691410e6e49f793a31842ded42953', 'ddddd', '79c691410e6e49f793a31842ded42953', 'ddddd', '343fb8a5be15e62e8f02eec406659c04', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:56', NULL, '2020-03-15 22:08:56', '2020-03-15 22:08:56', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('9cb70c525d044739985aa1eeeb2e3e52', NULL, '9cb70c525d044739985aa1eeeb2e3e52', NULL, '5f7b02e30a73741fb1b9587f8efde83b', '1', NULL, NULL, NULL, NULL, 60, '1', '0', '2020-03-08 19:56:06', NULL, '2020-03-08 19:56:06', '2020-03-08 19:56:06', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('9df68aafa8c14a369b5043b5c80f3e42', 'asfsa', '9df68aafa8c14a369b5043b5c80f3e42', 'bbbbb', 'b5be7c3351192fb51d80d84f397db91d', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:41', NULL, '2020-03-15 22:08:41', '2020-03-15 22:08:41', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('afa6567870834a70bca5690db70b5cc8', '123456', 'afa6567870834a70bca5690db70b5cc8', '123456', 'f0ddf8a31c8aaa599125c4204e17a6c2', '1', NULL, NULL, NULL, NULL, 80, '1', '2', '2020-03-07 20:08:14', '2020-03-08 10:15:46', '2020-03-07 20:08:14', '2020-03-07 20:08:14', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('b20109964ed0456688218a6e3ad3d4de', 'asfsa', 'b20109964ed0456688218a6e3ad3d4de', 'eeeee', '4fec09c0d052b3a9e3060333ccd50129', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:47', NULL, '2020-03-15 22:08:47', '2020-03-15 22:08:47', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('d5c807fc853347648c4eb8a66d335d77', '[\"2020\",\"03\",\"0303\",\"01\"]', 'd5c807fc853347648c4eb8a66d335d77', '我擦了', '51979f628067daac381d1838ca768563', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-29 21:24:53', NULL, '2020-03-29 21:24:53', '2020-03-29 21:24:53', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('fd5f05cb95bd438781d6c5e3b542a2b3', 'asfsa', 'fd5f05cb95bd438781d6c5e3b542a2b3', 'ddddd', '343fb8a5be15e62e8f02eec406659c04', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:45', NULL, '2020-03-15 22:08:45', '2020-03-15 22:08:45', 'userDefaultAvatar.png', NULL, NULL);

-- ----------------------------
-- Table structure for user_class
-- ----------------------------
DROP TABLE IF EXISTS `user_class`;
CREATE TABLE `user_class`  (
  `class_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `grade` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `depart` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `major` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `remark1` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection`  (
  `collection_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍id',
  `collection_time` timestamp(0) NULL DEFAULT NULL COMMENT '收藏时间',
  `book_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍名称',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍描述',
  `book_img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍图片',
  `is_like` int(11) NULL DEFAULT NULL COMMENT '赞标志',
  `is_collect` int(11) NULL DEFAULT NULL COMMENT '收藏标志',
  `group_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分组名',
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES ('0ccbbd7cebdc44ee8037a89c219e368e', '1', 'b57a9128631743239a41817936f5d7bb', '2020-03-16 23:01:13', '1441', '41', '20200310201513046QQ截图20200226194757.jpg', 0, 1, 'aaa', NULL, NULL);
INSERT INTO `user_collection` VALUES ('0e881d03f43341e1ad2d95719b74da74', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-16 23:00:46', 'hello', 'hello', '20200310201535486桌面.jpg', 1, 1, 'eeee', NULL, NULL);
INSERT INTO `user_collection` VALUES ('2de544d30cac45109146b308f12080fa', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-16 23:00:35', '141', '1421', '20200310190101380111.jpg', 0, 0, '444', NULL, NULL);
INSERT INTO `user_collection` VALUES ('46ff42dc5c924db3a25b2f503dd532a8', '1', '543adcda63bd4938a57cc86e072ec380', '2020-03-25 20:25:54', '真龙真龙', '真龙真龙', '20200310193819136QQ截图20200226194757.jpg', 1, 1, '11111111', NULL, NULL);
INSERT INTO `user_collection` VALUES ('49b2e6675ecb4661a49919ff3dc1afda', '1', 'fd05624d73214dedaabe3dc0f00cd1f8', '2020-03-18 22:28:37', '124', '11111', '20200310194739112桌面.jpg', 0, 1, 'haha', NULL, NULL);
INSERT INTO `user_collection` VALUES ('54973b62f7264f09add51410fc2d3659', '1', '3c40be903534470aa102788712cfe99e', '2020-03-23 20:52:56', '14141', '1414', '20200309202406690QQ截图20200226194757.jpg', 0, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('5a5263822f3c41688816b1945ae97745', '1', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2020-03-23 20:52:45', '111', '1', '20200310194958133桌面.jpg', 0, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('8868ce2f163649af9ec2bb31fd7915cb', '1', '613b4c3c7a39414d803bdd190bfc3ff2', '2020-03-16 23:01:00', '4141', '141', '20200310201731506QQ截图20200310190128.jpg', 0, 1, 'eeee', NULL, NULL);
INSERT INTO `user_collection` VALUES ('909548ab20ce461d844fd2e5db960f21', '1', 'dd445e68a24f40459266aedb395e5817', '2020-03-16 23:01:28', '122', '1', '20200310201353073QQ截图20200226194757.jpg', 0, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('911cebaa29d045839e454a062100e341', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-16 22:40:39', 'windows', 'windows', '20200310201102722QQ截图20200310190128.jpg', 1, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('9d89408a78cd4a8b98dccbd3f0451227', '1', '10fb3f', '2020-03-29 16:00:12', '海贼之我是大', '不知道', '20200310184728170QQ截图20200226194757.jpg', 0, 1, 'eeee', NULL, NULL);
INSERT INTO `user_collection` VALUES ('a3e8e464764c4c599eff91869b17fc8c', '1', 'd58a37c26ed2456c9f566768afc1d4ae', '2020-03-23 21:31:36', '1111', '4141', '20200310195324162QQ截图20200310190952.jpg', 0, 1, '11111111', NULL, NULL);
INSERT INTO `user_collection` VALUES ('aade9bba40634955b34d0dc363097c06', '1', 'f65f5a4768694472b70715fd73bca2f5', '2020-03-16 23:01:20', '111', '111', '20200310194929794桌面.jpg', 0, 1, 'haha', NULL, NULL);
INSERT INTO `user_collection` VALUES ('c7f84ff0518d4f7bb61fbe89429e241b', '1', 'd80b2ce8a65d438e942b60e0352dda84', '2020-03-18 22:29:05', '122', '1', '20200310201826603QQ截图20200226194757.jpg', 0, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('c94396075ba2484ab66d77219af33eef', '4d6d14e1b9e149aa89567a70ad723778', 'bf5d445abd77406fa433c72c683b10f2', NULL, 'windows', 'windows', '20200310201102722QQ截图20200310190128.jpg', 0, 0, NULL, NULL, NULL);
INSERT INTO `user_collection` VALUES ('dc76f7b174f24842ba1a33bb4f1a0e13', '1', '6372631134b64a25941c2f80958b980b', '2020-03-16 23:01:07', '真龙真龙', '真龙真龙真龙真龙', '20200310201915779403.png', 0, 1, 'haha', NULL, NULL);
INSERT INTO `user_collection` VALUES ('f80958640af34403a97bf73e40a9299d', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', NULL, '狼图腾', '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', '20200314203719290QQ截图20200310190128.jpg', 0, 0, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
