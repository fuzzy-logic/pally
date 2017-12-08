# pally

A friendly functional finder of palindromes in 'a man, a plan, a canal - Panama'!

NOTES:

Only works with "Happy path" palindromes to pass coding test, eg: Does not find palindromes with odd number of letters



# Installing project dependencies

You will need java 1.8 and maven installed to run.

Install maven from https://maven.apache.org/install.html

Install java 1.8 from: http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html



# Running the application for the code challenge

To run the program and get it's output for the code challenge run the following command from your shell in the project root directory:

```
git clone https://github.com/fuzzy-logic/pally.git
cd pally
mvn -q exec:java
```

or run main method of class com.wordsmith.pally.PalindromeFinder



# Running tests

To execute tests run the following command from your shell in the project root directory:

```
mvn test
```
