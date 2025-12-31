public class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    //  Default Constructor
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    //  Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    //  Copy Constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Display Method
    public void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    // Main Method
    public static void main(String[] args) {

        // Default booking
        HotelBooking booking1 = new HotelBooking();

        // Parameterized booking
        HotelBooking booking2 = new HotelBooking("Aman", "Deluxe", 3);

        // Copy booking
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("Default Booking:");
        booking1.displayBooking();

        System.out.println("\nParameterized Booking:");
        booking2.displayBooking();

        System.out.println("\nCopied Booking:");
        booking3.displayBooking();
    }
}
