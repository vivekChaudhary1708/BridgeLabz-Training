class Item {
    int id;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    private Item head = null;

    public void addAtBeginning(int id, String name, int qty, double price) {
        Item i = new Item(id, name, qty, price);
        i.next = head;
        head = i;
    }

    public void addAtEnd(int id, String name, int qty, double price) {
        Item i = new Item(id, name, qty, price);
        if (head == null) {
            head = i;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = i;
    }

    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        Item i = new Item(id, name, qty, price);
        i.next = temp.next;
        temp.next = i;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    public double totalValue() {
        double sum = 0;
        Item temp = head;
        while (temp != null) {
            sum += temp.price * temp.quantity;
            temp = temp.next;
        }
        return sum;
    }

    public void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    public void sortByNameAsc() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.name.compareToIgnoreCase(j.name) > 0) {
                    swap(i, j);
                }
            }
        }
    }

    public void sortByPriceDesc() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.price < j.price) {
                    swap(i, j);
                }
            }
        }
    }

    private void swap(Item a, Item b) {
        int id = a.id;
        String name = a.name;
        int qty = a.quantity;
        double price = a.price;

        a.id = b.id;
        a.name = b.name;
        a.quantity = b.quantity;
        a.price = b.price;

        b.id = id;
        b.name = name;
        b.quantity = qty;
        b.price = price;
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addAtEnd(1, "Keyboard", 10, 500);
        inv.addAtEnd(2, "Mouse", 20, 300);
        inv.addAtBeginning(3, "Laptop", 5, 50000);
        inv.addAtPosition(2, 4, "Monitor", 7, 8000);

        inv.display();
        System.out.println(inv.totalValue());

        inv.updateQuantity(2, 25);
        inv.searchById(2);

        inv.sortByNameAsc();
        inv.display();

        inv.sortByPriceDesc();
        inv.display();

        inv.removeById(1);
        inv.display();
    }
}
