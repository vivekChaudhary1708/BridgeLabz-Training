import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

interface FineCalculator {
    double calculateFine(int days);
}

class StudentFine implements FineCalculator {
    public double calculateFine(int days) {
        return days * 2;
    }
}

class StaffFine implements FineCalculator {
    public double calculateFine(int days) {
        return days * 1;
    }
}

class Book {
    int id;
    String title;
    boolean available = true;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

class Member extends User {
    List<Transaction> history = new ArrayList<>();

    public Member(String name) {
        super(name);
    }
}

class Transaction {
    Book book;
    int daysLate;

    public Transaction(Book book, int daysLate) {
        this.book = book;
        this.daysLate = daysLate;
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public Transaction issueBook(int id, Member m) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.id == id && b.available) {
                b.available = false;
                Transaction t = new Transaction(b, 0);
                m.history.add(t);
                return t;
            }
        }
        throw new BookNotAvailableException("Book not available");
    }

    public void returnBook(Transaction t, int lateDays, FineCalculator calc) {
        t.book.available = true;
        t.daysLate = lateDays;
        double fine = calc.calculateFine(lateDays);
        System.out.println("Fine: " + fine);
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book(1, "Java"));
        lib.addBook(new Book(2, "DSA"));

        Member m1 = new Member("Vivek");

        try {
            Transaction t1 = lib.issueBook(1, m1);
            lib.returnBook(t1, 5, new StudentFine());
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        try {
            Transaction t2 = lib.issueBook(2, m1);
            lib.returnBook(t2, 3, new StaffFine());
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
