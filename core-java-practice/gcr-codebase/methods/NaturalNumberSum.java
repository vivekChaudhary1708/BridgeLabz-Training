import java.util.Scanner;

public class NaturalNumberSum {

    // Method to calculate sum of n natural numbers
    static int calculateNaturalSum(int lastNumber) {

        int runningTotal = 0;

        for (int currentNumber = 1; currentNumber <= lastNumber; currentNumber++) {
            runningTotal = runningTotal + currentNumber;
        }

        return runningTotal;
    }

    public static void main(String[] args) {

        Scanner inputBox = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int nValue = inputBox.nextInt();

        int sumResult = calculateNaturalSum(nValue);

        System.out.println(
            "Sum of first " + nValue + " natural numbers is: " + sumResult
        );

        inputBox.close();
    }
}
