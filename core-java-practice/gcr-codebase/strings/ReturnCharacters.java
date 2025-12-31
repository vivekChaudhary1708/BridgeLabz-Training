import java.util.Scanner;

public class ReturnCharacters {

    // user-defined method: string se characters nikalna (without toCharArray)
    public static char[] nikaloCharacters(String aadmi) {

        char[] insaan = new char[aadmi.length()];

        for (int index = 0; index < aadmi.length(); index++) {
            insaan[index] = aadmi.charAt(index);
        }

        return insaan;
    }

    // compare two char arrays
    public static boolean compareArrays(char[] pehla, char[] dusra) {

        if (pehla.length != dusra.length) {
            return false;
        }

        for (int index = 0; index < pehla.length; index++) {
            if (pehla[index] != dusra[index]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("String daalo: ");
        String aadmi = input.next();

        char[] manualResult = nikaloCharacters(aadmi);
        char[] builtInResult = aadmi.toCharArray();

        boolean sameHai = compareArrays(manualResult, builtInResult);

        System.out.println("User-defined method se characters:");
        for (char ch : manualResult) {
            System.out.print(ch + " ");
        }

        System.out.println("\nBuilt-in toCharArray() se characters:");
        for (char ch : builtInResult) {
            System.out.print(ch + " ");
        }

        System.out.println();

        if (sameHai) {
            System.out.println("Dono method ka result same hai");
        } else {
            System.out.println("Dono method ka result same nahi hai");
        }

        input.close();
    }
}
