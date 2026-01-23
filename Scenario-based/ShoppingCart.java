import java.util.*;

public class ShoppingCart {

    HashMap<String, Integer> priceMap = new HashMap<>();
    LinkedHashMap<String, Integer> cartOrder = new LinkedHashMap<>();

    void addItem(String item, int price) {
        priceMap.put(item, price);
        cartOrder.put(item, price);
    }

    void displayCartOrder() {
        for (Map.Entry<String, Integer> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    void displaySortedByPrice() {
        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : priceMap.entrySet()) {
            sortedMap
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }

        for (Map.Entry<Integer, List<String>> entry : sortedMap.entrySet()) {
            for (String item : entry.getValue()) {
                System.out.println(item + " -> " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Laptop", 60000);
        cart.addItem("Mouse", 800);
        cart.addItem("Keyboard", 1500);
        cart.addItem("Monitor", 12000);

        System.out.println("Items in Cart Order:");
        cart.displayCartOrder();

        System.out.println("\nItems Sorted By Price:");
        cart.displaySortedByPrice();
    }
}
