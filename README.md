# ShoppingCart
Shopping Cart Application using Spring MVC, REST services, Angular and MySQL


A Simple Shopping Cart Application developed using Spring MVC, REST services,AngularJS,  Hibernate, MySQL

GUIDELINES TO RUN PROJECT:

●	Download the project and open in Eclipse JAVA EE.
●	Need JRE 1.8 or above.
●	Go to "servlet-context.xml"  file and replace mysql url, username and password bean properties with host computer`s mysql url, username and password.
●	Run the provided SQL script to get the database with populated values on host machine.
●	Update the maven dependencies to download all the required libraries.
●	Run the project, select Run on Server Option.

SCRIPT FILE PATH : ShoppingCart/src/main/webapp/WEB-INF/resources/scripts/db.sql

NOTE: If any errors regarding contextLoadListener, please do following steps:

1. Clean Tomcat Work Directory (Servers -> Tomcat Server -> Clean , Servers -> Tomcat Server -> Clean Work Directory)
2. Go to Project Properties -> Deployment Assembly -> Add -> Java Build Entries -> Maven Dependencies -> Apply -> Ok
3. Then Run the project.
