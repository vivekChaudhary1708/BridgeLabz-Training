public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";

        // Step 1: StringBuilder object banao
        StringBuilder sb = new StringBuilder();

        // Step 2: String append karo
        sb.append(input);

        // Step 3: Reverse karo
        sb.reverse();

        // Step 4: String me convert karo
        String result = sb.toString();

        System.out.println(result);
    }
}
