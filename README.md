# EcommerceAutomationDemo
Retail Project Automation

Automation Approach: Selenium-Cucumber BDD-Java-Maven-JUnit-TestRunner:

This repository contains a collection of sample selenium-cucumber-java project and libraries that
demonstrate how to use the tool and develop automation script using the Cucumber BDD framework
with Java as programming language. It is capable of generating HTML reports. It also generates
screenshots for your error shots for your failed test cases as well.

Installation (pre-requisites)

JDK 1.8+ (make sure Java class path is set)
Maven (make sure .m2 class path is set)
IntelliJ/Eclipse
IntelliJ/Eclipse Plugins for
Maven dependencies (selenium-java: v3.141.59, cucumber-java: v6.10.4, webdrivermanager: 5.1.1, cucumber-java8: 6.11.0,
cucumber-junit: 6.10.4, junit.version 4.13.2)
Cucumber
Browser driver (Framework is initialized with Chrome and Edge Browser. And it can take any browser if initialized)

Framework set up

Fork / Clone repository from "https://github.com/PrakiGit21/EcommerceAutomationDemo.git"
or download zip and set it up in your local workspace.

Run Some Sample Tests

1. Run the Feature Files individually from the .feature files, by right click Run 'Feature: FEATURE_NAME

Areas to look for improvements/corrections:
Running as Maven mvn tests
Running from TestRunner file

Reporters

Once your tests are completed system generates the cucumber.html. This framework selenium-cucumber-java
may be enhanced in the future to have different types of test reporters to communicate pass/failure.

The Page Object Design Pattern

Within your web app's UI there are areas that your tests interact with. A Page Object simply models these as objects within the test code.
This reduces the amount of duplicated code and means that if the UI changes, the fix is only applied in one place.
In other words one of the challenges of writing test automation is keeping your [selectors] ( classes, id's, or xpath' etc.)
up to date with the latest version of your code. The next challenge is to keep the code you write nice and DRY (Don't Repeat Yourself).
The page object pattern helps us accomplish this in one solution. Instead of including our selectors in our step definitions(in cucumber)
we instead place them in a .java file where we can manage all these selectors and methods together.
Your test file should only call the test methods.

You can also place reusable methods or logic inside of these pages and call them from your step java files.
The page object serves as a layer of abstraction between tests and code. When A test fails, it fails on a individual step.
That step may call a selector that is no longer valid, but that selector may be used by many other steps.
By having a single source of truth of what the selector is supposed to be, fixing one selector on the page object could
repair a number of failing tests that were affected by the same selector.

Initial Contributions By

Sivaprakash Ramasethu
29-06-2022 5.30 AM
