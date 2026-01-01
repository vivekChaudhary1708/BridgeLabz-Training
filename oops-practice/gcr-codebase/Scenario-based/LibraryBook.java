public class LibraryBook {

    // Static variable (shared by all books)
    private static String libraryName = "Egmore Library";

    // Instance variables
    private String title;
    private String author;
    private final String isbn;   // final variable

    // Constructor using 'this'
    public LibraryBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayBookDetails() {
        if (this instanceof LibraryBook) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    // Main method
    public static void main(String[] args) {

        LibraryBook book1 = new LibraryBook(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991"
        );

        displayLibraryName();
        book1.displayBookDetails();
    }
}
