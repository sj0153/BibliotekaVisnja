/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 10.4.13-MariaDB : Database - biblioteka
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biblioteka` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `biblioteka`;

/*Table structure for table `clanovi` */

DROP TABLE IF EXISTS `clanovi`;

CREATE TABLE `clanovi` (
  `IDC` varchar(10) NOT NULL,
  `Ime` varchar(30) DEFAULT NULL,
  `Prezime` varchar(30) DEFAULT NULL,
  `JMBG` varchar(13) DEFAULT NULL,
  `BrojLicneKarte` varchar(9) DEFAULT NULL,
  `KontaktTelefon` varchar(13) DEFAULT NULL,
  `Imejl` varchar(30) DEFAULT NULL,
  `Adresa` varchar(50) DEFAULT NULL,
  `PrivremenaAdresa` varchar(50) DEFAULT NULL,
  `Zanimanje` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `clanovi` */

insert  into `clanovi`(`IDC`,`Ime`,`Prezime`,`JMBG`,`BrojLicneKarte`,`KontaktTelefon`,`Imejl`,`Adresa`,`PrivremenaAdresa`,`Zanimanje`) values 
('1096804730','Mateja','Djordjevic','8378491026473','918374658','+381656565655','mateja.car@gmail.com','Marsala Tita 18','','softverski inzenjer'),
('2247403742','Igor','Jovanovic','8729458690153','873945876','0616161611','','Teslina 33','',''),
('4754710523','Srba','Spasic','8746290487163','','0677778765','srbaspasic@gmail.com','Topovska 18','','Glumac'),
('8751026313','Zeljko','Tripkovic','8739046271839','849507839','0656565655','zt@gmail.com','Micka Krstica 14','','obucar'),
('9011209905','Mirko','Vujadinovic','8837495681647','986374856','0626262622','mirkov@gmail.com','Dolinska 8','','Drvoseca'),
('9675489373','Mika','Mikic','1879472764041','877663809','0606060600','mika.mikic@gmail.com','Partizanska 8','','bagerista');

/*Table structure for table `knjige` */

DROP TABLE IF EXISTS `knjige`;

CREATE TABLE `knjige` (
  `IDK` varchar(10) NOT NULL,
  `Naziv` varchar(50) DEFAULT NULL,
  `Autor` varchar(50) DEFAULT NULL,
  `Kategorija` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `knjige` */

insert  into `knjige`(`IDK`,`Naziv`,`Autor`,`Kategorija`) values 
('1234234023','Zlocin i kazna','Fjodor Dostojevski','Roman, Klasik'),
('1234567891','Jadnici','Fjodor Dostojevski','Roman'),
('1238599239','Jadnici','Fjodor Dostojevski','Roman'),
('1723481238','O razvoju licnosti','Carl Jung','Psihologija'),
('1987654321','Kockar','Fjodor Dostojevski','Roman'),
('2239219311','Don Kihot','Migel de Servantes','Roman'),
('2348593424','Dobro i zlo','Fridrih Nice','Filozofija'),
('3296144666','Sapijens','Juval Noa Harari','nauka'),
('3759345939','Tako je govorio Zaratustra','Fridrih Nice','Filozofija'),
('3984712949','Zlocin i kazna','Fjodor Dostojevski','Roman, Klasik'),
('4353509093','Covek i njegovi simboli','Carl Jung','Psihologija'),
('5927635856','Sapijens','Juval Noa Harari','nauka'),
('6381034923','Zlocin i kazna','Fjodor Dostojevski','Roman, Klasik'),
('7435729928','Antihrist','Fridrih Nice','Filozofija'),
('8234293210','Zlocin i kazna','Fjodor Dostojevski','Roman, Klasik'),
('8239234592','Arhetipovi i kolektivno nesvesno','Carl Jung','Psihologija'),
('8374990716','Idiot 1','Fjodor Dostojevski','Roman'),
('8439238924','Crvena knjiga','Carl Jung','Psihologija'),
('8673916258','Braca Karamazov','Fjodor Dostojevski','Roman'),
('9033287520','Don Kihot','Migel de Servantes','Roman'),
('9384020921','Kockar','Fjodor Dostojevski','Roman'),
('9837485967','Idiot 2','Fjodor Dostojevski','Roman');

/*Table structure for table `potvrde` */

DROP TABLE IF EXISTS `potvrde`;

CREATE TABLE `potvrde` (
  `IDP` varchar(10) NOT NULL,
  `DatumIzdavanja` date DEFAULT NULL,
  `RokZaVracanje` date DEFAULT NULL,
  `DatumVracanja` date DEFAULT NULL,
  `zaposleni` varchar(10) DEFAULT NULL,
  `clan` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDP`),
  KEY `izdato` (`clan`),
  KEY `kreirao` (`zaposleni`),
  CONSTRAINT `izdato clanu` FOREIGN KEY (`clan`) REFERENCES `clanovi` (`IDC`) ON UPDATE CASCADE,
  CONSTRAINT `kreirao` FOREIGN KEY (`zaposleni`) REFERENCES `zaposleni` (`IDZ`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `potvrde` */

insert  into `potvrde`(`IDP`,`DatumIzdavanja`,`RokZaVracanje`,`DatumVracanja`,`zaposleni`,`clan`) values 
('1263758502','2022-02-16','2022-02-26','2022-02-16','9876543210','1096804730'),
('3665215418','2022-02-16','2022-02-26',NULL,'9876543210','4754710523'),
('3849238492','2021-12-09','2021-12-19','2021-12-30','8023457128','4754710523'),
('5235881290','2022-02-17','2022-02-27','2022-02-17','9876543210','9011209905'),
('5799384538','2021-12-29','2022-01-18','2022-01-16','9876543210','9011209905'),
('6024870533','2021-12-29','2022-01-08','2022-02-11','9876543210','9675489373'),
('7147136489','2022-02-11','2022-02-21',NULL,'9876543210','9011209905'),
('8271129211','2021-12-29','2022-01-28','2022-01-12','9876543210','8751026313'),
('9233645909','2021-12-29','2022-01-18',NULL,'9876543210','2247403742');

/*Table structure for table `stavke` */

DROP TABLE IF EXISTS `stavke`;

CREATE TABLE `stavke` (
  `potvrda` varchar(10) NOT NULL,
  `RBStavke` int(1) NOT NULL,
  `Napomena` varchar(300) DEFAULT NULL,
  `knjiga` varchar(10) DEFAULT NULL,
  KEY `primerak` (`knjiga`),
  KEY `pripada potvrdi` (`potvrda`),
  CONSTRAINT `primerak` FOREIGN KEY (`knjiga`) REFERENCES `knjige` (`IDK`),
  CONSTRAINT `pripada potvrdi` FOREIGN KEY (`potvrda`) REFERENCES `potvrde` (`IDP`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavke` */

insert  into `stavke`(`potvrda`,`RBStavke`,`Napomena`,`knjiga`) values 
('6024870533',1,NULL,'7435729928'),
('5799384538',1,NULL,'1723481238'),
('5799384538',2,NULL,'8673916258'),
('8271129211',1,NULL,'3759345939'),
('8271129211',2,NULL,'1723481238'),
('8271129211',3,NULL,'9384020921'),
('9233645909',1,NULL,'8239234592'),
('9233645909',2,NULL,'4353509093'),
('3849238492',1,'evo neka napomena','8374990716'),
('7147136489',1,NULL,'8673916258'),
('1263758502',1,'null','7435729928'),
('3665215418',1,'null','1234234023'),
('5235881290',1,'null','8439238924');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `IDZ` varchar(10) NOT NULL,
  `Ime` varchar(30) DEFAULT NULL,
  `Prezime` varbinary(30) DEFAULT NULL,
  `Username` varchar(30) DEFAULT NULL,
  `Password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`IDZ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`IDZ`,`Ime`,`Prezime`,`Username`,`Password`) values 
('8023457128','Stefan','Nemanja','prvi kralj','prvi kralj'),
('9876543210','Stefan','Jovanovic','admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
