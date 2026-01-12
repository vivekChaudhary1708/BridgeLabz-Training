import java.util.*;

class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String msg) {
        super(msg);
    }
}

interface EvaluationStrategy {
    int evaluate(List<Question> questions, Map<Integer, String> answers);
}

class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(List<Question> questions, Map<Integer, String> answers) {
        int score = 0;
        for (Question q : questions) {
            if (q.correctAnswer.equals(answers.get(q.id))) {
                score += 1;
            }
        }
        return score;
    }
}

class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(List<Question> questions, Map<Integer, String> answers) {
        int score = 0;
        for (Question q : questions) {
            if (answers.get(q.id) != null && !answers.get(q.id).isEmpty()) {
                score += 2;
            }
        }
        return score;
    }
}

class Question {
    int id;
    String text;
    String correctAnswer;

    public Question(int id, String text, String correct) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correct;
    }
}

class Exam {
    String name;
    List<Question> questions = new ArrayList<>();
    Map<Student, Map<Integer, String>> submissions = new HashMap<>();
    long endTime;

    public Exam(String name, int durationSeconds) {
        this.name = name;
        this.endTime = System.currentTimeMillis() + durationSeconds * 1000;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void submit(Student s, Map<Integer, String> answers) throws ExamTimeExpiredException {
        if (System.currentTimeMillis() > endTime) {
            throw new ExamTimeExpiredException("Exam time expired");
        }
        submissions.put(s, answers);
    }

    public int getResult(Student s, EvaluationStrategy eval) {
        return eval.evaluate(questions, submissions.get(s));
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}

public class ExamApp {
    public static void main(String[] args) {
        Exam exam = new Exam("Java Test", 5);

        exam.addQuestion(new Question(1, "2+2", "4"));
        exam.addQuestion(new Question(2, "3+3", "6"));

        Student s1 = new Student("Vivek");

        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "4");
        answers.put(2, "6");

        try {
            exam.submit(s1, answers);
            int score = exam.getResult(s1, new ObjectiveEvaluation());
            System.out.println("Score: " + score);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
