import java.util.Scanner;

public class BusRouteDistanceTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDistance = 0;
        String choice;

        while (true) {
            System.out.print("Enter distance travelled at this stop (in km): ");
            int distance = sc.nextInt();

            totalDistance += distance;

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Total distance travelled: " + totalDistance + " km");
        sc.close();
    }
}
