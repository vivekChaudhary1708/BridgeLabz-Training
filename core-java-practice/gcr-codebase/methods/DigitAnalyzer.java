import java.util.Scanner;

public class DigitAnalyzer {

    // Method to count digits
    public static int countDigits(int number) {
        int temp = Math.abs(number);
        if (temp == 0) return 1;

        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // Method to store digits in array
    public static int[] storeDigits(int number) {
        int temp = Math.abs(number);
        int size = countDigits(temp);
        int[] digits = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    // Method to reverse digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Method to check Palindrome number
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    // Method to check Duck number
    // (contains at least one non-zero digit)
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Digit count: " + countDigits(number));

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        int[] reversedDigits = reverseArray(digits);

        System.out.print("\nReversed Digits: ");
        for (int d : reversedDigits) {
            System.out.print(d + " ");
        }

        System.out.println("\nArrays Equal: " + areArraysEqual(digits, reversedDigits));
        System.out.println("Palindrome Number: " + isPalindrome(digits));
        System.out.println("Duck Number: " + isDuckNumber(digits));

        sc.close();
    }
}
