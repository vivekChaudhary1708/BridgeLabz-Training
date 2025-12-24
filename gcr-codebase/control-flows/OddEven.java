// Create a program to print odd and even numbers between 1 to the number entered by the user.
// Hint => 
// Get an integer input from the user, assign to a variable number and check for Natural Number
// Using a for loop, iterate from 1 to the number
// In each iteration of the loop, print the number is odd or even number

import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        number = input.nextInt();
        
        // Check if the number is a natural number (positive integer)
        if (number >= 1) {
            // Iterate from 1 to the entered number
            for (int i = 1; i <= number; i++) {
                // Check if the number is odd or even
                if (i % 2 == 0) {
                    System.out.println(i + " is an even number.");
                } else {
                    System.out.println(i + " is an odd number.");
                }
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
        
        // Close the scanner
        input.close();
    }
}