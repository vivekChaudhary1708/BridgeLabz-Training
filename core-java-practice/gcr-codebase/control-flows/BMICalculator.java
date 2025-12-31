import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // User input
        System.out.print("Enter weight in kg: ");
        double weightKg = input.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();

        // Convert height from cm to meter
        double heightMeter = heightCm / 100;

        // BMI formula
        double bmi = weightKg / (heightMeter * heightMeter);

        // Display BMI
        System.out.println("BMI is: " + bmi);

        // Determine status
        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } 
        else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Status: Normal");
        } 
        else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } 
        else {
            System.out.println("Status: Obese");
        }

        input.close();
    }
}
