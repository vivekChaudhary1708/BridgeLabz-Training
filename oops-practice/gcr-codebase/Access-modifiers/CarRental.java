public class CarRental {

    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500; // fixed rate per day

    //  Default Constructor
    public CarRental() {
        this.customerName = "Guest";
        this.carModel = "Basic Model";
        this.rentalDays = 1;
    }

    //  Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    //  Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    //  Display method
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    //  Main Method
    public static void main(String[] args) {

        // Default booking
        CarRental rental1 = new CarRental();
        rental1.displayDetails();

        System.out.println();

        // Parameterized booking
        CarRental rental2 = new CarRental("Rohit", "Honda City", 4);
        rental2.displayDetails();
    }
}
