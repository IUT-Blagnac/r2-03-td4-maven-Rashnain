@echo off

start mvn clean compile package
pause
java -jar target/tp_qualite-1.0.jar