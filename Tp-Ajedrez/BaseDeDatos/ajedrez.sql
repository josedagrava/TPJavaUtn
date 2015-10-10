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
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `partidas` table : 
#

CREATE TABLE `partidas` (
  `dniBlancas` int(8) NOT NULL,
  `dniNegras` int(8) NOT NULL,
  `idPartida` int(8) NOT NULL auto_increment,
  `dniTurno` int(8) default NULL,
  `estadoPartida` varchar(9) default NULL,
  PRIMARY KEY  (`dniBlancas`,`dniNegras`,`idPartida`),
  KEY `dniBlancas` (`dniBlancas`),
  KEY `dniNegras` (`dniNegras`),
  KEY `idPartida` (`idPartida`),
  CONSTRAINT `partidas_fk1` FOREIGN KEY (`dniBlancas`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `partidas_fk2` FOREIGN KEY (`dniNegras`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `posicion` table : 
#

CREATE TABLE `posicion` (
  `idPartida` int(8) NOT NULL,
  `tipoPieza` char(2) NOT NULL,
  `posicion` char(2) NOT NULL,
  `color` char(6) NOT NULL,
  PRIMARY KEY  (`idPartida`,`posicion`),
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
  (1,2,77,1,'Empezado'),
  (1,36547854,2,1,'Empezado'),
  (2,1,20,2,'Empezado'),
  (35897455,36547854,1,35897456,'Empezado');

COMMIT;

#
# Data for the `posicion` table  (LIMIT 0,500)
#

INSERT INTO `posicion` (`idPartida`, `tipoPieza`, `posicion`, `color`) VALUES 
  (77,'T','A1','N'),
  (77,'P','A2','N'),
  (77,'P','A7','B'),
  (77,'T','A8','B'),
  (77,'C','B1','N'),
  (77,'P','B2','N'),
  (77,'P','B7','B'),
  (77,'C','B8','B'),
  (77,'A','C1','N'),
  (77,'P','C2','N'),
  (77,'P','C7','B'),
  (77,'A','C8','B'),
  (77,'D','D1','N'),
  (77,'P','D2','N'),
  (77,'P','D7','B'),
  (77,'D','D8','B'),
  (77,'R','E1','N'),
  (77,'P','E2','N'),
  (77,'P','E7','B'),
  (77,'R','E8','B'),
  (77,'A','F1','N'),
  (77,'P','F2','N'),
  (77,'P','F7','B'),
  (77,'A','F8','B'),
  (77,'C','G1','N'),
  (77,'P','G2','N'),
  (77,'P','G7','B'),
  (77,'C','G8','B'),
  (77,'T','H1','N'),
  (77,'P','H2','N'),
  (77,'P','H7','B'),
  (77,'T','H8','B');

COMMIT;

