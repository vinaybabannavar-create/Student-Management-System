Student Management System

Student Management System using JPA + Hibernate + MySQL.

Project Description

This project is a console-based Student Management System developed using Java, Maven, JPA (Jakarta Persistence), Hibernate, and MySQL.

The application performs the following CRUD operations:

Create – Add a new student

Read – View student details by ID

Update – Update student details

Delete – Delete a student by ID

Technologies Used

Java 17

Maven

Jakarta Persistence (JPA)

Hibernate ORM

MySQL

MySQL Workbench

EntityManager

Transactions

Step-by-Step Process

1. Project Structure

Create the Maven project and organize the Java source files and persistence configuration inside the required folders.

Student-Management-System
│
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/studentmanagement/
│   │   │       ├── App.java
│   │   │       ├── JPAUtil.java
│   │   │       ├── Student.java
│   │   │       └── StudentDAO.java
│   │   │
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
└── README.md

2. Maven Dependencies (pom.xml)

Add the required Java, Hibernate, MySQL Connector/J, and JUnit dependencies in pom.xml.

The main dependencies used are:

Hibernate ORM

MySQL Connector/J

JUnit

Maven downloads the required libraries automatically.

3. Student Entity (Student.java)

Create Student.java to represent the student table and define the Student ID, Name, Email, Course, and Phone Number fields.

The class is marked with @Entity so Hibernate maps it to a database table.

The Student ID is generated automatically using:

@GeneratedValue(strategy = GenerationType.IDENTITY)

4. JPA Utility (JPAUtil.java)

Create JPAUtil.java to create the EntityManagerFactory and provide an EntityManager for database operations.

The persistence unit used in this project is:

studentPU

5. Persistence Configuration (persistence.xml)

Create persistence.xml inside src/main/resources/META-INF/ to configure JPA, Hibernate, the MySQL connection, and database properties.

The configuration includes:

Persistence unit name

Hibernate persistence provider

MySQL JDBC driver

Database URL

MySQL username

MySQL password

Hibernate database configuration

6. Data Access Object (StudentDAO.java)

Create StudentDAO.java to implement all Create, Read, Update, and Delete operations using EntityManager and transactions.

Create

A new student is added using:

entityManager.persist(student);

Read

Student details are retrieved using:

entityManager.find(Student.class, studentId);

Update

The existing student is retrieved, its details are modified, and the transaction is committed.

Delete

The student is retrieved and deleted using:

entityManager.remove(student);

7. Main Application (App.java)

Create App.java to provide the menu-driven console application and accept input from the user using Scanner.

The menu provides the following options:

====================================
       STUDENT MANAGEMENT SYSTEM
====================================

1. Add Student
2. View Student
3. Update Student
4. Delete Student
5. Exit

Enter your choice:

The selected option calls the corresponding method from StudentDAO.

8. Run and Test the Application

Run the Maven application and verify that Add, View, Update, Delete, and Exit options work correctly.

Main Menu

====================================
       STUDENT MANAGEMENT SYSTEM
====================================
1. Add Student
2. View Student
3. Update Student
4. Delete Student
5. Exit
Enter your choice:

Create – Add Student

Enter Student Name: Rahul
Enter Email: rahul@gmail.com
Enter Course: Java
Enter Phone: 9876543210

Student added successfully!
Student ID: 1

Read – View Student

Enter Student ID: 1

Student Details
-----------------------------
ID     : 1
Name   : Rahul
Email  : rahul@gmail.com
Course : Java
Phone  : 9876543210
-----------------------------

Update – Update Student

Enter Student ID: 1
Enter New Course: Full Stack Java
Enter New Phone: 9988776655

Student updated successfully!

Delete – Delete Student

Enter Student ID: 1

Student deleted successfully!

Exit

Thank you for using Student Management System!
Application closed.

9. MySQL Workbench Verification

Open MySQL Workbench and verify that the Student table and records created through JPA and Hibernate are stored correctly.

Create the database if required:

CREATE DATABASE student_management;

Select the database:

USE student_management;

Verify the Student table:

SELECT * FROM Student;

The student records stored through the application will be displayed in MySQL Workbench.

Core JPA Operations

CREATE  → entityManager.persist()

READ    → entityManager.find()

UPDATE  → Modify managed entity + Transaction

DELETE  → entityManager.remove()

Application Flow

User
  ↓
App.java
  ↓
StudentDAO
  ↓
EntityManager
  ↓
Hibernate
  ↓
MySQL Database

Database Configuration

The MySQL database connection is configured in:

src/main/resources/META-INF/persistence.xml

Example configuration:

<property
    name="jakarta.persistence.jdbc.url"
    value="jdbc:mysql://localhost:3306/student_management"/>

<property
    name="jakarta.persistence.jdbc.user"
    value="root"/>

<property
    name="jakarta.persistence.jdbc.password"
    value="YOUR_MYSQL_PASSWORD"/>

Note: Do not commit your actual MySQL password to GitHub.

Build the Project

Open the terminal inside the project directory and run:

mvn clean compile

A successful compilation displays:

BUILD SUCCESS

Conclusion

The Student Management System successfully demonstrates CRUD operations using JPA with Hibernate and MySQL.

The project uses EntityManager and transactions to create, read, update, and delete student records.
