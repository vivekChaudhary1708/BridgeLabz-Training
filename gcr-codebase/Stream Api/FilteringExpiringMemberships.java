import java.time.LocalDate;
import java.util.*;

public class FilteringExpiringMemberships {

    static class GymMember {
        String name;
        LocalDate expiryDate;

        GymMember(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }
    }

    public static void main(String[] args) {

        List<GymMember> members = List.of(
                new GymMember("Ravi", LocalDate.now().plusDays(10)),
                new GymMember("Amit", LocalDate.now().plusDays(25)),
                new GymMember("Rahul", LocalDate.now().plusDays(45))
        );

        System.out.println("Members whose membership expires within next 30 days:");

        members.stream()
                // filter members expiring within 30 days
                .filter(m ->
                        m.expiryDate.isAfter(LocalDate.now()) &&
                        m.expiryDate.isBefore(LocalDate.now().plusDays(30))
                )
                .forEach(m ->
                        System.out.println(m.name + " | Expiry: " + m.expiryDate)
                );
    }
}
