public class HexColorValidator {

    public static boolean validateHexColor(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {

        System.out.println(validateHexColor("#FFA500")); // true
        System.out.println(validateHexColor("#ff4500")); // true
        System.out.println(validateHexColor("#123"));    // false
        System.out.println(validateHexColor("FFA500"));  // false
        System.out.println(validateHexColor("#GGGGGG")); // false
    }
}
