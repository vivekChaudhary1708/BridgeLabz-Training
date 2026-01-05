import java.util.Scanner;

public class CafeteriaMenuApp {

    // Method to display menu
    static void displayMenu(String[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " " + items[i]);
        }
    }

    // Method to get item by index
    static String getItemByIndex(String[] items, int index) {
        if (index >= 0 && index < items.length) {
            return items[index];
        }
        return "Invalid item";
    }

    // Main method
    public static void main(String[] args) {

        String[] menuItems = {
            "Tea",
            "Coffee",
            "Sandwich",
            "Burger",
            "Pizza",
            "Pasta",
            "French Fries",
            "Noodles",
            "Cold Drink",
            "Ice Cream"
        };

        Scanner sc = new Scanner(System.in);

        displayMenu(menuItems);

        System.out.print("Enter item index: ");
        int choice = sc.nextInt();

        System.out.println(getItemByIndex(menuItems, choice));

        sc.close();
    }
}
