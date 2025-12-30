// Write a program to check if the first is the smallest of the 3 numbers.
// I/P => number1, number2, number3
// O/P => Is the first number the smallest? ____

import java.util.Scanner;
public class SmallestElement {
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
        
        // Check if the first number is the smallest
        boolean isSmallest = (number1 < number2) && (number1 < number3);
        
        System.out.println("Is the first number the smallest? " + isSmallest);
        
        // Close the scanner
        input.close();
    }
}