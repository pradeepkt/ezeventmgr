/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  t.pradeepkumar
 * Created: May 11, 2016
 */

CREATE DATABASE `EzEvents` /*!40100 DEFAULT CHARACTER SET big5 */;

CREATE TABLE `Contact` (
  `idContact` int(11) NOT NULL,
  `Name` varchar(256) DEFAULT NULL,
  `Email` varchar(256) DEFAULT NULL,
  `Mobile` varchar(256) DEFAULT NULL,
  `Phone` varchar(256) DEFAULT NULL,
  `AddressOffice` varchar(512) DEFAULT NULL,
  `AddressHome` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`idContact`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;


CREATE TABLE `Vendor` (
  `idVendor` int(11) NOT NULL,
  `Business` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`idVendor`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;


CREATE TABLE `User` (
  `idUser` int(11) NOT NULL,
  `contactID` int(11) DEFAULT NULL,
  `listEvents` varchar(512) DEFAULT NULL,
  `userRole` varchar(128) DEFAULT NULL,
  `VendorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  KEY `idContact_idx` (`contactID`),
  KEY `idVendor_idx` (`VendorID`),
  CONSTRAINT `idContact` FOREIGN KEY (`contactID`) REFERENCES `Contact` (`idContact`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idVendor` FOREIGN KEY (`VendorID`) REFERENCES `Vendor` (`idVendor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=big5;


CREATE TABLE `User` (
  `idUser` int(11) NOT NULL,
  `contactID` int(11) DEFAULT NULL,
  `listEvents` varchar(512) DEFAULT NULL,
  `userRole` varchar(128) DEFAULT NULL,
  `VendorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  KEY `idContact_idx` (`contactID`),
  KEY `idVendor_idx` (`VendorID`),
  CONSTRAINT `idContact` FOREIGN KEY (`contactID`) REFERENCES `Contact` (`idContact`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idVendor` FOREIGN KEY (`VendorID`) REFERENCES `Vendor` (`idVendor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=big5;
