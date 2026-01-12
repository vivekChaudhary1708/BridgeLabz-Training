import java.util.*;

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

public class SmartShelf {
    static void insertionSort(List<Book> list) {
        for (int i = 1; i < list.size(); i++) {
            Book key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).title.compareTo(key.title) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java"));
        books.add(new Book("Python"));
        books.add(new Book("C"));
        books.add(new Book("DSA"));

        insertionSort(books);

        for (Book b : books) {
            System.out.println(b.title);
        }
    }
}
