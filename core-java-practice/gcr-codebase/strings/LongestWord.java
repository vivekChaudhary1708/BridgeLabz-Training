public class LongestWord {

    public static void main(String[] args) {

        String sentence = "I am learning Java programming";

        String[] words = sentence.split(" ");
        String longestWord = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        System.out.println("Longest word: " + longestWord);
    }
}
