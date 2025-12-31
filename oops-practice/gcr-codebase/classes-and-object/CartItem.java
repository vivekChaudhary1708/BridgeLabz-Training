class CartItem {

    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    // Method to display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Total cost: $" + totalCost);
    }

    public static void main(String[] args) {

        CartItem item = new CartItem("Laptop", 999.99, 1);

        System.out.println("Item: " + item.itemName + ", Price: $" + item.price + ", Quantity: " + item.quantity);

        item.addItem(2);
        item.removeItem(1);
        item.displayTotalCost();
    }
}
