import java.util.*;

// -------- Vessel Model Class --------
class Vessel {

    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // No-argument constructor
    public Vessel() {
    }

    // Four-argument constructor
    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    // Getters and Setters
    public String getVesselId() {
        return vesselId;
    }

    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}

// -------- VesselUtil Class --------
class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId) {
        for (Vessel v : vesselList) {
            if (v.getVesselId().equals(vesselId)) {
                return v;
            }
        }
        return null;
    }

    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();
        double maxSpeed = 0;

        // Find highest speed
        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }

        // Collect vessels with highest speed
        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() == maxSpeed) {
                result.add(v);
            }
        }

        return result;
    }
}

// -------- UserInterface (Main Class) --------
public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter vessel details");

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split(":");

            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );

            util.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String searchId = sc.nextLine();

        Vessel found = util.getVesselById(searchId);

        if (found != null) {
            System.out.println(
                    found.getVesselId() + " | " +
                    found.getVesselName() + " | " +
                    found.getVesselType() + " | " +
                    found.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        System.out.println("High performance vessels are");

        List<Vessel> highPerf = util.getHighPerformanceVessels();
        for (Vessel v : highPerf) {
            System.out.println(
                    v.getVesselId() + " | " +
                    v.getVesselName() + " | " +
                    v.getVesselType() + " | " +
                    v.getAverageSpeed() + " knots"
            );
        }

        sc.close();
    }
}
