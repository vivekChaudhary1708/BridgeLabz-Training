// Write a program FizzBuzz, take a number as user input, and check for a positive integer. If positive integer, loop and print the number, but for multiples of 3 print "Fizz" instead of the number, for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz".
// Hint => 
// Take the user input number, check for a positive integer, and use for loop to display

import java.util.Scanner;;
public class FizzBuzz {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer
        if (number > 0) {
            // Loop from 1 to the entered number
            for (int i = 1; i <= number; i++) {
                // Check for multiples of 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } 
                // Check for multiples of 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } 
                // Check for multiples of 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } 
                // Print the number if not a multiple of 3 or 5
                else {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer.");
        }
        
        // Close the scanner
        input.close();
    }
}