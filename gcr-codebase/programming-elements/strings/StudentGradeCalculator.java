import java.util.Random;
import java.util.Scanner;

public class StudentGradeCalculator {

    // a) Generate random 2-digit PCM marks for all students
    public static int[][] generatePCMMarks(int students) {

        Random random = new Random();
        int[][] pcm = new int[students][3]; // 0-Physics, 1-Chemistry, 2-Maths

        for (int i = 0; i < students; i++) {
            pcm[i][0] = random.nextInt(90) + 10;
            pcm[i][1] = random.nextInt(90) + 10;
            pcm[i][2] = random.nextInt(90) + 10;
        }

        return pcm;
    }

    // b) Calculate total, average, percentage (rounded to 2 digits)
    public static double[][] calculateResults(int[][] pcm) {

        double[][] result = new double[pcm.length][3]; 
        // 0-total, 1-average, 2-percentage

        for (int i = 0; i < pcm.length; i++) {

            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return result;
    }

    // c) Calculate grade based on percentage
    public static String[] calculateGrades(double[][] result) {

        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {

            double percent = result[i][2];

            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }

        return grades;
    }

    // d) Display scorecard
    public static void displayScoreCard(
            int[][] pcm,
            double[][] result,
            String[] grades
    ) {

        System.out.println("\nStudent\tPhy\tChem\tMath\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                pcm[i][0] + "\t" +
                pcm[i][1] + "\t" +
                pcm[i][2] + "\t" +
                (int) result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2] + "\t\t" +
                grades[i]
            );
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Number of students daalo: ");
        int students = input.nextInt();

        int[][] pcmMarks = generatePCMMarks(students);
        double[][] results = calculateResults(pcmMarks);
        String[] grades = calculateGrades(results);

        displayScoreCard(pcmMarks, results, grades);

        input.close();
    }
}
