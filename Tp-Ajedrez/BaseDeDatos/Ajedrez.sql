# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : ajedrez


SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `ajedrez`;

CREATE DATABASE `ajedrez`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

#
# Structure for the `jugadores` table : 
#

CREATE TABLE `jugadores` (
  `dni` int(8) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  PRIMARY KEY (`dni`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `partidas` table : 
#

CREATE TABLE `partidas` (
  `dniBlancas` int(8) NOT NULL,
  `dniNegras` int(8) NOT NULL,
  `idPartida` int(8) NOT NULL AUTO_INCREMENT,
  `dniTurno` int(8) DEFAULT NULL,
  `estadoPartida` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`dniBlancas`,`dniNegras`,`idPartida`) USING BTREE,
  KEY `dniBlancas` (`dniBlancas`) USING BTREE,
  KEY `dniNegras` (`dniNegras`) USING BTREE,
  KEY `idPartida` (`idPartida`) USING BTREE,
  CONSTRAINT `partidas_fk1` FOREIGN KEY (`dniBlancas`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `partidas_fk2` FOREIGN KEY (`dniNegras`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Structure for the `posicion` table : 
#

CREATE TABLE `posicion` (
  `idPartida` int(8) NOT NULL,
  `tipoPieza` char(2) NOT NULL,
  `posicion` char(2) NOT NULL,
  `estaEnTablero` tinyint(1) DEFAULT NULL,
  `color` char(6) NOT NULL,
  PRIMARY KEY (`idPartida`,`tipoPieza`,`color`) USING BTREE,
  KEY `idPartida` (`idPartida`) USING BTREE,
  CONSTRAINT `posicion_fk` FOREIGN KEY (`idPartida`) REFERENCES `partidas` (`idPartida`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `jugadores` table  (LIMIT 0,500)
#

INSERT INTO `jugadores` (`dni`, `nombre`, `apellido`) VALUES 
  (1,'Jose','Dagrava'),
  (2,'Franco','Ferreyra'),
  (35897456,'Franco','Ferreyra'),
  (36547854,'Ayelen','Romano Bazan'),
  (36589789,'Jose Ignacio','Dagrava');

COMMIT;

#
# Data for the `partidas` table  (LIMIT 0,500)
#

INSERT INTO `partidas` (`dniBlancas`, `dniNegras`, `idPartida`, `dniTurno`, `estadoPartida`) VALUES 
  (1,2,5,1,'Empezado');

COMMIT;

