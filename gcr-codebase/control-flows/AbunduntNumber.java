// Create a program to check if a number is an Abundant Number.
// Hint => 
// An abundant number is an integer in which the sum of all the divisors of the number is greater than the number itself. For example,
// Divisor of 12: 1, 2, 3, 4, 6
// Sum of divisor: 1 + 2 + 3 + 4 + 6 = 16 > 12
// Get an integer input for the number variable.
// Create an integer variable sum with initial value 0.
// Run a for loop from i = 1 to i < number.
// Inside the loop, check if number is divisible by i.
// If true, add i to sum.
// Outside the loop Check if sum is greater than number.
// If the sum is greater than the number, print Abundant Number. Otherwise, print Not an Abundant Number.

import java.util.Scanner;
public class AbunduntNumber {  
    public static void main(String[] args) {
        int number, sum = 0;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer to check if it is an Abundant Number: ");
        number = input.nextInt();
        
        // Calculate the sum of divisors
        for (int i = 1; i < number; i++) {
            // Check if i is a divisor of number
            if (number % i == 0) {
                sum += i; // Add the divisor to sum
            }
        }
        
        // Check if the sum of divisors is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is Not an Abundant Number.");
        }
        
        // Close the scanner
        input.close();
    }
}