# 1.JDK version used

I have installed the JDK 17.

To configure java properly Environment variables was set
Variable Name: JAVA_HOME
Variable Value: C:\Program Files\Java\jdk-17

The PATH variable was updated to include:
%JAVA_HOME%\bin

Checking Java Installation

java -version
java version "17.0.8"

javac -version
javac 17.0.8


# 2 .Hello World Program

   Code:

   public class HelloWorld {
   public static void main(String[] args) {
   System.out.println("Hello, World!");
   }
   }

1.Save the file as HelloWorld.java.
2.Open terminal / command prompt in the location where the file is saved.
3.Compile the program using:
javac HelloWorld.java
4.After compilation, a file named HelloWorld.class is generated.
This file contains Java bytecode.
5.Run the compiled program using:
java HelloWorld
6.Output:
Hello, World!