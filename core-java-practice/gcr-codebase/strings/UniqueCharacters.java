import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int findLength(String text) {

        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // loop stops here
        }

        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);
        char[] temp = new char[length]; // max possible unique chars
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {

            char current = text.charAt(i);
            boolean isUnique = true;

            // check with previous characters
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount++] = current;
            }
        }

        // create final array of exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        char[] uniqueChars = findUniqueCharacters(aadmi);

        System.out.println("\nUnique characters:");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }

        input.close();
    }
}
