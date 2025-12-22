import java.util.Scanner;

public class VowelConsonantCount {

    // Method to check vowel or consonant
    public static String checkCharacter(char ch) {

        // uppercase ko lowercase me convert karo (ASCII logic)
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // check letter hai ya nahi
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // vowel check
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        return "Consonant";
    }

    // Method to count vowels and consonants
    public static int[] findVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String result = checkCharacter(ch);

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        int[] result = findVowelsAndConsonants(aadmi);

        System.out.println("Vowels count: " + result[0]);
        System.out.println("Consonants count: " + result[1]);

        input.close();
    }
}
