import java.util.Scanner;

public class StudentVoteChecker {

    // Method to check whether a student can vote
    public boolean canStudentVote(int age) {

        // Invalid age check
        if (age < 0) {
            return false;
        }

        // Voting eligibility check
        if (age >= 18) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker voteChecker = new StudentVoteChecker();

        // Array to store ages of 10 students
        int[] studentAges = new int[10];

        // Loop to take input and check voting eligibility
        for (int i = 0; i < studentAges.length; i++) {

            System.out.print("Enter age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();

            boolean eligible = voteChecker.canStudentVote(studentAges[i]);

            if (eligible) {
                System.out.println("Student " + (i + 1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " is NOT eligible to vote.");
            }
        }

        scanner.close();
    }
}
    