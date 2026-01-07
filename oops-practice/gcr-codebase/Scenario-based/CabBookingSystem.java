import java.util.*;

// User class
class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Driver class
class Driver {
    int id;
    String name;
    boolean available = true;

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Fare calculator interface
interface FareCalculator {
    double calculateFare(double distance);
}

// Normal pricing
class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

// Peak pricing
class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// Custom exception
class NoDriverAvailableException extends Exception {
    NoDriverAvailableException(String msg) {
        super(msg);
    }
}

// Ride class
class Ride {
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(User user, Driver driver, double distance, FareCalculator calculator) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = calculator.calculateFare(distance);
    }
}

// Main class
public class CabBookingSystem {

    static List<Driver> drivers = new ArrayList<>();
    static List<Ride> rides = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // adding drivers
        drivers.add(new Driver(1, "Amit"));
        drivers.add(new Driver(2, "Rohit"));

        User user = new User(101, "Vivek");

        System.out.println("Cab booking started");

        try {
            Driver driver = getDriver();

            System.out.print("Enter distance: ");
            double distance = sc.nextDouble();

            System.out.print("Is it peak time (yes/no): ");
            String peak = sc.next();

            FareCalculator calculator;
            if (peak.equalsIgnoreCase("yes")) {
                calculator = new PeakFare();
            } else {
                calculator = new NormalFare();
            }

            Ride ride = new Ride(user, driver, distance, calculator);
            rides.add(ride);
            driver.available = false;

            System.out.println("Ride booked");
            System.out.println("User name: " + user.name);
            System.out.println("Driver name: " + driver.name);
            System.out.println("Fare: " + ride.fare);

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        // showing ride history
        System.out.println("\nRide history:");
        for (Ride r : rides) {
            System.out.println(
                    r.user.name + " booked a ride with " +
                    r.driver.name + " for " +
                    r.distance + " km. Fare was " +
                    r.fare
            );
        }
    }

    static Driver getDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.available) {
                return d;
            }
        }
        throw new NoDriverAvailableException("No driver is available");
    }
}
