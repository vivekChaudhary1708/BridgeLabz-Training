import java.util.ArrayList;
import java.util.List;

class InvalidQuizSubmissionException extends Exception {
    InvalidQuizSubmissionException(String msg) {
        super(msg);
    }
}

public class QuizResultProcessor {

    static int calculateScore(String[] correct, String[] user)
            throws InvalidQuizSubmissionException {

        if (correct.length != user.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }

        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(user[i])) {
                score++;
            }
        }
        return score;
    }

    static String getGrade(int score) {
        if (score >= 4) return "A";
        if (score >= 2) return "B";
        return "C";
    }

    public static void main(String[] args) throws Exception {
        String[] correctAnswers = {"A", "B", "C", "D"};
        String[] userAnswers = {"A", "B", "A", "D"};

        List<Integer> scores = new ArrayList<>();

        int score = calculateScore(correctAnswers, userAnswers);
        scores.add(score);

        System.out.println("Score: " + score);
        System.out.println("Grade: " + getGrade(score));
    }
}
