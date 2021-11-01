# API_PET_STORE
Pet Store API

# Purpose
This solution contains automation script written to perform API TESTING on petstore API

# Technology Used 
##Cucumber
To leverage existing written test cases and
and provide reporting of tests executed in natural human language.

##RestAssured
Pre-written Library which is used because it brings the simplicity of use written in Java domain.

##IntelliJ
Integrated Development Environment of choice

##Maven
The Build tool of choice which allows us to build the project by downloading and building relevant 
dependencies required to run the project.

##GIT
Used for Version Control

##Test Approach.

The test approach used is POJOs (Plain old Java Objects). The use of POJOs allows 
flexibility in the maintenance and re-usability of payload and serialization of payload and de-serialzation of payload. 

Under the test/Java folder we have two subfolder
main/Java/org/example - this included all the POJO classes for objects of the payload.

test/Java/org/example - 
-this includes the appTest class which contains the methods that invoke the api 
-this includes the test Runner class 
This testRunner class is used to run the tests within the project. 

1. you may replace with any feature you wish to run,
2. you may include any tags within the specific feature you wish to run by typing "@runAll". this tag will ensure to run all scenarios which has that tags.

test/Java/Steps folder, 

-we also have the StepDefiniton class which contains the definition of each step
consumed in the cucumber feature files


## Getting Started.
1. Install IntelliJ
2. Ensure you have Java installed on your PC   
3. Make sure you have environments variable set for Java SDK
   Ensure you have git installed, it's usually installed with IntelliJ, but just double check to be sure
4. Open IntelliJ
   Click on file, New Project from Version control
   Version control - GIT
   Input the repo url 
   Input directory of choice and clone
   Give it a bit of time to download /clone
5. Ensure to install Cucumber java plugins for IntelliJ
6. Ensure to install Gherkin plugins for IntelliJ
7. Run a Maven Install or Maven verify to download the dependencies.
8. Ensure all dependencies in the Pom.xml are all downloaded and resolved.
9. You may run the test, directly from feature files, or through the use of test runner class.




