# Phase 2 End Project - Create a sample login and registration application

## Project Objective:

Create a sample login and registration application with using JSP+Servlets and hibernate. Important fields of this application:

## Modules

1. User will register with the details. (Username, password, etc...)

2. With the same database table user will get verified through login.

## Details

There will be several pages in this application:
 - index : DIrect user to either login or user registration
 - User Registration form
 - Login Form
 - Landing Page once user has successfully authenticated (content of this page not important)

We also need to have a user table that will be stored in the database using hibernate.

When user is directed to authenticate:
 - Retrieve the user from the users table using hibernate
 - confirm the password.
 - If successful, redirect to landing page
 - If unsuccessful, indicate error and do not redirect to landing page.


