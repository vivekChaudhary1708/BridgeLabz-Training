import java.util.Scanner;

public class FirstNonRepeatingChar {

    // Method to find first non-repeating character
    public static char findFirstNonRepeating(String text) {

        int[] freq = new int[256]; // ASCII characters frequency

        // Step 1: count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // no non-repeating character
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        char result = findFirstNonRepeating(aadmi);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("Koi non-repeating character nahi mila");
        }

        input.close();
    }
}
