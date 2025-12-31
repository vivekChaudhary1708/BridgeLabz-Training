public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {

        String text = null;   // text ko null assign kiya
        System.out.println(text.length()); // yahin exception aayega
    }

    // Method to handle NullPointerException
    public static void handleException() {

        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handle ho gaya");
        }
    }

    public static void main(String[] args) {

        // 1. Exception generate karna
        System.out.println("Exception generate ho raha hai:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception aaya, ab handle karenge");
        }

        // 2. Exception handle karna
        System.out.println("\nException handle ho raha hai:");
        handleException();
    }
}
