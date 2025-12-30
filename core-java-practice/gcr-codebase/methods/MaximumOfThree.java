import java.util.Scanner;

public class MaximumOfThree {

    // Method to take input
    public static int[] takeInput(Scanner sc) {
        int[] numbers = new int[3];

        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();

        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();

        return numbers;
    }

    // Method to find maximum number
    public static int findMaximum(int[] numbers) {
        int max = numbers[0];

        if (numbers[1] > max) {
            max = numbers[1];
        }

        if (numbers[2] > max) {
            max = numbers[2];
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = takeInput(sc);
        int max = findMaximum(numbers);

        System.out.println("Maximum number is: " + max);

        sc.close();
    }
}
