import java.util.Scanner;

class ElectionBoothManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int voteA = 0, voteB = 0, voteC = 0;

        while (true) {
            System.out.print("Enter age (-1 to exit): ");
            int age = sc.nextInt();

            // exit condition
            if (age == -1) {
                break;
            }

            // eligibility check
            if (age >= 18) {
                System.out.println("You are eligible to vote");
                System.out.print("Enter vote (1, 2, or 3): ");
                int vote = sc.nextInt();

                if (vote == 1) {
                    voteA++;
                } else if (vote == 2) {
                    voteB++;
                } else if (vote == 3) {
                    voteC++;
                } else {
                    System.out.println("Invalid vote");
                }

            } else {
                System.out.println("Not eligible to vote");
            }
        }

        // Result
        System.out.println("\nVoting Result:");
        System.out.println("Candidate A: " + voteA);
        System.out.println("Candidate B: " + voteB);
        System.out.println("Candidate C: " + voteC);

        sc.close();
    }
}
