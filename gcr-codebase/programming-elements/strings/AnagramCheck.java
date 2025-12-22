import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two texts are anagrams
    public static boolean isAnagram(String text1, String text2) {

        // Step 1: length check
        if (text1.length() != text2.length()) {
            return false;
        }

        int[] freq1 = new int[256]; // ASCII frequency
        int[] freq2 = new int[256];

        // Step 2: count frequency of characters
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Step 3: compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("First text daalo: ");
        String aadmi = input.nextLine();

        System.out.print("Second text daalo: ");
        String insaan = input.nextLine();

        boolean result = isAnagram(aadmi, insaan);

        if (result) {
            System.out.println("Dono texts anagrams hain");
        } else {
            System.out.println("Dono texts anagrams nahi hain");
        }

        input.close();
    }
}
