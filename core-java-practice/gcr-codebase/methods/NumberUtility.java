import java.util.Scanner;

public class NumberUtility {

    // Method to check Prime Number
    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // Method to check Neon Number
    // Neon: sum of digits of square == number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Method to check Spy Number
    // Spy: sum of digits == product of digits
    public static boolean isSpyNumber(int number) {
        int temp = Math.abs(number);
        int sum = 0;
        int product = 1;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Method to check Automorphic Number
    // Automorphic: square ends with the number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Method to check Buzz Number
    // Buzz: divisible by 7 OR ends with 7
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Prime Number: " + isPrime(number));
        System.out.println("Neon Number: " + isNeonNumber(number));
        System.out.println("Spy Number: " + isSpyNumber(number));
        System.out.println("Automorphic Number: " + isAutomorphic(number));
        System.out.println("Buzz Number: " + isBuzzNumber(number));

        sc.close();
    }
}
