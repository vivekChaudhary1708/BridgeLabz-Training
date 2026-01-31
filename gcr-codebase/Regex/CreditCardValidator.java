public class CreditCardValidator {

    public static boolean isValidCreditCard(String cardNumber) {

        // Visa: starts with 4, 16 digits
        // MasterCard: starts with 5, 16 digits
        String regex = "^(4[0-9]{15}|5[0-9]{15})$";

        return cardNumber.matches(regex);
    }

    public static void main(String[] args) {

        System.out.println(isValidCreditCard("4123456789012345")); // true (Visa)
        System.out.println(isValidCreditCard("5123456789012345")); // true (MasterCard)

        System.out.println(isValidCreditCard("6123456789012345")); // false
        System.out.println(isValidCreditCard("412345678901234"));  // false
        System.out.println(isValidCreditCard("51234abcd901234")); // false
    }
}
