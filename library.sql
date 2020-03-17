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

 Date: 17/03/2020 21:42:27
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
INSERT INTO `book` VALUES ('10d88d1b5409433db00d871370ce7fd6', '1', '141', '1421', '14421', '12412', 11.00, '1', '20200310190101380111.jpg', 0, '', 0, NULL, '2020-02-29 00:00:00', '2020-03-10 19:01:03');
INSERT INTO `book` VALUES ('10fb3f', '4', '海贼之我是大', '不知道', '不知道', '不知', 1.00, '0', '20200310184728170QQ截图20200226194757.jpg', 1, '636a4346df514f8998a7ff160fd52299.txt', 0, NULL, '2020-03-02 01:33:19', '2020-03-10 18:47:29');
INSERT INTO `book` VALUES ('26fd2b762c9646f49e1cf6f40566b7d8', '21', 'hello', 'hello', 'hello', 'hello', 11.00, '0', '20200310201535486桌面.jpg', 0, '', 0, NULL, '2020-02-29 00:00:00', '2020-03-10 20:15:37');
INSERT INTO `book` VALUES ('3c40be903534470aa102788712cfe99e', '2', '14141', '1414', '4141', '4141', 11.00, '1', '20200309202406690QQ截图20200226194757.jpg', 0, '', 0, NULL, '2020-03-06 00:00:00', '2020-03-09 20:24:08');
INSERT INTO `book` VALUES ('543adcda63bd4938a57cc86e072ec380', '1', '真龙真龙', '真龙真龙', '真龙真龙', '真龙真龙', 0.00, '0', '20200310193819136QQ截图20200226194757.jpg', 1, '20200309203156844魔道祖师.txt', 0, NULL, '2020-03-09 20:31:59', '2020-03-10 19:38:23');
INSERT INTO `book` VALUES ('613b4c3c7a39414d803bdd190bfc3ff2', '3', '4141', '141', '4114', '4141', 1.00, '0', '20200310201731506QQ截图20200310190128.jpg', 1, 'e4257f7f88454a7ea70055ee46b2e503.txt', 0, NULL, '2020-02-15 01:33:26', '2020-03-10 20:17:38');
INSERT INTO `book` VALUES ('6372631134b64a25941c2f80958b980b', '4', '真龙真龙', '真龙真龙真龙真龙', '真龙真龙', '真龙真龙', 0.00, '0', '20200310201915779403.png', 1, '251b8031be384d2487e22ac389e090c3.txt', 0, NULL, '2020-03-05 21:30:56', '2020-03-10 20:19:17');
INSERT INTO `book` VALUES ('a135df0ea5014c90bba0e4c6a7c82cab', '4', '狼图腾', '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', '姜绒1', '北京十月文艺出版社', 44.90, '0', '20200314203719290QQ截图20200310190128.jpg', 0, '111414', 0, NULL, '2020-03-20 00:00:00', '2020-03-14 20:37:21');
INSERT INTO `book` VALUES ('b57a9128631743239a41817936f5d7bb', '1', '1441', '41', '144141', '4141', 111.00, '1', '20200310201513046QQ截图20200226194757.jpg', 0, '1141', 0, NULL, '2020-03-21 00:00:00', '2020-03-10 20:15:14');
INSERT INTO `book` VALUES ('bf5d445abd77406fa433c72c683b10f2', '4', 'windows', 'windows', 'windows', 'windows', 1.00, '0', '20200310201102722QQ截图20200310190128.jpg', 1, 'a19253bc5ceb4fb5accfa233c6b6ec1a.txt', 2, 3.8, '2020-02-10 01:33:37', '2020-03-10 20:11:10');
INSERT INTO `book` VALUES ('c8dea18c7b924a9ba3af8ca5270ec64e', '1', '111', '1', '1111', '1111', 1.00, '1', '20200310194958133桌面.jpg', 1, '1', 0, 1.0, '2020-02-05 21:03:12', '2020-03-10 19:50:08');
INSERT INTO `book` VALUES ('d58a37c26ed2456c9f566768afc1d4ae', '9', '1111', '4141', '4141', '1441', 1441.00, '0', '20200310195324162QQ截图20200310190952.jpg', 0, '1441', 0, NULL, '2020-03-20 00:00:00', '2020-03-10 19:53:35');
INSERT INTO `book` VALUES ('d80b2ce8a65d438e942b60e0352dda84', '1', '122', '1', '1222', '1222', 1.00, '2', '20200310201826603QQ截图20200226194757.jpg', 1, '1', 0, 1.0, '2020-02-05 21:03:12', '2020-03-10 20:18:28');
INSERT INTO `book` VALUES ('dd445e68a24f40459266aedb395e5817', '1', '122', '1', '122', '122', 1.00, '0', '20200310201353073QQ截图20200226194757.jpg', 1, '1', 0, 1.0, '2020-02-05 21:03:12', '2020-03-10 20:14:02');
INSERT INTO `book` VALUES ('f65f5a4768694472b70715fd73bca2f5', '12', '111', '111', '111', '111', 11.00, '0', '20200310194929794桌面.jpg', 0, '111', 0, NULL, '2020-02-22 00:00:00', '2020-03-10 19:49:30');
INSERT INTO `book` VALUES ('fd05624d73214dedaabe3dc0f00cd1f8', '1', '124', '11111', '24211', '124', 1.00, '0', '20200310194739112桌面.jpg', 1, 'ca7f3e1e360e46de97b0a7602b4893b8.txt', 0, NULL, '2020-03-13 18:24:12', '2020-03-10 19:48:17');

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
INSERT INTO `borrowing` VALUES ('139c9519ca884ffba2f23225a5bdc193', '10d88d1b5409433db00d871370ce7fd6', '2', '141', '3', 30, '2020-03-04 22:28:30', '2020-03-04 22:29:32', '2020-03-05 22:28:28', NULL, '3', '3', NULL, NULL, '2020-03-04 22:28:30', '2020-03-04 22:29:32', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('1414114', '1414', '141414', 'www', 'ww', 11, '2020-03-14 22:59:32', '2020-03-04 22:24:52', '2020-03-13 22:59:47', '2020-03-04 22:25:20', '6', '3', '3', NULL, NULL, '2020-03-04 22:25:20', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('1ceedf3a35e74e6ea68f423c1f80d0b8', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-09 20:26:49', '2020-03-10 19:24:11', '2020-03-10 20:26:47', NULL, '2', 'admin', NULL, '11222', '2020-03-09 20:26:49', '2020-03-10 19:24:11', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('2', '2', '1', '1', '1', 11, '2020-02-05 21:05:19', '2020-03-07 10:54:35', '2020-02-21 21:05:21', '2020-03-08 11:02:03', '5', 'cl', '3', NULL, NULL, '2020-03-08 11:02:03', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('24', '24', '24', '24', '24', 11, '2020-02-06 04:59:37', NULL, '2020-02-24 04:59:39', '2020-02-27 04:59:43', '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('38829ec66b81450584c138808455574c', '044cf67fbcce4a9fa1feef2098103cbc', '2', '111', '3', 30, '2020-03-04 21:08:01', '2020-03-04 21:30:45', '2020-03-05 21:07:22', '2020-03-04 22:15:11', '6', '3', '3', NULL, '2020-03-04 21:08:01', '2020-03-04 22:15:11', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('502eadc37faf4e549785eb2e58f9c409', 'b57a9128631743239a41817936f5d7bb', '2', '1441', '3', 30, '2020-03-04 22:00:49', '2020-03-04 22:23:54', '2020-03-05 22:00:44', NULL, '3', '3', NULL, NULL, '2020-03-04 22:00:49', '2020-03-04 22:23:54', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('5c203ea2752542198bd78f7e2ca28b55', '3c40be903534470aa102788712cfe99e', '2', '14141', '3', 30, '2020-03-04 21:46:25', '2020-03-04 21:55:40', '2020-03-05 21:46:19', '2020-03-04 22:16:51', '6', '3', '3', '信誉不够', '2020-03-04 21:46:25', '2020-03-04 22:16:51', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('7411fd8d643d422ab78b29073b824e05', 'bf5d445abd77406fa433c72c683b10f2', '2', 'windows', '3', 30, '2020-03-04 23:05:20', '2020-03-08 11:21:30', '2020-03-05 23:05:14', NULL, '2', '3', NULL, '我日', '2020-03-04 23:05:20', '2020-03-08 11:21:30', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('8a164a148ca84414ab846a37cd288a4a', '089238da2d864fb6a35b73aeec1b478a', '2', '5421', '3', 30, '2020-03-04 22:22:29', '2020-03-04 22:22:51', '2020-03-05 22:22:27', '2020-03-04 22:31:25', '6', '3', '3', NULL, '2020-03-04 22:22:29', '2020-03-04 22:31:25', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a2d409e4aebd46fda301ff4e67e37fd5', 'a135df0ea5014c90bba0e4c6a7c82cab', '2', '损坏损坏', '3', 30, '2020-03-04 21:57:06', '2020-03-04 21:58:06', '2020-03-05 21:57:03', NULL, '2', '3', NULL, '信誉不够', '2020-03-04 21:57:06', '2020-03-04 21:58:06', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('a591b5369a4e45e0a2160d0c9eefbc3a', 'c8dea18c7b924a9ba3af8ca5270ec64e', '2', '1', '3', 7, '2020-03-04 22:44:05', '2020-03-04 22:44:16', '2019-03-06 08:00:00', '2020-03-04 22:56:31', '5', '3', '3', NULL, '2020-03-04 22:44:05', '2020-03-04 22:56:31', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('b2ffe3b78ad444ff9fb4da5bd81b7f48', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-08 13:21:07', '2020-03-08 13:21:20', '2020-03-09 13:21:04', NULL, '2', 'admin', NULL, '信誉不够', '2020-03-08 13:21:07', '2020-03-08 13:21:20', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('d96fa9e9d05e40da99af8f80a6718cb5', 'b57a9128631743239a41817936f5d7bb', '2', '1441', '3', 30, '2020-03-04 21:58:34', '2020-03-04 21:59:40', '2020-03-05 21:58:32', NULL, '2', '3', NULL, '信誉不够', '2020-03-04 21:58:34', '2020-03-04 21:59:43', NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('fa781239f24540f3801e8137d2c75828', '26fd2b762c9646f49e1cf6f40566b7d8', '1', 'hello', 'admin', 30, '2020-03-08 13:12:55', '2020-03-08 13:13:07', '2020-03-09 13:12:52', '2020-03-08 13:16:12', '6', 'admin', 'admin', NULL, '2020-03-08 13:12:55', '2020-03-08 13:16:12', NULL, NULL, NULL);

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
INSERT INTO `collection_group` VALUES ('a232a3ee96184ada9366471b5e88ac29', '1', '默认收藏夹', '2020-03-17 06:33:02', NULL, NULL, NULL, NULL, NULL);

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
  `score` int(0) NULL DEFAULT NULL COMMENT '评分',
  `reply_flag` int(0) NULL DEFAULT NULL,
  `reply_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zan_number` int(0) NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('00af7cd5206041f7aba5463987d37833', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:22:53', '真的强', 3, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('0129681802dc44518889ea6da5f2edc2', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:18:49', '好尴尬过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过好尴尬过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过嘎哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或嘎哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或嘎哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或', 5, NULL, NULL, 2, NULL, NULL);
INSERT INTO `comment` VALUES ('07824d6597514168aa5cf043e80b9c0b', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:07', '11111', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('0ac4b55c9d724b5e8e28bde604209f3a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:53:16', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', 1, NULL, NULL, 2, NULL, NULL);
INSERT INTO `comment` VALUES ('1292d0cdc77c4fb4b4cb27a44072b430', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:50:05', '法萨芬撒分散个搭嘎当时搞公司归属感', 1, NULL, NULL, 2, NULL, NULL);
INSERT INTO `comment` VALUES ('14b9776315994cab9523d15cbfc3ab98', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:50:22', '法萨芬撒分散个搭嘎当时搞公案发时发放司归属感', 1, NULL, NULL, 2, NULL, NULL);
INSERT INTO `comment` VALUES ('2685cf81587849d5a064dfea0df18e1c', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:52:24', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('31ef7b257c0d427bbb869c1bbae81f66', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:25:05', '我艹', 3, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('3d7dd2d1af084c0593171992c21796cb', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:52:04', '1111111111111 ', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('3faa0166674b4ceaa32e8436035e29c7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:22', '呜呜呜呜呜呜呜呜呜呜呜无无无无无无无无无无无无无无无无无无无无无无无无', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('576f0934768f4439947bb27dc87c67e5', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:35', '发撒阿萨法', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('693d949b39714fc6ac8f27191c719fba', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:38', '划分煽风点火', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('6a53eb3899ca4c6d9840560f6efd41da', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:52:43', '呜呜呜呜呜呜呜呜呜呜呜无无无无无无无无', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('873f0b9f57b2401d80f911faf1dda6bb', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:27:35', '给爸爸成啊', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8919d8f90d9d434a831963eb28d25088', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:38', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8c14a4a90c454e3db345c8b7e1058c23', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:23:37', '真的不错', 3, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8c26bca3e5da4957bef5a434f186c5fc', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:20', '1111', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('8e29bfc9a0ad4eeabc529a1de56031de', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:15', '嘻嘻嘻嘻嘻嘻嘻嘻xxxxxxxxxxx', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('939ea9e971eb4d7b82dc58a6e03a7465', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:49:03', '返回搜狐覆盖数分公司hoi9awf很大时额按规定洒', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('962fec3cc41445fd9616234633e4c2c5', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:45', '呜呜呜呜呜呜呜呜呜呜呜无无无无无无无无无无', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('9e657aaca850476a9a69935c4b21d9be', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:42', '划分煽风点火凄凄切切群群群群群群群群', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('a6e478905ac1434daa922b44ded30058', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:46', '111', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('aaf15cb362e64e8790d74b363ca2ebe4', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:05', '2222222', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('b7338fb08d1b4fabbec2950466f8312e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:44', '11111', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('bcc37e982ef54e00a321d2b59fdd2e0a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:24:27', '我艹', 3, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c0f36493ea9e40e8b3dbe7e0e6d84a35', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:35', '还不能女女女女女女女女女女女女女女女女女女女女女过过过过过过过', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c13f25dc68804338baf9ef4fb114477e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:48', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', 4, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('c20a65996e874952b430279d9798d7e6', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:26:59', '给爸爸成啊', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('cbbf77e249504cc498d834de017b224c', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 21:51:31', '我发玩法', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('cc347104056d4dc6994abbbbfba1e2b4', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 17:56:39', '很好很好', 3, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('cfd901919a524d86ad2bd3a2e9eccb7f', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:29', '哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('d4a31f957d554b22b451f31d8224e03a', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-15 19:36:28', '13131', 5, NULL, NULL, 1, NULL, NULL);
INSERT INTO `comment` VALUES ('e2bfdce13d1049069eecf395de2186b7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:26', '凄凄切切群群群群群群群群群群群群群群群群群群群群群群群群群群群群', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('e3c4b73c101a48f8b7b9c52a24e5c65d', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-16 19:09:19', '哒哒哒哒哒哒多多多多多多多多多多多多多多多多多多多多多', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('e5102d1a021d49e1990c16a5aef5326e', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:10', '11111', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('e64c987801044d6bb20da611e07995b7', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:13', '111', 1, NULL, NULL, 0, NULL, NULL);
INSERT INTO `comment` VALUES ('f14a8a30ee4241f394373fa0c33d7a17', 'bf5d445abd77406fa433c72c683b10f2', '1', '2020-03-17 21:13:48', '111', 1, NULL, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for comment_like
-- ----------------------------
DROP TABLE IF EXISTS `comment_like`;
CREATE TABLE `comment_like`  (
  `comment_like_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `comment_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `is_like` int(0) NULL DEFAULT NULL,
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
INSERT INTO `comment_like` VALUES ('25e2706aa723452087777677d445b4e7', 'd4a31f957d554b22b451f31d8224e03a', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('3c2258bc03b74b188376085f91dd53cc', '14b9776315994cab9523d15cbfc3ab98', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('472c4b1a6a0542d684dfaf8d9aff1979', '0129681802dc44518889ea6da5f2edc2', '4d6d14e1b9e149aa89567a70ad723778', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('482526d8bb6f417ea48c1fdbb35413b2', '0ac4b55c9d724b5e8e28bde604209f3a', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('63870a0130184c619619f0a2f430b207', 'cc347104056d4dc6994abbbbfba1e2b4', '1', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('6905477d07d543e29f406486fb56f307', '1292d0cdc77c4fb4b4cb27a44072b430', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('7ef4d0ae1e42466db8fad9b69c9253d4', '14b9776315994cab9523d15cbfc3ab98', '4d6d14e1b9e149aa89567a70ad723778', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('d582669aa4fe4e57b25a1e79a1f4e671', '1292d0cdc77c4fb4b4cb27a44072b430', '4d6d14e1b9e149aa89567a70ad723778', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('ed299a30d80c4ebc8bd85dbcf18800f2', '0129681802dc44518889ea6da5f2edc2', '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `comment_like` VALUES ('fd32c8c6c27340f997673cc1a218e10a', '0ac4b55c9d724b5e8e28bde604209f3a', '4d6d14e1b9e149aa89567a70ad723778', 1, NULL, NULL, NULL, NULL, NULL);

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
  `status` int(0) NULL DEFAULT NULL COMMENT '信息状态  已读、未读',
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
INSERT INTO `message` VALUES ('1fafsafsasafsa', '1', NULL, '2020-03-07 01:09:09', 'sfafs', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('2', '2', NULL, '2020-02-27 21:09:58', '1', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('25r2asdf2saf2', '1', NULL, '2020-03-07 01:10:13', 'af', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('2r2dsf3q34tsv3', '1', NULL, '2020-03-13 01:10:16', 'd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('4144yhu5644', '1', NULL, '2020-03-06 01:10:29', 's', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('735bf7223ede4e498e70c3a93e0ff699', '1', NULL, '2020-03-08 13:21:20', 'admin,您好，你申请借阅的书籍《hello》被驳回，驳回理由：信誉不够', 1, NULL, NULL, NULL, NULL);
INSERT INTO `message` VALUES ('afdwqr2dhg4wt', '1', NULL, '2020-02-29 01:10:10', 'wf', 1, NULL, NULL, NULL, NULL);
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
  `book_r` int(0) NULL DEFAULT NULL COMMENT '书籍信息读权限',
  `book_w` int(0) NULL DEFAULT NULL COMMENT '书籍信息写权限',
  `user_r` int(0) NULL DEFAULT NULL COMMENT '用户信息读权限',
  `user_w` int(0) NULL DEFAULT NULL COMMENT '用户信息写权限',
  `borrowing_r` int(0) NULL DEFAULT NULL COMMENT '借阅信息读权限',
  `borrowing_w` int(0) NULL DEFAULT NULL COMMENT '借阅信息写权限',
  `category_w` int(0) NULL DEFAULT NULL COMMENT '类别信息写权限',
  `statistics_r` int(0) NULL DEFAULT NULL COMMENT '统计信息读权限',
  `privilege` int(0) NULL DEFAULT NULL,
  `admin` int(0) NULL DEFAULT NULL,
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
  `book_page` int(0) NULL DEFAULT NULL COMMENT '电子书行数',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('0413258086b6439fa5ef5dcefbb4910e', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-17 21:12:19', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('0981ee35aa4446b7a2a220b441b3d9d0', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-15 15:13:40', '20200310201535486桌面.jpg', 'hello', NULL, 'hello', NULL, NULL);
INSERT INTO `record` VALUES ('2b90429ef36346ef8d098de4d9df341b', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:20:11', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('3381695d4cc4437bb91a5122ba91a904', '1', '6372631134b64a25941c2f80958b980b', '2020-03-15 15:06:37', '20200310201915779403.png', '真龙真龙', NULL, '真龙真龙真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('40d6dfd32908408d9266df8dfbffb5ef', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-16 23:00:43', '20200310201535486桌面.jpg', 'hello', NULL, 'hello', NULL, NULL);
INSERT INTO `record` VALUES ('4374c69bf1e8472ea77689a0e063ae7f', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-16 23:26:39', '20200310190101380111.jpg', '141', NULL, '1421', NULL, NULL);
INSERT INTO `record` VALUES ('4e359045bb5a4af6be4268945c62ddaa', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:15:49', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('54da97b405b4426690725d18d1455389', '1', '6372631134b64a25941c2f80958b980b', '2020-03-17 20:32:32', '20200310201915779403.png', '真龙真龙', NULL, '真龙真龙真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('727f8c0641b148d2a1a78efc67ba0d4b', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:22:35', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('7721e0f443e741cdb6df17742f486555', '1', '10fb3f', '2020-03-16 23:00:37', '20200310184728170QQ截图20200226194757.jpg', '海贼之我是大', NULL, '不知道', NULL, NULL);
INSERT INTO `record` VALUES ('aa3a133ada4240268f865165e2ff4a39', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-15 15:13:18', '20200310190101380111.jpg', '141', NULL, NULL, NULL, NULL);
INSERT INTO `record` VALUES ('af63b1dc75da4195a0050ca8a953f927', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:20:52', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('b0dc1603f57a46f3be2ca83d39a71db9', '4d6d14e1b9e149aa89567a70ad723778', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-16 19:34:52', '20200310201102722QQ截图20200310190128.jpg', 'windows', NULL, 'windows', NULL, NULL);
INSERT INTO `record` VALUES ('bd21110f218f443c864ca822f7f39ca7', '1', 'dd445e68a24f40459266aedb395e5817', '2020-03-16 23:01:23', '20200310201353073QQ截图20200226194757.jpg', '122', NULL, '1', NULL, NULL);
INSERT INTO `record` VALUES ('c37e29a07344481bbb02695cfccd3bd3', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:40:25', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('c68967f528e24aa6adcf1e78df0a69c0', '1', 'a135df0ea5014c90bba0e4c6a7c82cab', '2020-03-15 14:20:46', '20200314203719290QQ截图20200310190128.jpg', '狼图腾', NULL, '精装版隆重上市，影响深远的史诗级作品，入选新中国70年70部长篇小说，多所学校列入学生必读书单，不仅是一部好读的长篇小说，其信念、勇气与团队精神更是激励着一代又一代人。', NULL, NULL);
INSERT INTO `record` VALUES ('c9453a347c0249e3b93db6e80841089a', '1', '3c40be903534470aa102788712cfe99e', '2020-03-16 23:00:48', '20200309202406690QQ截图20200226194757.jpg', '14141', NULL, '1414', NULL, NULL);
INSERT INTO `record` VALUES ('d8561771643b4d68ba7ba18746c9798b', '1', 'f65f5a4768694472b70715fd73bca2f5', '2020-03-16 23:01:18', '20200310194929794桌面.jpg', '111', NULL, '111', NULL, NULL);
INSERT INTO `record` VALUES ('de5a361695664ccd996d07c2b628373f', '1', 'fd05624d73214dedaabe3dc0f00cd1f8', '2020-03-16 23:28:02', '20200310194739112桌面.jpg', '124', NULL, '11111', NULL, NULL);
INSERT INTO `record` VALUES ('eee9c4d9dc274a4ea20d170e9748268d', '1', '613b4c3c7a39414d803bdd190bfc3ff2', '2020-03-16 23:00:57', '20200310201731506QQ截图20200310190128.jpg', '4141', NULL, '141', NULL, NULL);
INSERT INTO `record` VALUES ('f06e6ada2677436a8f0a05a358cddb5f', '1', '543adcda63bd4938a57cc86e072ec380', '2020-03-16 23:00:53', '20200310193819136QQ截图20200226194757.jpg', '真龙真龙', NULL, '真龙真龙', NULL, NULL);
INSERT INTO `record` VALUES ('f0f9415f94be4d188f57d2ecf0cc9f9c', '1', 'b57a9128631743239a41817936f5d7bb', '2020-03-16 23:01:10', '20200310201513046QQ截图20200226194757.jpg', '1441', NULL, '41', NULL, NULL);

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
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `pid` int(0) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `level` int(0) NULL DEFAULT NULL,
  `sort` int(0) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hidden` int(0) NULL DEFAULT NULL,
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
  `credit` int(0) NULL DEFAULT NULL COMMENT '信用分',
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
INSERT INTO `user` VALUES ('1', '1', '1', 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', '1', '123456789123456789', '12345678912', '1142170725@qq.com', '    ', 60, '0', '3', '2020-03-07 19:23:04', '2020-03-17 21:40:08', '2020-03-07 19:23:04', '2020-03-07 19:23:04', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('3d982ffe5bae492b941d4f4649a873b5', 'asfsa', '3d982ffe5bae492b941d4f4649a873b5', 'fsafsa', '98548b70813d802a967c5fb3d3780cea', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:35', NULL, '2020-03-15 22:08:35', '2020-03-15 22:08:35', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('4d6d14e1b9e149aa89567a70ad723778', 'clt', '4d6d14e1b9e149aa89567a70ad723778', 'clt', 'b7d0ff96f3810b7b48cf0b5aad033605', '1', NULL, NULL, NULL, NULL, 80, '1', '2', '2020-03-07 20:08:02', '2020-03-16 19:34:43', '2020-03-07 20:08:02', '2020-03-07 20:08:02', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('5184c589a08245268de9b871d26dfd3c', 'asfsa', '5184c589a08245268de9b871d26dfd3c', 'aaaaa', 'b7da50fb58fad358f6c721b9c95b396d', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:39', NULL, '2020-03-15 22:08:39', '2020-03-15 22:08:39', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('5948ecef174e40d3af8be7c5c24cc361', NULL, '5948ecef174e40d3af8be7c5c24cc361', NULL, '5f7b02e30a73741fb1b9587f8efde83b', '1', NULL, NULL, NULL, NULL, 60, '1', '0', '2020-03-08 19:57:30', NULL, '2020-03-08 19:57:30', '2020-03-08 19:57:30', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('7067fc3b84804c699f196e383700c393', 'asfsa', '7067fc3b84804c699f196e383700c393', 'ccccc', '73061789d8d71f99bc993fe98d4392db', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:43', NULL, '2020-03-15 22:08:43', '2020-03-15 22:08:43', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('79c691410e6e49f793a31842ded42953', 'ddddd', '79c691410e6e49f793a31842ded42953', 'ddddd', '343fb8a5be15e62e8f02eec406659c04', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:56', NULL, '2020-03-15 22:08:56', '2020-03-15 22:08:56', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('9cb70c525d044739985aa1eeeb2e3e52', NULL, '9cb70c525d044739985aa1eeeb2e3e52', NULL, '5f7b02e30a73741fb1b9587f8efde83b', '1', NULL, NULL, NULL, NULL, 60, '1', '0', '2020-03-08 19:56:06', NULL, '2020-03-08 19:56:06', '2020-03-08 19:56:06', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('9df68aafa8c14a369b5043b5c80f3e42', 'asfsa', '9df68aafa8c14a369b5043b5c80f3e42', 'bbbbb', 'b5be7c3351192fb51d80d84f397db91d', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:41', NULL, '2020-03-15 22:08:41', '2020-03-15 22:08:41', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('afa6567870834a70bca5690db70b5cc8', '123456', 'afa6567870834a70bca5690db70b5cc8', '123456', 'f0ddf8a31c8aaa599125c4204e17a6c2', '1', NULL, NULL, NULL, NULL, 80, '1', '2', '2020-03-07 20:08:14', '2020-03-08 10:15:46', '2020-03-07 20:08:14', '2020-03-07 20:08:14', 'userDefaultAvatar.png', NULL, NULL);
INSERT INTO `user` VALUES ('b20109964ed0456688218a6e3ad3d4de', 'asfsa', 'b20109964ed0456688218a6e3ad3d4de', 'eeeee', '4fec09c0d052b3a9e3060333ccd50129', '1', NULL, NULL, NULL, NULL, 80, '1', '0', '2020-03-15 22:08:47', NULL, '2020-03-15 22:08:47', '2020-03-15 22:08:47', 'userDefaultAvatar.png', NULL, NULL);
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
  `is_like` int(0) NULL DEFAULT NULL COMMENT '赞标志',
  `is_collect` int(0) NULL DEFAULT NULL COMMENT '收藏标志',
  `group_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分组名',
  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES ('0ccbbd7cebdc44ee8037a89c219e368e', '1', 'b57a9128631743239a41817936f5d7bb', '2020-03-16 23:01:13', '1441', '41', '20200310201513046QQ截图20200226194757.jpg', 0, 1, 'aaa', NULL, NULL);
INSERT INTO `user_collection` VALUES ('0e881d03f43341e1ad2d95719b74da74', '1', '26fd2b762c9646f49e1cf6f40566b7d8', '2020-03-16 23:00:46', 'hello', 'hello', '20200310201535486桌面.jpg', 0, 1, 'eeee', NULL, NULL);
INSERT INTO `user_collection` VALUES ('2de544d30cac45109146b308f12080fa', '1', '10d88d1b5409433db00d871370ce7fd6', '2020-03-16 23:00:35', '141', '1421', '20200310190101380111.jpg', 0, 0, '444', NULL, NULL);
INSERT INTO `user_collection` VALUES ('46ff42dc5c924db3a25b2f503dd532a8', '1', '543adcda63bd4938a57cc86e072ec380', '2020-03-16 23:00:55', '真龙真龙', '真龙真龙', '20200310193819136QQ截图20200226194757.jpg', 0, 1, 'eeee', NULL, NULL);
INSERT INTO `user_collection` VALUES ('49b2e6675ecb4661a49919ff3dc1afda', '1', 'fd05624d73214dedaabe3dc0f00cd1f8', '2020-03-16 23:01:35', '124', '11111', '20200310194739112桌面.jpg', 0, 0, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('54973b62f7264f09add51410fc2d3659', '1', '3c40be903534470aa102788712cfe99e', '2020-03-16 23:00:51', '14141', '1414', '20200309202406690QQ截图20200226194757.jpg', 0, 1, 'haha', NULL, NULL);
INSERT INTO `user_collection` VALUES ('8868ce2f163649af9ec2bb31fd7915cb', '1', '613b4c3c7a39414d803bdd190bfc3ff2', '2020-03-16 23:01:00', '4141', '141', '20200310201731506QQ截图20200310190128.jpg', 0, 1, 'eeee', NULL, NULL);
INSERT INTO `user_collection` VALUES ('909548ab20ce461d844fd2e5db960f21', '1', 'dd445e68a24f40459266aedb395e5817', '2020-03-16 23:01:28', '122', '1', '20200310201353073QQ截图20200226194757.jpg', 0, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('911cebaa29d045839e454a062100e341', '1', 'bf5d445abd77406fa433c72c683b10f2', '2020-03-16 22:40:39', 'windows', 'windows', '20200310201102722QQ截图20200310190128.jpg', 1, 1, '默认收藏夹', NULL, NULL);
INSERT INTO `user_collection` VALUES ('9d89408a78cd4a8b98dccbd3f0451227', '1', '10fb3f', '2020-03-16 23:00:40', '海贼之我是大', '不知道', '20200310184728170QQ截图20200226194757.jpg', 0, 1, 'aaa', NULL, NULL);
INSERT INTO `user_collection` VALUES ('aade9bba40634955b34d0dc363097c06', '1', 'f65f5a4768694472b70715fd73bca2f5', '2020-03-16 23:01:20', '111', '111', '20200310194929794桌面.jpg', 0, 1, 'haha', NULL, NULL);
INSERT INTO `user_collection` VALUES ('dc76f7b174f24842ba1a33bb4f1a0e13', '1', '6372631134b64a25941c2f80958b980b', '2020-03-16 23:01:07', '真龙真龙', '真龙真龙真龙真龙', '20200310201915779403.png', 0, 1, 'haha', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
