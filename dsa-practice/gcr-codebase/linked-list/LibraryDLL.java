class Book {
    int id;
    String title, author, genre;
    boolean available;
    Book next, prev;

    Book(int id, String t, String a, String g, boolean av) {
        this.id = id;
        title = t;
        author = a;
        genre = g;
        available = av;
    }
}

class Library {
    Book head, tail;

    void addEnd(Book b) {
        if (head == null) {
            head = tail = b;
            return;
        }
        tail.next = b;
        b.prev = tail;
        tail = b;
    }

    void remove(int id) {
        Book t = head;
        while (t != null) {
            if (t.id == id) {
                if (t == head) head = head.next;
                if (t == tail) tail = tail.prev;
                if (t.prev != null) t.prev.next = t.next;
                if (t.next != null) t.next.prev = t.prev;
                return;
            }
            t = t.next;
        }
    }

    void displayForward() {
        for (Book t = head; t != null; t = t.next)
            System.out.println(t.id + " " + t.title);
    }

    void displayReverse() {
        for (Book t = tail; t != null; t = t.prev)
            System.out.println(t.id + " " + t.title);
    }
}

public class LibraryDLL {
    public static void main(String[] args) {
        Library l = new Library();
        l.addEnd(new Book(1,"Java","A","Tech",true));
        l.addEnd(new Book(2,"DSA","B","CS",true));
        l.displayForward();
        l.displayReverse();
    }
}
