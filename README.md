### Introduction

This project contains the code and instructions for running console application that accepts a file 
containing list of facts, grouped by first/last name and up votes and writes sorted grouped facts to a file on directory.

Technologies used:
* Java 8
* Gradle 6

Below commands are tested on MacOs.

#### <a href="build-api"></a> Build

* Clone this repo into a directory `clone https://github.com/usmansaleemch/catfacts.git `
* Change directory to the newly cloned repo: `cd catfacts`
* Execute `./gradlew clean build`


#### <a href="launch-api"></a> Run 

* Run Console Application  `./gradlew run --args="facts.psv"`

Input file can be placed anywhere and path should be provided accordingly e.g.
`./gradlew run --args="/Users/username/facts.psv"`

Output file is currently stored in `src/main/resources/` folder.

#### <a href="launch-api"></a> Test 

* Test Customer Profile API `./gradlew test`

Test reports can be found at build/reports/tests/test/index.html

