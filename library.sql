/*
 Navicat Premium Data Transfer

 Source Server         : 39.97.239.108
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 39.97.239.108:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 16/03/2020 23:37:19
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
  `ebook` int(0) NULL DEFAULT NULL COMMENT '是否是电子书',
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍位置',
  `zan_number` int(0) NULL DEFAULT NULL COMMENT '点赞数量',
  `score` decimal(2, 1) NULL DEFAULT NULL COMMENT '得分',
  `input_time` timestamp(0) NULL DEFAULT NULL COMMENT '录入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('10d88d1b5409433db00d871370ce7fd6', '1', '141', '1421', '14421', '12412', 11.00, '1', '20200310190101380111.jpg', 0, '', 0, NULL, '2020-02-28 16:00:00', '2020-03-10 11:01:03');
INSERT INTO `book` VALUES ('10fb3f', '4', '海贼之我是大', '不知道', '不知道', '不知', 1.00, '0', '20200310184728170QQ截图20200226194757.jpg', 1, '636a4346df514f8998a7ff160fd52299.txt', 0, NULL, '2020-03-01 17:33:19', '2020-03-10 10:47:29');
INSERT INTO `book` VALUES ('26fd2b762c9646f49e1cf6f40566b7d8', '21', 'hello', 'hello', 'hello', 'hello', 11.00, '0', '20200310201535486桌面.jpg', 0, '', 0, NULL, '2020-02-28 16:00:00', '2020-03-10 12:15:37');
INSERT INTO `book` VALUES ('3c40be903534470aa102788712cfe99e', '2', '14141', '1414', '4141', '4141', 11.00, '1', '20200309202406690QQ截图20200226194757.jpg', 0, '', 0, NULL, '2020-03-05 16:00:00', '2020-03-09 12:24:08');
INSERT INTO `book` VALUES ('543adcda63bd4938a57cc86e072ec380', '1', '真龙真龙', '真龙真龙', '真龙真龙', '真龙真龙', 0.00, '0', '20200310193819136QQ截图20200226194757.jpg', 1, '20200309203156844魔道祖师.txt', 0, NULL, '2020-03-09 12:31:59', '2020-03-10 11:38:23');
INSERT INTO `book` VALUES ('613b4c3c7a39414d803bdd190bfc3ff2', '3', '4141', '141', '4114', '4141', 1.00, '0', '20200310201731506QQ截图20200310190128.jpg', 1, 'e4257f7f88454a7ea70055ee46b2e503.txt', 0, NULL, '2020-02-14 17:33:26', '2020-03-10 12:17:38');
INSERT INTO `book` VALUES ('6372631134b64a25941c2f80958b980b', '4', '真龙真龙', '真龙真龙真龙真龙', '真龙真龙', '真龙真龙', 0.00, '0', '20200310201915779403.png', 1, '251b8031be384d2487e22ac389e090c3.txt', 0, NULL, '2020-03-05 13:30:56', '2020-03-10 12:19:17');
INSERT INTO `book` VALUES ('a135df0ea5014c90bba0e4c6a7c82cab', '4', '狼图腾', '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', '姜绒1', '北京十月文艺出版社', 44.90, '0', '20200314203719290QQ截图20200310190128.jpg', 0, '111414', 0, NULL, '2020-03-19 16:00:00', '2020-03-14 12:37:21');
INSERT INTO `book` VALUES ('b57a9128631743239a41817936f5d7bb', '1', '1441', '41', '144141', '4141', 111.00, '1', '20200310201513046QQ截图20200226194757.jpg', 0, '1141', 0, NULL, '2020-03-20 16:00:00', '2020-03-10 12:15:14');
INSERT INTO `book` VALUES ('bf5d445abd77406fa433c72c683b10f2', '4', 'windows', 'windows', 'windows', 'windows', 1.00, '0', '20200310201102722QQ截图20200310190128.jpg', 1, 'a19253bc5ceb4fb5accfa233c6b6ec1a.txt', 2, 3.8, '2020-02-09 17:33:37', '2020-03-10 12:11:10');
INSERT INTO `book` VALUES ('c8dea18c7b924a9ba3af8ca5270ec64e', '1', '111', '1', '1111', '1111', 1.00, '1', '20200310194958133桌面.jpg', 1, '1', 0, 1.0, '2020-02-05 13:03:12', '2020-03-10 11:50:08');
INSERT INTO `book` VALUES ('d58a37c26ed2456c9f566768afc1d4ae', '9', '1111', '4141', '4141', '1441', 1441.00, '0', '20200310195324162QQ截图20200310190952.jpg', 0, '1441', 0, NULL, '2020-03-19 16:00:00', '2020-03-10 11:53:35');
INSERT INTO `book` VALUES ('d80b2ce8a65d438e942b60e0352dda84', '1', '122', '1', '1222', '1222', 1.00, '2', '20200310201826603QQ截图20200226194757.jpg', 1, '1', 0, 1.0, '2020-02-05 13:03:12', '2020-03-10 12:18:28');
INSERT INTO `book` VALUES ('dd445e68a24f40459266aedb395e5817', '1', '122', '1', '122', '122', 1.00, '0', '20200310201353073QQ截图20200226194757.jpg', 1, '1', 0, 1.0, '2020-02-05 13:03:12', '2020-03-10 12:14:02');
INSERT INTO `book` VALUES ('f65f5a4768694472b70715fd73bca2f5', '12', '111', '111', '111', '111', 11.00, '0', '20200310194929794桌面.jpg', 0, '111', 0, NULL, '2020-02-21 16:00:00', '2020-03-10 11:49:30');
INSERT INTO `book` VALUES ('fd05624d73214dedaabe3dc0f00cd1f8', '1', '124', '11111', '24211', '124', 1.00, '0', '20200310194739112桌面.jpg', 1, 'ca7f3e1e360e46de97b0a7602b4893b8.txt', 0, NULL, '2020-03-13 10:24:12', '2020-03-10 11:48:17');

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
  `duration` int(0) NULL DEFAULT NULL COMMENT '借阅时长',
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
  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`borrowing_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowing
-- ----------------------------
INSERT INTO `borrowing` VALUES ('139c9519ca884ffba2f23225a5bdc193', '10d88d1b5409433db00d871370ce7fd6', '2', '141', '3', 30, '2020-03-04 14:28:30', '2020-03-04 14:29:32', '2020-03-05 14:28:28', NULL, '3', '3', NULL, NULL, '2020-03-04 14:28:30', '2020-03-04 14:29:32', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('1414114', '1414', '141414', 'www', 'ww', 11, '2020-03-14 14:59:32', '2020-03-04 14:24:52', '2020-03-13 14:59:47', '2020-03-04 14:25:20', '6', '3', '3', NULL, NULL, '2020-03-04 14:25:20', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('1ceedf3a35e74e6ea68f423c1f80d0b8', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-09 12:26:49', '2020-03-10 11:24:11', '2020-03-10 12:26:47', NULL, '2', 'admin', NULL, '11222', '2020-03-09 12:26:49', '2020-03-10 11:24:11', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('2', '2', '1', '1', '1', 11, '2020-02-05 13:05:19', '2020-03-07 02:54:35', '2020-02-21 13:05:21', '2020-03-08 03:02:03', '5', 'cl', '3', NULL, NULL, '2020-03-08 03:02:03', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('24', '24', '24', '24', '24', 11, '2020-02-05 20:59:37', NULL, '2020-02-23 20:59:39', '2020-02-26 20:59:43', '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('38829ec66b81450584c138808455574c', '044cf67fbcce4a9fa1feef2098103cbc', '2', '111', '3', 30, '2020-03-04 13:08:01', '2020-03-04 13:30:45', '2020-03-05 13:07:22', '2020-03-04 14:15:11', '6', '3', '3', NULL, '2020-03-04 13:08:01', '2020-03-04 14:15:11', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('502eadc37faf4e549785eb2e58f9c409', 'b57a9128631743239a41817936f5d7bb', '2', '1441', '3', 30, '2020-03-04 14:00:49', '2020-03-04 14:23:54', '2020-03-05 14:00:44', NULL, '3', '3', NULL, NULL, '2020-03-04 14:00:49', '2020-03-04 14:23:54', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('5c203ea2752542198bd78f7e2ca28b55', '3c40be903534470aa102788712cfe99e', '2', '14141', '3', 30, '2020-03-04 13:46:25', '2020-03-04 13:55:40', '2020-03-05 13:46:19', '2020-03-04 14:16:51', '6', '3', '3', '信誉不够', '2020-03-04 13:46:25', '2020-03-04 14:16:51', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('7411fd8d643d422ab78b29073b824e05', 'bf5d445abd77406fa433c72c683b10f2', '2', 'windows', '3', 30, '2020-03-04 15:05:20', '2020-03-08 03:21:30', '2020-03-05 15:05:14', NULL, '2', '3', NULL, '我日', '2020-03-04 15:05:20', '2020-03-08 03:21:30', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('8a164a148ca84414ab846a37cd288a4a', '089238da2d864fb6a35b73aeec1b478a', '2', '5421', '3', 30, '2020-03-04 14:22:29', '2020-03-04 14:22:51', '2020-03-05 14:22:27', '2020-03-04 14:31:25', '6', '3', '3', NULL, '2020-03-04 14:22:29', '2020-03-04 14:31:25', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a2d409e4aebd46fda301ff4e67e37fd5', 'a135df0ea5014c90bba0e4c6a7c82cab', '2', '损坏损坏', '3', 30, '2020-03-04 13:57:06', '2020-03-04 13:58:06', '2020-03-05 13:57:03', NULL, '2', '3', NULL, '信誉不够', '2020-03-04 13:57:06', '2020-03-04 13:58:06', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a591b5369a4e45e0a2160d0c9eefbc3a', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2', '1', '3', 7, '2020-03-04 14:44:05', '2020-03-04 14:44:16', '2019-03-06 00:00:00', '2020-03-04 14:56:31', '5', '3', '3', NULL, '2020-03-04 14:44:05', '2020-03-04 14:56:31', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('b2ffe3b78ad444ff9fb4da5bd81b7f48', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-08 05:21:07', '2020-03-08 05:21:20', '2020-03-09 05:21:04', NULL, '2', 'admin', NULL, '信誉不够', '2020-03-08 05:21:07', '2020-03-08 05:21:20', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('d96fa9e9d05e40da99af8f80a6718cb5', 'b57a9128631743239a41817936f5d7bb', '2', '1441', '3', 30, '2020-03-04 13:5