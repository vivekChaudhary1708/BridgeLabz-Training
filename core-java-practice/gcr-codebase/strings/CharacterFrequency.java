import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency of characters
    public static String[][] findCharacterFrequency(String text) {

        int[] freq = new int[256];   // ASCII frequency array

        // Step 1: count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                uniqueCount++;
                freq[ch] = -freq[ch]; // mark as counted
            }
        }

        // Step 3: create 2D array [character][frequency]
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (freq[ch] < 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(-freq[ch]);
                freq[ch] = 0; // reset so it won’t repeat
                index++;
            }
        }

        return result;
    }

    // Method to display result
    public static void displayResult(String[][] data) {

        System.out.println("\nCharacter\tFrequency");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        String[][] frequencyData = findCharacterFrequency(aadmi);
        displayResult(frequencyData);

        input.close();
