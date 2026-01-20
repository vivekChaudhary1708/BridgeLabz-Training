import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BookShelf {

  
    private Map<String, LinkedList<String>> catalog = new HashMap<>();

    
    private Set<String> bookSet = new HashSet<>();

  
    public void addBook(String genre, String book) {
        if (bookSet.contains(book)) {
            System.out.println("Duplicate book avoided: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        bookSet.add(book);

        System.out.println(book + " added to genre: " + genre);
    }

  
    public void borrowBook(String genre, String book) {
        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found!");
            return;
        }

        if (catalog.get(genre).remove(book)) {
            bookSet.remove(book);
            System.out.println(book + " borrowed from " + genre);
        } else {
            System.out.println(book + " not available in " + genre);
        }
    }

 
    public void returnBook(String genre, String book) {
        addBook(genre, book);
    }

   
    public void displayLibrary() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println(genre + " -> " + catalog.get(genre));
        }
    }

   
    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();

        shelf.addBook("Fiction", "Harry Potter");
        shelf.addBook("Fiction", "Alchemist");
        shelf.addBook("Science", "Physics 101");
        shelf.addBook("Fiction", "Harry Potter"); // Duplicate

        shelf.displayLibrary();

        shelf.borrowBook("Fiction", "Alchemist");
        shelf.displayLibrary();

        shelf.returnBook("Fiction", "Alchemist");
        shelf.displayLibrary();
    }
}
