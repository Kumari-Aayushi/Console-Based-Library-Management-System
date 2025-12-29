Overview

The Console-Based Library Management System is a Java application designed to manage essential library operations such as book cataloging, member registration, and borrowing workflows through a structured, menu-driven console interface.
This project demonstrates a strong foundation in Java programming, Object-Oriented Design, Collections Framework, and file-based persistence, making it suitable for academic submissions and entry-level software engineering portfolios.

Key Objectives

Design a real-world Java console application

Apply Object-Oriented Programming principles effectively

Implement persistent data storage using files

Practice structured exception handling and input validation

Strengthen Java fundamentals relevant to technical interviews

Features

Add, view, and manage library books

Register and manage library members

Borrow and return books with due-date tracking

Persistent data storage across program executions

Console-based interactive menu system

Robust input validation and error handling

Library statistics and usage overview

Technical Stack

Programming Language: Java

Paradigm: Object-Oriented Programming (OOP)

Data Structures: ArrayList

Persistence: File I/O using Object Streams

Date Handling: LocalDate

Execution Environment: Command Line / IDE

Project Structure
week3-library-system/
│── src/
│   └── main/
│       └── java/
│           └── library/
│               ├── Main.java
│               ├── Book.java
│               ├── Member.java
│               ├── Library.java
│               └── FileHandler.java
│── data/
│   ├── books.txt
│   └── members.txt
│── README.md
│── .gitignore

System Design
Core Components

Book – Represents library books with availability and due-date tracking

Member – Represents registered users and their borrowing history

Library – Manages business logic for borrowing, returning, and statistics

FileHandler – Handles persistent storage and retrieval of data

Main – Entry point and console interface controller

Application Workflow

User selects an option from the console menu

Input is validated before processing

Business logic is executed via the Library class

Updated data is persisted to files

Results are displayed in a formatted console output

Sample Menu
=== LIBRARY MANAGEMENT SYSTEM ===
1. Add New Book
2. View All Books
3. Register Member
4. Borrow Book
5. Return Book
6. View Library Statistics
7. Exit

How to Run
Compile
javac -d bin src/main/java/library/*.java

Execute
java -cp bin library.Main

Testing & Validation

Prevents borrowing of unavailable books

Ensures valid member and book existence

Verifies data persistence across restarts

Validates due-date assignment logic

Code Quality Standards

Clean and modular class design

Proper encapsulation and access control

Meaningful naming conventions

Separation of concerns

Readable and maintainable code

Learning Outcomes

Practical understanding of Java OOP principles

Experience with collections and file handling

Improved problem-solving and system design skills

Confidence in building real-world Java console applications

Future Enhancements

Overdue fine calculation

Book reservation and waitlist system

Search and filter capabilities

CSV and report export functionality

Unit testing using JUnit

Maven-based project configuration
