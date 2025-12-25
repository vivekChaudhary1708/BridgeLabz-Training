public class RemoveCharacter {

    public static void main(String[] args) {

        String str = "Hello World";
        char removeChar = 'l';
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != removeChar) {
                result += str.charAt(i);
            }
        }

        System.out.println("Modified String: " + result);
    }
}
