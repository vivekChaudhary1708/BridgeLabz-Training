import java.util.Scanner;

public class ShortestLongestWord {

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

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0, index = 0;

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
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestLongest(String[][] data) {

        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < data.length; i++) {
            int currentLength = Integer.parseInt(data[i][1]);
            int shortestLength = Integer.parseInt(data[shortestIndex][1]);
            int longestLength = Integer.parseInt(data[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Complete text daalo: ");
        String aadmi = input.nextLine();

        String[] words = splitWords(aadmi);
        String[][] data = wordWithLength(words);
        int[] resultIndex = findShortestLongest(data);

        System.out.println("\nWord\t\tLength");
        System.out.println("----------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + Integer.parseInt(data[i][1]));
        }

        System.out.println("\nShortest word: " + data[resultIndex[0]][0]);
        System.out.println("Longest word: " + data[resultIndex[1]][0]);

        input.close();
    }
}
