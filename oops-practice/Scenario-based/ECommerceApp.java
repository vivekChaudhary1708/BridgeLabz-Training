import java.util.*;

class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) {
        super(msg);
    }
}

interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

class CardPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 5000) {
            throw new PaymentFailedException("Card limit exceeded");
        }
        System.out.println("Paid " + amount + " using Card");
    }
}

class UpiPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 10000) {
            throw new PaymentFailedException("UPI daily limit exceeded");
        }
        System.out.println("Paid " + amount + " using UPI");
    }
}

class WalletPayment implements Payment {
    private double walletBalance = 3000;

    public void pay(double amount) throws PaymentFailedException {
        if (amount > walletBalance) {
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        walletBalance -= amount;
        System.out.println("Paid " + amount + " using Wallet");
    }
}

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order {
    int orderId;
    Product product;
    String status;

    public Order(int orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
        this.status = "Placed";
    }

    public void cancel() {
        status = "Cancelled";
    }

    public void track() {
        System.out.println("Order " + orderId + " Status: " + status);
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Order placeOrder(Product p, Payment payment) throws PaymentFailedException {
        payment.pay(p.price);
        Order o = new Order(orders.size() + 1, p);
        orders.add(o);
        return o;
    }
}

public class ECommerceApp {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop", 45000);
        Product p2 = new Product(2, "Headphone", 3000);

        Customer c1 = new Customer("Vivek");

        Payment upi = new UpiPayment();
        Payment wallet = new WalletPayment();

        try {
            Order o1 = c1.placeOrder(p2, wallet);
            o1.track();

            Order o2 = c1.placeOrder(p1, upi);
            o2.track();

            o2.cancel();
            o2.track();

        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
