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

 Date: 03/03/2020 17:27:56
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
  `score` int(11) NULL DEFAULT NULL COMMENT '得分',
  `input_time` timestamp(0) NULL DEFAULT NULL COMMENT '录入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('044cf67fbcce4a9fa1feef2098103cbc', '12', '111', '111', '111', '111', 11.00, '2', '02715e876b464faa8fa31f8482f09800.jpg', 0, '111', 0, NULL, '2020-02-21 16:00:00', '2020-02-29 10:34:56');
INSERT INTO `book` VALUES ('089238da2d864fb6a35b73aeec1b478a', '2', '5421', '141', '1521', '1252', 1421.00, '0', 'b92f3ec2a45840b28c9bf1f440aa4c43.jpg', 0, '11', 0, NULL, '2020-03-12 16:00:00', '2020-03-01 13:05:28');
INSERT INTO `book` VALUES ('10d88d1b5409433db00d871370ce7fd6', '1', '141', '1421', '14421', '12412', 11.00, '2', 'c06abb1a68334651b10b87dae8bc7b77.jpg', 0, '', NULL, NULL, '2020-02-28 16:00:00', '2020-02-25 17:33:23');
INSERT INTO `book` VALUES ('10fb3f', '4', '海贼之我是大', '不知道', '不知道', '不知', 1.00, NULL, 'http://localhost:8090/download/f57fad556e1c45bb813c62749228af06.jpg', 1, '636a4346df514f8998a7ff160fd52299.txt', 0, NULL, '2020-03-01 17:33:19', '2020-02-29 06:34:59');
INSERT INTO `book` VALUES ('26fd2b762c9646f49e1cf6f40566b7d8', '21', 'hello', 'hello', 'hello', 'hello', 11.00, '0', '09860827d9b04ee5a9ec2e4fc54f29d0.jpg', 0, '', 0, NULL, '2020-02-28 16:00:00', '2020-02-29 03:59:57');
INSERT INTO `book` VALUES ('3c40be903534470aa102788712cfe99e', '2', '14141', '1414', '4141', '4141', 11.00, '0', NULL, 0, '', NULL, NULL, '2020-03-05 16:00:00', '2020-02-19 17:33:33');
INSERT INTO `book` VALUES ('613b4c3c7a39414d803bdd190bfc3ff2', '3', '4141', '141', '4114', '4141', 1.00, NULL, NULL, 1, 'e4257f7f88454a7ea70055ee46b2e503.txt', NULL, NULL, '2020-02-14 17:33:26', '2020-02-26 17:33:30');
INSERT INTO `book` VALUES ('a135df0ea5014c90bba0e4c6a7c82cab', '9', '损坏损坏', '1144141', '损坏损坏', '损坏损坏', 14141414.00, '2', '36af36f3c62742c493b1150b87d98ae3.jpg', 0, '111414', 0, NULL, '2020-03-19 16:00:00', '2020-03-01 01:58:03');
INSERT INTO `book` VALUES ('b57a9128631743239a41817936f5d7bb', '1', '1441', '41', '144141', '4141', 111.00, '0', '5f8c1070efcb4bb6acd8f136c34f2d40.jpg', 0, '1141', 0, NULL, '2020-03-20 16:00:00', '2020-03-01 03:33:52');
INSERT INTO `book` VALUES ('bf5d445abd77406fa433c72c683b10f2', '4', 'windows', 'windows', 'windows', 'windows', 1.00, NULL, '68991466e69c4721b7e882b563762bb1.jpg', 1, 'a19253bc5ceb4fb5accfa233c6b6ec1a.txt', 0, NULL, '2020-02-09 17:33:37', '2020-02-28 11:18:20');
INSERT INTO `book` VALUES ('c8dea18c7b924a9ba3af8ca5270ec64e', '1', '1', '1', '1', '1', 1.00, '1', '1', 1, '1', 0, 1, '2020-02-05 13:03:12', '2020-02-29 10:06:51');
INSERT INTO `book` VALUES ('d58a37c26ed2456c9f566768afc1d4ae', '9', '1111', '4141', '4141', '1441', 1441.00, '0', '3f4d71f2f7a8412ea872ac845b83e392.jpg', 0, '1441', 0, NULL, '2020-03-19 16:00:00', '2020-03-01 03:20:20');
INSERT INTO `book` VALUES ('d80b2ce8a65d438e942b60e0352dda84', '1', '1', '1', '1', '1', 1.00, '1', '1', 1, '1', 0, 1, '2020-02-05 13:03:12', '2020-02-29 09:56:48');
INSERT INTO `book` VALUES ('dd445e68a24f40459266aedb395e5817', '1', '1', '1', '1', '1', 1.00, '1', '1', 1, '1', 0, 1, '2020-02-05 13:03:12', '2020-02-29 10:01:38');
INSERT INTO `book` VALUES ('f65f5a4768694472b70715fd73bca2f5', '12', '111', '111', '111', '111', 11.00, '2', NULL, 0, '111', 0, NULL, '2020-02-21 16:00:00', '2020-02-29 10:34:07');
INSERT INTO `book` VALUES ('fd05624d73214dedaabe3dc0f00cd1f8', '1', '124', '11111', '24211', '124', 1.00, NULL, '23595addb99e4928a0a6be3e32b117e6.jpg', 1, 'ca7f3e1e360e46de97b0a7602b4893b8.txt', 0, NULL, NULL, '2020-03-03 16:07:18');

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
  `duration` int(4) NULL DEFAULT NULL COMMENT '借阅时长',
  `application_time` timestamp(0) NULL DEFAULT NULL COMMENT '申请时间',
  `handle_time` timestamp(0) NULL DEFAULT NULL COMMENT '处理时间',
  `borrowing_time` timestamp(0) NULL DEFAULT NULL COMMENT '借阅时间',
  `return_time` timestamp(0) NULL DEFAULT NULL COMMENT '归还时间',
  `borrowing_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态  申请、驳回、已借、逾期、归还',
  `operator` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作人',
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
INSERT INTO `borrowing` VALUES ('1414114', '1414', '141414', 'www', 'ww', 11, '2020-03-14 14:59:32', '2020-03-03 15:00:10', '2020-03-13 14:59:47', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('2', '2', '1', '1', '1', 11, '2020-02-05 13:05:19', '2020-02-29 14:20:21', '2020-02-21 13:05:21', '2020-02-28 13:05:23', '3', 'cl', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `borrowing` VALUES ('24', '24', '24', '24', '24', 11, '2020-02-05 20:59:37', NULL, '2020-02-23 20:59:39', '2020-02-26 20:59:43', '2', '2', NULL, NULL, NULL, NULL, NULL, NULL);

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
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论id',
  `book_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `comment_time` timestamp(0) NOT NULL COMMENT '评论时间',
  `Zan_flag` int(11) NULL DEFAULT NULL COMMENT '赞标志',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `score` int(11) NULL DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '2020-02-06 13:08:45', 1, '1', 1);
INSERT INTO `comment` VALUES ('2', '2', '2', '2020-02-29 21:05:32', 0, '2', 2);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '信息id',
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `sending_time` timestamp(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '信息内容',
  `status` int(11) NULL DEFAULT NULL COMMENT '信息状态  已读、未读',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', '2020-03-01 21:12:02', '1', 0);
INSERT INTO `message` VALUES ('2', '2', '2020-02-27 13:09:58', '1', 1);

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
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 1, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `permission` VALUES ('2', 2, 1, 1, 1, 1, 1, 1, 1);

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
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2', '2', '1', '2020-02-27 13:12:24', '1', '1');

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
INSERT INTO `type` VALUES (1, NULL, '', 1, 0, '小说', NULL, NULL, '2020-02-28 21:19:16');
INSERT INTO `type` VALUES (2, NULL, '', 1, 0, '文学', NULL, NULL, '2020-02-28 21:23:40');
INSERT INTO `type` VALUES (3, 1, NULL, 2, NULL, '中国小说', NULL, NULL, '2020-02-29 22:24:26');
INSERT INTO `type` VALUES (4, 3, NULL, 3, NULL, '武侠', NULL, NULL, '2020-02-29 03:17:31');
INSERT INTO `type` VALUES (5, 3, NULL, 3, NULL, '科幻', NULL, NULL, '2020-02-29 03:17:43');
INSERT INTO `type` VALUES (6, 3, NULL, 3, NULL, '军事', NULL, NULL, '2020-02-29 03:17:49');
INSERT INTO `type` VALUES (7, 3, NULL, 3, NULL, '情感', NULL, NULL, '2020-02-29 03:17:56');
INSERT INTO `type` VALUES (8, 3, NULL, 3, NULL, '古典', NULL, NULL, '2020-02-29 03:18:04');
INSERT INTO `type` VALUES (9, 1, NULL, 2, NULL, '外国小说', NULL, NULL, '2020-02-29 14:12:07');
INSERT INTO `type` VALUES (10, 2, NULL, 2, NULL, '传记', NULL, NULL, '2020-02-29 03:18:32');
INSERT INTO `type` VALUES (11, 2, NULL, 2, NULL, '影视文学', NULL, NULL, '2020-02-29 03:18:46');
INSERT INTO `type` VALUES (12, 2, NULL, 2, NULL, '戏曲文学', NULL, NULL, '2020-02-29 03:18:55');
INSERT INTO `type` VALUES (13, 2, NULL, 2, NULL, '散文', NULL, NULL, '2020-02-29 03:19:03');
INSERT INTO `type` VALUES (15, 10, NULL, 3, NULL, '政治人物', NULL, NULL, '2020-02-29 03:19:32');
INSERT INTO `type` VALUES (16, 10, NULL, 3, NULL, '文学家', NULL, NULL, '2020-02-29 03:19:39');
INSERT INTO `type` VALUES (17, 10, NULL, 3, NULL, '科学家', NULL, NULL, '2020-02-29 03:19:45');
INSERT INTO `type` VALUES (18, 10, NULL, 3, NULL, '哲学家', NULL, NULL, '2020-02-29 03:19:52');
INSERT INTO `type` VALUES (21, 9, NULL, 3, NULL, '恐怖小说', NULL, NULL, '2020-02-29 03:47:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `IDcard` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `tel` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `credit` int(11) NULL DEFAULT NULL COMMENT '信用分',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户状态',
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色',
  `register_time` timestamp(0) NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '3', '2', '1', '1', '1', '1', 1, '1', '1', '2020-02-26 12:01:45', '2020-02-26 12:01:48');

SET FOREIGN_KEY_CHECKS = 1;
