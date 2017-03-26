# javaDemoForAyyeka

Abstract

   This is a demo Java code for a Model (part of MVC), which can be used in a server which
   stores and aggregates information arriving from smart sensors.
   Currently, these smart sensors measure temprature every 5 minutes and every hour they
   send list of measures to the server.
   This demo code uses Java 8, Eclipse, Maven, SQLite DB, Apache iBatis (SQL mapper framework now called MyBatis).

   Notes:  1. For now, only parts of the code can run as this is only partial code example.
           2. Later, Spring can be added (light application framework and inversion of control (IoC) container)      


Suggested walkthrough for reviewing

1. Watch the simple database diagram screenshot.
      This schema only contains the tables and primary keys.
      Later it can be updated indexes, relations, maybe triggers.      

2.                                         
                                         
3. Read the com.ayyeka.server.model.unitTests.MeasuresHandlerTest
      This test demonstrates how a Conroller (part of MVC) can add measures to persistency using
      the MeasureHandler interface and the MeasuresHandlerUsingIbatisImpl implementor class. 
 
4. Open the project in Eclipse and read the code (compiles well).       




