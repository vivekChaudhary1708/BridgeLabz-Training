// Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch
// Hint => 
// Create a variable counter to take user inputted value for the countdown.
// Use the while loop to check if the counter is 1
// Inside a while loop, print the value of the counter and decrement the counter.

import java.util.Scanner;
public class RocketLaunch {
    public static void main(String[] args) {
        int counter;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the countdown start number: ");
        counter = input.nextInt();
        
        // Countdown using while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // Decrement the counter
        }
        
        System.out.println("Rocket Launched!");
        
        // Close the scanner
        input.close();
    }
}