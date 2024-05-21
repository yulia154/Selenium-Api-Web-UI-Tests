# Selenium Rest Api and Web UI test
this test is to 
- automate rest API for GET, POST, PUT, and DELETE
- automate WEB UI tests

## pre-requisites
1. install OpenJDK below is one of the ways to do it on mac :

         brew install openjdk
## IDE setup
Below are the steps to set this project up with Intellij IDEA :
1. clone project using 'git'
2. open the directory of this project ('Selenium-Api-Web-UI-Tests') from Intellij IDEA
3. the project will be initialized. wait until it finishes downloading Gradle and its dependencies
4. Open 'preferences' -> 'plugin'. install the following plugins (if not already)
   - Gherkin
   - Cucumber
  
## run the project
 below are the ways to run the project
- to run all the tests
  
            ./gradlew cucumber
  
- to run only for a speciffic scenario
  open .feature file on feature package -> click run button on a specific scenario
- to run all the sceario for specific feature
  open .feature file on feature package -> click run button on the feature
- to run all the API scenarios 
  open APIRunner on runner package -> click run button
- to run all WEB UI scenarios
  open WEBUIRunner on runner package -> click run button

## test result
All the tests
![image](https://github.com/yulia154/Selenium-Api-Web-UI-Tests/assets/75233715/974fc3b1-a03d-4fd6-896c-4adf20a1b2bc)

API tests
![image](https://github.com/yulia154/Selenium-Api-Web-UI-Tests/assets/75233715/74fd0231-1f24-4be2-b31b-ed70ec52413e)

WEB UI Tests
![image](https://github.com/yulia154/Selenium-Api-Web-UI-Tests/assets/75233715/63a64dd1-6f6b-4702-862c-9007554d05a9)

## test report
API Tests
![image](https://github.com/yulia154/Selenium-Api-Web-UI-Tests/assets/75233715/cad47fb1-2987-4c0c-bcae-90b11430de2b)


WEB UI Tests
![image](https://github.com/yulia154/Selenium-Api-Web-UI-Tests/assets/75233715/c2d48555-bcaa-4e73-ba7a-bc7712e0f601)


