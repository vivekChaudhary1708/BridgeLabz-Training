import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateException(String aadmi) {

        // Non-numeric text ko number me convert kar rahe hain
        int number = Integer.parseInt(aadmi);
        System.out.println("Number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String aadmi) {

        try {
            int number = Integer.parseInt(aadmi);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handle ho gaya");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handle ho gaya");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Text daalo (number nahi bhi ho sakta): ");
        String insaan = input.next();

        // 1. Exception generate karna
        System.out.println("\nException generate ho raha hai:");
        try {
            generateException(insaan);
        } catch (NumberFormatException e) {
            System.out.println("Exception aaya, program abruptly stop ho jata");
        }

        // 2. Exception handle karna
        System.out.println("\nException handle ho raha hai:");
        handleException(insaan);

        input.close();
    }
}
