import java.util.Scanner;

public class TrigonometryCalculator {

    // Method to calculate trigonometric functions
    public double[] calculateTrigonometricFunctions(double angleInDegrees) {

        double angleInRadians = Math.toRadians(angleInDegrees);

        double sineValue = Math.sin(angleInRadians);
        double cosineValue = Math.cos(angleInRadians);
        double tangentValue = Math.tan(angleInRadians);

        return new double[]{sineValue, cosineValue, tangentValue};
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double givenAngle = inputReader.nextDouble();

        TrigonometryCalculator calculator = new TrigonometryCalculator();

        double[] trigResults =
                calculator.calculateTrigonometricFunctions(givenAngle);

        System.out.println("Sine value: " + trigResults[0]);
        System.out.println("Cosine value: " + trigResults[1]);
        System.out.println("Tangent value: " + trigResults[2]);

        inputReader.close();
    }
}
