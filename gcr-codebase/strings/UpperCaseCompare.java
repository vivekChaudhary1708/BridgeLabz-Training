import java.util.Scanner;

public class UpperCaseCompare {

    // Method to convert text to uppercase using charAt() and ASCII logic
    public static String convertToUpper(String aadmi) {

        String result = "";

        for (int index = 0; index < aadmi.length(); index++) {
            char ch = aadmi.charAt(index);

            // lowercase a-z => uppercase A-Z
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result = result + ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String pehli, String dusri) {

        if (pehli.length() != dusri.length()) {
            return false;
        }

        for (int index = 0; index < pehli.length(); index++) {
            if (pehli.charAt(index) != dusri.charAt(index)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Complete text daalo: ");
        String insaan = input.nextLine();

        String manualUpper = convertToUpper(insaan);
        String builtInUpper = insaan.toUpperCase();

        System.out.println("Manual uppercase:   " + manualUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);

        boolean sameHai = compareStrings(manualUpper, builtInUpper);

        if (sameHai) {
            System.out.println("Dono uppercase result same hai");
        } else {
            System.out.println("Dono uppercase result same nahi hai");
        }

        input.close();
    }
}
