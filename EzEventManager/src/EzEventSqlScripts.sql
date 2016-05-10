/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  t.pradeepkumar
 * Created: May 11, 2016
 */
DROP TABLE IF EXISTS `Contact`;
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

