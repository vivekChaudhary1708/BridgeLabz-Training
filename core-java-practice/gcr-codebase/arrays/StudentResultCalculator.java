import java.util.Scanner;

public class StudentResultCalculator {

    public static void main(String[] args) {

        Scanner bhaiScanner = new Scanner(System.in);

        System.out.print("Kitne students hain: ");
        int totalStudents = bhaiScanner.nextInt();

        int[] physics = new int[totalStudents];
        int[] chemistry = new int[totalStudents];
        int[] maths = new int[totalStudents];

        double[] percentage = new double[totalStudents];
        char[] grade = new char[totalStudents];

        for (int student = 0; student < totalStudents; student++) {

            System.out.println("Student " + (student + 1));

            System.out.print("Physics marks: ");
            physics[student] = bhaiScanner.nextInt();

            if (physics[student] < 0) {
                System.out.println("Positive marks dalo");
                student--;
                continue;
            }

            System.out.print("Chemistry marks: ");
            chemistry[student] = bhaiScanner.nextInt();

            if (chemistry[student] < 0) {
                System.out.println("Positive marks dalo");
                student--;
                continue;
            }

            System.out.print("Maths marks: ");
            maths[student] = bhaiScanner.nextInt();

            if (maths[student] < 0) {
                System.out.println("Positive marks dalo");
                student--;
                continue;
            }
        }

        for (int student = 0; student < totalStudents; student++) {

            int totalMarks = physics[student] + chemistry[student] + maths[student];
            percentage[student] = (totalMarks / 300.0) * 100;

            if (percentage[student] >= 80) {
                grade[student] = 'A';
            } else if (percentage[student] >= 70) {
                grade[student] = 'B';
            } else if (percentage[student] >= 60) {
                grade[student] = 'C';
            } else if (percentage[student] >= 50) {
                grade[student] = 'D';
            } else if (percentage[student] >= 40) {
                grade[student] = 'E';
            } else {
                grade[student] = 'R';
            }
        }

        for (int student = 0; student < totalStudents; student++) {

            System.out.println("Student " + (student + 1));
            System.out.println("Physics: " + physics[student]);
            System.out.println("Chemistry: " + chemistry[student]);
            System.out.println("Maths: " + maths[student]);
            System.out.println("Percentage: " + percentage[student]);
            System.out.println("Grade: " + grade[student]);
        }

        bhaiScanner.close();
    }
}
