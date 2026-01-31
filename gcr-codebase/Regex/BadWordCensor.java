public class BadWordCensor {

    public static void main(String[] args) {

        String text = "This is a damn bad example with some stupid words.";

        // List of bad words
        String[] badWords = { "damn", "stupid" };

        // Create regex: \b(damn|stupid)\b
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        String censoredText = text.replaceAll(regex, "****");

        System.out.println(censoredText);
    }
}
