# Library Management System

A very simple CRUD API for a library management system, where patrons can borrow and return books. 
The system should also keep track of which books are checked out and by whom.

## Contents
- [Overview](#overview)
    - [Functional Requirements](#functional-requirements)
- [The Database](#the-database)
    - [Design Considerations](#design-considerations)
    - [Choosing The Database](#choosing-the-database)
    - [Database Migrations](#database-migrations)
- [Getting Started](#getting-started)
- [Features](#features)
- [Takes on Design](#takes-on-design)
- [Notes](#notes)

## Overview

## Functional Requirements

1- Books:
- Add a book with details like title, author, ISBN, and quantity
- Update a book’s details.
- Delete a book.
- List all books.

2- Patrons:
- Register a patron with details like name, email, and password.
- Update patron details.
- Delete a patron.
- List all patrons.

3- Borrowing and Returning:
- A patron can check out a book. The system should keep track of which books are
  checked out and by whom.
- A patron can return a book.
- A patron can check the books they currently have. [Not implemented]
- The system should keep track of due dates for the books and list books that are
  overdue. [Not implemented]

## The Database
![](.assets/database_lib.png)

### Design Considerations
- For sake of simplicity, the `id` of the entities is an `integer` and it's auto-incremented.
- One patron can only borrow one book at a time.
- No due date is set for the borrowed books.
- Indexes are set for `isbn` and `patron_name` for faster search. (though it's not used)

### Choosing the database
Both MySQL and PostgreSQL are excellent choices and meet the projects' requirements, but as a personal taste I will go with PostgreSQL as it's easier to setup for me and it supports out-of-the-box feaures like various data types.

## Getting started
You don't need anything to start, just `docker-compose` and you're ready to kick!
- Java 17 (or higher)
- Spring > 3.0
- Check out the gradle file for full dependencies

## Features
While the project is pretty simple and it just meets the requirements, it's worth mentioning that is has some cool features beside the already defined ones in the requirements:
- All CRUD operations are satisfied in a clean way
- Tests using testcontainers

## Takes on Design
I have some takes on the design I came up with but for sake of limited time I couldn't implement them:
- I could have used a `JWT` for authentication and authorization, but I didn't have time to implement it.
- I could have used a `ORM` though I prefer to use `SQL` queries for better performance and control.
- The business logic is in the service layer is pretty plain and simple and based on the SRS I only implemented the required features (no facny stuff).

## Notes
- Currently, I am throwing database errors as server errors : `500`

## Todo
- [X] Desgin an archicture to follow
- [X] Database
    - [X] Choose a database and why ?
    - [X] Schema Desgin
    - [X] Normalization
    - [X] Choosing indexes
- [X] API Desgin: REST
    - [X] Book routes
    - [X] Patron routes
    - [X] Borrow routes
- [ ] Security : Authorization and Authentication
- [X] Documentations
- [ ] Production Setup: HTTPs, Docker
- [X] Define a way to handle errors : throw the errors from the service with status codes and check types on controller
- [X] Testing