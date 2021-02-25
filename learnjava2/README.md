# LearnJava2

## Database


You will need to install MySQL or MariaDB.

One alternative to this if you lack admin permissions is [XAMPP](https://www.apachefriends.org/download.html).


#### Creating a database and user

```sql
create database db_example; -- Creates the new database
create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

#### Creating a table

```sql
CREATE TABLE db_example.user (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```

#### Inserting some data

```sql
insert into `db_example.user` (id, email, name, password) values (1, 'someemail@someemailprovider.com', 'First', 'mypassword');
insert into `db_example.user` (id, email, name, password) values (2, 'someemail@someemailprovider.com', 'Second', 'mypassword2');
```


#### Testing a select

```sql
select * from user;
```

#### MYSQL Root Password Reset

Here's what to do if you run windows and have to reset your root password:

[How to Reset Root Password](https://dev.mysql.com/doc/mysql-windows-excerpt/5.7/en/resetting-permissions-windows.html)
