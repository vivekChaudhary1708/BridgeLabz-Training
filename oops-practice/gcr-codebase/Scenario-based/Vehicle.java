public class Vehicle {

    // Instance Variables
    String ownerName;
    String vehicleType;

    // Class Variable (shared by all vehicles)
    static double registrationFee = 5000;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance Method
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class Method
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main Method
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Rahul", "Car");
        Vehicle v2 = new Vehicle("Amit", "Bike");

        System.out.println("Before Updating Registration Fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        // Update registration fee
        Vehicle.updateRegistrationFee(6500);

        System.out.println("\nAfter Updating Registration Fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
