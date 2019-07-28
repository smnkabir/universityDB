-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: UniversityDB
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `code` varchar(10) NOT NULL,
  `title` varchar(40) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('ACT1021','Introduction to Accounting',3),('CSE1011','Programming Language I (C)',3),('CSE1012','Programming Language I (C) Lab',1),('CSE1013','Computer Fundamentals',3),('CSE1021','Discrete Mathematics',3),('CSE1031','Numerical Methods',3),('CSE1033','Data Structure',3),('CSE1034','Data Structure Lab',1),('CSE2013','Digital Logic Design',3),('CSE2014','Digital Logic Design Lab',1),('CSE2015','Programming Language II(Java)',3),('CSE2016','Programming Language II(Java) Lab',1),('CSE2021','Algorithm',3),('CSE2026','Algorithm Lab',1),('CSE3011','Database Design',3),('CSE3012','Database Design Lab',1),('CSE3013','Microprocessor Design ',3),('CSE3014','Microprocessor Design Lab',1),('CSE3025','Theory of Computing ',3),('ECO2021','Introduction to Economics',3),('EEE1021','Electrical Circuits I',3),('EEE1022','Electrical Circuits I Lab',1),('EEE2011','Electronic Devices And Circuits I',3),('EEE2012','Electronic Devices And Circuits I Lab',1),('ENG1001','Basic Composition',0),('ENG1002','Intermediate Composition',3),('ENG1021','English for Engineer',3),('ETE2023','Communication Theory',3),('ETE2024','Communication Theory Lab',1),('MATH1024','Coordinate Geometry and Vector Analysis',3),('MATH1034','Differential and Integral Calculus',3),('MATH2014','Complex Variables and Transforms',3),('MATH2015','Linear Algebra and Matrics',3),('MGT2011','Introduction to Business & Management',3),('PHY1021','Physics I',3),('PHY1031','Physics II',3),('PHY1034','Physics Lab',1),('SOC2031','Engineering Ethics',3),('STAT2012','Statistical Methods & Probability',3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `stId` varchar(15) NOT NULL,
  `code` varchar(10) NOT NULL,
  `semId` int(11) NOT NULL,
  `lecId` varchar(15) DEFAULT NULL,
  `gpa` double DEFAULT NULL,
  PRIMARY KEY (`stId`,`code`,`semId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES ('2016000000021','ACT1021',1,'tbd',4),('2016000000021','CSE1011',2,'sm',4),('2016000000021','CSE1012',2,'sm',4),('2016000000021','CSE1013',1,'ht',4),('2016000000021','CSE1021',3,'nsk',3.5),('2016000000021','CSE1031',5,'sm',4),('2016000000021','CSE1033',4,'rb',4),('2016000000021','CSE1034',4,'rb',4),('2016000000021','CSE2013',5,'ahq',3.75),('2016000000021','CSE2014',5,'ahq',4),('2016000000021','CSE2015',5,'kmh',4),('2016000000021','CSE2016',5,'kmh',4),('2016000000021','CSE2021',6,'ar',4),('2016000000021','CSE2026',6,'ar',4),('2016000000021','CSE3011',7,'ar',4),('2016000000021','ECO2021',5,'ast',4),('2016000000021','EEE1021',3,'moah',4),('2016000000021','EEE1022',3,'moah',4),('2016000000021','EEE2011',4,'moah',4),('2016000000021','EEE2012',4,'moah',4),('2016000000021','ENG1001',1,'tbd',3.5),('2016000000021','ENG1002',2,'nck',3.25),('2016000000021','ETE2023',6,'mdsr',4),('2016000000021','ETE2024',6,'rda',4),('2016000000021','MATH1024',2,'tbd',4),('2016000000021','MATH1034',1,'dma',4),('2016000000021','MATH2014',3,'sbb',4),('2016000000021','MATH2015',6,'sbb',4),('2016000000021','MGT2011',6,'gta',4),('2016000000021','PHY1021',2,'dhr',4),('2016000000021','PHY1031',3,'dhr',4),('2016000000021','PHY1034',3,'mks',4),('2016000000021','SOC2031',4,'ap',4),('2016000000021','STAT2012',4,'mtar',4),('2016000000085','ACT1021',1,'tbd',3.5),('2016000000085','CSE1011',2,'sm',3.75),('2016000000085','CSE1012',2,'sm',2.5),('2016000000085','CSE1013',1,'ht',3),('2016000000085','CSE1021',3,'nsk',4),('2016000000085','CSE1031',5,'sm',4),('2016000000085','CSE1033',4,'rb',3.5),('2016000000085','CSE1034',4,'rb',3.5),('2016000000085','CSE2013',5,'ahq',3.75),('2016000000085','CSE2014',5,'ahq',4),('2016000000085','CSE2015',5,'kmh',3.5),('2016000000085','CSE2016',5,'kmh',3.75),('2016000000085','CSE2021',6,'ar',3.5),('2016000000085','CSE2026',6,'ar',4),('2016000000085','ECO2021',5,'ast',4),('2016000000085','EEE1021',3,'moah',3.5),('2016000000085','EEE1022',3,'moah',4),('2016000000085','EEE2011',4,'moah',3.75),('2016000000085','EEE2012',4,'moah',4),('2016000000085','ENG1001',1,'tbd',3.75),('2016000000085','ENG1002',2,'nck',4),('2016000000085','ETE2023',6,'mdsr',3.75),('2016000000085','ETE2024',6,'rda',3.75),('2016000000085','MATH1024',2,'tbd',3.5),('2016000000085','MATH1034',1,'dma',3),('2016000000085','MATH2014',3,'sbb',3.25),('2016000000085','MATH2015',6,'sbb',4),('2016000000085','MGT2011',6,'gta',3.5),('2016000000085','PHY1021',2,'dhr',4),('2016000000085','PHY1031',3,'dhr',4),('2016000000085','PHY1034',3,'mks',4),('2016000000085','SOC2031',4,'ap',4),('2016000000085','STAT2012',4,'mtar',4),('2016000000091','ACT1021',1,'tbd',3.5),('2016000000091','CSE1011',2,'sm',4),('2016000000091','CSE1012',2,'sm',3.75),('2016000000091','CSE1013',1,'ht',4),('2016000000091','CSE1021',3,'nsk',3),('2016000000091','CSE1031',5,'sm',4),('2016000000091','CSE1033',4,'rb',3.5),('2016000000091','CSE1034',4,'rb',3.75),('2016000000091','CSE2013',5,'ahq',3.5),('2016000000091','CSE2014',5,'ahq',3.75),('2016000000091','CSE2015',5,'kmh',4),('2016000000091','CSE2016',5,'kmh',3.5),('2016000000091','CSE2021',6,'ar',4),('2016000000091','CSE2026',6,'ar',4),('2016000000091','ECO2021',5,'ast',4),('2016000000091','EEE1021',3,'moah',4),('2016000000091','EEE1022',3,'moah',3.5),('2016000000091','EEE2011',4,'moah',4),('2016000000091','EEE2012',4,'moah',4),('2016000000091','ENG1001',1,'tbd',3.5),('2016000000091','ENG1002',2,'nck',3.25),('2016000000091','ETE2023',6,'mdsr',3.5),('2016000000091','ETE2024',6,'rda',4),('2016000000091','MATH1024',2,'tbd',4),('2016000000091','MATH1034',1,'dma',3.5),('2016000000091','MATH2014',3,'sbb',4),('2016000000091','MATH2015',6,'sbb',3.5),('2016000000091','MGT2011',6,'gta',4),('2016000000091','PHY1021',2,'dhr',4),('2016000000091','PHY1031',3,'dhr',4),('2016000000091','PHY1034',3,'mks',3.75),('2016000000091','SOC2031',4,'ap',4),('2016000000091','STAT2012',4,'mtar',4);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester`
--

DROP TABLE IF EXISTS `semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semester` (
  `id` int(11) NOT NULL,
  `title` varchar(30) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester`
--

LOCK TABLES `semester` WRITE;
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` VALUES (1,'Spring','2016'),(2,'Summer','2016'),(3,'Fall','2016'),(4,'Spring','2017'),(5,'Summer','2017'),(6,'Fall','2017'),(7,'Spring','2018');
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` varchar(15) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('2016000000021','Fahmida','Mohakhali','lebu@gmail.com','lebu'),('2016000000085','Nazmul Mridul','Mirpur','nm@gmail.com','nazmul'),('2016000000089','Shiddique shuvo','Uttara','forsha@gmail.com','aaaaa'),('2016000000091','Ali Hossain Sagar','Uttara','lxsagor@gmail.com','saaab'),('2016000000096','S. M. Nazmul Kabir','Khilkhet','nk@gmail.com','abcde'),('a','a','a','a@gmail.com','a');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` varchar(15) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('ar','Ashiqur Rahman','Banani','ar@gmail.com','ar'),('raj','Roksana Akter','Banani','raj@gmail.com','raj');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-13  2:21:37
