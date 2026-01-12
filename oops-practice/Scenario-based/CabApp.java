import java.util.*;

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) {
        super(msg);
    }
}

interface FareCalculator {
    double calculateFare(double distance);
}

class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

class User {
    String name;
    List<Ride> rideHistory = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}

class Driver {
    String name;
    boolean available = true;

    public Driver(String name) {
        this.name = name;
    }
}

class Ride {
    User user;
    Driver driver;
    double fare;

    public Ride(User user, Driver driver, double fare) {
        this.user = user;
        this.driver = driver;
        this.fare = fare;
    }
}

class RideService {
    List<Driver> drivers = new ArrayList<>();

    public RideService() {
        drivers.add(new Driver("Rohit"));
        drivers.add(new Driver("Aman"));
    }

    public Ride bookRide(User user, double distance, FareCalculator calc) throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.available) {
                d.available = false;
                double fare = calc.calculateFare(distance);
                Ride r = new Ride(user, d, fare);
                user.rideHistory.add(r);
                return r;
            }
        }
        throw new NoDriverAvailableException("No driver available");
    }
}

public class CabApp {
    public static void main(String[] args) {
        User u1 = new User("Vivek");
        RideService service = new RideService();

        FareCalculator normal = new NormalFare();
        FareCalculator peak = new PeakFare();

        try {
            Ride r1 = service.bookRide(u1, 10, normal);
            System.out.println(r1.driver.name + " " + r1.fare);

            Ride r2 = service.bookRide(u1, 5, peak);
            System.out.println(r2.driver.name + " " + r2.fare);
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        for (Ride r : u1.rideHistory) {
            System.out.println(r.driver.name + " " + r.fare);
        }
    }
}
