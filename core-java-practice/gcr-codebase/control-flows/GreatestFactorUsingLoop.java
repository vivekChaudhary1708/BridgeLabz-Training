// Rewrite the above program to print the greatest factor of a number beside itself using a while loop.
// Hint => 
// Get an integer input and assign it to the number variable. As well as define a greatestFactor variable and assign it to 1
// Create a variable counter and assign counter = number - 1; Use the while loop till the counter is equal to 1.
// Inside the loop, check if the number is perfectly divisible by the counter then assign the counter to greatestFactor variable and break the loop.
// Display the greatestFactor variable outside the loop

import java.util.Scanner;;
public class GreatestFactorUsingLoop {
    public static void main(String[] args) {
        int number;
        int greatestFactor = 1; // Initialize greatestFactor variable
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its greatest factor: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer
        if (number > 1) {
            int counter = number - 1; // Initialize counter variable
            
            // Find greatest factor using while loop
            while (counter >= 1) {
                // Check if counter is a factor of number
                if (number % counter == 0) {
                    greatestFactor = counter; // Assign counter to greatestFactor
                    break; // Exit the loop
                }
                counter--; // Decrement the counter
            }
            System.out.println("The greatest factor of " + number + " besides itself is: " + greatestFactor);
        } else {
            System.out.println("The number " + number + " does not have a greatest factor beside itself.");
        }
        
        // Close the scanner
        input.close();
    }
}