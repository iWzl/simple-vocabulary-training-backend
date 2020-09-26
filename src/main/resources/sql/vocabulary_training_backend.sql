/*
 Source Server         : Leonardo-iWzl-Master-192.168.1.11
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.1.11:3306
 Source Schema         : vocabulary_training_backend

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 26/09/2020 22:50:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '账户userId 唯一标识用户',
  `role` enum('Admin','User') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'User' COMMENT '用户身份',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名/用户登录',
  `secret_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密钥Key',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
  `birthday` bigint NOT NULL DEFAULT '1577808000000' COMMENT '用户生日 UNIX时间戳',
  `nike_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户昵称',
  `gender` enum('M','F','NO') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'NO' COMMENT '用户性别',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '个性签名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户头像',
  `background` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '背景底色图片',
  `status` int NOT NULL DEFAULT '0' COMMENT '用户状态,用于标识用户的基本状态',
  `create_time` bigint NOT NULL COMMENT '创建时间',
  `update_time` bigint NOT NULL COMMENT '更新时间',
  `last_login_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100038 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES (100036, 'User', 'Leonardo', '2f986a35-f184-4f2a-bbdc-c4a65fb48c69', 'Jo9QAYE8KaOAhZa8kUo0Ug==', 1577808000000, 'Leonardo DiCaprio', 'M', NULL, 'https://w.wallhaven.cc/full/39/wallhaven-39pw6v.jpg', NULL, 0, 1597593479103, 1597593479103, 1597593479000);
INSERT INTO `account` VALUES (100037, 'User', '123456', '829c2455-e204-4777-9b78-129ceb55e607', 'q5sKYQLa3f3DWuMr8P2C2Q==', 1602172800000, '学习机', 'M', '好好学习，天天向上', 'https://w.wallhaven.cc/full/39/wallhaven-39pw6v.jpg', 'http://api-a.upuphub.com/image/8fe963b3-cd53-452a-9d6c-833d69134aa1.png', 0, 1597734648071, 1601129140573, 1601129065000);
COMMIT;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint NOT NULL COMMENT 'ID',
  `word` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '单词',
  `symbol` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '音标',
  `paraphrase` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '释义',
  `part_of_speech` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '词性',
  `status` int DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `fid` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_time` bigint NOT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of feedback
-- ----------------------------
BEGIN;
INSERT INTO `feedback` VALUES (7, 100037, '看看', 1601126593363, 0);
COMMIT;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int NOT NULL AUTO_INCREMENT COMMENT '商品Id',
  `classify` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '分类',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '商品名称',
  `image` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '商品图片',
  `introduction` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '说明',
  `price` float(10,2) NOT NULL COMMENT '价格',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`gid`),
  KEY `classify` (`classify`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, '单词书', '我是单词书名称', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=108437590,1996824283&fm=26&gp=0.jpg', '我是单词书说明', 9999999.00, 0);
INSERT INTO `goods` VALUES (2, '教材', '我是教材名称', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=303454938,2600310523&fm=26&gp=0.jpg', '我是教材说明', 888888.00, 0);
INSERT INTO `goods` VALUES (3, '阅读材料', '我是阅读材料名称', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601137007418&di=6427d22803cf52e62d972d89d5ab38a6&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201503%2F27%2F20150327225201_TcRki.jpeg', '我是阅读材料说明', 66.66, 0);
COMMIT;

-- ----------------------------
-- Table structure for sentence
-- ----------------------------
DROP TABLE IF EXISTS `sentence`;
CREATE TABLE `sentence` (
  `id` int NOT NULL COMMENT '句子ID',
  `classify` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '分类',
  `english` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '英文',
  `chinese` varchar(2048) COLLATE utf8mb4_bin NOT NULL COMMENT '中文',
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `classify` (`classify`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sentence
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for vocabulary
-- ----------------------------
DROP TABLE IF EXISTS `vocabulary`;
CREATE TABLE `vocabulary` (
  `id` bigint NOT NULL COMMENT 'ID',
  `uid` int NOT NULL COMMENT '用户ID',
  `word` varchar(1024) COLLATE utf8mb4_bin NOT NULL COMMENT '单词',
  `status` int DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of vocabulary
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
