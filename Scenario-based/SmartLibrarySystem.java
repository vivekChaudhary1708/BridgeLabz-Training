import java.util.*;

// ==================================================
// 1. BUILDER PATTERN – Book
// ==================================================
class Book {
    private String title;
    private String author;
    private String edition;
    private String genre;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.edition = builder.edition;
        this.genre = builder.genre;
    }

    public String getTitle() {
        return title;
    }

    // Builder
    static class BookBuilder {
        private String title;
        private String author;
        private String edition;
        private String genre;

        BookBuilder(String title) {
            this.title = title;
        }

        BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        BookBuilder edition(String edition) {
            this.edition = edition;
            return this;
        }

        BookBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        Book build() {
            return new Book(this);
        }
    }
}

// ==================================================
// 2. SINGLETON PATTERN – Library Catalog
// ==================================================
class LibraryCatalog {

    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();

    private LibraryCatalog() {}

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Catalog updated: " + book.getTitle());
    }
}

// ==================================================
// 3. OBSERVER PATTERN – Notifications
// ==================================================
interface Observer {
    void update(String message);
}

class LibraryUser implements Observer {
    private String name;

    LibraryUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("Notification to " + name + ": " + message);
    }
}

class NotificationService {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void notifyUsers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }
}

// ==================================================
// 4. FACTORY PATTERN – Users
// ==================================================
abstract class User {
    protected String name;
    abstract void getRole();
}

class Student extends User {
    Student(String name) { this.name = name; }
    void getRole() {
        System.out.println(name + " is a Student (Limited borrowing)");
    }
}

class Faculty extends User {
    Faculty(String name) { this.name = name; }
    void getRole() {
        System.out.println(name + " is Faculty (Extended borrowing)");
    }
}

class Librarian extends User {
    Librarian(String name) { this.name = name; }
    void getRole() {
        System.out.println(name + " is Librarian (Manages inventory)");
    }
}

class UserFactory {
    public static User createUser(String role, String name) {
        if (role.equalsIgnoreCase("student"))
            return new Student(name);
        if (role.equalsIgnoreCase("faculty"))
            return new Faculty(name);
        if (role.equalsIgnoreCase("librarian"))
            return new Librarian(name);
        throw new IllegalArgumentException("Invalid user role");
    }
}

// ==================================================
// MAIN CLASS – INTEGRATION
// ==================================================
public class SmartLibrarySystem {

    public static void main(String[] args) {

        System.out.println("=== SMART UNIVERSITY LIBRARY SYSTEM ===\n");

        // Singleton
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Factory
        User user1 = UserFactory.createUser("student", "Amit");
        User user2 = UserFactory.createUser("faculty", "Dr. Sharma");
        user1.getRole();
        user2.getRole();

        // Observer
        NotificationService notificationService = new NotificationService();
        notificationService.subscribe(new LibraryUser("Amit"));
        notificationService.subscribe(new LibraryUser("Dr. Sharma"));

        // Builder
        Book book = new Book.BookBuilder("Data Structures by Cormen")
                .author("Thomas H. Cormen")
                .edition("3rd Edition")
                .genre("Computer Science")
                .build();

        // Add book to catalog
        catalog.addBook(book);

        // Notify observers
        notificationService.notifyUsers(
                "New book available: " + book.getTitle()
        );

        System.out.println("\nSystem execution completed successfully.");
    }
}
