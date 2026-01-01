public class TransportUnit {

    // Static variable (shared by all vehicles)
    private static double registrationFee = 2500.0;

    // Instance variables
    private final String registrationNumber;   // final variable
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this'
    public TransportUnit(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details
    public void displayDetails() {
        if (this instanceof TransportUnit) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: ₹" + registrationFee);
        }
    }

    // Main method
    public static void main(String[] args) {

        TransportUnit v1 = new TransportUnit("DL01AB1234", "Rahul", "Car");
        TransportUnit v2 = new TransportUnit("MH12XY5678", "Amit", "Bike");

        // Update registration fee
        TransportUnit.updateRegistrationFee(3000.0);

        v1.displayDetails();
        v2.displayDetails();
    }
}
