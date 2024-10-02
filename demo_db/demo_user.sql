-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.37-0ubuntu0.23.10.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'anhtan@gmail.com','Anh Tan','$2a$10$Q3w6ngSgD.MekW4cDigFXuFOrKG2kA.YEahTo0GjabD9CZPCJtTxW',NULL),(52,'xuanthai@gmail.com','Xuan Thai','$2a$10$Hhn8kRuO3caTITjb/95R4e6oIhU0DQTNW2RyxXGkQTo2ndIsyOyfi',NULL),(102,'trungquan@gmail.com','Trung Quan','$2a$10$NvP0bLXwy74lcKhuXePrleR1/OZXtZReo9eHBuJaa3Ortu1CyCY2.',NULL),(152,'nhutuan@gmail.com','Nhu Tuan','$2a$10$ScVmSVNDzHl1v6Gjhr33C.zAeT6BG3KHugDdjAU96z0XdD6v4WBNi',NULL),(202,'anhtai@gmail.com','Anh Tai','$2a$10$uCWPOt9YUl/BQDv7vmoAA.0ePVbafPObcpLRx0FVS.ZfY2jj8TLdC',NULL),(252,'khanhnguyen@gmail.com','Khanh Nguyen','$2a$10$HsilKvavLvhH1t6R5Qa8IOo78wQ3lJKFPcdBGpEt4JsfPSN2w2Eke',NULL),(302,'baolong@gmail.com','Bao Long','$2a$10$d6xrdBuPiX2pvamWFSzlCe0q6eF49gQ3gT1gaqYz8n6RcPTVDUlH.',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 22:53:57
