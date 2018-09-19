CREATE DATABASE  IF NOT EXISTS `quiz_data`;
USE `quiz_data`;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tresc_pytania` varchar(150) DEFAULT NULL,
  `odp1` varchar(150) DEFAULT NULL,
  `odp2` varchar(150) DEFAULT NULL,
  `odp3` varchar(45) DEFAULT NULL,
  `poprawna_odp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

