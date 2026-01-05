// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract Class
abstract class LibraryItem {

    // Encapsulation: private fields
    private int itemId;
    private String title;
    private String author;

    // Sensitive borrower data (hidden)
    private String borrowerName;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Protected methods for subclasses / interface logic
    protected void setBorrower(String name) {
        this.borrowerName = name;
        this.isAvailable = false;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    protected String getBorrowerMasked() {
        if (borrowerName == null) {
            return "None";
        }
        return borrowerName.charAt(0) + "***";
    }

    // Abstract method
    abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Available: " + isAvailable);
        System.out.println("Borrower: " + getBorrowerMasked());
    }
}

// Book class
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 5; // 5 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main Class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Polymorphism: LibraryItem reference
        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book(1, "Java Programming", "James Gosling");
        items[1] = new Magazine(2, "Tech Monthly", "Editorial Team");
        items[2] = new DVD(3, "Inception", "Christopher Nolan");

        // Reserving items
        ((Reservable) items[0]).reserveItem("Rahul");
        ((Reservable) items[2]).reserveItem("Aman");

        // Display details
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println();
        }
    }
}
