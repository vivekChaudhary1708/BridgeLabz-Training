import java.util.Scanner;

class MovieTicket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter movie type (Action/Comedy): ");
            String movie = sc.next();

            System.out.print("Enter seat type (gold/silver): ");
            String seat = sc.next();

            System.out.print("Do you want snacks? (yes/no): ");
            String snack = sc.next();

            int price = 0;

            switch (seat) {
                case "gold":
                    price = 300;
                    break;
                case "silver":
                    price = 200;
                    break;
                default:
                    System.out.println("Invalid seat type");
            }

            if (snack.equals("yes")) {
                price += 100;
            }

            System.out.println("Total Ticket Price: ₹" + price);

            System.out.print("Next customer? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y');

        sc.close();
    }
}
