import java.util.Scanner;

public class TrimStringCompare {

    // Method to find start and end index after trimming spaces
    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        // trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String pehli, String dusri) {

        if (pehli.length() != dusri.length()) {
            return false;
        }

        for (int i = 0; i < pehli.length(); i++) {
            if (pehli.charAt(i) != dusri.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text with spaces daalo: ");
        String aadmi = input.nextLine();

        // manual trim
        int[] indexes = findTrimIndexes(aadmi);
        String manualTrim = createSubstring(aadmi, indexes[0], indexes[1]);

        // built-in trim
        String builtInTrim = aadmi.trim();

        System.out.println("\nManual trim result:   [" + manualTrim + "]");
        System.out.println("Built-in trim result: [" + builtInTrim + "]");

        boolean sameHai = compareStrings(manualTrim, builtInTrim);

        if (sameHai) {
            System.out.println("\nDono trim result same hai");
        } else {
            System.out.println("\nDono trim result same nahi hai");
        }

        input.close();
    }
}
