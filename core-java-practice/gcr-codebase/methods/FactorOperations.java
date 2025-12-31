import java.util.Scanner;

public class FactorOperations {

    // Method to find factors and return as array
    public static int[] findFactors(int givenNumber) {

        int factorCount = 0;

        // First loop: count factors
        for (int i = 1; i <= givenNumber; i++) {
            if (givenNumber % i == 0) {
                factorCount++;
            }
        }

        int[] factorList = new int[factorCount];
        int indexPosition = 0;

        // Second loop: store factors
        for (int i = 1; i <= givenNumber; i++) {
            if (givenNumber % i == 0) {
                factorList[indexPosition] = i;
                indexPosition++;
            }
        }

        return factorList;
    }

    // Method to find sum of factors
    public static int findSumOfFactors(int[] factors) {
        int sumTotal = 0;
        for (int value : factors) {
            sumTotal += value;
        }
        return sumTotal;
    }

    // Method to find product of factors
    public static long findProductOfFactors(int[] factors) {
        long productTotal = 1;
        for (int value : factors) {
            productTotal *= value;
        }
        return productTotal;
    }

    // Method to find sum of squares of factors
    public static double findSumOfSquares(int[] factors) {
        double squareSum = 0;
        for (int value : factors) {
            squareSum += Math.pow(value, 2);
        }
        return squareSum;
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userNumber = inputReader.nextInt();

        int[] factorsArray = findFactors(userNumber);

        System.out.print("Factors are: ");
        for (int value : factorsArray) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("Sum of factors: " + findSumOfFactors(factorsArray));
        System.out.println("Product of factors: " + findProductOfFactors(factorsArray));
        System.out.println("Sum of squares of factors: " + findSumOfSquares(factorsArray));

        inputReader.close();
    }
}
