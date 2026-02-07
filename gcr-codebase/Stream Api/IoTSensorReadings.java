import java.util.*;

public class IoTSensorReadings {

    public static void main(String[] args) {

        // Sensor readings data
        List<Integer> sensorReadings = List.of(
                45, 72, 88, 30, 95, 60
        );

        int threshold = 70;

        System.out.println("Sensor Readings Above Threshold:");

        sensorReadings.stream()
                // filter readings above threshold
                .filter(reading -> reading > threshold)

                // print using forEach()
                .forEach(reading ->
                        System.out.println("High Reading: " + reading)
                );
    }
}
