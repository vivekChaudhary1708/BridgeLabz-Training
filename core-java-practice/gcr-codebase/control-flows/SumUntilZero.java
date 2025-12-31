// Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement
// Hint => 
// Use infinite while loop as in while (true)
// Take the user entry and check if the user entered 0 or a negative number to break the loop using break;

import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        double total = 0.0;
        double number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        // Infinite loop to take user input until 0 or negative number is entered
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            number = input.nextDouble();
            
            // Check if the number is 0 or negative to break the loop
            if (number <= 0) {
                break; // Exit the loop
            }
            
            total += number; // Add the entered number to total
        }
        
        System.out.println("The total sum is: " + total);
        
        // Close the scanner
        input.close();
    }
}