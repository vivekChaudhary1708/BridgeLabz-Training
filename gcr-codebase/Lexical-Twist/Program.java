import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        // Validation: more than one word
        if (first.trim().contains(" ")) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        // Validation: more than one word
        if (second.trim().contains(" ")) {
            System.out.println(second + " is an invalid word");
            return;
        }

        // Check if second is reverse of first (case-insensitive)
        String reversedFirst = new StringBuilder(first).reverse().toString();

        if (reversedFirst.equalsIgnoreCase(second)) {
            // Case 1: second is reverse of first

            String lower = reversedFirst.toLowerCase();
            StringBuilder result = new StringBuilder();

            for (char ch : lower.toCharArray()) {
                if (isVowel(ch)) {
                    result.append('@');
                } else {
                    result.append(ch);
                }
            }

            System.out.println(result.toString());

        } else {
            // Case 2: second is NOT reverse of first

            String combined = (first + second).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (isVowel(ch)) {
                    vowelCount++;
                } else if (Character.isLetter(ch)) {
                    consonantCount++;
                }
            }

            if (vowelCount > consonantCount) {
                printFirstTwoUniqueVowels(combined);
            } else if (consonantCount > vowelCount) {
                printFirstTwoUniqueConsonants(combined);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        sc.close();
    }

    // Helper: vowel check
    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    // Print first 2 unique vowels
    private static void printFirstTwoUniqueVowels(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            if (isVowel(ch)) {
                set.add(ch);
            }
            if (set.size() == 2) break;
        }

        for (char ch : set) {
            System.out.print(ch);
        }
    }

    // Print first 2 unique consonants
    private static void printFirstTwoUniqueConsonants(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            if (!isVowel(ch) && Character.isLetter(ch)) {
                set.add(ch);
            }
            if (set.size() == 2) break;
        }

        for (char ch : set) {
            System.out.print(ch);
        }
    }
}
