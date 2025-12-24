import java.util.Scanner;

public class SplitTextCompare {

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
    public static String[] manualSplit(String text) {

        int length = findLength(text);
        int wordCount = 1;

        // 1. Count words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // 2. Store space indexes
        int[] spaceIndex = new int[wordCount - 1];
        int spacePos = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[spacePos++] = i;
            }
        }

        // 3. Extract words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndex.length; i++) {
            words[i] = text.substring(start, spaceIndex[i]);
            start = spaceIndex[i] + 1;
        }

        words[wordCount - 1] = text.substring(start, length);

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] pehla, String[] dusra) {

        if (pehla.length != dusra.length) {
            return false;
        }

        for (int i = 0; i < pehla.length; i++) {
            if (!pehla[i].equals(dusra[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Complete text daalo: ");
        String aadmi = input.nextLine();

        String[] manualWords = manualSplit(aadmi);
        String[] builtInWords = aadmi.split(" ");

        boolean sameHai = compareArrays(manualWords, builtInWords);

        System.out.println("\nManual split result:");
        for (String word : manualWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in split() result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        if (sameHai) {
            System.out.println("\nDono split result same hai");
        } else {
            System.out.println("\nDono split result same nahi hai");
        }

        input.close();
    }
}
