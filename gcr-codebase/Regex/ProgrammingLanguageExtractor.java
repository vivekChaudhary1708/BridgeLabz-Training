import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingLanguageExtractor {

    public static void main(String[] args) {

        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages to extract
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
