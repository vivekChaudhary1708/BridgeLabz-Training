// Write an IntOperation program by taking a, b, and c as input values and print the following integer operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the precedence of the operators. 
// Hint => 
// Create variables a, b, and c of int data type.
// Take user input for a, b, and c.
// Compute 3 integer operations and assign the result to a variable
// Finally, print the result and try to understand operator precedence.
// I/P => fee, discountPrecent
// O/P => The results of Int Operations are ___, ___, and ___

import java.util.Scanner;
public class IntOperation {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first integer (a): ");
        int a = input.nextInt();
        
        System.out.print("Enter the second integer (b): ");
        int b = input.nextInt();
        
        System.out.print("Enter the third integer (c): ");
        int c = input.nextInt();
        
        // Perform integer operations
        int operation1 = a + b * c; // b * c is evaluated first due to operator precedence
        int operation2 = a * b + c; // a * b is evaluated first due to operator precedence
        int operation3 = c + a / b; // a / b is evaluated first due to operator precedence
        int operation4 = a % b + c; // a % b is evaluated first due to operator precedence

        System.out.println("The results of Int Operations are " + operation1 + ", " + operation2 + ", " + operation3 + ", and " + operation4);
        
        // Close the scanner
        input.close();
    }
}