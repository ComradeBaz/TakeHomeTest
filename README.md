# TakeHomeTest

Candidate Java Coding ExerciseExpectation is for the candidate to take approx. 4 hrs 
Create a simple application with database access;
Based on an input from the user provide the following functionality;
Provide a console application to do the following:
1. Add Person (id, firstName, lastName)
2. Edit Person (firstName, lastName)
3. Delete Person (id)
4. Add Address to person [multiple required] (id, street, city, state, postalCode)
5. Edit Address (street, city, state, postalCode)
6. Delete Address (id)
7. Count Number of Persons
8. List Persons

## To Build

Run mvn clean install from the root folder of the project

## To Run

Navigate to /target and run "java -jar app-0.0.1-SNAPSHOT.jar prod"

## How to Manage existing Persons and Addresses

The ID for persons and addresses can be found by listing the entities (Menu Items 8 and 9)
To edit or delete a person or address, search by the ID

## Technologies

Java(TM) SE Runtime Environment (build 1.8.0_271-b09)
Maven 3.6.3
