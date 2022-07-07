Drop database BloodDonation;
Create database BloodDonation;
USE BloodDonation; 

CREATE TABLE Donor ( 
 dSSN INTEGER NOT NULL PRIMARY KEY, 
 dname VARCHAR(100), 
 PhoneNumber VARCHAR(100), 
 Address VARCHAR(100), 
 DateofBirth DATE, 
 Gender varchar(10), 
 BloodType varchar(3), 
 BloodHGB INTEGER, 
 Eligibletodonate varchar(3)); 
 
 CREATE TABLE BloodReceiver ( 
 rSSN INTEGER NOT NULL PRIMARY KEY, 
 rName VARCHAR(100), 
 PhoneNumber VARCHAR(100), 
 Address VARCHAR(100), 
 DateofBirth DATE, 
 Gender varchar(10), 
 BloodType varchar(3));
  
 CREATE TABLE Donation ( 
 ID INTEGER NOT NULL PRIMARY KEY, 
 dSSN INTEGER NOT NULL, 
 DateofDonation DATE,
 BloodType varchar(3), 
 BloodTypeQuantity INTEGER, 
 Hospital VARCHAR(100), 
 Doctor VARCHAR(100),
 FOREIGN KEY (dSSN) REFERENCES Donor(dSSN)); 
 
 CREATE TABLE BloodReceiving ( 
 ID INTEGER NOT NULL PRIMARY KEY, 
 rSSN INTEGER NOT NULL, 
 DateofReceiving DATE,
 BloodType varchar(3), 
 BloodTypeQuantity INTEGER, 
 Hospital VARCHAR(100), 
 Doctor VARCHAR(100),
 FOREIGN KEY (rSSN) REFERENCES BloodReceiver(rSSN)); 
 
 select * from Donor;
 select * from BloodReceiver;
 select * from Donation;
 select * from BloodReceiving;