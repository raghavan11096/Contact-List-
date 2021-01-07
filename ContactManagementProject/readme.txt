

ContactList Website Using Java


Language: Java version: 11
Framework: Maven
Database: MySQL 5.1.30, username: root, password: admin
Servlet:Javaxservlet: 3.1.0
Server: Apache Tomcat version 8.0

----------FOR RUNNING THE DATABASE-----------------------------------------------------------
username: root
password: root
Inside Proj folder, find Create.sql
Login to MySQL and run the Create.sql (find the command below)
mysql> source </path/>/ContactList/createschema.sql
The database will be created.


---STARTING THE APPLICATION---
Install Apache Tomcat and Paste the proj.war in the WebApp folder.
Start the Apache Tomcat server
Open http://localhost:8080/Contacts on browser.
The proj.war is found inside proj folder. 
