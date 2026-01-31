public class LicensePlateValidator {

    public static boolean validateLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {

        System.out.println(validateLicensePlate("AB1234")); // true
        System.out.println(validateLicensePlate("A12345")); // false
        System.out.println(validateLicensePlate("ab1234")); // false
        System.out.println(validateLicensePlate("AB12"));   // false
        System.out.println(validateLicensePlate("XY9999")); // true
    }
}
