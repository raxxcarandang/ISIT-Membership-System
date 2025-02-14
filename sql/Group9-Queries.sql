use ISITDatabase;

-- Manual Insertion of Data into the Database
INSERT INTO Member_info (Member_ID, ID_Number,  Year_Level, First_Name, Middle_Name, Surname, Gender, Address, Birthdate, PWD) VALUES ( "1000000", "ADMIN TEST", "ADMIN TEST", "DELETE", "ONCE", "AN ADMIN", "HAS", "BEEN SET", "0001-01-01", "FALSE");
INSERT INTO member_login (Login_ID, Member_ID, Access_level, username, password) VALUES ("1", "1000000", "Admin", "admin", "test");
INSERT INTO Guardian_info (Guardian_Record, Member_ID, Guardian_ID, First_Name, Middle_Name, Surname, Address) VALUES ( "1", "1", "1", "Jesus", "Heaven", "Christ", "Heaven");
INSERT INTO Organization_info (Organization_Record, Member_ID, Organization_ID, Organization_Name, Organization_Address, Membership_Status, Date_Joined) VALUES( "1", "1", "1", "INTEGRATED STUDENTS OF INFORMATION TECHNOLOGY", "LUCBAN", "PREMIUM MEMBER", "2021-10-09");
INSERT INTO achievement_info (Achievement_Record, Organization_ID, Achievement_ID,  Member_ID,  Achievement, Awarder, Award_Date) VALUES ("1", "1", "1", "1", "CERTIFICATE OF RECOGNITION", "ORGANIZATION PRESIDENT", "2022-02-21");
INSERT INTO Company_info (Company_Record, Member_ID, Company_ID, Company_Name, Company_Address) VALUES( "1" ,"1", "1", "AGENTS OF HEAVEN", "HEAVEN");
INSERT INTO Contact_info (Member_ID, Guardian_ID, Contact_ID, Phone_Number, Email_Address) VALUES( "1", "N/A", "1", "09123456789", "test@gmail.com");

-- Manual Viewing of Data from the Database
SELECT * FROM member_login;
SELECT * FROM member_info;
SELECT * FROM guardian_info;
SELECT * FROM organization_info;
SELECT * FROM company_info;
SELECT * FROM contact_info;
SELECT * FROM achievement_info;

-- Manual Updating of Data in the Database
UPDATE Member_info SET ID_Number ="21L-6942", Year_Level ="2ND YEAR", First_Name ="Susan", Middle_Name ="Jane", Surname ="Test", Gender ="Female", Address ="To the Moon", Birthdate ="1999-09-19", PWD ="False" WHERE Member_ID ="1000000";
UPDATE Member_login SET Member_ID ="1000000", Access_level ="ADMIN", username ="admin", password ="test" WHERE Login_ID ="1";
UPDATE Organization_info SET  Organization_Name ="INTEGRATED STUDENTS OF INFORMATION TECHNOLOGY", Organization_Address ="LUCBAN - TAYABAS ROAD" WHERE Organization_ID ="1";
UPDATE Guardian_info SET Guardian_ID ="1", Member_ID ="1000000", First_Name ="Mary", Middle_Name ="Jane", Surname ="Test", Gender ="Female", Address ="Heaven" WHERE Guardian_Record ="1";
UPDATE Contact_info SET Member_ID ="1000000", Guardian_ID ="1", Phone_Number ="09987654321", Email_Address ="tested@yahoo.com" WHERE Contact_ID ="1";
UPDATE Organization_info SET Member_ID ="1000000", Organization_ID ="1", Organization_Name ="ISIT", Organization_Address ="LUCBAN - TAYABAS ROAD", Membership_Status ="MEMBER", Join_Date = "2021-08-07"  WHERE Organization_RECORD ="1";
UPDATE Company_info SET Company_ID =1, Member_ID ="1000000", Company_Name ="N.A.S.A", Job ="Astronaut", Company_Address ="Moon" WHERE Company_Record ="1";

-- Manual Deleting of Data from the Database
DELETE FROM Member_info WHERE Member_ID ="1";
DELETE FROM Member_login WHERE Login_ID ="1";
DELETE FROM Contact_info WHERE Contact_ID ="1";
DELETE FROM Guardian_info WHERE Guardian_Record ="1";
DELETE FROM organization_info WHERE organization_record = "1";
DELETE FROM Achievement_info WHERE Achievement_Record ="1";
DELETE FROM Company_info WHERE Company_Record ="1";
