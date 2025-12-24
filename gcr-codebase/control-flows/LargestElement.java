// Write a program to check if the first, second, or third number is the largest of the three.
// I/P => number1, number2, number3
// O/P => 
// Is the first number the largest? ____
// Is the second number the largest? ___
// Is the third number the largest? ___

import java.util.Scanner;
public class LargestElement {
    public static void main(String[] args) {
        int number1, number2, number3;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        number1 = input.nextInt();
        
        System.out.print("Enter second number: ");
        number2 = input.nextInt();
        
        System.out.print("Enter third number: ");
        number3 = input.nextInt();
        
        // Determine the largest using if-else chain (mirrors original strict '>' logic)
        boolean isFirstLargest, isSecondLargest, isThirdLargest;
        if ((number1 > number2) && (number1 > number3)) {
            isFirstLargest = true;
            isSecondLargest = false;
            isThirdLargest = false;
        } else if ((number2 > number1) && (number2 > number3)) {
            isFirstLargest = false;
            isSecondLargest = true;
            isThirdLargest = false;
        } else if ((number3 > number1) && (number3 > number2)) {
            isFirstLargest = false;
            isSecondLargest = false;
            isThirdLargest = true;
        } else {
            // No single number is strictly greater than the others (ties or all equal)
            isFirstLargest = false;
            isSecondLargest = false;
            isThirdLargest = false;
        }

        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);
        
        // Close the scanner
        input.close();
    }
}