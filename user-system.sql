/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.30-log : Database - user_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `resource` */

CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(50) DEFAULT NULL COMMENT '地址',
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

/*Data for the table `resource` */

insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (1,'用户管理','/user',0,NULL,NULL,1);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (2,'用户添加','/userEdit',1,NULL,NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (3,'用户修改','/userEdit',1,NULL,NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (4,'用户删除','/user',1,NULL,NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (5,'用户查询','/user',1,NULL,NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (6,'角色管理','/role',0,NULL,NULL,2);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (7,'角色添加','/roleEdit',6,NULL,NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (8,'角色修改','/roleEdit',6,NULL,NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (12,'角色查询','/role',6,'2020-07-07 16:23:28','2020-07-09 10:17:27',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (13,'角色删除','/roleDelete',6,'2020-07-07 16:23:46','2020-07-07 16:27:44',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (14,'角色授权','/editRoleOfResource',6,'2020-07-07 16:24:11','2020-07-09 10:17:29',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (15,'资源管理','/resource',6,'2020-07-07 16:24:41','2020-07-09 10:17:31',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (16,'资源添加','/resourceEdit',6,'2020-07-07 16:25:15','2020-07-12 17:33:40',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (17,'资源删除','/resource',6,'2020-07-07 16:25:37','2020-07-12 17:33:34',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (19,'资源修改','/resourceEdit',6,'2020-07-07 16:26:09','2020-07-12 17:33:27',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (20,'资源查询','/resource',6,'2020-07-07 16:27:05','2020-07-12 17:32:59',NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (22,'Test','/233',0,'2020-07-13 17:27:57',NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (24,'设置','/setting',0,'2020-07-13 18:00:50',NULL,3);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (25,'帮助','/help',0,'2020-07-13 18:01:02',NULL,4);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (29,'主页','/index',0,'2020-07-13 18:42:13',NULL,NULL);
insert  into `resource`(`id`,`name`,`url`,`pid`,`create_time`,`update_time`,`order_number`) values (30,'角色编辑','/authorize',6,'2020-07-13 18:49:28',NULL,NULL);

/*Table structure for table `role` */

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `remark` text,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`remark`,`create_time`,`update_time`) values (1,'超级管理员','拥有全站最高权限，能够修改编辑任何东西。','2020-07-03 14:58:51','2020-07-08 11:19:11');
insert  into `role`(`id`,`name`,`remark`,`create_time`,`update_time`) values (2,'管理员','普通的账号管理员，拥有部分可控权限','2020-07-03 15:00:43','2020-07-07 08:29:42');
insert  into `role`(`id`,`name`,`remark`,`create_time`,`update_time`) values (3,'普通用户','拥有最普通的权限,只能查看页面，无法做出修改','2020-07-03 15:00:52','2020-07-07 15:41:31');

/*Table structure for table `role_resource` */

CREATE TABLE `role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `role_resource` */

insert  into `role_resource`(`role_id`,`resource_id`) values (1,2);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,3);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,4);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,5);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,6);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,7);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,8);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,12);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,13);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,14);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,15);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,16);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,17);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,19);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,20);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,21);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,1);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,1);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,2);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,3);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,4);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,5);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,21);
insert  into `role_resource`(`role_id`,`resource_id`) values (3,21);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,24);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,25);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,28);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,28);
insert  into `role_resource`(`role_id`,`resource_id`) values (3,28);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,29);
insert  into `role_resource`(`role_id`,`resource_id`) values (1,30);
insert  into `role_resource`(`role_id`,`resource_id`) values (2,29);
insert  into `role_resource`(`role_id`,`resource_id`) values (3,29);

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `login_name` varchar(50) NOT NULL,
  `login_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role_id` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_user_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (1,'雷普稀','admin','123',1,'2020-07-01 15:46:47','2020-07-09 15:46:52');
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (2,'张三','11','11',2,'2020-07-09 15:47:04','2020-07-09 16:57:28');
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (5,'张2','admin1','1111',3,'2020-07-09 16:54:34','2020-07-13 16:55:31');
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (6,'chino','admin011','11',1,'2020-07-09 17:06:16','2020-07-09 18:20:30');
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (9,'1','1','1',3,'2020-07-09 21:13:33',NULL);
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (10,'11','11','11',3,'2020-07-09 21:13:39','2020-07-09 21:13:57');
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (11,'111','111','111',3,'2020-07-09 21:27:43',NULL);
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (13,'121','121','121',3,'2020-07-09 21:27:59',NULL);
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (14,'112','112','112',3,'2020-07-09 21:28:04',NULL);
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (15,'223','223','223',3,'2020-07-09 21:28:10',NULL);
insert  into `user`(`id`,`name`,`login_name`,`login_password`,`role_id`,`create_time`,`update_Time`) values (16,'2233','2233','2233',3,'2020-07-09 21:28:17',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
