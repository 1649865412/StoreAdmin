/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.5.20 : Database - mindo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mindo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mindo`;

/*Table structure for table `cultural_information` */

DROP TABLE IF EXISTS `cultural_information`;

CREATE TABLE `cultural_information` (
  `culturalInformationId` int(10) NOT NULL AUTO_INCREMENT COMMENT '文化资讯表自增长ID',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `textIntroduction` text COMMENT '内容',
  `commentNumber` int(10) DEFAULT NULL COMMENT '评论数',
  `releaseTime` date DEFAULT NULL COMMENT '发布时间',
  `metaKeywork` varchar(20) DEFAULT NULL COMMENT '索引关键字(如有多个，以逗号分隔)',
  `readNumber` int(10) DEFAULT NULL COMMENT '阅读数',
  `writer` varchar(20) DEFAULT NULL COMMENT '作者',
  `type` int(10) DEFAULT NULL COMMENT '类型（0：秀场）（1：访谈）（3：搭配）（4：线下主题活动）（5：月刊）',
  `logoImg` varchar(128) DEFAULT NULL COMMENT 'logo',
  `imgOne` varchar(128) DEFAULT NULL COMMENT '大图一',
  `imgTwo` varchar(128) DEFAULT NULL COMMENT '大图二',
  `brandId` int(10) DEFAULT NULL COMMENT '品牌ID',
  `sortOrder` int(10) DEFAULT NULL COMMENT '排序值（越大越前）',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `videoAddress` varchar(20) DEFAULT NULL COMMENT '视屏地址',
  `backOne` varchar(20) DEFAULT NULL COMMENT '备注',
  `backTwo` varchar(20) DEFAULT NULL COMMENT '备用字段二',
  `state` int(20) DEFAULT NULL COMMENT '发布状态（0：发布，1取消）',
  `recommendArrayId` varchar(30) DEFAULT NULL COMMENT '推荐咨询（格式是ID数组（1，2，3））',
  PRIMARY KEY (`culturalInformationId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cultural_information` */

insert  into `cultural_information`(`culturalInformationId`,`title`,`textIntroduction`,`commentNumber`,`releaseTime`,`metaKeywork`,`readNumber`,`writer`,`type`,`logoImg`,`imgOne`,`imgTwo`,`brandId`,`sortOrder`,`createTime`,`videoAddress`,`backOne`,`backTwo`,`state`,`recommendArrayId`) values (1,'ceshi','<p>dsfsdfsdfsd</p>',1,'2015-06-01','1',1,'xcvvc',0,'','','',1,1,'2015-06-24',NULL,'fdgdfgdg',NULL,NULL,NULL);

/*Table structure for table `monthly_cultural` */

DROP TABLE IF EXISTS `monthly_cultural`;

CREATE TABLE `monthly_cultural` (
  `monthlyCulturalId` int(32) NOT NULL AUTO_INCREMENT COMMENT '文化资讯月刊自增长Id',
  `img` varchar(30) DEFAULT NULL COMMENT '图片链接',
  `createTime` date DEFAULT NULL COMMENT '发布时间',
  `culturalInformationId` int(32) DEFAULT NULL COMMENT '文化资讯列表Id',
  PRIMARY KEY (`monthlyCulturalId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `monthly_cultural` */

/*!50106 set global event_scheduler = 1*/;

/* Event structure for event `truncate_shoppingcart_promotion` */

/*!50106 DROP EVENT IF EXISTS `truncate_shoppingcart_promotion`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`localhost` EVENT `truncate_shoppingcart_promotion` ON SCHEDULE EVERY 1 DAY STARTS '2014-11-20 16:50:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
	    truncate table shoppingcart_promotion;
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
