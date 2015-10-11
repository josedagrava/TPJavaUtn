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

USE `ajedrez`;

#
# Structure for the `jugadores` table : 
#

CREATE TABLE `jugadores` (
  `dni` int(8) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  PRIMARY KEY (`dni`)
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
  PRIMARY KEY (`dniBlancas`,`dniNegras`,`idPartida`),
  KEY `dniBlancas` (`dniBlancas`),
  KEY `dniNegras` (`dniNegras`),
  KEY `idPartida` (`idPartida`),
  CONSTRAINT `partidas_fk1` FOREIGN KEY (`dniBlancas`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `partidas_fk2` FOREIGN KEY (`dniNegras`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

#
# Structure for the `posicion` table : 
#

CREATE TABLE `posicion` (
  `idPartida` int(8) NOT NULL,
  `tipoPieza` char(2) NOT NULL,
  `posicion` char(2) NOT NULL,
  `color` char(6) NOT NULL,
  PRIMARY KEY (`idPartida`,`posicion`),
  KEY `idPartida` (`idPartida`),
  CONSTRAINT `posicion_fk1` FOREIGN KEY (`idPartida`) REFERENCES `partidas` (`idPartida`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `jugadores` table  (LIMIT 0,500)
#

INSERT INTO `jugadores` (`dni`, `nombre`, `apellido`) VALUES 
  (1,'Juan','Gomez'),
  (2,'Paula','Fernandez'),
  (35897455,'Franco','Ferreyra'),
  (36547854,'Ayelen','Romano Bazan'),
  (36589789,'Jose Ignacio','Dagrava');

COMMIT;

#
# Data for the `partidas` table  (LIMIT 0,500)
#

INSERT INTO `partidas` (`dniBlancas`, `dniNegras`, `idPartida`, `dniTurno`, `estadoPartida`) VALUES 
  (1,2,80,1,'Empezado'),
  (1,2,85,1,'Empezado'),
  (2,1,81,2,'Empezado'),
  (2,1,82,2,'Empezado'),
  (2,1,83,2,'Empezado'),
  (2,1,84,2,'Empezado');

COMMIT;

#
# Data for the `posicion` table  (LIMIT 0,500)
#

INSERT INTO `posicion` (`idPartida`, `tipoPieza`, `posicion`, `color`) VALUES 
  (80,'P','A2','N'),
  (80,'T','a6','N'),
  (80,'P','A7','B'),
  (80,'C','B1','N'),
  (80,'P','B2','N'),
  (80,'P','B7','B'),
  (80,'C','B8','B'),
  (80,'A','C1','N'),
  (80,'P','C2','N'),
  (80,'P','C7','B'),
  (80,'A','C8','B'),
  (80,'D','D1','N'),
  (80,'P','D2','N'),
  (80,'P','D7','B'),
  (80,'D','D8','B'),
  (80,'R','E1','N'),
  (80,'P','E2','N'),
  (80,'P','E7','B'),
  (80,'R','E8','B'),
  (80,'A','F1','N'),
  (80,'P','F2','N'),
  (80,'P','f6','B'),
  (80,'A','F8','B'),
  (80,'C','G1','N'),
  (80,'P','G2','N'),
  (80,'P','G7','B'),
  (80,'C','G8','B'),
  (80,'T','h2','B'),
  (80,'P','H7','B'),
  (82,'T','A1','N'),
  (82,'P','A2','N'),
  (82,'P','A7','B'),
  (82,'T','A8','B'),
  (82,'C','B1','N'),
  (82,'P','B2','N'),
  (82,'P','B7','B'),
  (82,'C','B8','B'),
  (82,'A','C1','N'),
  (82,'P','C2','N'),
  (82,'P','C7','B'),
  (82,'A','C8','B'),
  (82,'D','D1','N'),
  (82,'P','D2','N'),
  (82,'P','D7','B'),
  (82,'D','D8','B'),
  (82,'R','E1','N'),
  (82,'P','E2','N'),
  (82,'P','E7','B'),
  (82,'R','E8','B'),
  (82,'A','F1','N'),
  (82,'P','F2','N'),
  (82,'P','F7','B'),
  (82,'A','F8','B'),
  (82,'C','G1','N'),
  (82,'P','G2','N'),
  (82,'P','G7','B'),
  (82,'C','G8','B'),
  (82,'T','H1','N'),
  (82,'P','H2','N'),
  (82,'P','H7','B'),
  (82,'T','H8','B'),
  (83,'T','A1','N'),
  (83,'P','A2','N'),
  (83,'P','A7','B'),
  (83,'T','A8','B'),
  (83,'C','B1','N'),
  (83,'P','B2','N'),
  (83,'P','B7','B'),
  (83,'C','B8','B'),
  (83,'A','C1','N'),
  (83,'P','C2','N'),
  (83,'P','C7','B'),
  (83,'A','C8','B'),
  (83,'D','D1','N'),
  (83,'P','D2','N'),
  (83,'P','D7','B'),
  (83,'D','D8','B'),
  (83,'R','E1','N'),
  (83,'P','E2','N'),
  (83,'P','E7','B'),
  (83,'R','E8','B'),
  (83,'A','F1','N'),
  (83,'P','F2','N'),
  (83,'P','F7','B'),
  (83,'A','F8','B'),
  (83,'C','G1','N'),
  (83,'P','G2','N'),
  (83,'P','G7','B'),
  (83,'C','G8','B'),
  (83,'T','H1','N'),
  (83,'P','H2','N'),
  (83,'P','H7','B'),
  (83,'T','H8','B'),
  (84,'T','A1','N'),
  (84,'P','A2','N'),
  (84,'P','A7','B'),
  (84,'T','A8','B'),
  (84,'C','B1','N'),
  (84,'P','B2','N'),
  (84,'P','B7','B'),
  (84,'C','B8','B'),
  (84,'A','C1','N'),
  (84,'P','C2','N'),
  (84,'P','C7','B'),
  (84,'A','C8','B'),
  (84,'D','D1','N'),
  (84,'P','D2','N'),
  (84,'P','D7','B'),
  (84,'D','D8','B'),
  (84,'R','E1','N'),
  (84,'P','E2','N'),
  (84,'P','E7','B'),
  (84,'R','E8','B'),
  (84,'A','F1','N'),
  (84,'P','F2','N'),
  (84,'P','F7','B'),
  (84,'A','F8','B'),
  (84,'C','G1','N'),
  (84,'P','G2','N'),
  (84,'P','G7','B'),
  (84,'C','G8','B'),
  (84,'T','H1','N'),
  (84,'T','h2','B'),
  (84,'P','H7','B'),
  (85,'T','A1','N'),
  (85,'P','A2','N'),
  (85,'P','A7','B'),
  (85,'T','A8','B'),
  (85,'C','B1','N'),
  (85,'P','B2','N'),
  (85,'P','B7','B'),
  (85,'C','B8','B'),
  (85,'A','C1','N'),
  (85,'P','C2','N'),
  (85,'P','C7','B'),
  (85,'A','C8','B'),
  (85,'D','D1','N'),
  (85,'P','D2','N'),
  (85,'P','D7','B'),
  (85,'D','D8','B'),
  (85,'R','E1','N'),
  (85,'P','E2','N'),
  (85,'P','E7','B'),
  (85,'R','E8','B'),
  (85,'A','F1','N'),
  (85,'P','F2','N'),
  (85,'P','F7','B'),
  (85,'A','F8','B'),
  (85,'C','G1','N'),
  (85,'P','G2','N'),
  (85,'P','G7','B'),
  (85,'C','G8','B'),
  (85,'T','H1','N'),
  (85,'P','H2','N'),
  (85,'P','H7','B'),
  (85,'T','H8','B');

COMMIT;

