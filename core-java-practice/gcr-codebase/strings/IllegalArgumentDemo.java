import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String aadmi) {

        // start index > end index
        System.out.println(aadmi.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String aadmi) {

        try {
            System.out.println(aadmi.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handle ho gaya");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handle ho gaya");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("String daalo: ");
        String insaan = input.next();

        // 1. Exception generate karna
        System.out.println("\nException generate ho raha hai:");
        try {
            generateException(insaan);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception aaya, program abruptly stop ho jata");
        }

        // 2. Exception handle karna
        System.out.println("\nException handle ho raha hai:");
        handleException(insaan);

        input.close();
    }
}
