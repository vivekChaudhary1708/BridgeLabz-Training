import java.util.Scanner;

public class SumCompare {

    // Recursive method
    static int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    // Formula method
    static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a valid natural number.");
        } else {
            int sumByRecursion = recursiveSum(number);
            int sumByFormula = formulaSum(number);

            System.out.println("Sum using recursion: " + sumByRecursion);
            System.out.println("Sum using formula: " + sumByFormula);

            if (sumByRecursion == sumByFormula) {
                System.out.println("Both results are correct.");
            } else {
                System.out.println("Results are not matching.");
            }
        }

        input.close();
    }
}
