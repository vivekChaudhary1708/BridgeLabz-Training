// Create a program to find the multiplication table of a number entered by the user from 6 to 9 and display the result
// Hint => 
// Take integer input and store it in the variable number as well as define an integer array to store the multiplication result in the variable multiplicationResult
// Using a for loop, find the multiplication table of numbers from 6 to 9 and save the result in the array
// Finally, display the result from the array in the format number * i = ___

import java.util.Scanner;
public class Multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number
        System.out.print("Enter a number to find its multiplication table from 6 to 9: ");
        int number = scanner.nextInt();
        int[] multiplicationResult = new int[4]; // To store results for 6, 7, 8, and 9

        // Generating multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Displaying the multiplication results
        System.out.println("Multiplication Table of " + number + " from 6 to 9:");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        scanner.close();
    }
}