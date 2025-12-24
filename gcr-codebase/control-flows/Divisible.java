// Write a program to check if a number is divisible by 5
// I/P => number
// O/P => Is the number ___ divisible by 5? ___

import java.util.Scanner;
public class Divisible {
    public static void main(String[] args) {
        int number;
        // input user se lene ke liye
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        number = input.nextInt();
        
        // Check if the number is divisible by 5
        boolean isDivisible = (number % 5 == 0);
        
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
        
        // Close the scanner
        input.close();
    }
}