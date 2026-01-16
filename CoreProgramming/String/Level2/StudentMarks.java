package String.Level2;

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
/*
 * This class generates and processes academic performance data for 'n' students.
 * It uses 2D arrays to map raw scores to statistics and letter grades.
 */
public class StudentMarks {
    // Generates random marks between 10 and 99 for Physics, Chemistry, and Maths
    public int[][] generatePCMScores(int n) {
        int[][] scores = new int[n][3]; // 0: Physics, 1: Chemistry, 2: Maths
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                // random.nextInt(90) gives 0-89, +10 ensures a range of 10-99
                scores[i][j] = random.nextInt(90) + 10;
            }
        }
        return scores;
    }
    // Performs mathematical calculations for Total, Average, and Percentage
    public double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3]; // 0: Total, 1: Average, 2: Percentage
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percentage = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }
    // Assigns alphabetical grades and qualitative levels based on percentage
    public String[][] calculateGrades(double[][] stats) {
        String[][] gradeData = new String[stats.length][2]; // 0: Grade, 1: Remarks
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 80) {
                gradeData[i][0] = "A";
                gradeData[i][1] = "(Level 4)";
            } else if (p >= 70) {
                gradeData[i][0] = "B";
                gradeData[i][1] = "(Level 3)";
            } else if (p >= 60) {
                gradeData[i][0] = "C";
                gradeData[i][1] = "(Level 2)";
            } else if (p >= 50) {
                gradeData[i][0] = "D";
                gradeData[i][1] = "(Level 1)";
            } else if (p >= 40) {
                gradeData[i][0] = "E";
                gradeData[i][1] = "(Level 1-)";
            } else {
                gradeData[i][0] = "R";
                gradeData[i][1] = "(Remedial)";
            }
        }
        return gradeData;
    }
    // Formats and prints a multi-column scorecard
    public void displayScorecard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("\n" + "=".repeat(95));
        System.out.printf("%-10s | %-3s | %-3s | %-3s | %-7s | %-7s | %-7s | %-5s | %-15s\n",
                "Student", "Phy", "Che", "Mat", "Total", "Avg", "Perc%", "Grade", "Remarks");
        System.out.println("-".repeat(95));

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %-2d | %-3d | %-3d | %-3d | %-7.0f | %-7.2f | %-7.2f | %-5s | %-15s\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i][0], grades[i][1]);
        }
        System.out.println("=".repeat(95));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentMarks system = new StudentMarks();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        // Sequential processing
        int[][] pcmScores = system.generatePCMScores(n);
        double[][] performanceStats = system.calculateStats(pcmScores);
        String[][] finalGrades = system.calculateGrades(performanceStats);
        system.displayScorecard(pcmScores, performanceStats, finalGrades);

        sc.close();
    }
}
