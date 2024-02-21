-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `empleadosfarmacia`
--

DROP TABLE IF EXISTS `empleadosfarmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleadosfarmacia` (
  `id_EmpleadosFarmacia` varchar(10) NOT NULL,
  `Nombre` varchar(64) NOT NULL,
  `Apellido` varchar(64) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Edad` int NOT NULL,
  `Turno` varchar(16) NOT NULL,
  `Sueldo` int NOT NULL,
  `TituloUniversitario` varchar(2) NOT NULL,
  PRIMARY KEY (`id_EmpleadosFarmacia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadosfarmacia`
--

LOCK TABLES `empleadosfarmacia` WRITE;
/*!40000 ALTER TABLE `empleadosfarmacia` DISABLE KEYS */;
INSERT INTO `empleadosfarmacia` VALUES ('EMPL','Ximena','Garza','F',27,'Matutino',6800,'Si'),('EMPL1','Ximena','Garza','F',27,'Matutino',6800,'Si'),('EMPL2','Walter','Sylva','M',21,'Vespertino',3100,'Si'),('EMPL3','Alexis','Elizalde','M',24,'Matutino',1200,'No'),('EMPL4','Ingrid','Coppel','F',30,'Vespertino',7800,'Si'),('EMPL5','Eduardo','Lara','M',18,'Vespertino',1350,'No'),('EMPL6','Manuel','Amador','M',25,'Matutino',2800,'Si');
/*!40000 ALTER TABLE `empleadosfarmacia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-28  0:34:39
