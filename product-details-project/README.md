# Retrieving the Product Details Using the Product ID.

## DESCRIPTION

## Project objective:
Create a servlet-based application that shows a form to enter a product ID. The product ID is then validated, and product details are retrieved from the database and displayed to the user. You need to create a product table in MySQL and prepopulate it with data. Use JDBC to do all database processing.


## Background of the problem statement:
As a part of developing an e-commerce web application, the admin backend requires a module that can retrieve product information based on the product ID.


## You must use the following:

 * Eclipse as the IDE
 * Apache Tomcat as the web server
 * MySQL Connector for JDBC functionality


## Following requirements should be met:

 * Create an HTML page to take in a product ID
 * Set up JDBC to work with the application
 * Create a servlet that will take the product ID and use JDBC to query the database for the product
 * If the product is found, the servlet will display the product details, otherwise it will show an error message
 * Document the step-by-step process involved in completing this task

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


