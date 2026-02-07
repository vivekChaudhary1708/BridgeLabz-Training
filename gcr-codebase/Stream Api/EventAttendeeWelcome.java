import java.util.*;

public class EventAttendeeWelcome {

    public static void main(String[] args) {

        List<String> attendees = List.of(
                "Vivek",
                "Rahul",
                "Aman",
                "Neha"
        );

        System.out.println("Event Welcome Messages:");

        // Using forEach() with lambda expression
        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
