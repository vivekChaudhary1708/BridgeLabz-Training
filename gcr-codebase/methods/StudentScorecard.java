import java.util.Scanner;

public class StudentScorecard {

    // Method to generate random PCM scores (2-digit)
    // cols: 0-Physics, 1-Chemistry, 2-Maths
    static int[][] generateScores(int students) {

        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10; // Physics
            scores[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }

        return scores;
    }

    // Method to calculate total, average, percentage
    // cols: 0-Total, 1-Average, 2-Percentage
    static double[][] calculateResults(int[][] scores) {

        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // round to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    // Method to display scorecard
    static void displayScorecard(int[][] scores, double[][] result) {

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < scores.length; i++) {

            double percent = result[i][2];
            String grade;

            if (percent >= 80) grade = "A";
            else if (percent >= 70) grade = "B";
            else if (percent >= 60) grade = "C";
            else if (percent >= 50) grade = "D";
            else if (percent >= 40) grade = "E";
            else grade = "R";

            System.out.println(
                (i + 1) + "\t" +
                scores[i][0] + "\t" +
                scores[i][1] + "\t" +
                scores[i][2] + "\t" +
                result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2] + "\t" +
                grade
            );
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] scores = generateScores(students);
        double[][] result = calculateResults(scores);

        displayScorecard(scores, result);

        sc.close();
    }
}
