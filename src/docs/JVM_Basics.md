# JVM Basics

## 1. What is JDK, JRE, JVM?

JDK (Java Development Kit):
JDK is a complete package used to develop Java applications.
It includes tools like the Java compiler (`javac`) and also contains JRE.

JRE (Java Runtime Environment):
JRE provides the environment required to run Java programs.
It includes JVM and standard libraries needed for execution.

JVM (Java Virtual Machine):
JVM is responsible for running Java programs.
It takes the bytecode and converts it into machine-level instructions that the system can understand.


## 2. What is Bytecode?

Bytecode is the intermediate code generated after compiling a Java program using the `javac` compiler.

It is stored in `.class` files and is not specific to any machine.
This makes Java programs portable across different systems.


## 3. What does "Write Once, Run Anywhere" mean?

"Write Once, Run Anywhere" means that a Java program can be written once and run on any system without modification.

When a Java program is compiled, it is converted into bytecode instead of machine-specific code. This bytecode can run on any device that has a JVM installed.

Because every operating system has its own JVM implementation, the same Java program can run on Windows, Linux, or Mac without changing the code. This makes Java platform-independent.
