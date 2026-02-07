import java.util.*;

public class TransformingNamesForDisplay {

    public static void main(String[] args) {

        List<String> customerNames = List.of(
                "vivek",
                "rahul",
                "aman",
                "neha",
                "rohit"
        );

        System.out.println("Customer Names (Uppercase & Sorted):");

        customerNames.stream()
                // convert names to uppercase
                .map(String::toUpperCase)

                // sort alphabetically
                .sorted()

                // display
                .forEach(System.out::println);
    }
}
