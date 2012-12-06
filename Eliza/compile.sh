mkdir classes
javac -d classes -sourcepath src -classpath lib/log4j/log4j-api-2.0-beta3.jar src/fortress/CommandLine.java
cp src/log4j2-test.xml classes/
