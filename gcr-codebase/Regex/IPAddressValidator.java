public class IPAddressValidator {

    public static boolean isValidIPv4(String ip) {

        String regex =
                "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}"
              + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        return ip.matches(regex);
    }

    public static void main(String[] args) {

        System.out.println(isValidIPv4("192.168.1.1"));   // true
        System.out.println(isValidIPv4("255.255.255.255"));// true
        System.out.println(isValidIPv4("0.0.0.0"));       // true

        System.out.println(isValidIPv4("256.1.1.1"));     // false
        System.out.println(isValidIPv4("192.168.1"));     // false
        System.out.println(isValidIPv4("192.168.1.999")); // false
    }
}
