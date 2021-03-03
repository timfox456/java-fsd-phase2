# Assisted Practice: 3.1

## Configuration of Hibernate

This section will guide you to:
 * Set up Eclipse to work with Hibernate
 * Create an HTML page to call a servlet
 * Create a servlet that will initialize Hibernate and then close it

Development Environment
 * Eclipse IDE for Enterprise Java Developers v2019-03 (4.11.0)
 * Apache Tomcat Server v9.0
 
 
#### Step 3.1.1: Creating a Maven project
 * 	Open Eclipse 
 * 	Go the File menu. Choose New->Maven Project
 * 	Enter the project name as HibernateConfig. Click on Next
 * 	Select archetype for Maven as "maven-archetype-webapp"
 *  Maven should create your project.

#### Step 3.1.2: Add dependencies for pom.xml
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

 * Also change the java version to `1.8` as appropriate.
 



#### Step 3.1.3: Configuring Hibernate with `hibernate.cfg.xml`
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
 
 You will also need to create the eproduct table:
 
 ```sql
 CREATE TABLE eproduct (ID bigint primary key auto_increment,
 name varchar(100), price decimal(10,2), date_added timestamp default now()) 
 ```
 
 Let us also insert some rows into the eproduct table:
 
 ```sql
 use ecommerce;
INSERT INTO eproduct (name, price, date_added) VALUES( 'HP Laptop ABC', 12000, '2021-03-01') ;
INSERT INTO eproduct (name, price, date_added) VALUES( 'Acer Laptop ABC', 14000, '2021-03-01') ;
INSERT INTO eproduct (name, price, date_added) VALUES( 'Lenovo Laptop ABC', 12000, '2021-03-01') ;
 
```
 
#### Step 3.1.4: Editing the `index.jsp` file
 * Find `index.jsp` that was created by the maven archtetype.  It should be under your "Deployed Resources"
 * Change the content to the following:
 
```html
<html>
<body>
<h2>Initialize Hibernate</h2>


<a href="init">Initialize Hibernate</a><br>


</body>
</html>

```

#### Step 3.1.5: Creating a HibernateUtil class to initiate Hibernate in code

 * Create the HibernateUtil class in the `com.example` package:
 
```java
package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




public class HibernateUtil {

	private static final SessionFactory sessionFactory;

    static {
            try {
                    StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                                    .configure("hibernate.cfg.xml").build();
                    Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
                    sessionFactory = metaData.getSessionFactoryBuilder().build();
            } catch (Throwable th) {
                    throw new ExceptionInInitializerError(th);
            }
    }

    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }

	
}


```

#### Step 3.1.6: Creating a `InitHibernate` servlet

 * Create the `InitHibernate` servlet in the default package:
 
 ```java
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.HibernateUtil;

/**
 * Servlet implementation class InitHibernate
 */
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitHibernate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
              PrintWriter out = response.getWriter();
              out.println("<html><body>");

              SessionFactory factory = HibernateUtil.getSessionFactory();
                     
              Session session = factory.openSession();
              out.println("Hibernate Session opened.<br>");
              session.close();
              out.println("Hibernate Session closed.<br>");
                     
              out.println("</body></html>");
                 
                  
       } catch (Exception ex) {
              throw ex;
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
 
 ```
 
#### Step 3.1.7: Configuring `web.xml`

 * In the Project Explorer, expand HibernateConfig->WebContent->WEB-INF
 * Double click on web.xml to open it in the editor
 * Enter the following script:


```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>HibernateConfig</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>InitHibernate</display-name>
    <servlet-name>InitHibernate</servlet-name>
    <servlet-class>InitHibernate</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>InitHibernate</servlet-name>
    <url-pattern>/init</url-pattern>
  </servlet-mapping>
</web-app>	


```

#### Step 3.1.8: Ensuring Maven Dependencies are loaded
 
  * Right click on the project and go to Maven -> Update Project
  * Right click on the Project and go to Properties -> Deployment Assembly
    - Ensure that Maven Dependencies are present
    - If not, click `Add` and add the maven dependencies.
    
#### Step 3.1.9: Building the project
 * 	From the Project menu at the top, click on Build
 * 	If any compile errors are shown, fix them as required


#### Step 3.1.10: Publishing and starting the project
 * 	If you do not see the Servers tab near the bottom of the IDE, go to Window menu and click Show View->Servers
 * 	Right click on the Server entry and choose Add and Remove
 * 	Click the Add button to move HibernateConfig from the Available list to the Configured list
 * 	Click on Finish
 * 	Right click on the Server entry and click on Publish
 * 	Right click on the Server entry and click on Start
 * 	This will start the server

#### Step 3.1.11: Running the project
 * 	To run the project, open a web browser and type: http://localhost:8080/HibernateConfig




