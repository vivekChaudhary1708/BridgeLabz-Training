import java.util.Scanner;

public class NumberAnalyzer {

    // Method to check positive or negative
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    // Method to check even or odd
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Method to compare two numbers
    // returns 1 if num1 > num2, 0 if equal, -1 if num1 < num2
    public static int compareNumbers(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        // Taking input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");

        // Checking positive/negative and even/odd
        for (int i = 0; i < numbers.length; i++) {

            int currentNumber = numbers[i];

            if (isPositive(currentNumber)) {
                System.out.print(currentNumber + " is Positive and ");

                if (isEven(currentNumber)) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }

            } else {
                System.out.println(currentNumber + " is Negative");
            }
        }

        // Comparing first and last element
        int comparisonResult =
                compareNumbers(numbers[0], numbers[numbers.length - 1]);

        System.out.println("\n--- Comparison Result ---");

        if (comparisonResult == 1) {
            System.out.println("First element is greater than last element");
        } else if (comparisonResult == 0) {
            System.out.println("First and last elements are equal");
        } else {
            System.out.println("First element is less than last element");
        }

        input.close();
    }
}
