import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {

    // Method to generate random 2-digit ages of n students
    public static int[] generateAges(int totalStudents) {

        Random random = new Random();
        int[] ages = new int[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            ages[i] = random.nextInt(90) + 10; // 2-digit age (10–99)
        }

        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";   // invalid age
            } else if (ages[i] >= 18) {
                result[i][1] = "true";    // can vote
            } else {
                result[i][1] = "false";   // cannot vote
            }
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Total students daalo (default 10): ");
        int students = input.nextInt();

        int[] aadmiAges = generateAges(students);
        String[][] votingResult = checkVotingEligibility(aadmiAges);

        displayTable(votingResult);

        input.close();
    }
}
