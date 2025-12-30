import java.util.Scanner;

public class BmiReportOfTeam {

    public static void main(String[] args) {

        Scanner bhaiScanner = new Scanner(System.in);

        System.out.print("Team me kitne log hain: ");
        int logonKiGinti = bhaiScanner.nextInt();

        double[] heightMeter = new double[logonKiGinti];
        double[] weightKg = new double[logonKiGinti];
        double[] bmiValue = new double[logonKiGinti];
        String[] healthStatus = new String[logonKiGinti];

        for (int aadmi = 0; aadmi < logonKiGinti; aadmi++) {

            System.out.println("Person " + (aadmi + 1));

            System.out.print("Height (meters): ");
            heightMeter[aadmi] = bhaiScanner.nextDouble();

            System.out.print("Weight (kg): ");
            weightKg[aadmi] = bhaiScanner.nextDouble();
        }

        for (int aadmi = 0; aadmi < logonKiGinti; aadmi++) {

            bmiValue[aadmi] =
                    weightKg[aadmi] / (heightMeter[aadmi] * heightMeter[aadmi]);

            if (bmiValue[aadmi] <= 18.4) {
                healthStatus[aadmi] = "Underweight";
            } else if (bmiValue[aadmi] <= 24.9) {
                healthStatus[aadmi] = "Normal";
            } else if (bmiValue[aadmi] <= 39.9) {
                healthStatus[aadmi] = "Overweight";
            } else {
                healthStatus[aadmi] = "Obese";
            }
        }

        for (int aadmi = 0; aadmi < logonKiGinti; aadmi++) {

            System.out.println("Person " + (aadmi + 1));
            System.out.println("Height: " + heightMeter[aadmi]);
            System.out.println("Weight: " + weightKg[aadmi]);
            System.out.println("BMI: " + bmiValue[aadmi]);
            System.out.println("Status: " + healthStatus[aadmi]);
        }

        bhaiScanner.close();
    }
}
