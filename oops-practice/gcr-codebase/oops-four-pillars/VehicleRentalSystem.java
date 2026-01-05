// Interface
interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

// Abstract Class
abstract class Vehicle {

    // Encapsulation: private fields
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Sensitive data (hidden)
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // No direct getter for policy number (encapsulation)
    protected String getInsurancePolicyNumberMasked() {
        return "XXXX-" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    // Abstract method
    abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle implements Insurable {

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 200 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (" + getInsurancePolicyNumberMasked() + ")";
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 100 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (" + getInsurancePolicyNumberMasked() + ")";
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    @Override
    double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; // extra charge
    }

    @Override
    public double calculateInsurance(int days) {
        return 300 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (" + getInsurancePolicyNumberMasked() + ")";
    }
}

// Main Class
public class VehicleRentalSystem {

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR123", 1500, "CARPOL1234");
        vehicles[1] = new Bike("BIKE456", 500, "BIKEPOL5678");
        vehicles[2] = new Truck("TRUCK789", 3000, "TRUCKPOL9999");

        int days = 3;

        for (Vehicle v : vehicles) {

            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = ((Insurable) v).calculateInsurance(days);

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println(((Insurable) v).getInsuranceDetails());
            System.out.println();
        }
    }
}
