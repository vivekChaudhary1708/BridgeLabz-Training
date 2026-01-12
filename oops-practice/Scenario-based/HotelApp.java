import java.util.*;

class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String msg) {
        super(msg);
    }
}

interface PricingStrategy {
    double calculatePrice(double base);
}

class NormalPricing implements PricingStrategy {
    public double calculatePrice(double base) {
        return base;
    }
}

class SeasonalPricing implements PricingStrategy {
    public double calculatePrice(double base) {
        return base * 1.5;
    }
}

class Room {
    int roomNo;
    double basePrice;
    boolean available = true;

    public Room(int roomNo, double price) {
        this.roomNo = roomNo;
        this.basePrice = price;
    }

    public double getPrice(PricingStrategy p) {
        return p.calculatePrice(basePrice);
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(int no, double price) {
        super(no, price);
    }
}

class StandardRoom extends Room {
    public StandardRoom(int no, double price) {
        super(no, price);
    }
}

class Guest {
    String name;

    public Guest(String name) {
        this.name = name;
    }
}

class Reservation {
    Room room;
    Guest guest;
    double bill;

    public Reservation(Room r, Guest g, double bill) {
        this.room = r;
        this.guest = g;
        this.bill = bill;
    }
}

class Hotel {
    List<Room> rooms = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Reservation bookRoom(Guest g, PricingStrategy p) throws RoomNotAvailableException {
        for (Room r : rooms) {
            if (r.available) {
                r.available = false;
                double price = r.getPrice(p);
                Reservation res = new Reservation(r, g, price);
                reservations.add(res);
                return res;
            }
        }
        throw new RoomNotAvailableException("No room available");
    }

    public void checkout(Reservation r) {
        r.room.available = true;
        System.out.println("Bill: " + r.bill);
    }
}

public class HotelApp {
    public static void main(String[] args) {
        Hotel h = new Hotel();

        h.addRoom(new DeluxeRoom(101, 2000));
        h.addRoom(new StandardRoom(102, 1000));

        Guest g1 = new Guest("Vivek");

        try {
            Reservation r1 = h.bookRoom(g1, new SeasonalPricing());
            h.checkout(r1);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
