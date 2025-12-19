// Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
// Hint => 
// Spring Season is from March 20 to June 20

import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args) {
        int month, day;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);

        // Ask for user's name first (examples provided)
        System.out.print("Enter your name (e.g., Ram or Shyam): ");
        String name = input.nextLine();

        System.out.print("Enter month (1-12): ");
        month = input.nextInt();

        System.out.print("Enter day (1-31): ");
        day = input.nextInt();
        
        // Check if the date is in Spring Season
        boolean isSpringSeason = (month == 3 && day >= 20) || 
                                 (month == 4) || 
                                 (month == 5) || 
                                 (month == 6 && day <= 20);
        
        if (isSpringSeason) {
            System.out.println(name + ", It's a Spring Season");
        } else {
            System.out.println(name + ", Not a Spring Season");
        }
        
        // Close the scanner
        input.close();
    }
}