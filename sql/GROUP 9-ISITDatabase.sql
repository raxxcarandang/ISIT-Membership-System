
CREATE DATABASE `ISITDatabase`;
USE `ISITDatabase` ;

CREATE TABLE IF NOT EXISTS `Member_info` 
(
  `Member_ID` INT NOT NULL,
  `ID_Number` VARCHAR(100) NOT NULL,
  `Year_Level` VARCHAR(100) NOT NULL,
  `First_Name` VARCHAR(100) NOT NULL,
  `Middle_Name` VARCHAR(100) NOT NULL,
  `Surname` VARCHAR(100) NOT NULL,
  `Gender` VARCHAR(100) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `Birthdate` DATETIME NOT NULL,
  `PWD` VARCHAR(100) NOT NULL,
  UNIQUE KEY(`ID_Number`),
  PRIMARY KEY (`Member_ID`)
  );

CREATE  TABLE IF NOT EXISTS `Member_login` 
(
	`Login_ID` INT not null,
	`Member_ID` INT not null,
    `Access_level` varchar(100),
	`username` varchar(100) not null,
	`password` varchar(100) not null,
PRIMARY KEY (`Login_ID`),
FOREIGN KEY(`Member_ID`) REFERENCES `Member_info` (`Member_ID`)
 );

CREATE TABLE IF NOT EXISTS `Guardian_info` 
(
  `Guardian_Record` INT NOT NULL,
  `Guardian_ID` INT NOT NULL,
  `Member_ID` INT,
  `First_Name` VARCHAR(100) NOT NULL,
  `Middle_Name` VARCHAR(100) NOT NULL,
  `Surname` VARCHAR(100) NOT NULL,
  `Gender` VARCHAR(100) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`Guardian_Record`),
    FOREIGN KEY (`Member_ID`) REFERENCES `Member_info` (`Member_ID`)
);

CREATE TABLE IF NOT EXISTS `Organization_info` 
(
  `Organization_Record` INT NOT NULL,
  `Organization_ID` INT NOT NULL,
  `Member_ID` INT,  
  `Organization_Name` VARCHAR(100) NOT NULL,
  `Organization_Address` VARCHAR(100) NOT NULL,
  `Membership_Status` VARCHAR(100) NOT NULL,
  `Join_Date` DATETIME NOT NULL,
  PRIMARY KEY (`Organization_Record`),
  FOREIGN KEY (`Member_ID`) REFERENCES `Member_info` (`Member_ID`)
  );

CREATE TABLE IF NOT EXISTS `Achievement_info` 
(
  `Achievement_Record` INT NOT NULL,
  `Member_ID` INT NOT NULL, 
  `Organization_ID` INT,
  `Achievement_ID` INT NOT NULL,
  `Achievement` VARCHAR(100) NOT NULL,
  `Awarder` VARCHAR(100) NOT NULL,
  `Award_Date` DATETIME,
  PRIMARY KEY (`Achievement_Record`),
  FOREIGN KEY (`Member_ID`) REFERENCES `Member_info` (`Member_ID`)
  );

CREATE TABLE IF NOT EXISTS `Company_info` 
(
  `Company_Record` INT NOT NULL,
  `Company_ID` INT NOT NULL,
  `Member_ID` INT,
  `Job` VARCHAR(100),
  `Company_Name` VARCHAR(100) NOT NULL,
  `Company_Address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Company_Record`),
  FOREIGN KEY (`Member_ID`) REFERENCES `Member_info` (`Member_ID`)
  );

CREATE TABLE IF NOT EXISTS `Contact_info`
(
	`Contact_ID` INT NOT NULL,
	`Member_ID` INT,
	`Guardian_ID` INT,
	`Phone_Number` VARCHAR(100),
	`Email_Address` VARCHAR(100),
	PRIMARY KEY (`Contact_ID`),
	FOREIGN KEY (`Member_ID`) REFERENCES `Member_info` (`Member_ID`)
);

INSERT INTO Member_info (Member_ID, ID_Number,  Year_Level, First_Name, Middle_Name, Surname, Gender, Address, Birthdate, PWD) VALUES ( "1000000", "ADMIN TEST", "ADMIN TEST", "DELETE", "ONCE", "AN ADMIN", "HAS", "BEEN SET", "0001-01-01", "FALSE");
INSERT INTO member_login (Login_ID, Member_ID, Access_level, username, password) VALUES ("1", "1000000", "Admin", "admin", "test");