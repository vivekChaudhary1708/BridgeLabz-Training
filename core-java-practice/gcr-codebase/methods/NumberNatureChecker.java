import java.util.Scanner;

public class NumberNatureChecker {

    // Method to check number type
    static int checkNumberNature(int userNumber) {
        if (userNumber > 0) {
            return 1;
        } else if (userNumber < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Scanner inputBox = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int givenNumber = inputBox.nextInt();

        int result = checkNumberNature(givenNumber);

        if (result == 1) {
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        inputBox.close();
    }
}
