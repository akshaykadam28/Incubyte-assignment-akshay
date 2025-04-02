1.Project Overview

This project is a test automation framework for verifying the login and registration features of a web application. It uses Selenium WebDriver, Cucumber (BDD), and JUnit 5 for testing. The framework follows the Page Object Model (POM) for better code organization.

Technologies Used

Java 11

Selenium WebDriver

Cucumber (BDD Framework)

JUnit 5

Maven

Eclipse IDE

2.Folder Structure

Myassignment
│── src/main/java
│   ├── pompages                  # Page classes for Login and Registration
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   ├── utils                     # Utility classes
│
│── src/test/java
│   ├── factory                   # WebDriver factory setup
│   │   ├── DriverFactory.java
│   ├── hooks                     # Cucumber hooks
│   │   ├── MyHooks.java
│   ├── runner                    # Test runner class
│   │   ├── MyRunner.java
│   ├── stepdefinitions           # Step definition files
│   │   ├── Login.java
│   │   ├── Register.java
│
│── src/test/resources
│   ├── config                    # Configuration files
│   │   ├── config.properties
│   ├── features                  # Feature files for test cases
│   │   ├── 01_register.feature
│   │   ├── 02_login.feature
│
│── pom.xml                        # Maven dependencies
│── target                         # Test reports and output files

3. How to Run Test Cases

Prerequisites

Install Java 11 or later

Install Maven

Install Eclipse IDE (or any preferred IDE)

Add required browser drivers (e.g., ChromeDriver for Chrome)

4. Running Tests

Using Maven

Run all test cases with this command:

mvn clean test

Running Tests from Eclipse

Open MyRunner.java in the runner package.

Right-click and select Run As > JUnit Test.

Thank you
