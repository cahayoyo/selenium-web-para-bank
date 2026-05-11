# ParaBank Selenium Automation Framework

[![Java Version](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Selenium Version](https://img.shields.io/badge/Selenium-4.43.0-green.svg)](https://www.selenium.dev/)
[![TestNG Version](https://img.shields.io/badge/TestNG-7.12.0-blue.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red.svg)](https://maven.apache.org/)

## 📌 Project Overview

This project is a robust, production-ready automation framework designed to test the **ParaBank** banking application. It implements the **Page Object Model (POM)** design pattern to ensure maintainability, scalability, and reusability of the automation scripts.

The framework provides comprehensive coverage for critical modules such as User Registration and Login, featuring advanced reporting, detailed logging, and automated failure recovery.

## 🚀 Key Features

*   **Page Object Model (POM):** Decoupled test logic from UI elements for better maintainability.
*   **Comprehensive Reporting:** Integrated with **ExtentReports** for rich, interactive HTML reports.
*   **Advanced Logging:** Utilizes **Log4j2** for detailed execution tracing and debugging.
*   **Screenshot Capture:** Automatically captures screenshots on test failure and attaches them to the report.
*   **Data-Driven Configuration:** Centralized management of test data and environment URLs via a `Config` class.
*   **Robust Assertions:** Uses TestNG's `SoftAssert` for comprehensive verification without early termination of tests.
*   **Dynamic Data Generation:** Logic to generate unique usernames to ensure registration tests can be run repeatedly without data collisions.

## 🛠 Technology Stack

*   **Language:** Java 17
*   **UI Automation:** Selenium WebDriver (4.43.0)
*   **Testing Framework:** TestNG
*   **Build Tool:** Maven
*   **Reporting:** ExtentReports
*   **Logging:** Log4j2
*   **Utilities:** Lombok, Commons IO, Jakarta Mail

## 📂 Project Structure

```text
selenium-para-bank/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/               # Base test configurations and setup
│   │   │   ├── pages/              # Page Object classes (POM)
│   │   │   └── utils/              # Helper classes, Config, Logging, Reporting
│   │   └── resources/
│   │       └── log4j2.xml          # Logging configuration
│   └── test/
│       └── java/
│           └── tests/              # Test suites and test cases
├── logs/                           # Execution logs generated during runs
├── reports/                        # ExtentReports HTML output
├── screenshots/                    # Failure and step-by-step screenshots
├── pom.xml                         # Maven dependencies and build settings
└── testng.xml                      # Test execution suite configuration
```

## 📋 Prerequisites

Before running the tests, ensure you have the following installed:

*   **Java Development Kit (JDK) 17** or higher.
*   **Apache Maven**.
*   **Google Chrome Browser**.
*   (Optional) An IDE like **IntelliJ IDEA** or **Eclipse**.

## ⚙️ Setup & Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/selenium-para-bank.git
    cd selenium-para-bank
    ```

2.  **Install dependencies:**
    ```bash
    mvn clean install
    ```

## 🏃 Running Tests

### Via Command Line (Maven)
To run the default test suite defined in `testng.xml`:
```bash
mvn test
```

### Via IDE (IntelliJ IDEA)
1.  Right-click on `testng.xml` and select **Run '...testng.xml'**.
2.  Alternatively, run individual test classes from `src/test/java/tests/`.

## 📊 Reporting & Results

After execution, you can find the detailed test reports and execution artifacts in the following directories:

*   **ExtentReport:** `reports/Index.html` (Open this file in any web browser).
*   **Logs:** `logs/app.log` (Check for detailed execution steps).
*   **Screenshots:** `screenshots/` (Contains screenshots captured during test steps and on failures).

## 📄 License

This project is for educational and portfolio purposes.
