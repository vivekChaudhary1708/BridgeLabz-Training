public class Book {

    // Public variable
    public String ISBN;

    // Protected variable
    protected String title;

    // Private variable
    private String author;

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    public void displayBook() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Main method
    public static void main(String[] args) {

        EBook ebook = new EBook("978-0135166307", "Java Programming", "James Gosling", "PDF");

        ebook.displayEBook();

        // Update author using setter
        ebook.setAuthor("Oracle Team");

        System.out.println("\nAfter Updating Author:");
        ebook.displayEBook();
    }
}

// Subclass
class EBook extends Book {

    String format;

    public EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    public void displayEBook() {
        System.out.println("ISBN: " + ISBN);       // public → accessible
        System.out.println("Title: " + title);     // protected → accessible
        System.out.println("Format: " + format);
        System.out.println("Author: " + getAuthor()); // private → via getter
    }
}
