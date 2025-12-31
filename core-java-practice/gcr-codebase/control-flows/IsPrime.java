// Write a Program to check if the given number is a prime number or not
// Hint => 
// A number that can be divided exactly only by itself and 1 are Prime Numbers,
// Prime Numbers checks are done for numbers greater than 1
// Loop through all the numbers from 2 to the user input number and check if the reminder is zero. If the reminder is zero break out from the loop as the number is divisible by some other number and is not a prime number. 
// Use the isPrime boolean variable to store the result

import java.util.Scanner;
public class IsPrime {
    public static void main(String[] args) {
        int number;
        boolean isPrime = true; // Variable to track if the number is prime
        
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        number = input.nextInt();
        
        // Check if the number is greater than 1
        if (number > 1) {
            // Loop from 2 to the square root of the number
            for (int i = 2; i <= Math.sqrt(number); i++) {
                // Check if the number is divisible by i
                if (number % i == 0) {
                    isPrime = false; // Number is not prime
                    break; // Exit the loop
                }
            }
        } else {
            isPrime = false; // Numbers less than or equal to 1 are not prime
        }
        
        // Output the result
        if (isPrime) {
            System.out.println("The number " + number + " is a prime number.");
        } else {
            System.out.println("The number " + number + " is not a prime number.");
        }
        
        // Close the scanner
        input.close();
    }
}