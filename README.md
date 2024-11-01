## Magento_ST_Board_Automation_v101
### Project Overview:
This repository contains automated test cases to validate key functionalities for the Magento eCommerce platform. The tests are implemented using **Selenium (Java)** and organized with **TestNG**. The target application can be accessed here:
🔗 [Magento eCommerce Platform](https://magento.softwaretestingboard.com/)

## 🧪 Test Cases Included

| **Test Case ID** | **Test Case Name**                          | **Description**                                                |
|------------------|---------------------------------------------|---------------------------------------------------------------|
| US01_TC001       | AccountRegistration                         | Tests the user account registration process.                  |
| US01_TC002       | ValidUserLogin                             | Verifies login functionality with valid credentials.          |
| US01_TC003       | InvalidUserLogin                           | Verifies login functionality with invalid credentials.        |
| US02_TC004       | MouseHoverAction                           | Tests mouse hover action for menu items.                      |
| US02_TC005       | HoverAndClickSubMenu                       | Tests mouse hover and submenu click actions.                  |
| US03_TC006       | SortByPriceAscending                       | Verifies sorting products by ascending price.                 |
| US03_TC007       | SortByPriceDescending                      | Verifies sorting products by descending price.                |
| US04_TC008       | SearchBoxWithValidInput                    | Tests product search with a valid input.                      |
| US04_TC009       | SearchBoxWithAnEmptyInput                  | Verifies search box behavior with empty input.                |
| US05_TC010       | TertiaryMenuNavigation                     | Tests navigation through tertiary menus.                      |
| US06_TC011       | CartOperations                             | Verifies add, update, and remove operations in the cart.      |
| US07_TC012       | CheckoutProcess                            | Completes the full checkout process.                          |


## 🚀 Planned Features
* **Account Management Tests:** Automate scenarios like updating profile information, changing passwords, and viewing order history.
* **Cross-browser Compatibility Tests:** Ensure functionality works across multiple browsers, including Chrome, Firefox, and Safari.

## 🛠️ Framework Features

| **Component**       | **Description**                                                          |
|---------------------|--------------------------------------------------------------------------|
| Selenium WebDriver  | Automates browser interactions for end-to-end testing.                   |
| TestNG              | Manages, groups, and executes test cases with detailed logs.             |
| Maven               | Handles dependencies and builds the project seamlessly.                 |
| Extent Reports      | Generates rich HTML reports with screenshots for failed tests.           |
| Page Object Model   | Separates test logic from UI elements to improve code maintainability.   |

## ⚙️ Prerequisites

| **Software**            | **Version** or **Description**                                  |
|-------------------------|------------------------------------------------------------------|
| Java Development Kit    | JDK 8 or higher                                                  |
| Maven                   | Dependency management tool                                      |
| Selenium WebDriver      | Compatible with Chrome, Firefox, etc.                            |
| Browser                 | Latest version of Chrome, Firefox, or Safari                     |
| TestNG                  | Test framework for organizing and executing tests                |
| Jenkins (Optional)      | For CI/CD pipeline automation                                    |

## 🔄 How to Run the Tests  

### Running Tests via TestNG XML  

| **Test Suite**   | **Description**                                                       | **Command to Run**                          |
|------------------|-----------------------------------------------------------------------|--------------------------------------------|
| master.xml       | Executes the entire test suite, covering all scenarios.               | `mvn test -DsuiteXmlFile=master.xml`       |
| grouping.xml     | Runs specific groups of tests (e.g., Sanity, Regression, EndToEnd).| `mvn test -DsuiteXmlFile=grouping.xml`    |

### 🔄 Running Commands in cmd or Git Bash   

You can run these commands in **Command Prompt (cmd)** or **Git Bash**, as shown below:

#### 1️⃣ **Using Command Prompt (Windows):**  
1. Open **Command Prompt**.
2. Navigate to your project directory:
   
   ```bash
   cd path\to\your\project
   ```
3. Run the command to execute the full test suite:
   
   ```bash
   mvn test -DsuiteXmlFile=master.xml
   ```
4. Or run specific test groups:
   
   ```bash
   mvn test -DsuiteXmlFile=grouping.xml
   ```


   
#### 2️⃣ **Using Git Bash:**
1. Open **Git Bash**.
2. Navigate to your project directory:
   
   ```bash
   cd /c/path/to/your/project
   ```
3. Run the same command to execute the full test suite:
   
   ```bash
   mvn test -DsuiteXmlFile=master.xml
   ```
4. Or run specific test groups:
   
   ```bash
   mvn test -DsuiteXmlFile=grouping.xml
   ```

### 3️⃣ Running Tests Using `run.bat` (Windows Users)  

For convenience, use the provided **`run.bat`** script to run tests:  

1. **Double-click** the `run.bat` file in your project root directory to execute it.
   
   **OR**

2. Open **Command Prompt** or **Git Bash**.

   1. Navigate to your project root directory:
      ```bash
      cd path\to\your\project
      ```
      (In Git Bash, use `cd /c/path/to/your/project`.)

   2. Run the script by typing:
      ```bash
      run.bat
      ```
   
This script automates the Maven test execution. Ensure:
1. **Maven** and **Java** are installed and available in your system’s **PATH**.
2. You run the script from the **project root directory**.

### 4️⃣ Running Tests from an IDE (e.g., Eclipse or IntelliJ IDEA)  

1. **Open your project in your preferred IDE** (Eclipse, IntelliJ IDEA, etc.).
2. Navigate to the `master.xml` or `grouping.xml` file in your project explorer.
3. Right-click on the XML file and select **Run As** -> **Maven test**.
4. The IDE will execute the tests defined in the selected XML file.

## 🛠️ Jenkins Integration
This project supports Jenkins for Continuous Integration and Continuous Delivery (CI/CD). By configuring Jenkins, you can automate the triggering of test executions every time changes are pushed to the repository. This helps ensure that all tests are run consistently, maintaining code quality and stability throughout the development lifecycle.
