// Create a program to print the greatest factor of a number beside itself using a loop.
// Hint => 
// Get an integer input and assign it to the number variable. As well as define a greatestFactor variable and assign it to 1
// Create a for loop that runs from last but one till 1 as in i = number - 1 to i = 1.
// Inside the loop, check if the number is perfectly divisible by i then assign i to greatestFactor variable and break the loop.
// Display the greatestFactor variable outside the loop

import java.util.Scanner;;
public class GreatestFactor {
    public static void main(String[] args) {
        int number;
        int greatestFactor = 1; // Initialize greatestFactor variable
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its greatest factor: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer
        if (number > 1) {
            // Find greatest factor using for loop
            for (int i = number - 1; i >= 1; i--) {
                // Check if i is a factor of number
                if (number % i == 0) {
                    greatestFactor = i; // Assign i to greatestFactor
                    break; // Exit the loop
                }
            }
            System.out.println("The greatest factor of " + number + " besides itself is: " + greatestFactor);
        } else {
            System.out.println("The number " + number + " does not have a greatest factor beside itself.");
        }
        
        // Close the scanner
        input.close();
    }
}