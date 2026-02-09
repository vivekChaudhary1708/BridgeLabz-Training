import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FoodOrder {
    String employeeName;
    String foodItem;
    int quantity;
    double totalBill;

    public FoodOrder(String employeeName, String foodItem, int quantity, double totalBill) {
        this.employeeName = employeeName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.totalBill = totalBill;
    }

    public void displayOrder() {
        System.out.println(employeeName + " ordered " + foodItem + " x" + quantity +
                " Total bill (with GST): $" + totalBill);
    }
}

public class SmartCanteen {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<FoodOrder> orderList = new ArrayList<>();

        while (true) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter food item: ");
            String foodItem = sc.nextLine();

            double price = 0;

            switch (foodItem.toLowerCase()) {
                case "burger":
                    price = 80;
                    break;
                case "pizza":
                    price = 120;
                    break;
                case "sandwich":
                    price = 60;
                    break;
                default:
                    System.out.println("Invalid food item");
                    continue;
            }

            int quantity;
            try {
                System.out.print("Enter quantity: ");
                quantity = Integer.parseInt(sc.nextLine());

                if (quantity <= 0) {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("Invalid quantity input");
                continue;
            }

            double bill = price * quantity;
            double gst = bill * 0.05;
            double totalBill = bill + gst;

            FoodOrder order = new FoodOrder(name, foodItem, quantity, totalBill);
            orderList.add(order);
        }

        System.out.println("\nOrder Summary:");
        for (FoodOrder order : orderList) {
            order.displayOrder();
        }

        sc.close();
    }
}
