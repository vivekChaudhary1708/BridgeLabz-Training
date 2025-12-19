// Rewrite the above program 7 to find the factors of a number using the while loop
// Hint => 
// Get the input value for a variable named number and check if it is a positive integer.
// Create a counter variable and run the _**while**_ loop till the counter is less than the user input number. In each iteration of the loop, check if the number is perfectly divisible by the counter. If true, print the value of the counter.

import java.util.Scanner;
public class FactorsUsingLoop {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its factors: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer
        if (number > 0) {
            System.out.println("The factors of " + number + " are:");
            int counter = 1; // Initialize counter variable
            
            // Find factors using while loop
            while (counter <= number) {
                // Check if counter is a factor of number
                if (number % counter == 0) {
                    System.out.println(counter); // Print the factor
                }
                counter++; // Increment the counter
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer.");
        }
        
        // Close the scanner
        input.close();
    }
}