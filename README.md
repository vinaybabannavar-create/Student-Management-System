🎓 Student Management System

<p align="center">
  <b>A clean, console-based CRUD application built with Java, JPA, Hibernate, Maven, and MySQL.</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" alt="Java 17">
  <img src="https://img.shields.io/badge/JPA-Jakarta%20Persistence-blue?style=for-the-badge" alt="JPA">
  <img src="https://img.shields.io/badge/Hibernate-6.6.36-59666C?style=for-the-badge&logo=hibernate" alt="Hibernate">
  <img src="https://img.shields.io/badge/MySQL-8.x-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
</p>

📌 Overview

Student Management System is a Java-based console application developed to demonstrate database persistence using Jakarta Persistence (JPA) with Hibernate and MySQL.

The application provides a simple menu-driven interface for managing student records through complete CRUD operations:

➕ Create — Add a new student

🔍 Read — View student details by ID

✏️ Update — Update course and phone number

🗑️ Delete — Delete a student by ID

🚪 Exit — Close the application

This project demonstrates how a Java application communicates with a relational database using JPA's EntityManager and transaction management.

✨ Features

Menu-driven console interface

Complete CRUD functionality

Automatic Student ID generation

JPA entity mapping using annotations

Hibernate as the JPA persistence provider

MySQL database integration

Transaction management using EntityTransaction

Automatic database table creation/update through Hibernate

Maven dependency management

Clean separation between entity, DAO, utility, and application layers

🛠️ Tech Stack

Technology

Purpose

Java 17

Application development

Maven

Build and dependency management

Jakarta Persistence (JPA)

Persistence API

Hibernate ORM

JPA implementation / ORM framework

MySQL

Relational database

MySQL Workbench

Database verification

EntityManager

Database operations

Transactions

Data consistency
## 📁 Project Structure

```text
Student-Management-System/
│
├── .mvn/
│   ├── jvm.config
│   └── maven.config
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── studentmanagement/
│   │   │           ├── App.java
│   │   │           ├── JPAUtil.java
│   │   │           ├── Student.java
│   │   │           └── StudentDAO.java
│   │   │
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── studentmanagement/
│                   └── AppTest.java
│
├── .gitignore
├── pom.xml
└── README.md
```

## 🏗️ Application Architecture

The application follows a simple layered structure:

```text
User
  │
  ▼
App.java
(Console / User Input)
  │
  ▼
StudentDAO.java
(CRUD Operations)
  │
  ▼
EntityManager
(JPA Persistence)
  │
  ▼
Hibernate ORM
(JPA Persistence Provider)
  │
  ▼
MySQL Database
(student_management)
```
📚 Step-by-Step Implementation

1. Create the Maven Project

Create a Maven project using Java 17 with the standard Maven directory structure.

The project uses pom.xml to manage dependencies and build configuration.

2. Add Maven Dependencies

The required libraries are added to pom.xml.

Main dependencies

Hibernate ORM

MySQL Connector/J

JUnit

Maven automatically downloads and manages these dependencies.

3. Create the Student Entity

Student.java represents a student record in the database.

The entity contains:

Student ID
Student Name
Email
Course
Phone Number

The class uses JPA annotations such as:

@Entity
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

Hibernate maps the entity to the Student database table.

4. Configure JPA and Hibernate

Create:

src/main/resources/META-INF/persistence.xml

This configuration file defines the persistence unit and database connection.

The persistence unit used by the application is:

studentPU

It configures:

Hibernate persistence provider

MySQL JDBC driver

Database URL

Database username

Database password

Hibernate schema management

5. Create JPA Utility

JPAUtil.java creates the EntityManagerFactory using the studentPU persistence unit.

It also provides an EntityManager whenever database operations are required.

6. Implement CRUD Operations

StudentDAO.java contains the database operations.

CREATE

entityManager.persist(student);

Adds a new student to the database.

READ

entityManager.find(Student.class, studentId);

Retrieves a student using the Student ID.

UPDATE

The existing managed entity is retrieved, its values are changed, and the transaction is committed.

DELETE

entityManager.remove(student);

Removes the selected student from the database.

7. Build the Menu-Driven Application

App.java provides the console interface.

====================================
       STUDENT MANAGEMENT SYSTEM
====================================
1. Add Student
2. View Student
3. Update Student
4. Delete Student
5. Exit

Enter your choice:

The application reads the user's choice and calls the appropriate StudentDAO method.

🔄 CRUD Workflow

                 Student Management System
                           │
          ┌────────────────┼────────────────┐
          │                │                │
       CREATE            READ            UPDATE
          │                │                │
      persist()          find()       find() + modify
          │                │                │
          └────────────────┼────────────────┘
                           │
                        DELETE
                           │
                        remove()
                           │
                           ▼
                    MySQL Database

🗄️ Database Setup

1. Start MySQL

Make sure your MySQL Server is running.

2. Create the Database

Open MySQL Workbench and execute:

CREATE DATABASE student_management;

3. Select the Database

USE student_management;

Hibernate will create/update the required Student table according to the JPA entity configuration.

⚙️ Configuration

Open:

src/main/resources/META-INF/persistence.xml

Configure your local MySQL credentials:

<property
    name="jakarta.persistence.jdbc.url"
    value="jdbc:mysql://localhost:3306/student_management"/>

<property
    name="jakarta.persistence.jdbc.user"
    value="root"/>

<property
    name="jakarta.persistence.jdbc.password"
    value="YOUR_MYSQL_PASSWORD"/>

⚠️ Security: Never commit your real MySQL password to a public GitHub repository. Use a local configuration or environment-based secret for real projects.

▶️ Running the Project

Prerequisites

Install the following:

Java 17 or later

Maven

MySQL Server

MySQL Workbench

Git

Verify Java:

java -version

Verify Maven:

mvn -version

1. Clone the Repository

git clone https://github.com/vinaybabannavar-create/Student-Management-System.git

Move into the project directory:

cd Student-Management-System

2. Configure MySQL

Create the database:

CREATE DATABASE student_management;

Update the MySQL credentials in:

src/main/resources/META-INF/persistence.xml

3. Compile the Project

Run:

mvn clean compile

A successful build should display:

BUILD SUCCESS

4. Run the Application

Run App.java from your IDE.

The console will display the Student Management System menu.

🖥️ Application Demo

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

Create — Add Student

Enter Student Name: Rahul
Enter Email: rahul@gmail.com
Enter Course: Java
Enter Phone: 9876543210

Student added successfully!
Student ID: 1

Read — View Student

Enter Student ID: 1

Student Details
-----------------------------
ID     : 1
Name   : Rahul
Email  : rahul@gmail.com
Course : Java
Phone  : 9876543210
-----------------------------

Update — Update Student

Enter Student ID: 1
Enter New Course: Full Stack Java
Enter New Phone: 9988776655

Student updated successfully!

Delete — Delete Student

Enter Student ID: 1

Student deleted successfully!

Exit

Thank you for using Student Management System!
Application closed.

🔎 MySQL Workbench Verification

After performing CRUD operations, verify the records directly in MySQL Workbench.

USE student_management;

SELECT * FROM Student;

The records created or modified through the Java application will be reflected in the Student table.

🔑 Core JPA Operations

Operation

JPA Operation

CREATE

entityManager.persist()

READ

entityManager.find()

UPDATE

Modify managed entity + Transaction

DELETE

entityManager.remove()

🧩 Key JPA Concepts Demonstrated

Entity Mapping

@Entity maps the Java class to a database table.

Primary Key

@Id identifies the primary key.

Auto-Generated ID

@GeneratedValue(strategy = GenerationType.IDENTITY) allows MySQL to generate the Student ID.

EntityManager

EntityManager performs persistence operations between Java objects and the database.

Transactions

Transactions ensure that database changes are committed safely.

ORM

Hibernate maps Java objects to relational database records, reducing the need for manual SQL for CRUD operations.

📌 Expected Database Table

The application creates a table similar to:

Student
├── studentId
├── studentName
├── email
├── course
└── phoneNumber

🧪 Testing

The project includes a test source directory under:

src/test/java/com/studentmanagement/

Maven can be used to execute tests:

mvn test

📂 Important Files

File

Responsibility

App.java

Main menu and user interaction

Student.java

JPA entity representing a student

StudentDAO.java

CRUD database operations

JPAUtil.java

EntityManagerFactory and EntityManager creation

persistence.xml

JPA/Hibernate and MySQL configuration

pom.xml

Maven dependencies and build configuration

.gitignore

Prevents generated/unwanted files from being committed

🚀 Learning Outcomes

This project demonstrates practical understanding of:

Java application development

Maven project management

Jakarta Persistence (JPA)

Hibernate ORM

Entity mapping

EntityManager

Database transactions

CRUD operations

MySQL integration

Maven build lifecycle

Git and GitHub project management

👨‍💻 Author

Vinay Babannavar

GitHub: @vinaybabannavar-create

📄 License

This project is created for educational and lab assignment purposes.
