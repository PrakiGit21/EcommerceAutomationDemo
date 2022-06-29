package com.ecommerce.automation.Utilities;

import java.io.File;

public interface Constants {

    String FILE_SEPERATOR = System.getProperty("file.seperator");
    String USER_DIR = System.getProperty("user.dir");
    String PACKAGE_NAME = "com" + FILE_SEPERATOR + "ecommerce" + FILE_SEPERATOR + "automation";

    //Folder Names
    String SOURCE_FOLDER_NAME = "src";
    String TEST_FOLDER_NAME = "test";
    String RESOURCES_FOLDER_NAME = "resources";
    String JAVA_FOLDER_NAME = "java";

    // Directories Absolute Path
    String SOURCE_DIR = USER_DIR + FILE_SEPERATOR + SOURCE_FOLDER_NAME;
    String TEST_DIR = SOURCE_DIR + FILE_SEPERATOR + TEST_FOLDER_NAME;
    String SOURCE_CODE_DIR = TEST_DIR + FILE_SEPERATOR + JAVA_FOLDER_NAME + FILE_SEPERATOR + PACKAGE_NAME;
    String RESOURCE_DIR = TEST_DIR + FILE_SEPERATOR + RESOURCES_FOLDER_NAME + FILE_SEPERATOR + PACKAGE_NAME;

    //path needed for cucumber runner class
    String CONFIG_DIR =  "S:\\EcommerceAutomation\\src\\test\\resources\\com.ecommerce.automation\\configurations\\";
    String FEATURES_DIR = "src/test/resources/com/ecommerce/automation/features/";
    String STEP_DEFINITIONS_DIR = "com/ecommerce/automation/StepDefinitions";
}
