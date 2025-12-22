import java.util.Scanner;

public class StringLengthWithoutLength {

    // Method to find string length without using length()
    public static int findLength(String aadmi) {

        int count = 0;

        try {
            while (true) {   // infinite loop
                aadmi.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // jab index out of range hoga, yahin aa jayega
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("String daalo: ");
        String insaan = input.next();

        int manualLength = findLength(insaan);
        int builtInLength = insaan.length();

        System.out.println("Manual length (without length()): " + manualLength);
        System.out.println("Built-in length(): " + builtInLength);

        input.close();
    }
}
