import java.util.Scanner;

public class WordsWithLength {

    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitWords(String text) {

        int length = findLength(text);
        int wordCount = 1;

        // count words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }

        words[index] = text.substring(start, length);

        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] wordWithLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Complete text daalo: ");
        String aadmi = input.nextLine();

        String[] words = splitWords(aadmi);
        String[][] finalResult = wordWithLength(words);

        System.out.println("\nWord\t\tLength");
        System.out.println("----------------------");

        for (int i = 0; i < finalResult.length; i++) {
            int length = Integer.parseInt(finalResult[i][1]);
            System.out.println(finalResult[i][0] + "\t\t" + length);
        }

        input.close();
    }
}
