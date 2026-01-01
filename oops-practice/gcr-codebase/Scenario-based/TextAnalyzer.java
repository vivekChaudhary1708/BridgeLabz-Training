public class TextAnalyzer {

    public static void main(String[] args) {

        String text = "Java is powerful. Java is fast and Java is popular.";

        // Word count
        String[] words = text.split(" ");
        int count = words.length;
        System.out.println("Word Count: " + count);

        // Longest word
        String longest = "";
        for (int i = 0; i < words.length; i++) {
            String clean = words[i].replace(".", "");
            if (clean.length() > longest.length()) {
                longest = clean;
            }
        }
        System.out.println("Longest Word: " + longest);

        // Replace word
        String newText = text.replace("Java", "Python");
        System.out.println("After Replace: " + newText);
    }
}
