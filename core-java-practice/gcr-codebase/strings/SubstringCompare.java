import java.util.Scanner;

public class SubstringCompare {

    // substring banana using charAt()
    public static String banaSubstring(String pooraText, int shuru, int khatam) {

        String result = "";

        for (int index = shuru; index < khatam; index++) {
            result = result + pooraText.charAt(index);
        }

        return result;
    }

    // compare two strings using charAt()
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

        System.out.print("String daalo: ");
        String aadmi = input.next();

        System.out.print("Start index daalo: ");
        int shuruIndex = input.nextInt();

        System.out.print("End index daalo: ");
        int khatamIndex = input.nextInt();

        String charAtSubstring = banaSubstring(aadmi, shuruIndex, khatamIndex);
        String builtInSubstring = aadmi.substring(shuruIndex, khatamIndex);

        System.out.println("charAt() se substring: " + charAtSubstring);
        System.out.println("substring() se result: " + builtInSubstring);

        boolean sameHai = compareStrings(charAtSubstring, builtInSubstring);

        if (sameHai) {
            System.out.println("Dono substring same hai");
        } else {
            System.out.println("Dono substring same nahi hai");
        }

        input.close();
    }
}
