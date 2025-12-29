import java.util.Scanner;

public class BmiFitnessTracker {
    public static void main(String[] args) {

        Scanner maya = new Scanner(System.in);

        // Taking height input (in meters)
        System.out.print("Height enter karo (meters me): ");
        double heightOfClient = maya.nextDouble();

        // Taking weight input (in kilograms)
        System.out.print("Weight enter karo (kg me): ");
        double weightOfClient = maya.nextDouble();

        // BMI formula
        double bmiValue = weightOfClient / (heightOfClient * heightOfClient);

        // Display BMI
        System.out.println("BMI value: " + bmiValue);

        // Checking BMI category using if-else
        if (bmiValue < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmiValue >= 18.5 && bmiValue < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }

        maya.close();
    }
}
