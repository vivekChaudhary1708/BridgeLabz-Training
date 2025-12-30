import java.util.Scanner;

public class QuotientAndRemainderFinder {

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        int calculatedQuotient = number / divisor;
        int calculatedRemainder = number % divisor;

        return new int[]{calculatedQuotient, calculatedRemainder};
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int mainNumber = inputReader.nextInt();

        System.out.print("Enter the divisor: ");
        int dividingNumber = inputReader.nextInt();

        int[] resultValues =
                findRemainderAndQuotient(mainNumber, dividingNumber);

        System.out.println("Quotient is: " + resultValues[0]);
        System.out.println("Remainder is: " + resultValues[1]);

        inputReader.close();
    }
}
