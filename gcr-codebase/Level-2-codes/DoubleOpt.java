// Similarly, write the DoubleOpt program by taking double values and doing the same operations.

import java.util.Scanner;
public class DoubleOpt {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first double value (a): ");
        double a = input.nextDouble();
        
        System.out.print("Enter the second double value (b): ");
        double b = input.nextDouble();
        
        System.out.print("Enter the third double value (c): ");
        double c = input.nextDouble();
        
        // Perform double operations
        double operation1 = a + b * c; // b * c is evaluated first due to operator precedence
        double operation2 = a * b + c; // a * b is evaluated first due to operator precedence
        double operation3 = c + a / b; // a / b is evaluated first due to operator precedence
        double operation4 = a % b + c; // a % b is evaluated first due to operator precedence

        System.out.println("The results of Double Operations are " + operation1 + ", " + operation2 + ", " + operation3 + ", and " + operation4);
        
        // Close the scanner
        input.close();
    }
}