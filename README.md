# X-Code-Interpreter
Interpreter for  Unique X-Code Language written in Java

This program takes an .x [x-code] filename as an arguement, converts it to byte-code, and executes the bytecode on a virtual machine. 

The x-code language resembles that of pseudocode Java or C++. 

Programs are limited by 32-bit integers; the bytecode and VM are configured to use 32-bit ints. 


The purpose of this interpreter is to more deeply understand the way that java-code is compiled and ran on machines from the top-down. 
The compilation path emulates that of a java compiler and JVM. 
