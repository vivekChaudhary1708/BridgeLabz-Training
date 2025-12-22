import java.util.Scanner;

public class CharacterTypeCheck {

    // Method to check character type
    public static String checkCharacterType(char ch) {

        // uppercase ko lowercase me convert (ASCII logic)
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // letter nahi hai
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // vowel check
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        return "Consonant";
    }

    // Method to find character and its type using charAt()
    public static String[][] findCharacterTypes(String text) {

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }

        return result;
    }

    // Method to display 2D array in tabular format (no separators)
    public static void displayTable(String[][] data) {

        System.out.println("\nCharacter\tType");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo: ");
        String aadmi = input.nextLine();

        String[][] result = findCharacterTypes(aadmi);
        displayTable(result);

        input.close();
    }
}
