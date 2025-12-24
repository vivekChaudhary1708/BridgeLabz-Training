import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] log) {

        // Array length se bada index access
        System.out.println(log[log.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] log) {

        try {
            System.out.println(log[log.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handle ho gaya");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handle ho gaya");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Kitne names daalne hain: ");
        int size = input.nextInt();

        String[] aadmi = new String[size];

        for (int index = 0; index < size; index++) {
            System.out.print("Name " + (index + 1) + ": ");
            aadmi[index] = input.next();
        }

        // 1. Exception generate karna
        System.out.println("\nException generate ho raha hai:");
        try {
            generateException(aadmi);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception aaya, program abruptly stop ho jata");
        }

        // 2. Exception handle karna
        System.out.println("\nException handle ho raha hai:");
        handleException(aadmi);

        input.close();
    }
}
