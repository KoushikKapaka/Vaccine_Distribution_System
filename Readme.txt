Vaccination Distribution System is a simple java project using Swing and JDBC to store the data
of the vaccinated persons into a database with age validation and days between two doses validation.
MYSQL database is used to store the data using JDBC.

Used Technologies:
->Eclipse IDE(4.21.0)
->JDBC (8.0.27)
->MYSQL (8.0.27)
->JDK (17.0.1)

Prerequisites:
-->Database setup
Run the following queries:
>create database vds;
> use vds;
> create table cvdata(name varchar(30),phone char(10),aadharno char(15),Age int(3),
FDose char(3),Fdate date,SDose char(3),Sdate date);
> create table csdata(name varchar(30),phone char(10),aadharno char(15),Age int(3),
FDose char(3),Fdate date,SDose char(3),Sdate date);
-->JDBC is already added to the CLASSPATH in project, no need to add.
-->Kindly add your database passwords into pass variable before executing  in CVdetailsPanelUI, 
CSdetailsPanelUI, CSData and CVData.
