public class MostFrequentCharacter {

    public static void main(String[] args) {

        String str = "success";
        char mostFrequent = ' ';
        int maxCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = ch;
            }
        }

        System.out.println("Most Frequent Character: " + mostFrequent);
    }
}
