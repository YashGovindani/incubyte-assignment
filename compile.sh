javac -d ./classes ./src/incubyte/*.java
cd classes
jar -cvf ../dist/isc.jar incubyte
