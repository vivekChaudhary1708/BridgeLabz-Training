import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;
    boolean available;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
}

public class LibraryManagementSystem {

    static List<Book> books = new ArrayList<>();

    static void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    static void searchBook(String keyword) {
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.title + " - " +
                        (b.available ? "Available" : "Checked Out"));
            }
        }
    }

    static void checkoutBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && b.available) {
                b.available = false;
                System.out.println("Book checked out");
                return;
            }
        }
        System.out.println("Book not available");
    }

    public static void main(String[] args) {
        addBook("Java Basics", "James");
        addBook("DSA with Java", "Mark");

        searchBook("java");
        checkoutBook("Java Basics");
        searchBook("java");
    }
}
