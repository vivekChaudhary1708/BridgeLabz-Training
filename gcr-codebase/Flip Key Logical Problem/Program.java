import java.util.Scanner;

public class Program {

    public static String CleanseAndInvert(String input) {

        // Rule 1: null or length < 6
        if (input == null || input.length() < 6) {
            return "";
        }

        // Rule 2: must contain only alphabets (no space, digit, special char)
        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return "";
            }
        }

        // Convert to lowercase
        String lower = input.toLowerCase();

        // Remove characters with even ASCII values
        StringBuilder filtered = new StringBuilder();
        for (char ch : lower.toCharArray()) {
            if ((int) ch % 2 != 0) { // keep odd ASCII only
                filtered.append(ch);
            }
        }

        // Reverse the string
        filtered.reverse();

        // Convert even index characters to uppercase
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < filtered.length(); i++) {
            char ch = filtered.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String input = sc.nextLine();

        String output = CleanseAndInvert(input);

        if (output.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + output);
        }

        sc.close();
    }
}
