## Magento_ST_Board_Automation_v101
## Project Overview:
This project is aimed at automating the test cases for the Magento eCommerce platform at https://magento.softwaretestingboard.com/. The automation suite covers key functionalities like user registration, login, product search, cart operations, and more. The framework is designed using Selenium WebDriver (Java) and leverages TestNG for test case organization and execution.

## Test Cases Included
The current test suite automates the following key scenarios:

* **User Account Registration**
* **Valid and Invalid User Login**
* **Mouse Hover and Submenu Navigation**
* **Product Sorting by Price**
* **Product Search** (Valid and Empty Inputs)
* **Cart Operations** (Add, Update, Remove)

## Planned Features
* **Checkout Process** (To be implemented): US07_TC012_CheckoutProcess
* **Account Management Tests:** Automate scenarios like updating profile information, changing passwords, and viewing order history.
* **Cross-browser Compatibility Tests:** Ensure functionality works across multiple browsers, including Chrome, Firefox, and Safari.

## Framework Features
* **Selenium WebDriver** for automating browser actions.
* **TestNG** for organizing, grouping, and running test cases.
* **Maven** for project and dependency management.
* **Extent Reports** for generating detailed execution reports with screenshots for failed tests.
* **Page Object Model (POM)** for structuring test logic and web element interactions.

## How to Run the Tests

### Running Tests via TestNG Suites
- **`master.xml`**: Use this suite to execute the entire test suite.
- **`grouping.xml`**: This suite allows you to run specific groups of tests, such as **Sanity**, **Regression**, **UI**, **Cart** etc.

### Running Tests Using `run.bat` (Windows Users)
For a convenient approach, Windows users can utilize the `run.bat` file provided in the project root. This batch script automates the process of executing the Maven tests.

## Jenkins Integration
This project is configured to work with Jenkins for continuous integration and continuous delivery. Jenkins allows you to schedule or trigger test executions automatically whenever changes are made to the repository.
