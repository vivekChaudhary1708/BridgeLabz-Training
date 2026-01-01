public class StoreItem {

    // Static variable (shared among all items)
    private static double discount = 10.0;  

    // Instance variables
    private final String itemId;   // final variable
    private String itemName;
    private double price;
    private int quantity;

    // Constructor using 'this'
    public StoreItem(String itemId, String itemName, double price, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to display item details
    public void displayItemDetails() {
        if (this instanceof StoreItem) {
            System.out.println("Product ID: " + itemId);
            System.out.println("Product Name: " + itemName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");

            double finalPrice = price - (price * discount / 100);
            System.out.println("Price after Discount: $" + finalPrice);
        }
    }

    // Main method
    public static void main(String[] args) {

        StoreItem item1 = new StoreItem("P001", "Laptop", 1200.0, 5);

        // Optional discount update
        StoreItem.updateDiscount(10.0);

        item1.displayItemDetails();
    }
}
