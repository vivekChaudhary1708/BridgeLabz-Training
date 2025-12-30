import java.util.Scanner;

public class LowerCaseCompare {

    // Method to convert text to lowercase using charAt() and ASCII logic
    public static String convertToLower(String aadmi) {

        String result = "";

        for (int index = 0; index < aadmi.length(); index++) {
            char ch = aadmi.charAt(index);

            // uppercase A-Z => lowercase a-z
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
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

        String manualLower = convertToLower(insaan);
        String builtInLower = insaan.toLowerCase();

        System.out.println("Manual lowercase:   " + manualLower);
        System.out.println("Built-in lowercase: " + builtInLower);

        boolean sameHai = compareStrings(manualLower, builtInLower);

        if (sameHai) {
            System.out.println("Dono lowercase result same hai");
        } else {
            System.out.println("Dono lowercase result same nahi hai");
        }

        input.close();
    }
}
