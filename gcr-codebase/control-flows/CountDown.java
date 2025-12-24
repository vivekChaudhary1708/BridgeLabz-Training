// Rewrite program 8 to do the countdown using the for-loop

import java.util.Scanner;
public class CountDown {
    public static void main(String[] args) {
        int counter;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the countdown start number: ");
        counter = input.nextInt();
        
        // Countdown using for loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        System.out.println("Rocket Launched!");
        
        // Close the scanner
        input.close();
    }
}