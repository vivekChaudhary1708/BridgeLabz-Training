public class TextFormatter {

    public static void main(String[] args) {

        String text = "hello   world.this is   a test!how are you?  i am fine.";

        text = text.trim();

        // Remove extra spaces
        while (text.contains("  ")) {
            text = text.replace("  ", " ");
        }

        // Add space after punctuation
        text = text.replace(".", ". ");
        text = text.replace("!", "! ");
        text = text.replace("?", "? ");

        // Capitalize first letter and after punctuation
        char[] arr = text.toCharArray();
        boolean capitalize = true;

        for (int i = 0; i < arr.length; i++) {
            if (capitalize && arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char)(arr[i] - 32);
                capitalize = false;
            }

            if (arr[i] == '.' || arr[i] == '!' || arr[i] == '?') {
                capitalize = true;
            }
        }

        System.out.println(new String(arr));
    }
}
