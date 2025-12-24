// Rewrite the program 4 FizzBuzz using the while loop 

import java.util.Scanner;;
public class FizzBuzzLoop { 
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        number = input.nextInt();
        
        int counter = 1; // Initialize counter
        
        // FizzBuzz using while loop
        while (counter <= number) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (counter % 3 == 0) {
                System.out.println("Fizz");
            } else if (counter % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(counter);
            }
            counter++; // Increment counter
        }
        
        // Close the scanner
        input.close();
    }
}