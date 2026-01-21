import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    protected String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public abstract void displayInfo();
}

class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics Item : " + name);
    }
}

class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Grocery Item     : " + name);
    }
}

class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture Item   : " + name);
    }
}

class Storage<T extends WarehouseItem> {

    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}

public class SmartWarehouseSystem {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("---- Electronics Section ----");
        Storage.displayItems(electronicsStorage.getItems());

        System.out.println("\n---- Grocery Section ----");
        Storage.displayItems(groceryStorage.getItems());

        System.out.println("\n---- Furniture Section ----");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
