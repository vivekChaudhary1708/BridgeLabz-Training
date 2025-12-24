// Write a program to check for the natural number and write the sum of n natural numbers 
// Hint => 
// A Natural Number is a positive integer (1,2,3, etc) sometimes with the inclusion of 0
// A sum of n natural numbers is n * (n+1) / 2 
// I/P => number
// O/P => If the number is a positive integer then the output is
// The sum of ___ natural numbers is ___
// Otherwise 
// The number ___ is not a natural number

import java.util.Scanner;
public class NaturalNumber {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        number = input.nextInt();
        
        // Check if the number is a natural number (positive integer)
        if (number >= 1) {
            // Calculate the sum of n natural numbers
            int sum = number * (number + 1) / 2;
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        
        // Close the scanner
        input.close();
    }
}