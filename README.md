# Course project: Owm api automated testing

## Installation

Use given code to install mvn dependencies and run project tests in src/test folder.
```
mvn install
```

## Usage
To get current weather report and 3 day forecast. You must activate command:
```
mvn exec:java -Dexec.mainClass=ee.icd0004.project.OwmForecastRequester
```
This  will activate class `src/main/java/ee/icd0004/project/OwmForecastRequester.java`.
By default, program will read city names form `createdWeatherReportJsonFiles/inputData/info.json` file and generate weather report to  `createdWeatherReportJsonFiles/outputData` directory.

