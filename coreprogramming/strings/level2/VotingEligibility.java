package strings.level2;

import java.util.Scanner;
import java.util.Random;
/*
 * This class simulates a voting eligibility check for a group of people.
 * It uses a 1D array for data input and a 2D array for the processed output map.
 */
public class VotingEligibility {
    public int[] getStudentAges(int n) {
        // Generates an array of random ages between 10 and 99
        int[] ages = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10;
        }
        return ages;
    }
    // Maps each age to a voting status string
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
    // Formats and prints the 2D results array as a table
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
