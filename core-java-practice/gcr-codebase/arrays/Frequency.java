// Create a program to take a number as input find the frequency of each digit in the number using an array and display the frequency of each digit
// Hint => 
// Take the input for a number
// Find the count of digits in the number
// Find the digits in the number and save them in an array
// Find the frequency of each digit in the number. For this define a frequency array of size 10, Loop through the digits array, and increase the frequency of each digit
// Display the frequency of each digit in the number

import java.util.Scanner;
public class Frequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number
        System.out.print("Enter a number to find the frequency of each digit: ");
        int number = scanner.nextInt();
        int tempNumber = number;

        // Finding the count of digits
        int digitCount = 0;
        while (tempNumber != 0) {
            tempNumber /= 10;
            digitCount++;
        }

        // Storing digits in an array
        int[] digits = new int[digitCount];
        tempNumber = number;
        for (int i = 0; i < digitCount; i++) {
            digits[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        // Finding frequency of each digit
        int[] frequency = new int[10]; // Digits range from 0 to 9
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        // Displaying the frequency of each digit
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }

        scanner.close();
    }
}