// Write a program that takes your height in centimeters and converts it into feet and inches
// Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
// I/P => height
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___

import java.util.Scanner;
public class height {   
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        
        // Convert height from cm to inches
        double heightInches = heightCm / 2.54;
        // Convert height from inches to feet and remaining inches
        int feet = (int) (heightInches / 12);
        double inches = heightInches % 12;

        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches);
        
        // Close the scanner
        input.close();
    }
}