# Overview
This is a simple CRUD application with core CRUD functionality
- Database uses MySQL 
- Java API with JPA
- Angular frontend

# Database

This folder has a createDB.sql file, which should be run first (this sets up the database)
Second to run is dbSchemaSetupFINAL.sql (this creates all the tables properly)
Finally, run mockData.sql (this fills out data)

- NOTE: The application.properties file found in the Personnel-Management-App folder project assumes the login and password are both "root" for the database. Modify this as needed.
- SQL DB should run on port 3306 (can be changed in application.properties if needed)

# API

The API should run on port 8080 since the frontend assumes localhost 8080