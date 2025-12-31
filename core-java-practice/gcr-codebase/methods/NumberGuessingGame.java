import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    // Method to generate a random guess
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    // Method to get user feedback
    public static String getFeedback(Scanner sc) {
        System.out.print("Is the guess high, low, or correct? ");
        return sc.next();
    }

    // Method to update range based on feedback
    public static int[] updateRange(String feedback, int guess, int low, int high) {
        if (feedback.equalsIgnoreCase("high")) {
            high = guess - 1;
        } else if (feedback.equalsIgnoreCase("low")) {
            low = guess + 1;
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        boolean isCorrect = false;

        System.out.println("Think of a number between 1 and 100.");

        while (!isCorrect) {

            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);

            String feedback = getFeedback(sc);

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed the correct number!");
                isCorrect = true;
            } else {
                int[] range = updateRange(feedback, guess, low, high);
                low = range[0];
                high = range[1];
            }
        }

        sc.close();
    }
}
