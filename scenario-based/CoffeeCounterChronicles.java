import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {

        Scanner ravi = new Scanner(System.in);

        while (true) {

            System.out.print("Coffee type batao (espresso/latte/cappuccino) ya exit likho: ");
            String customerName = ravi.nextLine();

            if (customerName.equalsIgnoreCase("exit")) {
                System.out.println("Cafe band ho gaya ☕");
                break;
            }

            System.out.print("Quantity batao: ");
            int bhola = ravi.nextInt();

            int coffeePrice = 0;

            switch (customerName.toLowerCase()) {
                case "espresso":
                    coffeePrice = 100;
                    break;
                case "latte":
                    coffeePrice = 150;
                    break;
                case "cappuccino":
                    coffeePrice = 180;
                    break;
                default:
                    System.out.println("Ye coffee available nahi hai 😢");
                    ravi.nextLine(); // buffer clear
                    continue;
            }

            int totalAmount = coffeePrice * bhola;
            double gst = totalAmount * 0.18;
            double finalBill = totalAmount + gst;

            System.out.println("Base Bill: ₹" + totalAmount);
            System.out.println("GST (18%): ₹" + gst);
            System.out.println("Final Bill: ₹" + finalBill);

            System.out.println("-------------------------");

            ravi.nextLine(); // buffer clear
        }

        ravi.close();
    }
}
