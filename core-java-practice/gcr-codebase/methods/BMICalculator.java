import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI
    static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightInMeter = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInMeter * heightInMeter);
        }
    }

    // Method to get BMI status
    static String getStatus(double bmi) {
        if (bmi <= 18.4)
            return "Underweight";
        else if (bmi <= 24.9)
            return "Normal";
        else if (bmi <= 39.9)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][3]; 
        // col 0 = weight, col 1 = height, col 2 = bmi

        for (int i = 0; i < 10; i++) {
            System.out.print("Weight of person " + (i + 1) + ": ");
            persons[i][0] = sc.nextDouble();

            System.out.print("Height (cm) of person " + (i + 1) + ": ");
            persons[i][1] = sc.nextDouble();
        }

        calculateBMI(persons);

        System.out.println("\nPerson  Weight  Height  BMI   Status");

        for (int i = 0; i < 10; i++) {
            String status = getStatus(persons[i][2]);
            System.out.printf("%d      %.1f   %.1f   %.1f   %s%n",
                    (i + 1), persons[i][0], persons[i][1], persons[i][2], status);
        }

        sc.close();
    }
}
