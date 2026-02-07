import java.util.*;
import java.util.stream.*;

public class TopTrendingMovies {

    static class Movie {
        String name;
        double rating;
        int releaseYear;

        Movie(String name, double rating, int releaseYear) {
            this.name = name;
            this.rating = rating;
            this.releaseYear = releaseYear;
        }
    }

    public static void main(String[] args) {

        List<Movie> movies = List.of(
                new Movie("Movie A", 9.2, 2024),
                new Movie("Movie B", 8.5, 2023),
                new Movie("Movie C", 9.0, 2024),
                new Movie("Movie D", 7.9, 2022),
                new Movie("Movie E", 8.8, 2023),
                new Movie("Movie F", 9.5, 2024)
        );

        System.out.println("Top 5 Trending Movies:");

        movies.stream()
                // filter high-rated movies (example condition)
                .filter(m -> m.rating >= 8.0)

                // sort by rating DESC, then release year DESC
                .sorted(
                        Comparator.comparingDouble((Movie m) -> m.rating).reversed()
                                .thenComparing(m -> m.releaseYear, Comparator.reverseOrder())
                )

                // take top 5
                .limit(5)

                // display
                .forEach(m ->
                        System.out.println(
                                m.name + " | Rating: " + m.rating + " | Year: " + m.releaseYear
                        )
                );
    }
}
