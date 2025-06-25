Project Overview
This project is a Maven-based Automation framework utilizing a Behavior-Driven Development (BDD) approach with Cucumber.
This framework is designed with Page Object design pattern to enhance Maintainability and Scalability.
Additionally this project uses PicoContainer to handle Dependency injection, improving Code structure and Test maintenance.

Technologies Used:
    Java: Version 21
    Selenium: Version 4.33

Folder Structure:
   src/main/java:
       Contains all page object classes and utility classes.
   src/main/resources:
       Contains properties files.
   src/test/java:
       Contains Cucumber feature files, step definition classes and test runner files.

Test Coverage:
    Number of Test Cases: 9
    Scope: All test cases are designed to validate the Job search functionality.

Execution Instructions:
    The framework supports execution via the command line using Maven commands,

To execute with a specific browser:
     mvn test -DBrowser=browserName   [By Default tag: @Regression]
    Ex:  mvn test -DBrowser=chrome
    
To execute with a specific browser and filter test cases by tag:
    mvn test -DBrowser=browserName -Dcucumber.filter.tags="@tagName"
    EX: mvn test -DBrowser=browserName -Dcucumber.filter.tags="@Smoke"

Valid Browser Values:
    chrome, firefox

Valid Tag Values:
     Smoke, Regression, Sanity

Screenshots and Report:
Screenshot:
   Screenshots are taken during tests and saved inside the “screenshot” folder, which is under the “target” folder.
Report:
   Cucumber test reports are automatically created and saved in the “cucumber-reports” folder, which is also inside the “target” folder.
