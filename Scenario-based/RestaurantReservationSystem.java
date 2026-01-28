import java.util.*;

class Table {
    int tableNumber;

    Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}

class Reservation {
    int tableNumber;
    String timeSlot;

    Reservation(int tableNumber, String timeSlot) {
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
    }
}

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String msg) {
        super(msg);
    }
}

public class RestaurantReservationSystem {

    Map<Integer, Table> tables = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

    public RestaurantReservationSystem() {
        tables.put(1, new Table(1));
        tables.put(2, new Table(2));
        tables.put(3, new Table(3));
    }

    void reserveTable(int tableNumber, String timeSlot) throws TableAlreadyReservedException {
        for (Reservation r : reservations) {
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                throw new TableAlreadyReservedException("Table already reserved!");
            }
        }
        reservations.add(new Reservation(tableNumber, timeSlot));
        System.out.println("Table " + tableNumber + " reserved for " + timeSlot);
    }

    void cancelReservation(int tableNumber, String timeSlot) {
        reservations.removeIf(r -> r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot));
        System.out.println("Reservation cancelled");
    }

    void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");
        for (Integer tableNo : tables.keySet()) {
            boolean booked = false;
            for (Reservation r : reservations) {
                if (r.tableNumber == tableNo && r.timeSlot.equals(timeSlot)) {
                    booked = true;
                }
            }
            if (!booked) {
                System.out.println("Table " + tableNo);
            }
        }
    }

    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();

        try {
            system.reserveTable(1, "7PM");
            system.reserveTable(2, "7PM");
            system.reserveTable(1, "7PM"); // double booking
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7PM");
        system.cancelReservation(2, "7PM");
        system.showAvailableTables("7PM");
    }
}
