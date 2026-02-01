import java.util.Scanner;

// =======================
// ABSTRACT PARENT CLASS
// =======================
abstract class GoodsTransport {

    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public String getTransportId() {
        return transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}

// =======================
// BRICK TRANSPORT
// =======================
class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    @Override
    public String vehicleSelection() {
        if (brickQuantity < 300)
            return "Truck";
        else if (brickQuantity <= 500)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {

        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float discount = 0;
        if (transportRating == 5)
            discount = price * 0.20f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.10f;

        float vehicleCost;
        String vehicle = vehicleSelection().toLowerCase();

        if (vehicle.equals("truck"))
            vehicleCost = 1000;
        else if (vehicle.equals("lorry"))
            vehicleCost = 1700;
        else
            vehicleCost = 3000;

        return (price + tax + vehicleCost) - discount;
    }
}

// =======================
// TIMBER TRANSPORT
// =======================
class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    @Override
    public String vehicleSelection() {
        double area = 2 * 3.147 * timberRadius * timberLength;

        if (area < 250)
            return "Truck";
        else if (area <= 400)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {

        double volume = 3.147 * timberRadius * timberRadius * timberLength;

        double rate;
        if (timberType.equalsIgnoreCase("Premium"))
            rate = 0.25;
        else
            rate = 0.15;

        float price = (float) (volume * timberPrice * rate);
        float tax = price * 0.3f;

        float discount = 0;
        if (transportRating == 5)
            discount = price * 0.20f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.10f;

        float vehicleCost;
        String vehicle = vehicleSelection().toLowerCase();

        if (vehicle.equals("truck"))
            vehicleCost = 1000;
        else if (vehicle.equals("lorry"))
            vehicleCost = 1700;
        else
            vehicleCost = 3000;

        return (price + tax + vehicleCost) - discount;
    }
}

// =======================
// UTILITY CLASS
// =======================
class Utility {

    public boolean validateTransportId(String transportId) {

        if (!transportId.matches("RTS\\d{3}[A-Z]")) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }
        return true;
    }

    public GoodsTransport parseDetails(String input) {

        String[] data = input.split(":");

        String transportId = data[0];
        String transportDate = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (type.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(
                    transportId,
                    transportDate,
                    rating,
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6])
            );
        } else {
            return new TimberTransport(
                    transportId,
                    transportDate,
                    rating,
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7])
            );
        }
    }

    public String findObjectType(GoodsTransport obj) {
        if (obj instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}

// =======================
// MAIN CLASS (PUBLIC)
// =======================
public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        String transportId = input.split(":")[0];

        if (!utility.validateTransportId(transportId)) {
            return;
        }

        GoodsTransport transport = utility.parseDetails(input);

        System.out.println("\nTransporter id : " + transport.getTransportId());
        System.out.println("Date of transport : " + transport.getTransportDate());
        System.out.println("Rating of the transport : " + transport.getTransportRating());

        if (transport instanceof BrickTransport) {
            BrickTransport bt = (BrickTransport) transport;
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
        } else {
            TimberTransport tt = (TimberTransport) transport;
            System.out.println("Type of the timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
        }

        System.out.println("Vehicle for transport : " + transport.vehicleSelection());
        System.out.println("Total charge : " + transport.calculateTotalCharge());
    }
}
