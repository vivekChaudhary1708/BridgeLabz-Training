public class LengthConverter {

    // Convert yards to feet
    public static double yardsToFeet(double yards) {
        double yardsToFeetFactor = 3.0;
        return yards * yardsToFeetFactor;
    }

    // Convert feet to yards
    public static double feetToYards(double feet) {
        double feetToYardsFactor = 0.333333;
        return feet * feetToYardsFactor;
    }

    // Convert meters to inches
    public static double metersToInches(double meters) {
        double metersToInchesFactor = 39.3701;
        return meters * metersToInchesFactor;
    }

    // Convert inches to meters
    public static double inchesToMeters(double inches) {
        double inchesToMetersFactor = 0.0254;
        return inches * inchesToMetersFactor;
    }

    // Convert inches to centimeters
    public static double inchesToCentimeters(double inches) {
        double inchesToCmFactor = 2.54;
        return inches * inchesToCmFactor;
    }
}
