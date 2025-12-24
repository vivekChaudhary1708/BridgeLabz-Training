// Create a program to find all the multiples of a number taken as user input below 100.
// Hint => 
// Get the input value for a variable named number. Check the number is a positive integer and less than 100.
// Run a for loop backward: from i = 100 to i = 1.
// Inside the loop, check if i perfectly divide the number. If true, print the number and continue the loop.

import java.util.Scanner;
public class MultiplesOfNumber {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100 to find its multiples: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer and less than 100
        if (number > 0 && number < 100) {
            System.out.println("The multiples of " + number + " below 100 are:");
            // Find multiples using for loop
            for (int i = 100; i >= 1; i--) {
                // Check if i is a multiple of number
                if (i % number == 0) {
                    System.out.println(i); // Print the multiple
                }
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer less than 100.");
        }
        
        // Close the scanner
        input.close();
    }
}