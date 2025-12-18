// Write a program to create a basic calculator for addition, subtraction, multiplication, and division. The program should ask for two numbers (floating point) and perform all the operations
// Hint => 
// Create a variable number1 and number2 and take user inputs.
// Perform Arithmetic Operations of addition, subtraction, multiplication, and division assign the result to a variable, and finally print the result
// I/P => number1, number2
// O/P => The addition, subtraction, multiplication, and division value of 2 numbers ___ and ___ is ___, ____, ____, and ___

import java.util.Scanner;
public class Calculator {   
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();
        
        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();
        
        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
        
        // Close the scanner
        input.close();
    }
}