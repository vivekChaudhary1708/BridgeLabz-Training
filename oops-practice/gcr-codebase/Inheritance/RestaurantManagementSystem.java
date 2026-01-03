
interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Chef class
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Role: Chef");
        System.out.println("Duties: Cooking food and managing kitchen");
    }
}

// Waiter class
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Role: Waiter");
        System.out.println("Duties: Serving food to customers");
    }
}

// Main class
public class RestaurantManagementSystem {
    public static void main(String[] args) {

        Worker w1 = new Chef("Rohit", 101);
        Worker w2 = new Waiter("Aman", 102);

        w1.performDuties();
        System.out.println("------");
        w2.performDuties();
    }
}
