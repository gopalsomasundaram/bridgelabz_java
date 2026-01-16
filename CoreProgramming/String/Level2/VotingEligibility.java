package String.Level2;

import java.util.Scanner;
import java.util.Random;
public class VotingEligibility {
    public int[] getStudentAges(int n) {
        int[] ages = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10;
        }
        return ages;
    }
    public String[][] evaluateVoting(int[] ages) {
        String[][] statusMap = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            statusMap[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                statusMap[i][1] = "false (Invalid Age)";
            } else if (ages[i] >= 18) {
                statusMap[i][1] = "true";
            } else {
                statusMap[i][1] = "false";
            }
        }
        return statusMap;
    }
    public void displayVotingTable(String[][] data) {
        System.out.printf("%-10s | %-15s\n", "Age", "Can Vote?");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s | %-15s\n", data[i][0], data[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingEligibility obj = new VotingEligibility();

        System.out.print("Enter the number of students (e.g., 10): ");
        int count = scanner.nextInt();
        int[] studentAges = obj.getStudentAges(count);
        String[][] votingData = obj.evaluateVoting(studentAges);
        obj.displayVotingTable(votingData);
        scanner.close();
    }
}
