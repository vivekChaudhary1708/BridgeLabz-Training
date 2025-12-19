// Create a program to find the power of a number.
// Hint => 
// Get integer input for two variables - number and power and check for positive integer
// Create a result variable with an initial value of 1.
// Run a for loop from i = 1 to i <= power. In each iteration of the loop, multiply the result by the number and assign the value to the result. Finally, print the result

import java.util.Scanner;
public class Pow {  
    public static void main(String[] args) {
        int number, power;
        int result = 1; // Initialize result variable
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer as the base number: ");
        number = input.nextInt();
        
        System.out.print("Enter a positive integer as the exponent (power): ");
        power = input.nextInt();
        
        // Check if both number and power are positive integers
        if (number > 0 && power >= 0) {
            // Calculate power using for loop
            for (int i = 1; i <= power; i++) {
                result *= number; // Multiply result by number
            }
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        } else {
            System.out.println("Both base number and exponent must be positive integers.");
        }
        
        // Close the scanner
        input.close();
    }
}