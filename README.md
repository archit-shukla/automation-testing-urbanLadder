# Urban Ladder Test Automation Framework

This project contains a test automation framework for testing the Urban Ladder website. The framework is built using Behavior-Driven Development (BDD) with Cucumber and TestNG.

## Features

- Automated tests for various functionalities of the Urban Ladder website.
- BDD approach for writing test scenarios in natural language.
- Integration with TestNG for test execution and reporting.
- Data-driven testing using Cucumber scenarios and TestNG data providers.
- Page Object Model (POM) design pattern for better code organization and maintenance.

## Pre-requisites

Before running the tests, make sure you have the following installed:

- Java Development Kit (JDK)
- Maven
- WebDriver (ChromeDriver, GeckoDriver, etc.) for browser automation

## Getting Started

1. Clone the repository to your local machine.
2. Install the necessary dependencies using Maven: `mvn clean install`
3. Configure the test data and environment settings in the `config.properties` file.
4. Run the tests using Maven: `mvn test`

## Project Structure

- `src/test/java`: Contains the test scripts and supporting classes.
  - `bdd`: Contains the feature files written in Gherkin syntax for BDD.
  - `stepDefinitions`: Contains the step definition classes for Cucumber.
  - `data`: Contains data providers for TestNG data-driven testing.
  - `pageObject`: Contains Page Object classes for different pages of the website.
  - `utilities`: Contains utility classes for common functions and helpers.
  - `runner`: contains the code to run the program
  - `reusableComponents`: contains code to load the webdriver 
- `src/test/resources`: Contains configuration files and test data.
  - `config.properties`: Configuration file for test environment settings.
  - `testData.xlsx`: Test data in Excel format for data-driven testing.
- `pom.xml`: Maven project configuration file.

## Reporting

TestNG generates HTML reports in the `test-output` directory after test execution. You can view these reports to check the test results and status.
