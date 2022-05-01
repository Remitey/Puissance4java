-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: puissance4
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `cpu`
--

DROP TABLE IF EXISTS `cpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpu` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(20) DEFAULT NULL,
  `DEPTH` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu`
--

LOCK TABLES `cpu` WRITE;
/*!40000 ALTER TABLE `cpu` DISABLE KEYS */;
/*!40000 ALTER TABLE `cpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PLAYER_1` int DEFAULT NULL,
  `PLAYER_2` int DEFAULT NULL,
  `CPU` int DEFAULT NULL,
  `GRID_SIZE_row` int DEFAULT NULL,
  `GRID_SIZE_col` int DEFAULT NULL,
  `RESULT` int DEFAULT NULL,
  `datetime_start` bigint DEFAULT NULL,
  `DURATION` time DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Fk_Game_player1` (`PLAYER_1`),
  KEY `Fk_Game_player2` (`PLAYER_2`),
  KEY `Fk_Game_cpu` (`CPU`),
  CONSTRAINT `Fk_Game_cpu` FOREIGN KEY (`CPU`) REFERENCES `cpu` (`ID`),
  CONSTRAINT `Fk_Game_player1` FOREIGN KEY (`PLAYER_1`) REFERENCES `player` (`ID`),
  CONSTRAINT `Fk_Game_player2` FOREIGN KEY (`PLAYER_2`) REFERENCES `player` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (5,8,9,NULL,6,7,NULL,1651416267842,NULL);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `PERMISSION` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (8,'thotho','lad@yahhoo.fr','7c4a8d09ca3762af61e59520943dc26494f8941b',2),(9,'dhodho','lad@yahhoo.fr','7c4a8d09ca3762af61e59520943dc26494f8941b',2);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turn`
--

DROP TABLE IF EXISTS `turn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turn` (
  `GAME_ID` int NOT NULL,
  `TURN` int NOT NULL AUTO_INCREMENT,
  `PLAYER_ID` int DEFAULT NULL,
  `X` int DEFAULT NULL,
  `Y` int DEFAULT NULL,
  PRIMARY KEY (`TURN`,`GAME_ID`),
  KEY `Fk_Game_player` (`PLAYER_ID`),
  CONSTRAINT `Fk_Game_player` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turn`
--

LOCK TABLES `turn` WRITE;
/*!40000 ALTER TABLE `turn` DISABLE KEYS */;
/*!40000 ALTER TABLE `turn` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-01 16:49:01
