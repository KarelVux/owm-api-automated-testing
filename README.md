# Course project: Owm api automated testing

## Installation

Use given code to install mvn dependencies and run project tests in src/test folder.
```
mvn install
```
Use given code to install mvn dependencies and skip tests.

```
mvn -Dmaven.test.skip=true package
```

## Team
Author of this project is Karel Vuks

## Technological stack
* JDK 8
* Maven
* Junit
* Rest assured
* Assertj core
* Mockito core
* Jersey client
* Jersey json

## Usage
To get current weather report and 3 day forecast. You must activate command:
```
mvn exec:java -Dexec.mainClass=ee.icd0004.project.OwmForecastRequester
```
This  will activate class `src/main/java/ee/icd0004/project/OwmForecastRequester.java`.

By default, program will read city names form `createdWeatherReportJsonFiles/inputData/info.json` file. All porgram inputfiles must be in json format.

**Example input file:**
```
{
  "cityList": [
    "Tallinn",
    "Keila"
  ]
}
```
Generated weather reports will be stored inside `createdWeatherReportJsonFiles/outputData` directory.

## Running tests
To run all tests use command:
```
mvn test
```

## Openweathermap api
For current weather data program will use current weather forecast api `https://openweathermap.org/current` 
For 3 day forecast data program will use 5 day weather forecast api `https://openweathermap.org/forecast5` 


## Program logging
Programm will generate log when there are problems in:
* When existing weather report file for city is being overwritten
* When an error occurs for invalid city name(s) then application logs ERROR message for that city.

All generated logs will be stored inside ```logs/owmLog.log``` file. Everytime new process is activate ownLog.log file will be overwritten.

## Commit messages
This project was developed my using test driven development method. 
Commit messages base layout:
```
[Test number]: [Test step], [Description]
```

```[Test number]``` - All cases are written in ```tests.md```

```[Test step]``` - Describes in what stage of development is current code

```[Description]``` - Given field will be added when needed

Example:
```
REQ 18: Add failing test, unsupported filetype
```