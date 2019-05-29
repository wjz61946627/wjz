-- MySQL dump 10.13  Distrib 8.0.12, for osx10.14 (x86_64)
--
-- Host: localhost    Database: wjz
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `group` (
  `gid` int(4) NOT NULL AUTO_INCREMENT COMMENT '组唯一标识',
  `gname` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '组名称',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (2,'test4'),(3,'test1'),(4,'test4'),(5,'asdf'),(6,'asdfasdfdsfsd'),(7,'asdfasdfdsfsd'),(8,'adfdsfasdfasdfdsfsd'),(9,'adfdsfasdfasdfdsfsd'),(10,'adfdsfasdfasdfdsfsd');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myfile`
--

DROP TABLE IF EXISTS `myfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `myfile` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `uploadtime` timestamp NOT NULL,
  `uploadid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myfile`
--

LOCK TABLES `myfile` WRITE;
/*!40000 ALTER TABLE `myfile` DISABLE KEYS */;
INSERT INTO `myfile` VALUES (6,'2017013120_徐澳澳.zip','2019-05-28 20:09:37',1,9),(7,'2017013123_胡尊豪.zip','2019-05-28 20:09:39',1,9),(8,'2017013129_施红军.zip','2019-05-28 20:29:47',1,9),(9,'2017013118_宋鸿成.zip','2019-05-28 20:36:38',1,9),(10,'2017013122_郭子琳.zip','2019-05-28 20:41:32',1,9);
/*!40000 ALTER TABLE `myfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `project` (
  `pid` int(4) NOT NULL AUTO_INCREMENT,
  `pname` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '项目名称',
  `desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` timestamp NOT NULL,
  `visited` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (9,'ads塞法','阿斯顿发的','2019-05-27 02:01:19',1),(10,'八号楼拆除','因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿因为八号楼地下有矿','2019-05-27 02:05:48',0),(11,'你好','这是一个描述','2019-05-29 06:44:04',1);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project2group`
--

DROP TABLE IF EXISTS `project2group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `project2group` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `pid` int(4) NOT NULL COMMENT '项目id',
  `gid` int(4) NOT NULL COMMENT '组id',
  `access` int(8) NOT NULL DEFAULT '0' COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project2group`
--

LOCK TABLES `project2group` WRITE;
/*!40000 ALTER TABLE `project2group` DISABLE KEYS */;
INSERT INTO `project2group` VALUES (1,9,2,7),(2,9,3,7),(3,9,4,2),(4,9,7,4),(5,9,9,2),(6,9,5,4),(7,11,3,3);
/*!40000 ALTER TABLE `project2group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uid` int(4) NOT NULL AUTO_INCREMENT COMMENT '用户身份唯一标识',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码md5值',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `token` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户登陆临时token',
  `admin` tinyint(1) DEFAULT '0' COMMENT '是否是管理员',
  `timecreate` timestamp NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'50ef62249f03c4110e191084e7584455','admin','913548946@qq.com',NULL,1,'2017-01-31 16:00:00'),(2,'15baaedb643b60e2fd3e7d739ad4e7b9','王彤','913548946@qq.com',NULL,0,'2019-05-10 19:01:26'),(3,'acb30c81403a143141d98c1a36ab371d','wjz',NULL,NULL,0,'2019-05-29 06:38:03'),(4,'d58f5604759d44865fcc73488c4642f9','test','913548946@qq.com',NULL,0,'2019-05-29 06:41:34');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user2group`
--

DROP TABLE IF EXISTS `user2group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user2group` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) NOT NULL COMMENT '用户id',
  `gid` int(4) NOT NULL COMMENT '组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user2group`
--

LOCK TABLES `user2group` WRITE;
/*!40000 ALTER TABLE `user2group` DISABLE KEYS */;
INSERT INTO `user2group` VALUES (2,2,2);
/*!40000 ALTER TABLE `user2group` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-29 22:57:26
