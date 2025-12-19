// Rewrite the program number 12 with the for loop instead of a while loop to find the sum of n Natural Numbers. 
// Hint => 
// Take the user input number and check whether it's a Natural number
// If it's a natural number Compute using formulae as well as compute using for loop
// Compare the two results and print the result

import java.util.Scanner;
public class SumOfNaturalNumbers {  
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        number = input.nextInt();
        
        // Check if the number is a natural number (positive integer)
        if (number >= 1) {
            // Calculate the sum using formula
            int formulaSum = number * (number + 1) / 2;
            
            // Calculate the sum using for loop
            int loopSum = 0;
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }
            
            // Display both sums
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            
            // Compare the two results
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct and equal.");
            } else {
                System.out.println("There is a discrepancy between the two computations.");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        
        // Close the scanner
        input.close();
    }
}