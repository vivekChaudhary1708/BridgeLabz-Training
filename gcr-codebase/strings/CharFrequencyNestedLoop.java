import java.util.Scanner;

public class CharFrequencyNestedLoop {

    // Method to find frequency using nested loops
    public static String[] findFrequency(String text) {

        char[] characters = text.toCharArray();   // characters array
        int[] frequency = new int[characters.length];

        // Step 1: Nested loop to calculate frequency
        for (int i = 0; i < characters.length; i++) {

            if (characters[i] == '0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0'; // mark duplicate
                }
            }
        }

        // Step 2: Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                uniqueCount++;
            }
        }

        // Step 3: Store character and frequency in 1D String array
        String[] result = new String[uniqueCount];
        int index = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                result[index++] = characters[i] + " : " + frequency[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        String[] output = findFrequency(aadmi);

        System.out.println("\nCharacter Frequency:");
        for (String data : output) {
            System.out.println(data);
        }

        input.close();
    }
}
