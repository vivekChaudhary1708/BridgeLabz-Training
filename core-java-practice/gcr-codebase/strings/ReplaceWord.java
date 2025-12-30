public class ReplaceWord {

    public static void main(String[] args) {

        String sentence = "I love Java programming";
        String oldWord = "Java";
        String newWord = "Python";

        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result += newWord;
            } else {
                result += words[i];
            }

            if (i < words.length - 1) {
                result += " ";
            }
        }

        System.out.println("Modified Sentence: " + result);
    }
}
