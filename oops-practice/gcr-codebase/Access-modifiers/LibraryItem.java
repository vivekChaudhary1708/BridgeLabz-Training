public class LibraryItem {

    String title;
    String author;
    double price;
    boolean isAvailable;

    // Constructor
    public LibraryItem(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to borrow the book
    public void borrowItem() {
        if (isAvailable) {
            System.out.println("Book successfully borrowed!");
            isAvailable = false;
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    // Display details
    public void displayItem() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Main method
    public static void main(String[] args) {

        LibraryItem book = new LibraryItem(
                "Clean Code",
                "Robert C. Martin",
                650.0,
                true
        );

        System.out.println("Book Details:");
        book.displayItem();

        System.out.println("\nBorrowing Book...");
        book.borrowItem();

        System.out.println("\nAfter Borrowing:");
        book.displayItem();
    }
}
