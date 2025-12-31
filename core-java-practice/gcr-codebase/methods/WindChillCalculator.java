import java.util.Scanner;

public class WindChillCalculator {

    // Method to calculate wind chill temperature
    public double calculateWindChill(double temperature, double windSpeed) {

        double windSpeedPower = Math.pow(windSpeed, 0.16);

        double windChillValue =
                35.74
                + (0.6215 * temperature)
                + (0.4275 * temperature - 35.75) * windSpeedPower;

        return windChillValue;
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double givenTemperature = inputReader.nextDouble();

        System.out.print("Enter wind speed: ");
        double givenWindSpeed = inputReader.nextDouble();

        WindChillCalculator calculator = new WindChillCalculator();

        double finalWindChill =
                calculator.calculateWindChill(givenTemperature, givenWindSpeed);

        System.out.println("Calculated Wind Chill Temperature is: " + finalWindChill);

        inputReader.close();
    }
}
