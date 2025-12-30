import java.util.Scanner;

public class MinMaxOfThree {

    // Single method to find smallest and largest
    public static int[] findSmallestAndLargest(int numberOne, int numberTwo, int numberThree) {

        int smallestNumber = numberOne;
        int largestNumber = numberOne;

        if (numberTwo < smallestNumber) {
            smallestNumber = numberTwo;
        }
        if (numberTwo > largestNumber) {
            largestNumber = numberTwo;
        }

        if (numberThree < smallestNumber) {
            smallestNumber = numberThree;
        }
        if (numberThree > largestNumber) {
            largestNumber = numberThree;
        }

        return new int[]{smallestNumber, largestNumber};
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int firstValue = inputReader.nextInt();

        System.out.print("Enter second number: ");
        int secondValue = inputReader.nextInt();

        System.out.print("Enter third number: ");
        int thirdValue = inputReader.nextInt();

        int[] finalResult =
                findSmallestAndLargest(firstValue, secondValue, thirdValue);

        System.out.println("Smallest number is: " + finalResult[0]);
        System.out.println("Largest number is: " + finalResult[1]);

        inputReader.close();
    }
}
