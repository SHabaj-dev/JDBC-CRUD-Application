## Simple CRUD App in Java using JDBC
This is a simple CRUD (Create, Read, Update, Delete) application built in Java using JDBC (Java Database Connectivity) to interact with a MySQL database.

# Prerequisites
- Java Development Kit (JDK) installed on your machine
- MySQL server installed on your machine
- MySQL Connector/J library added to the classpath of your project
# Installation
- Clone this repository to your local machine.
- Create a database called `mydatabase` in your MySQL server.
    ```
    CREATE DATABASE mydatabase;
    ```
- Create a table name `student` with following attributes `student_id` as Primary Key, `first_name`, `last_name`, `branch`.
    ```
    CREATE TABLE mydatabase.student (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    branch VARCHAR(50)
    );
    ```
- Open the project in your preferred Java IDE.
- Add the MySQL Connector/J library to the classpath of your project. You can download it from [here](https://dev.mysql.com/downloads/connector/j/).
- Run the MainClass.java file to start the application.
# Usage
Upon running the application, you will be presented with a menu that lets you choose from the following options:

1. Show all data from the student table
2. Show data for a specific student
3. Insert new data into the student table
4. Delete data for a specific student
5. Exit

Select the option you want to perform by entering its corresponding number.

- If you select option 1, the application will retrieve and display all data from the student table.

- If you select option 2, you will be prompted to enter the ID of the student whose data you want to display. The application will then retrieve and display that student's data.

- If you select option 3, you will be prompted to enter the data for the new student you want to insert into the student table.

- If you select option 4, you will be prompted to enter the ID of the student whose data you want to delete. The application will then delete that student's data from the student table.

- If you select option 5, the application will exit.
