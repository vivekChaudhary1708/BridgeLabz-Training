import java.util.ArrayList;
import java.util.List;

// Main class
public class CinemaTime {

    // Lists for titles and showtimes
    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();

  
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }

   
    public void searchMovie(String keyword) {
        try {
            boolean found = false;

            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(
                            String.format("Movie: %s | Time: %s",
                                    movieTitles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index accessed during search!");
        }
    }

 
    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(movieTitles.get(i) + " at " + showTimes.get(i));
        }
    }

  
    public void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        System.out.println("\n--- Printable Movie Report ---");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " | " + timesArray[i]);
        }
    }

   
    private boolean isValidTime(String time) {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
        } catch (Exception e) {
            return false;
        }
    }

   
    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Avengers", "21:00");
            cinema.addMovie("Interstellar", "25:99"); 
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- All Movies ---");
        cinema.displayAllMovies();

        System.out.println("\n--- Search Result ---");
        cinema.searchMovie("inter");

        cinema.generateReport();
    }
}


class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
