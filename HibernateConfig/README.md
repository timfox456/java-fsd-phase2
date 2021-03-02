# Assisted Practice: 3.1

## Configuration of Hibernate

This section will guide you to:
 * Set up Eclipse to work with Hibernate
 * Create an HTML page to call a servlet
 * Create a servlet that will initialize Hibernate and then close it

Development Environment
 * Eclipse IDE for Enterprise Java Developers v2019-03 (4.11.0)
 * Apache Tomcat Server v9.0
 * JRE: OpenJDK Runtime Environment 11.0.2
 * Hibernate for Java 5.2.1
 * MySQL Connector for Java 8.0.16
 * JTA  v 1.1
 * Java XML Bind (no version)
 * JAXB OSGI v.2.4.0
 * Java Activation (no version)
 
Step 3.1.1: Creating a Maven project
 * 	Open Eclipse 
 * 	Go the File menu. Choose New->Maven Project
 * 	Enter the project name as HibernateConfig. Click on Next
 * 	Select archetype for Maven as "maven-archetype-webapp"
 *  Maven should create your project.

Step 3.1.2: Add dependencies for pom.xml
 *  Edit the pom.xml by adding dependencies as follows: 
 ( It should go between the `<dependencies>` and `</dependencies>` tags in the `pom.xml` file. )
 
```xml
  
       <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.4.28.Final</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.ow2.asm/asm -->
<dependency>
    <groupId>org.ow2.asm</groupId>
    <artifactId>asm</artifactId>
    <version>9.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.23</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.persistence/persistence-api -->
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>persistence-api</artifactId>
    <version>1.0.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.transaction/jta -->
<dependency>
    <groupId>javax.transaction</groupId>
    <artifactId>jta</artifactId>
    <version>1.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-osgi -->
<dependency>
    <groupId>com.sun.xml.bind</groupId>
    <artifactId>jaxb-osgi</artifactId>
    <version>3.0.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.4.0-b180830.0359</version>
</dependency>

<!-- https://mvnrepository.com/artifact/cglib/cglib -->
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.3.0</version>
</dependency>

```


Step 3.1.3: Configuring Hibernate with `hibernate.cfg.xml`
 * 	In the Project Explorer, expand HibernateConfig->Java Resources
 * 	Right click on src and choose New->Other
 * 	Select General->File and click Next
 * 	In filename, enter `hibernate.cfg.xml` and click on Finish
 * 	Enter the following code:
 
 ```xml 
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>       
  <session-factory>
    <!-- Database connection settings -->
    <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="connection.url">jdbc:mysql://localhost:3306/ecommerce</property>
    <property name="connection.username">springuser</property>
    <property name="connection.password">ThePassword</property>
  </session-factory>
</hibernate-configuration>
 
 
 ```
 
 You will also need to configure your database as follows: (in MySQL commmand line or Workbench)
 
 ```sql
 create database ecommerce; -- Creates the new database
create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on ecommerce.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
 
 ```

