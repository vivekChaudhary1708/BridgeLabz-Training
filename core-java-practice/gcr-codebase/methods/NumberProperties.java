import java.util.Scanner;

public class NumberProperties {

    // Method to find sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        if (number <= 1) return 0;

        int sum = 1; // 1 is a proper divisor for numbers > 1
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Method to check Perfect Number
    public static boolean isPerfectNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) == number;
    }

    // Method to check Abundant Number
    public static boolean isAbundantNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) > number;
    }

    // Method to check Deficient Number
    public static boolean isDeficientNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) < number;
    }

    // Method to find factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check Strong Number
    // Strong: sum of factorial of digits == number
    public static boolean isStrongNumber(int number) {
        int temp = number;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Perfect Number: " + isPerfectNumber(number));
        System.out.println("Abundant Number: " + isAbundantNumber(number));
        System.out.println("Deficient Number: " + isDeficientNumber(number));
        System.out.println("Strong Number: " + isStrongNumber(number));

        sc.close();
    }
}
