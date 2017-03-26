# Java Demo for Ayyeka by Eli Isaak

Abstract

   This is a demo Java code for a Model (part of MVC), which can be used in a server which
   stores and aggregates information arriving from smart sensors.
   Currently, these smart sensors measure temprature every 5 minutes and every hour they
   send list of measures to the server.
   This demo code uses Java 8, Eclipse, Maven, MySQL DB, Apache iBatis (SQL mapper framework with connections-pool now called MyBatis).

   Notes:
   <br/>
      1. For now, only parts of the code can run as this is only partial code example.
   <br/>
      2. Later, Spring can be added (light application framework and inversion of control (IoC) container)      
   <br/>

<br/>

Suggested walkthrough

   1. View the simple database diagram screenshot.
        For now, this schema only contains the tables and primary keys.
        Later it can be updated with indexes, relations, maybe triggers, or even store-procedures.      

   2. View the Eclipse project screenshot.
         
         You will see there:  
             
             2 root packages: api and persistency.
             
             Persistency package contains packages for DataAccessObjects (DAO) and DataTransferObjects (DTO)
             according to DAO design pattern.
             
             XML files which define queries for iBatis against MySQL (system deployer can easily change them). 
                                         
   3. Read the com.ayyeka.server.model.unitTests.MeasuresHandlerTest
      This test demonstrates how a Conroller (part of MVC) can add measures to persistency using
      the MeasureHandler interface and the MeasuresHandlerUsingIbatisImpl implementor class. 
 
   4. Open the project in Eclipse and read the code (compiles well).       




