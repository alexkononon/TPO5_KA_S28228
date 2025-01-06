# Car Management System

## Overview

The Car Management System is a Java-based web application that implements a simple car management system. This project utilizes servlets for handling HTTP requests and JSP for the front-end. The project is managed using Maven for build automation and dependency management.

## Technologies

### Build Automation and Dependency Management


Apache Maven: Used for project build automation and dependency management. Maven simplifies the build process and manages project dependencies, ensuring consistent builds across different environments.
### Web Server
Apache Tomcat: A widely used web server for deploying Java-based web applications. Tomcat provides a reliable and efficient platform for running the Car Management System.
### Database
MySQL: A popular relational database management system used to store and manage car data. MySQL offers reliable data storage, querying capabilities, and integration with Java applications.
### Frontend Technologies
JSP (JavaServer Pages): Used for building the frontend interface of the application. JSP allows the integration of dynamic content with HTML, enabling the creation of interactive web pages.
### Servlets
Java Servlets: Used for handling HTTP requests and responses. Servlets form the core of the backend logic, processing user requests, and interacting with the database.

## Launching 

#### Clone the Repository
```
git clone https://github.com/alexkononon/TPO5_KA_S28228.git
```

#### Navigate to the project directory
```
cd TPO5_KA_S28228
```

#### Build the Project
```
mvn clean package
```

#### Set up a connection to the database and create a table in it

```
CREATE TABLE IF NOT EXISTS Cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    fuelConsumption DOUBLE NOT NULL
    );
```

#### Start the Web Server

#### Start your Apache Tomcat server. If it's already running, Tomcat will automatically deploy the new WAR file

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE.txt) file for details.

