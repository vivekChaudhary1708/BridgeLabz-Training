import java.util.*;

class OutOfStockException extends Exception {
    public OutOfStockException(String msg) {
        super(msg);
    }
}

interface AlertService {
    void sendAlert(Product p);
}

class EmailAlert implements AlertService {
    public void sendAlert(Product p) {
        System.out.println("Low stock alert for " + p.name);
    }
}

class Product {
    int id;
    String name;
    int quantity;

    public Product(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.quantity = qty;
    }
}

class Inventory {
    List<Product> products = new ArrayList<>();
    AlertService alertService = new EmailAlert();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println(p.name + " added");
    }

    public void updateStock(int id, int qty) throws OutOfStockException {
        for (Product p : products) {
            if (p.id == id) {
                if (qty < 0 && p.quantity + qty < 0) {
                    throw new OutOfStockException("Stock not available");
                }
                p.quantity += qty;
                System.out.println(p.name + " stock: " + p.quantity);
                if (p.quantity <= 5) {
                    alertService.sendAlert(p);
                }
            }
        }
    }

    public void viewStock() {
        for (Product p : products) {
            System.out.println(p.id + " " + p.name + " " + p.quantity);
        }
    }
}

public class InventoryApp {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        Product p1 = new Product(1, "Keyboard", 10);
        Product p2 = new Product(2, "Mouse", 3);

        inv.addProduct(p1);
        inv.addProduct(p2);

        try {
            inv.updateStock(1, -6);
            inv.updateStock(2, -3);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        inv.viewStock();
    }
}
