// Rewrite the program to find all the multiples of a number below 100 using while loop.
// Hint => 
// Get the input value for a variable named number. Check the number is a positive integer and less than 100.
// Create a counter variable and assign counter = number - 1; Use a while till the counter is > 1
// Inside the loop, check if the counter perfectly divides the number. If true, print the number and continue the loop.

import java.util.Scanner;
public class MultiplesBelow100 {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100 to find its multiples: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer and less than 100
        if (number > 0 && number < 100) {
            System.out.println("The multiples of " + number + " below 100 are:");
            int counter = 100; // Initialize counter variable
            
            // Find multiples using while loop
            while (counter >= 1) {
                // Check if counter is a multiple of number
                if (counter % number == 0) {
                    System.out.println(counter); // Print the multiple
                }
                counter--; // Decrement the counter
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer less than 100.");
        }
        
        // Close the scanner
        input.close();
    }
}