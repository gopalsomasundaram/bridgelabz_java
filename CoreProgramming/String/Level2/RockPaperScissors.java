package String.Level2;

import java.util.Scanner;
public class RockPaperScissors {
    public String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0, 1, or 2
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }
    public int findWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer)) return 0;

        if ((user.equalsIgnoreCase("Rock") && computer.equalsIgnoreCase("Scissors")) ||
                (user.equalsIgnoreCase("Paper") && computer.equalsIgnoreCase("Rock")) ||
                (user.equalsIgnoreCase("Scissors") && computer.equalsIgnoreCase("Paper"))) {
            return 1; // Player wins
        } else {
            return 2; // Computer wins
        }
    }

    public String[][] calculateStats(int pWins, int cWins, int ties, int totalGames) {
        String[][] stats = new String[2][3];

        double pPerc = (totalGames == 0) ? 0 : ((double) pWins / totalGames) * 100;
        double cPerc = (totalGames == 0) ? 0 : ((double) cWins / totalGames) * 100;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(pWins);
        stats[0][2] = String.format("%.2f%%", pPerc);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(cWins);
        stats[1][2] = String.format("%.2f%%", cPerc);

        return stats;
    }

    public void displayStats(String[][] stats, int ties) {
        System.out.printf("%-12s | %-10s | %-15s\n", "Entity", "Total Wins", "Win Percentage");
        for (String[] row : stats) {
            System.out.printf("%-12s | %-10s | %-15s\n", row[0], row[1], row[2]);
        }
        System.out.println("Total Ties: " + ties);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors();

        System.out.print("Enter number of games to play: ");
        int totalToPlay = sc.nextInt();

        int pWins = 0, cWins = 0, ties = 0;

        for (int i = 1; i <= totalToPlay; i++) {
            System.out.println("\n--- Game " + i + " ---");
            System.out.print("Enter Choice (Rock, Paper, Scissors): ");
            String userChoice = sc.next();
            String compChoice = game.getComputerChoice();

            System.out.println("Computer chose: " + compChoice);

            int result = game.findWinner(userChoice, compChoice);
            if (result == 1) {
                System.out.println("Result: You Win!");
                pWins++;
            } else if (result == 2) {
                System.out.println("Result: Computer Wins!");
                cWins++;
            } else {
                System.out.println("Result: It's a Tie!");
                ties++;
            }
        }
        String[][] finalStats = game.calculateStats(pWins, cWins, ties, totalToPlay);
        game.displayStats(finalStats, ties);
        sc.close();
    }
}
