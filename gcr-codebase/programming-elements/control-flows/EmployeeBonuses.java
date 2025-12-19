// Create a program to find the bonuses of employees based on their years of service.
// Hint => 
// Zara decided to give a bonus of 5% to employees whose year of service is more than 5 years.
// Take salary and year of service in the year as input.
// Print the bonus amount.

import java.util.Scanner;
public class EmployeeBonuses {
    public static void main(String[] args) {
        double salary;
        int yearsOfService;
        double bonus = 0.0;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the employee's salary: ");
        salary = input.nextDouble();
        
        System.out.print("Enter the employee's years of service: ");
        yearsOfService = input.nextInt();
        
        // Check if years of service is more than 5 to calculate bonus
        if (yearsOfService > 5) {
            bonus = salary * 0.05; // Calculate 5% bonus
        }
        
        System.out.println("The bonus amount for the employee is: " + bonus);
        
        // Close the scanner
        input.close();
    }
}