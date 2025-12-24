import java.util.Scanner;

public class PalindromeCheck {

    // -------- Logic 1: Iterative start-end comparison --------
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // -------- Logic 2: Recursive comparison --------
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // -------- Helper: Reverse string using charAt() --------
    public static char[] reverseString(String text) {

        int length = text.length();
        char[] reverse = new char[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = text.charAt(length - 1 - i);
        }

        return reverse;
    }

    // -------- Logic 3: Using character arrays --------
    public static boolean isPalindromeUsingArray(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        boolean result1 = isPalindromeIterative(aadmi);
        boolean result2 = isPalindromeRecursive(aadmi, 0, aadmi.length() - 1);
        boolean result3 = isPalindromeUsingArray(aadmi);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Iterative): " + result1);
        System.out.println("Logic 2 (Recursive): " + result2);
        System.out.println("Logic 3 (Array): " + result3);

        input.close();
    }
}
