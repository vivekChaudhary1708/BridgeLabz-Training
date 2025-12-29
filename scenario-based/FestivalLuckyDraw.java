import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number;
        String choice;

        while (true) {

            System.out.print("Enter your lucky number: ");
            number = sc.nextInt();

            // Invalid input
            if (number <= 0) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            // Check divisibility
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("You won a gift.");
            } else {
                System.out.println("Better luck next time.");
            }

            System.out.print("Next visitor? (yes/no): ");
            choice = sc.next();

            if (choice.equals("no")) {
                break;
            }
        }

        System.out.println("Thank you for visiting the Diwali Mela.");
        sc.close();
    }
}
