# Phase 2 End Project - Create a sample login and registration application

## Project Objective:

Create a sample login and registration application with using JSP+Servlets and hibernate. Important fields of this application:

## Modules

1. User will register with the details. (Username, password, etc...)

2. With the same database table user will get verified through login.

## Details

There will be several pages in this application: (this is a suggestion, you can design the actual site navigation to suit).
 * index : DIrect user to either login or user registration
 * User Registration form
 * Login Form (could be part of the index if you want)
 * Landing Page once user has successfully authenticated (content of this page not important), should have a link or button to "log out" back to index.

The actual front-end design (html/css) can be very minimalistic and design is unimportant as we have not really learned much about front-end coding.

We also need to have a user table that will be stored in the database using hibernate.

When user is directed to authenticate:
 * Retrieve the user from the users table using hibernate
 * confirm the password.
 * If successful, redirect to landing page
 * If unsuccessful, indicate error and do not redirect to landing page.

There is no need to implement security best practices here. You don't need to enforce and redirect 
unauthenticated users to login page as we would in a real application. It
is not required (but is optional) if you want to store passwords in the database 
in a encrypted or hashed format.

Notes:

Original pdf is located [here](./doc/phase-2-end-project.pdf)


