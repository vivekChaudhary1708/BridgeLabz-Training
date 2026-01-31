public class SSNValidator {

    public static boolean isValidSSN(String ssn) {

        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }

    public static void main(String[] args) {

        String validSSN = "123-45-6789";
        String invalidSSN = "123456789";

        System.out.println(validSSN + " is valid: " + isValidSSN(validSSN));
        System.out.println(invalidSSN + " is valid: " + isValidSSN(invalidSSN));
    }
}
