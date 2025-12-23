import java.util.Scanner;

class MetroSmartCard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 100;   // initial smart card balance

        while (balance > 0) {

            System.out.print("Enter distance in km (-1 to quit): ");
            int distance = sc.nextInt();

            // exit condition
            if (distance == -1) {
                break;
            }

            // fare calculation using ternary operator
            int fare = (distance <= 5) ? 10 : 20;

            // check sufficient balance
            if (balance >= fare) {
                balance = balance - fare;
                System.out.println("Fare deducted: ₹" + fare);
                System.out.println("Remaining balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance. Please recharge!");
                break;
            }
        }

        System.out.println("Thank you for using Delhi Metro 🚇");
        sc.close();
    }
}
