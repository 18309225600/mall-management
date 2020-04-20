/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mall-management

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-04-21 00:11:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mall_customer`
-- ----------------------------
DROP TABLE IF EXISTS `mall_customer`;
CREATE TABLE `mall_customer` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT ''客户姓名'',
  `phone` varchar(64) DEFAULT NULL COMMENT ''客户电话'',
  `country` varchar(255) DEFAULT NULL COMMENT ''国家'',
  `province` varchar(64) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT ''详细地址'',
  `email` varchar(255) DEFAULT NULL COMMENT ''邮箱'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mall_customer
-- ----------------------------
INSERT INTO `mall_customer` VALUES (''1251361384722145282'', ''Pirate'', ''18309225600'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''18309225600@163.com'', ''2020-04-18 12:06:18'', null);

-- ----------------------------
-- Table structure for `mall_goods`
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods` (
  `id` bigint(10) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL COMMENT ''产品品名'',
  `url_suffix` varchar(255) DEFAULT NULL COMMENT ''url后缀'',
  `facebook_num` varchar(255) DEFAULT NULL COMMENT ''facebook像素编号'',
  `line_num` varchar(255) DEFAULT NULL COMMENT ''line像素编号'',
  `country` varchar(50) DEFAULT NULL COMMENT ''国家'',
  `template_id` bigint(20) DEFAULT NULL COMMENT ''模板ID'',
  `template_name` varchar(255) DEFAULT NULL COMMENT ''模板名称'',
  `domain_name` varchar(255) DEFAULT NULL COMMENT ''域名'',
  `title` varchar(255) DEFAULT NULL COMMENT ''标题'',
  `special_offer` varchar(255) DEFAULT NULL COMMENT ''特价'',
  `original_offer` varchar(255) DEFAULT NULL COMMENT ''原价'',
  `currency_symbol` varchar(255) DEFAULT NULL COMMENT ''货币符号'',
  `sales_volume` int(10) DEFAULT NULL COMMENT ''销量'',
  `remaining_num` int(10) DEFAULT NULL COMMENT ''剩余件数'',
  `show_shop_match` tinyint(1) DEFAULT NULL COMMENT ''是否展示711店配 0否  1是'',
  `show_discount_code` tinyint(1) DEFAULT NULL COMMENT ''是否展示优惠码 0否 1是'',
  `default_selection_specification` tinyint(1) DEFAULT NULL COMMENT ''规格是否默认选择  0否  1是'',
  `promotion_words` varchar(255) DEFAULT NULL COMMENT ''促销语'',
  `purchase_link` varchar(255) DEFAULT NULL COMMENT ''采购连接'',
  `purchase_cost` bigint(20) DEFAULT NULL COMMENT ''采购成本  单位：分'',
  `remark` varchar(255) DEFAULT NULL COMMENT ''备注'',
  `head_img` varchar(1000) DEFAULT NULL COMMENT ''首图'',
  `detail` longtext COMMENT ''产品详情'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mall_goods
-- ----------------------------
INSERT INTO `mall_goods` VALUES (''1251859768096649217'', ''123'', ''123'', ''123'', ''123'', ''123'', ''1'', ''台湾模板1'', ''123'', ''123'', ''123'', ''123'', ''NT＄'', ''123'', ''123'', null, null, null, ''123'', ''123'', ''123'', ''123'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTN-AIhrzAAiQfKHDaaQ438.jpg'', ''<p>123</p>'', ''2020-04-19 21:06:42'', ''2020-04-19 21:08:11'');
INSERT INTO `mall_goods` VALUES (''1251860662422925314'', ''123'', ''123'', ''123'', ''123'', ''123'', ''1'', ''台湾模板1'', ''123'', ''123'', ''123'', ''123'', ''NT＄'', ''123'', ''123'', null, null, null, ''123'', ''123'', ''123'', ''123'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTYmAY00dAAkVVGMybN8778.jpg'', ''<p>123</p>'', ''2020-04-19 21:10:15'', ''2020-04-19 21:13:39'');
INSERT INTO `mall_goods` VALUES (''1251861875520499714'', ''123'', ''123'', ''123'', ''123'', ''123'', ''1'', ''台湾模板1'', ''123'', ''123'', ''123'', ''123'', ''NT＄'', ''123'', ''123'', ''1'', ''1'', ''1'', ''123'', ''123'', ''123'', ''123'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTYmAY00dAAkVVGMybN8778.jpg'', ''<p>123</p>'', ''2020-04-19 21:15:04'', ''2020-04-20 20:16:40'');
INSERT INTO `mall_goods` VALUES (''1251895349589639169'', ''123'', ''123'', ''123'', ''123'', ''123'', ''2'', ''香港模板1'', ''123'', ''123'', ''123'', ''123'', ''HK＄'', ''123'', ''123'', null, null, null, ''123'', ''123'', ''123'', ''123'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cbfyAIEdWAAkVVGMybN8247.jpg'', ''<p>123</p>'', ''2020-04-19 23:28:05'', ''2020-04-20 20:16:41'');
INSERT INTO `mall_goods` VALUES (''1252208053684596738'', ''123'', ''123'', ''12'', ''123'', ''123'', ''2'', ''香港模板1'', ''123'', ''123'', ''123'', ''123'', ''HK＄'', ''123'', ''123'', null, null, null, ''123'', ''123'', ''123'', ''123'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkmaAUjuJAAiQfKHDaaQ647.jpg'', ''<p>123</p>'', ''2020-04-20 20:10:40'', ''2020-04-20 20:16:44'');
INSERT INTO `mall_goods` VALUES (''1252209740071628802'', ''1234'', ''1234'', ''1234'', ''1234'', ''1234'', ''2'', ''香港模板1'', ''1234'', ''1234'', ''1234'', ''1234'', ''HK＄'', ''1234'', ''1234'', ''1'', ''1'', ''1'', ''1234'', ''1234'', ''1234'', ''1234'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dksqAdBqOAAkVVGMybN8630.jpg'', ''<p>1234</p>'', ''2020-04-20 20:17:22'', null);

-- ----------------------------
-- Table structure for `mall_goods_img`
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_img`;
CREATE TABLE `mall_goods_img` (
  `id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL COMMENT ''商品ID'',
  `type` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''图片类型：0:产品主图  1:产品参数   2:产品详情'',
  `url` varchar(512) NOT NULL COMMENT ''图片地址'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT=''商品其他图片'';

-- ----------------------------
-- Records of mall_goods_img
-- ----------------------------
INSERT INTO `mall_goods_img` VALUES (''1251861875583414273'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:15:04'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251861875583414274'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:15:04'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251861875583414275'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:15:04'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251861875583414276'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:15:04'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251861875583414277'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:15:04'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863085149388801'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:19:53'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863085178748930'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:19:53'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863085493321730'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:19:53'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863085497516033'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:19:53'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863085510098946'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:19:53'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863377236525057'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:21:02'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863377236525058'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:21:02'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863377605623810'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:21:02'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863377618206721'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:21:02'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863377622401025'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:21:02'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863425345191937'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:21:14'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863425361969153'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:21:14'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863425844314113'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:21:14'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863425848508417'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:21:14'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863425852702722'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:21:14'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863531406557185'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:21:39'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863531410751490'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:21:39'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863531725324290'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:21:39'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863531733712898'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:21:39'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863531733712899'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:21:39'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863875918299138'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:23:01'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863875935076353'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:23:01'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863876199317506'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:23:01'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863876199317507'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:23:01'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251863876199317508'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:23:01'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864015139831810'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:23:34'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864015144026114'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:23:34'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864015144026115'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cUNKAV7w5AAvea_OGt2M946.jpg'', ''2020-04-19 21:23:34'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864015617982465'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:23:34'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864015622176770'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:23:34'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864015630565378'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:23:34'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864042352476161'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-19 21:23:41'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864042360864770'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-19 21:23:41'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864042360864771'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cUNKAV7w5AAvea_OGt2M946.jpg'', ''2020-04-19 21:23:41'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864042830626817'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-19 21:23:41'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864042834821122'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-19 21:23:41'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251864042834821123'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-19 21:23:41'', ''2020-04-20 20:06:56'');
INSERT INTO `mall_goods_img` VALUES (''1251895349652553730'', ''1251895349589639169'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cbf6ARkDgAAkVVGMybN8576.jpg'', ''2020-04-19 23:28:05'', null);
INSERT INTO `mall_goods_img` VALUES (''1251895349652553731'', ''1251895349589639169'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cbgKAN7owAA1rIuRd3Es392.jpg'', ''2020-04-19 23:28:05'', null);
INSERT INTO `mall_goods_img` VALUES (''1251895349652553732'', ''1251895349589639169'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cbf-AW73KAAkVVGMybN8415.jpg'', ''2020-04-19 23:28:05'', null);
INSERT INTO `mall_goods_img` VALUES (''1251895349652553733'', ''1251895349589639169'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cbgSANw3_AA1rIuRd3Es619.jpg'', ''2020-04-19 23:28:05'', null);
INSERT INTO `mall_goods_img` VALUES (''1251895349652553734'', ''1251895349589639169'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cbgWAUlnBAAvqH_kipG8993.jpg'', ''2020-04-19 23:28:05'', null);
INSERT INTO `mall_goods_img` VALUES (''1252207116299595777'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsOADB-4AAiQfKHDaaQ615.jpg'', ''2020-04-20 20:06:56'', null);
INSERT INTO `mall_goods_img` VALUES (''1252207116337344514'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTsiATPVFAA1rIuRd3Es315.jpg'', ''2020-04-20 20:06:56'', null);
INSERT INTO `mall_goods_img` VALUES (''1252207116341538817'', ''1251861875520499714'', ''0'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cUNKAV7w5AAvea_OGt2M946.jpg'', ''2020-04-20 20:06:56'', null);
INSERT INTO `mall_goods_img` VALUES (''1252207116836466689'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTs2AeLMfAAvqH_kipG8283.jpg'', ''2020-04-20 20:06:56'', null);
INSERT INTO `mall_goods_img` VALUES (''1252207116853243905'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtGAfwqrAAvea_OGt2M932.jpg'', ''2020-04-20 20:06:56'', null);
INSERT INTO `mall_goods_img` VALUES (''1252207116857438210'', ''1251861875520499714'', ''1'', ''http://dfs.inconnection.cn/00/14/rBEwyV6cTtWAOeRtAAzodQCbVVc869.jpg'', ''2020-04-20 20:06:56'', null);
INSERT INTO `mall_goods_img` VALUES (''1252208053684596739'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkR-AJoNiAA1rIuRd3Es459.jpg'', ''2020-04-20 20:10:40'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208053684596740'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSOAPoWHAA1rIuRd3Es527.jpg'', ''2020-04-20 20:10:40'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208053684596741'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSCAZH-HAAvea_OGt2M196.jpg'', ''2020-04-20 20:10:40'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208053684596742'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSqAdr28AAvea_OGt2M232.jpg'', ''2020-04-20 20:10:40'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208053684596743'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkS2Afj6xAAvea_OGt2M933.jpg'', ''2020-04-20 20:10:40'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208202930515970'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkR-AJoNiAA1rIuRd3Es459.jpg'', ''2020-04-20 20:11:15'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208202943098882'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSOAPoWHAA1rIuRd3Es527.jpg'', ''2020-04-20 20:11:15'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208203211534337'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSCAZH-HAAvea_OGt2M196.jpg'', ''2020-04-20 20:11:15'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208203211534338'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSqAdr28AAvea_OGt2M232.jpg'', ''2020-04-20 20:11:15'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208203211534339'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkS2Afj6xAAvea_OGt2M933.jpg'', ''2020-04-20 20:11:15'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208862262521857'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkR-AJoNiAA1rIuRd3Es459.jpg'', ''2020-04-20 20:13:52'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208862275104770'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSOAPoWHAA1rIuRd3Es527.jpg'', ''2020-04-20 20:13:52'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208862551928834'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSCAZH-HAAvea_OGt2M196.jpg'', ''2020-04-20 20:13:52'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208862551928835'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSqAdr28AAvea_OGt2M232.jpg'', ''2020-04-20 20:13:52'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252208862551928836'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkS2Afj6xAAvea_OGt2M933.jpg'', ''2020-04-20 20:13:52'', ''2020-04-20 20:15:33'');
INSERT INTO `mall_goods_img` VALUES (''1252209286377959426'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkR-AJoNiAA1rIuRd3Es459.jpg'', ''2020-04-20 20:15:33'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209286390542338'', ''1252208053684596738'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSOAPoWHAA1rIuRd3Es527.jpg'', ''2020-04-20 20:15:33'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209286809972738'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSCAZH-HAAvea_OGt2M196.jpg'', ''2020-04-20 20:15:34'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209286809972739'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkSqAdr28AAvea_OGt2M232.jpg'', ''2020-04-20 20:15:34'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209286809972740'', ''1252208053684596738'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkS2Afj6xAAvea_OGt2M933.jpg'', ''2020-04-20 20:15:34'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209740138737666'', ''1252209740071628802'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dks2AcStBAAkVVGMybN8973.jpg'', ''2020-04-20 20:17:22'', ''2020-04-20 20:18:06'');
INSERT INTO `mall_goods_img` VALUES (''1252209740138737667'', ''1252209740071628802'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dktCAFcR8AAkVVGMybN8618.jpg'', ''2020-04-20 20:17:22'', ''2020-04-20 20:18:06'');
INSERT INTO `mall_goods_img` VALUES (''1252209875803500545'', ''1252209740071628802'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dks2AcStBAAkVVGMybN8973.jpg'', ''2020-04-20 20:17:54'', ''2020-04-20 20:18:06'');
INSERT INTO `mall_goods_img` VALUES (''1252209875811889153'', ''1252209740071628802'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkvCAKtLFAAvea_OGt2M875.jpg'', ''2020-04-20 20:17:54'', ''2020-04-20 20:18:06'');
INSERT INTO `mall_goods_img` VALUES (''1252209876130656257'', ''1252209740071628802'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dktCAFcR8AAkVVGMybN8618.jpg'', ''2020-04-20 20:17:54'', ''2020-04-20 20:18:06'');
INSERT INTO `mall_goods_img` VALUES (''1252209876134850561'', ''1252209740071628802'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkvOAKHzpAAvea_OGt2M333.jpg'', ''2020-04-20 20:17:54'', ''2020-04-20 20:18:06'');
INSERT INTO `mall_goods_img` VALUES (''1252209924960743426'', ''1252209740071628802'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dks2AcStBAAkVVGMybN8973.jpg'', ''2020-04-20 20:18:06'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209924960743427'', ''1252209740071628802'', ''0'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkvCAKtLFAAvea_OGt2M875.jpg'', ''2020-04-20 20:18:06'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209925287899137'', ''1252209740071628802'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dktCAFcR8AAkVVGMybN8618.jpg'', ''2020-04-20 20:18:06'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209925287899138'', ''1252209740071628802'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkvOAKHzpAAvea_OGt2M333.jpg'', ''2020-04-20 20:18:06'', null);
INSERT INTO `mall_goods_img` VALUES (''1252209925287899139'', ''1252209740071628802'', ''1'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dkv6ADGb8AAzodQCbVVc789.jpg'', ''2020-04-20 20:18:06'', null);

-- ----------------------------
-- Table structure for `mall_goods_specification`
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_specification`;
CREATE TABLE `mall_goods_specification` (
  `id` bigint(20) NOT NULL,
  `goods_id` bigint(20) DEFAULT NULL COMMENT ''商品ID'',
  `name` varchar(255) DEFAULT NULL COMMENT ''规格名称'',
  `url` varchar(500) DEFAULT NULL COMMENT ''规格图片'',
  `description` varchar(255) DEFAULT NULL COMMENT ''规格类型描述'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_goods_specification
-- ----------------------------
INSERT INTO `mall_goods_specification` VALUES (''1252263224070438914'', ''1252209740071628802'', ''123'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxJOAaIbbAAvqH_kipG8719.jpg'', ''456'', ''2020-04-20 23:49:53'', ''2020-04-20 23:55:14'');
INSERT INTO `mall_goods_specification` VALUES (''1252263224116576258'', ''1252209740071628802'', ''789'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxJyAV8MGAAvea_OGt2M310.jpg'', ''000'', ''2020-04-20 23:49:53'', ''2020-04-20 23:55:14'');
INSERT INTO `mall_goods_specification` VALUES (''1252264570693689345'', ''1252209740071628802'', ''123'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxJOAaIbbAAvqH_kipG8719.jpg'', ''456'', ''2020-04-20 23:55:14'', ''2020-04-20 23:55:32'');
INSERT INTO `mall_goods_specification` VALUES (''1252264570727243777'', ''1252209740071628802'', ''789'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxJyAV8MGAAvea_OGt2M310.jpg'', ''000'', ''2020-04-20 23:55:14'', ''2020-04-20 23:55:32'');
INSERT INTO `mall_goods_specification` VALUES (''1252264570727243778'', ''1252209740071628802'', ''ABC'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxdyAR1imAAvea_OGt2M122.jpg'', ''DEF'', ''2020-04-20 23:55:14'', ''2020-04-20 23:55:32'');
INSERT INTO `mall_goods_specification` VALUES (''1252264643083182081'', ''1252209740071628802'', ''123'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxJOAaIbbAAvqH_kipG8719.jpg'', ''456'', ''2020-04-20 23:55:32'', ''2020-04-20 23:55:45'');
INSERT INTO `mall_goods_specification` VALUES (''1252264643095764994'', ''1252209740071628802'', ''789'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxfKANVicAAzodQCbVVc938.jpg'', ''000'', ''2020-04-20 23:55:32'', ''2020-04-20 23:55:45'');
INSERT INTO `mall_goods_specification` VALUES (''1252264643099959298'', ''1252209740071628802'', ''ABC'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxdyAR1imAAvea_OGt2M122.jpg'', ''DEF'', ''2020-04-20 23:55:32'', ''2020-04-20 23:55:45'');
INSERT INTO `mall_goods_specification` VALUES (''1252264701711163394'', ''1252209740071628802'', ''123'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxJOAaIbbAAvqH_kipG8719.jpg'', ''456'', ''2020-04-20 23:55:45'', ''2020-04-20 23:58:20'');
INSERT INTO `mall_goods_specification` VALUES (''1252264701727940610'', ''1252209740071628802'', ''ABC'', ''http://dfs.inconnection.cn/00/15/rBEwyV6dxdyAR1imAAvea_OGt2M122.jpg'', ''DEF'', ''2020-04-20 23:55:45'', ''2020-04-20 23:58:20'');
INSERT INTO `mall_goods_specification` VALUES (''1252265350813261825'', ''1252209740071628802'', ''123'', '''', ''456'', ''2020-04-20 23:58:20'', ''2020-04-21 00:09:27'');
INSERT INTO `mall_goods_specification` VALUES (''1252265350821650433'', ''1252209740071628802'', ''ABC'', ''http://dfs.inconnection.cn/00/16/rBEwyV6dxp2ATjOJAAzodQCbVVc794.jpg'', ''DEF'', ''2020-04-20 23:58:20'', ''2020-04-21 00:09:27'');
INSERT INTO `mall_goods_specification` VALUES (''1252268146799222785'', ''1252209740071628802'', ''123'', ''http://dfs.inconnection.cn/00/16/rBEwyV6dyTWAWXTqAA1rIuRd3Es445.jpg'', ''456'', ''2020-04-21 00:09:27'', null);
INSERT INTO `mall_goods_specification` VALUES (''1252268146811805697'', ''1252209740071628802'', ''ABC'', ''http://dfs.inconnection.cn/00/16/rBEwyV6dyQmAGv1yAAvWFkcZHjA484.jpg'', ''DEF'', ''2020-04-21 00:09:27'', null);

-- ----------------------------
-- Table structure for `mall_order`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint(20) NOT NULL,
  `order_no` varchar(255) DEFAULT NULL COMMENT ''订单编号'',
  `country` varchar(255) DEFAULT NULL COMMENT ''国家'',
  `customer_id` bigint(20) DEFAULT NULL COMMENT ''客户ID'',
  `customer_name` varchar(255) DEFAULT NULL COMMENT ''客户姓名'',
  `customer_phone` varchar(64) DEFAULT NULL COMMENT ''客户手机号'',
  `customer_email` varchar(64) DEFAULT NULL COMMENT ''客户邮箱'',
  `customer_country` varchar(255) DEFAULT NULL COMMENT ''客户国家'',
  `customer_province` varchar(255) DEFAULT NULL,
  `customer_city` varchar(255) DEFAULT NULL,
  `customer_address` varchar(1024) DEFAULT NULL,
  `customer_remark` varchar(1024) DEFAULT NULL COMMENT ''客户备注留言'',
  `delivery` int(2) DEFAULT NULL COMMENT ''配送方式 0:到家  1:711  2:全家超商取货'',
  `amount` varchar(255) DEFAULT NULL COMMENT ''金额'',
  `amout_currency_symbol` varchar(255) DEFAULT NULL COMMENT ''货币符号'',
  `goods_id` bigint(20) DEFAULT NULL COMMENT ''商品ID'',
  `status` int(1) DEFAULT NULL COMMENT ''状态'',
  `delivery_company` varchar(255) DEFAULT NULL COMMENT ''快递公司'',
  `delivery_num` varchar(255) DEFAULT NULL COMMENT ''快递单号'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
INSERT INTO `mall_order` VALUES (''1251362128338690049'', ''20200418120915794'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''1'', '''', '''', ''2020-04-18 12:09:15'', null);
INSERT INTO `mall_order` VALUES (''1251362458224893954'', ''20200418121033302'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''2'', null, null, ''2020-04-18 12:10:34'', null);
INSERT INTO `mall_order` VALUES (''1251362482195341313'', ''20200418121039769'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', ''天天快递'', ''234234234'', ''2020-04-18 12:10:40'', null);
INSERT INTO `mall_order` VALUES (''1251388514373804034'', ''20200418135406074'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''4'', null, null, ''2020-04-18 13:54:06'', null);
INSERT INTO `mall_order` VALUES (''1251388518794600450'', ''20200418135407651'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:07'', null);
INSERT INTO `mall_order` VALUES (''1251388521919356929'', ''20200418135407990'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''4'', null, null, ''2020-04-18 13:54:08'', null);
INSERT INTO `mall_order` VALUES (''1251388524427550721'', ''20200418135408393'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:09'', null);
INSERT INTO `mall_order` VALUES (''1251388526642143234'', ''20200418135409000'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:09'', null);
INSERT INTO `mall_order` VALUES (''1251388528705740801'', ''20200418135409569'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:10'', null);
INSERT INTO `mall_order` VALUES (''1251388530962276353'', ''20200418135410430'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''1'', null, null, ''2020-04-18 13:54:10'', null);
INSERT INTO `mall_order` VALUES (''1251388532904239106'', ''20200418135410910'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:11'', null);
INSERT INTO `mall_order` VALUES (''1251388534330302465'', ''20200418135410991'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:11'', null);
INSERT INTO `mall_order` VALUES (''1251388536423260162'', ''20200418135411575'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:11'', null);
INSERT INTO `mall_order` VALUES (''1251388539266998274'', ''20200418135412795'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:12'', null);
INSERT INTO `mall_order` VALUES (''1251388540789530626'', ''20200418135412645'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:12'', null);
INSERT INTO `mall_order` VALUES (''1251388543863955458'', ''20200418135413276'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:13'', null);
INSERT INTO `mall_order` VALUES (''1251388546644779010'', ''20200418135413877'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:14'', null);
INSERT INTO `mall_order` VALUES (''1251388548280557570'', ''20200418135414064'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:14'', null);
INSERT INTO `mall_order` VALUES (''1251388551505977346'', ''20200418135415901'', null, ''1251361384722145282'', ''Pirate'', ''18309225600'', ''18309225600@163.com'', ''中国'', ''shanxi'', ''xian'', ''xx区xx大厦xx室'', ''加急，快发货'', ''1'', ''22'', ''NT＄'', ''1251167799561207809'', ''0'', null, null, ''2020-04-18 13:54:15'', null);

-- ----------------------------
-- Table structure for `mall_order_process`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_process`;
CREATE TABLE `mall_order_process` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL COMMENT ''订单ID'',
  `type` int(1) NOT NULL COMMENT ''类型：0 添加备注 1更新状态 2填写物流信息'',
  `remark` varchar(255) DEFAULT NULL COMMENT ''备注信息'',
  `order_status` varchar(64) DEFAULT NULL COMMENT ''订单状态'',
  `delivery_company` varchar(255) DEFAULT NULL COMMENT ''快递公司'',
  `delivery_num` varchar(255) DEFAULT NULL COMMENT ''快递单号'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_order_process
-- ----------------------------
INSERT INTO `mall_order_process` VALUES (''1251410490572161025'', ''1251362128338690049'', ''0'', ''123123'', null, null, null, ''2020-04-18 15:21:26'', null);
INSERT INTO `mall_order_process` VALUES (''1251410722181627906'', ''1251362458224893954'', ''0'', ''测试备注订单'', null, null, null, ''2020-04-18 15:22:21'', null);
INSERT INTO `mall_order_process` VALUES (''1251410916050747393'', ''1251362482195341313'', ''0'', ''测试添加备注'', null, null, null, ''2020-04-18 15:23:07'', null);
INSERT INTO `mall_order_process` VALUES (''1251427446150938625'', ''1251388530962276353'', ''1'', null, ''已经采购'', null, null, ''2020-04-18 16:28:48'', null);
INSERT INTO `mall_order_process` VALUES (''1251427475968245762'', ''1251362128338690049'', ''1'', null, ''测试订单'', null, null, ''2020-04-18 16:28:55'', null);
INSERT INTO `mall_order_process` VALUES (''1251427508511850497'', ''1251362458224893954'', ''1'', null, ''重复订单'', null, null, ''2020-04-18 16:29:03'', null);
INSERT INTO `mall_order_process` VALUES (''1251427533912555521'', ''1251388514373804034'', ''1'', null, ''测试订单'', null, null, ''2020-04-18 16:29:09'', null);
INSERT INTO `mall_order_process` VALUES (''1251427576371494914'', ''1251388521919356929'', ''1'', null, ''测试订单'', null, null, ''2020-04-18 16:29:19'', null);
INSERT INTO `mall_order_process` VALUES (''1251444282582122497'', ''1251362128338690049'', ''2'', null, null, ''百世快递'', ''1234123123'', ''2020-04-18 17:35:42'', null);
INSERT INTO `mall_order_process` VALUES (''1251444427587600386'', ''1251362482195341313'', ''2'', null, null, ''天天快递'', ''234234234'', ''2020-04-18 17:36:17'', null);
INSERT INTO `mall_order_process` VALUES (''1251467346082545666'', ''1251362128338690049'', ''0'', ''123'', null, null, null, ''2020-04-18 19:07:21'', null);
INSERT INTO `mall_order_process` VALUES (''1251480577199063042'', ''1251362128338690049'', ''2'', null, null, ''123'', ''123123'', ''2020-04-18 19:59:56'', null);
INSERT INTO `mall_order_process` VALUES (''1251480756174209026'', ''1251362128338690049'', ''2'', null, null, ''123'', ''123123'', ''2020-04-18 20:00:38'', null);
INSERT INTO `mall_order_process` VALUES (''1251480939867947010'', ''1251362128338690049'', ''2'', null, null, ''123'', ''123'', ''2020-04-18 20:01:22'', null);
INSERT INTO `mall_order_process` VALUES (''1251722322209988609'', ''1251362128338690049'', ''0'', ''123'', null, null, null, ''2020-04-19 12:00:32'', null);
INSERT INTO `mall_order_process` VALUES (''1251722347900100609'', ''1251362128338690049'', ''1'', null, ''已经采购'', null, null, ''2020-04-19 12:00:38'', null);
INSERT INTO `mall_order_process` VALUES (''1251722365398736897'', ''1251362128338690049'', ''2'', null, null, ''123'', ''123'', ''2020-04-19 12:00:42'', null);
INSERT INTO `mall_order_process` VALUES (''1251754026089897986'', ''1251362128338690049'', ''0'', null, null, null, null, ''2020-04-19 14:06:31'', null);
INSERT INTO `mall_order_process` VALUES (''1251754621098057730'', ''1251362128338690049'', ''0'', null, null, null, null, ''2020-04-19 14:08:53'', null);
INSERT INTO `mall_order_process` VALUES (''1251755046043967489'', ''1251362128338690049'', ''0'', null, null, null, null, ''2020-04-19 14:10:34'', null);
INSERT INTO `mall_order_process` VALUES (''1251755132488572929'', ''1251362128338690049'', ''0'', null, null, null, null, ''2020-04-19 14:10:55'', null);
INSERT INTO `mall_order_process` VALUES (''1251755234825396225'', ''1251362128338690049'', ''0'', null, null, null, null, ''2020-04-19 14:11:19'', null);
INSERT INTO `mall_order_process` VALUES (''1251755592771493890'', ''1251362128338690049'', ''0'', ''123'', null, null, null, ''2020-04-19 14:12:44'', null);
INSERT INTO `mall_order_process` VALUES (''1251758721751638017'', ''1251362128338690049'', ''1'', null, ''已经采购'', null, null, ''2020-04-19 14:25:10'', null);
INSERT INTO `mall_order_process` VALUES (''1251760869625356290'', ''1251362128338690049'', ''2'', null, null, '''', '''', ''2020-04-19 14:33:43'', null);

-- ----------------------------
-- Table structure for `mall_template`
-- ----------------------------
DROP TABLE IF EXISTS `mall_template`;
CREATE TABLE `mall_template` (
  `id` bigint(20) NOT NULL,
  `region` varchar(255) DEFAULT NULL COMMENT ''地区'',
  `region_code` varchar(255) DEFAULT NULL COMMENT ''地区编码'',
  `name` varchar(255) DEFAULT NULL COMMENT ''模板名称'',
  `currency_symbol` varchar(255) DEFAULT NULL COMMENT ''货币符号'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mall_template
-- ----------------------------
INSERT INTO `mall_template` VALUES (''1'', ''台湾'', ''NT'', ''台湾模板1'', ''NT＄'', ''2020-04-13 16:02:36'', null);
INSERT INTO `mall_template` VALUES (''2'', ''香港'', ''HK'', ''香港模板1'', ''HK＄'', ''2020-04-13 16:03:13'', null);

-- ----------------------------
-- Table structure for `mall_user`
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT ''姓名'',
  `phone` varchar(11) NOT NULL COMMENT ''手机号'',
  `password` varchar(64) NOT NULL COMMENT ''密码'',
  `status` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''状态 0正常   1禁用'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `deleted_time` datetime DEFAULT NULL COMMENT ''删除时间'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES (''1'', ''刘宏飞'', ''18309225600'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 20:13:14'', null);
INSERT INTO `mall_user` VALUES (''2'', ''Pirate'', ''17382568276'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 22:23:27'', null);
INSERT INTO `mall_user` VALUES (''8'', ''234234'', ''234234'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:22:49'', ''2020-04-14 23:33:42'');
INSERT INTO `mall_user` VALUES (''9'', ''123'', ''123'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:23:09'', ''2020-04-14 23:33:36'');
INSERT INTO `mall_user` VALUES (''10'', ''123'', ''1234'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:23:35'', ''2020-04-14 23:32:53'');
INSERT INTO `mall_user` VALUES (''11'', ''123'', ''12345'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:23:59'', ''2020-04-14 23:33:44'');
INSERT INTO `mall_user` VALUES (''12'', ''123'', ''123123'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:24:25'', ''2020-04-14 23:33:47'');
INSERT INTO `mall_user` VALUES (''13'', ''123'', ''123'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:33:53'', ''2020-04-14 23:34:00'');
INSERT INTO `mall_user` VALUES (''14'', ''123'', ''123'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-14 23:34:03'', ''2020-04-17 20:50:45'');
INSERT INTO `mall_user` VALUES (''15'', ''123123123'', ''123123123'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-17 20:50:57'', ''2020-04-17 20:51:06'');
INSERT INTO `mall_user` VALUES (''16'', ''测试'', ''测试'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-19 11:58:51'', ''2020-04-19 11:58:56'');
INSERT INTO `mall_user` VALUES (''17'', ''123'', ''123'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-19 13:58:52'', ''2020-04-19 13:58:56'');
INSERT INTO `mall_user` VALUES (''18'', ''123'', ''234234'', ''e10adc3949ba59abbe56e057f20f883e'', ''0'', ''2020-04-19 14:00:43'', ''2020-04-19 14:00:46'');
