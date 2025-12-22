import java.util.Scanner;

public class StringIndexExceptionDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String aadmi) {

        // length se aage ka index access
        System.out.println(aadmi.charAt(aadmi.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String aadmi) {

        try {
            System.out.println(aadmi.charAt(aadmi.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handle ho gaya");
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
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception aaya, program abruptly stop ho jata");
        }

        // 2. Exception handle karna
        System.out.println("\nException handle ho raha hai:");
        handleException(insaan);

        input.close();
    }
}
