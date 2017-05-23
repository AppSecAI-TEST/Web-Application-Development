/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buys` (
  `buys_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `spaceship_id` int(11) NOT NULL,
  `trans_cost` double DEFAULT NULL,
  `trans_date` varchar(45) DEFAULT NULL,
  `trans_descrip` longtext,
  `trans_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`buys_id`),
  UNIQUE KEY `transactionID_UNIQUE` (`buys_id`),
  KEY `customer_id_idx` (`customer_id`),
  KEY `spaceship_id_idx` (`spaceship_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `spaceship_id` FOREIGN KEY (`spaceship_id`) REFERENCES `spaceship` (`spaceship_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `logonName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `screenname` varchar(45) NOT NULL,
  `DOB` date DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`),
  UNIQUE KEY `logonName_UNIQUE` (`logonName`),
  KEY `user_role_id_idx` (`user_role_id`),
  CONSTRAINT `user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`user_role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spaceship` (
  `spaceship_id` int(11) NOT NULL AUTO_INCREMENT,
  `modelName` varchar(45) NOT NULL,
  `modelYear` date NOT NULL,
  `color` varchar(45) DEFAULT NULL,
  `maxCapacity` int(11) NOT NULL,
  `price` double NOT NULL,
  `image_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`spaceship_id`),
  UNIQUE KEY `spaceship_id_UNIQUE` (`spaceship_id`),
  UNIQUE KEY `modelName_UNIQUE` (`modelName`),
  UNIQUE KEY `modelYear_UNIQUE` (`modelYear`),
  UNIQUE KEY `color_UNIQUE` (`color`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL,
  `user_role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `userRoleId_UNIQUE` (`user_role_id`),
  UNIQUE KEY `user_role_UNIQUE` (`user_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;