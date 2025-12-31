import java.util.Scanner;

public class TriangularParkRun {

    // Method to calculate number of rounds
    static double calculateRounds(double firstSide, double secondSide, double thirdSide) {
        double parkPerimeter = firstSide + secondSide + thirdSide;
        double totalRunDistance = 5000; // 5 km in meters
        return totalRunDistance / parkPerimeter;
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter first side of the park (in meters): ");
        double sideOne = inputReader.nextDouble();

        System.out.print("Enter second side of the park (in meters): ");
        double sideTwo = inputReader.nextDouble();

        System.out.print("Enter third side of the park (in meters): ");
        double sideThree = inputReader.nextDouble();

        double requiredRounds =
                calculateRounds(sideOne, sideTwo, sideThree);

        System.out.println(
            "The athlete needs to complete " + requiredRounds +
            " rounds to finish a 5 km run."
        );

        inputReader.close();
    }
}
