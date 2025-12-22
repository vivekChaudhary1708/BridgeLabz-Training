import java.util.Scanner;

public class BMICalculator {

    // b) Method to calculate BMI and Status for one person
    public static String[] calculateBMIStatus(double weightKg, double heightCm) {

        double heightMeter = heightCm / 100.0;
        double bmi = weightKg / (heightMeter * heightMeter);

        bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimals

        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.valueOf(bmi), status};
    }

    // c) Method to compute BMI for all persons
    public static String[][] computeBMI(double[][] data) {

        String[][] result = new String[data.length][4];
        // height, weight, bmi, status

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiResult = calculateBMIStatus(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiResult[0];
            result[i][3] = bmiResult[1];
        }

        return result;
    }

    // d) Method to display result in table format
    public static void displayResult(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                result[i][0] + "\t\t" +
                result[i][1] + "\t\t" +
                result[i][2] + "\t\t" +
                result[i][3]
            );
        }
    }

    // e) Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[][] data = new double[10][2];
        // [i][0] = weight, [i][1] = height

        for (int i = 0; i < 10; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight (kg): ");
            data[i][0] = input.nextDouble();

            System.out.print("Enter height (cm): ");
            data[i][1] = input.nextDouble();
        }

        String[][] result = computeBMI(data);
        displayResult(result);

        input.close();
    }
}
