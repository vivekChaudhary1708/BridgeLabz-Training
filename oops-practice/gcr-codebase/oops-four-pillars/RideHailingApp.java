// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Class
abstract class Vehicle {

    // Encapsulation: private fields
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // GPS data (secured)
    private String currentLocation = "Unknown";

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Protected GPS helpers
    protected String getLocation() {
        return currentLocation;
    }

    protected void setLocation(String location) {
        this.currentLocation = location;
    }

    // Abstract method
    abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per KM: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

// Car class
class Car extends Vehicle implements GPS {

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance; // no base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20; // small base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

// Main Class
public class RideHailingApp {

    // Polymorphic fare calculation
    static void calculateRideFare(Vehicle[] vehicles, double distance) {

        for (Vehicle v : vehicles) {

            ((GPS) v).updateLocation("City Center");

            v.getVehicleDetails();
            System.out.println("Distance: " + distance + " km");
            System.out.println("Total Fare: " + v.calculateFare(distance));
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Vehicle[] rides = new Vehicle[3];

        rides[0] = new Car("CAR101", "Rahul", 15);
        rides[1] = new Bike("BIKE202", "Aman", 8);
        rides[2] = new Auto("AUTO303", "Ravi", 10);

        calculateRideFare(rides, 10); // 10 km ride
    }
}
