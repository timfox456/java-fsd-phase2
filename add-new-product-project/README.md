# Adding a New Product in the Database.
## DESCRIPTION

## Project objective:

Create a servlet-based web application that shows a form to add new products. A MySQL database will be created to store product data. The form data will be validated, and a row will be added to the database. All database processing will be done using Hibernate.


## Background of the problem statement:

As a part of developing an e-commerce web application, you have to create a database table for storing product information. A form is needed to add new products. The form submission is validated, and a new record is created in the product table.


### You must use the following:

 * Eclipse as the IDE
 * Apache Tomcat as the web server
 * JSP pages for the front end
 * Servlets for backend processing
 * Hibernate to store data into the database


### Following requirements should be met:

 * Show an add product form in JSP
 * Use of any client-side javascript libraries such as bootstrap or jquery is allowed (but not required).  There should be no absolute need for client-side javascript anywhere in this project.
 * Handle the form submission in a servlet. Validate it for any missing information
 * Add the product information into the database using Hibernate
 * Set up Hibernate configuration files using XML or Annotations for the product table
 * A class has to be created to store product data. This class will be linked to Hibernate via an hbm.xml file or Annotations.
 * The servlet will put the form data into the product class and then pass the product class into Hibernate to add into the database
 * The step-by-step process involved in completing this task should be documented


### Hints

It is fine for us to actually use the same DB and same code as the previous PetsExample
 

## Suggested SQL

```sql
CREATE DATABASE pets;
create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user springuser
grant all on pets.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

```sql
CREATE TABLE pets.products (
id  int(11) AUTO_INCREMENT,
name VARCHAR(256),
color VARCHAR(256),
price DECIMAL(19,2),
PRIMARY KEY (`id`)
);

INSERT INTO pets.products (name,color,price) VALUES ("Bird", "Chartreuse", 200.00);
INSERT INTO pets.products (name,color,price) VALUES ("Hamster", "Brown", 30.00);
INSERT INTO pets.products (name,color,price) VALUES ("Cayman", "Neon Pink", 500.00);
INSERT INTO pets.products (name,color,price) VALUES ("Tarantula", "Red", 100.00);
```
