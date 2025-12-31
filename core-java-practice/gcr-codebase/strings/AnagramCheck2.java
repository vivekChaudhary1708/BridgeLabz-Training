public class AnagramCheck2{

    public static void main(String[] args) {

        String str1 = "listen";
        String str2 = "silent";

        if (isAnagram(str1, str2)) {
            System.out.println("Strings are Anagrams");
        } else {
            System.out.println("Strings are NOT Anagrams");
        }
    }

    static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] count = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                return false;
        }

        return true;
    }
}
