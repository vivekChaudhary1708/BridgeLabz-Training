public class StringUtils {

    // Reverse a string
    public static String reverse(String str) {
        if (str == null) return null;

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Check if string is palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) return false;

        String reversed = reverse(str);
        return str.equals(reversed);
    }

    // Convert string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) return null;

        return str.toUpperCase();
    }
}
