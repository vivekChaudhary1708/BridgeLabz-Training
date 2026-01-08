// Node class
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
class MovieDoublyLinkedList {

    Movie head;
    Movie tail;

    // Add at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newMovie;
            return;
        }

        newMovie.next = head;
        head.prev = newMovie;
        head = newMovie;
    }

    // Add at end
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newMovie;
            return;
        }

        tail.next = newMovie;
        newMovie.prev = tail;
        tail = newMovie;
    }

    // Add at specific position (1-based)
    void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp == tail) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove movie by title
    void removeByTitle(String title) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } 
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } 
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // Search by director
    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equals(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found for this director");
    }

    // Search by rating
    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found with this rating");
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // Display forward
    void displayForward() {
        Movie temp = head;

        if (temp == null) {
            System.out.println("No movies available");
            return;
        }

        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {
        Movie temp = tail;

        if (temp == null) {
            System.out.println("No movies available");
            return;
        }

        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method
    void displayMovie(Movie m) {
        System.out.println(
            m.title + " | " +
            m.director + " | " +
            m.year + " | " +
            m.rating
        );
    }
}

// Main class
public class MovieManagementApp {
    public static void main(String[] args) {

        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        list.addAtBeginning("Inception", "Nolan", 2010, 9.0);
        list.addAtEnd("Interstellar", "Nolan", 2014, 8.9);
        list.addAtEnd("Titanic", "Cameron", 1997, 8.5);
        list.addAtPosition(2, "Avatar", "Cameron", 2009, 8.0);

        System.out.println("Movies (Forward):");
        list.displayForward();

        System.out.println("\nMovies (Reverse):");
        list.displayReverse();

        System.out.println("\nSearch by Director:");
        list.searchByDirector("Nolan");

        list.updateRating("Titanic", 9.1);
        list.removeByTitle("Avatar");

        System.out.println("\nAfter Update & Delete:");
        list.displayForward();
    }
}
