// Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
// Hint => 
// Take user input for the age and height of the 3 friends and store it in a variable
// Find the smallest of the 3 ages to find the youngest friend and display it
// Find the largest of the 3 heights to find the tallest friend and display it

import java.util.Scanner;;
public class YoungestFriends {
    public static void main(String[] args) {
        int ageAmar, ageAkbar, ageAnthony;
        double heightAmar, heightAkbar, heightAnthony;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        // Taking ages as input
        System.out.print("Enter Amar's age: ");
        ageAmar = input.nextInt();
        
        System.out.print("Enter Akbar's age: ");
        ageAkbar = input.nextInt();
        
        System.out.print("Enter Anthony's age: ");
        ageAnthony = input.nextInt();
        
        // Taking heights as input
        System.out.print("Enter Amar's height (in cm): ");
        heightAmar = input.nextDouble();
        
        System.out.print("Enter Akbar's height (in cm): ");
        heightAkbar = input.nextDouble();
        
        System.out.print("Enter Anthony's height (in cm): ");
        heightAnthony = input.nextDouble();
        
        // Finding the youngest friend
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Amar is the youngest friend.");
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            System.out.println("Akbar is the youngest friend.");
        } else if (ageAnthony < ageAmar && ageAnthony < ageAkbar) {
            System.out.println("Anthony is the youngest friend.");
        } else {
            System.out.println("There is a tie for the youngest friend.");
        }
        
        // Finding the tallest friend
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Amar is the tallest friend.");
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            System.out.println("Akbar is the tallest friend.");
        } else if (heightAnthony > heightAmar && heightAnthony > heightAkbar) {
            System.out.println("Anthony is the tallest friend.");
        } else {
            System.out.println("There is a tie for the tallest friend.");
        }
        
        // Close the scanner
        input.close();
    }
}