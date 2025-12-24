import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int random = (int) (Math.random() * 3);
        if (random == 0) return "rock";
        if (random == 1) return "paper";
        return "scissors";
    }

    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) return "Draw";

        if (
            (user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))
        ) {
            return "User";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent);

        return stats;
    }

    // UPDATED display (no dashed lines)
    public static void displayResults(
            String[] userChoices,
            String[] computerChoices,
            String[] winners,
            String[][] stats
    ) {

        System.out.println("\nGame\tUser\tComputer\tWinner");

        for (int i = 0; i < winners.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                userChoices[i] + "\t" +
                computerChoices[i] + "\t\t" +
                winners[i]
            );
        }

        System.out.println("\nPlayer\tWins\tWin Percentage");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(
                stats[i][0] + "\t" +
                stats[i][1] + "\t" +
                stats[i][2] + "%"
            );
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Kitne games khelne hain: ");
        int games = input.nextInt();

        String[] userChoices = new String[games];
        String[] computerChoices = new String[games];
        String[] winners = new String[games];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {

            System.out.print("\nGame " + (i + 1) + " (rock/paper/scissors): ");
            String userChoice = input.next().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            userChoices[i] = userChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;

            if (winner.equals("User")) userWins++;
            if (winner.equals("Computer")) computerWins++;
        }

        String[][] stats = calculateStats(userWins, computerWins, games);
        displayResults(userChoices, computerChoices, winners, stats);

        input.close();
    }
}
