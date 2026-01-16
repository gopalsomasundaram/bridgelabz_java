package String.Level3;

import java.util.Scanner;
public class BMI {
        public String[] calculateSingleBMI(double weight, double heightCm) {
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            double roundedBMI = Math.round(bmi * 100.0) / 100.0;
            String status;
            if (roundedBMI <= 18.4) {
                status = "Underweight";
            } else if (roundedBMI <= 24.9) {
                status = "Normal";
            } else if (roundedBMI <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            return new String[]{String.valueOf(roundedBMI), status};
        }
        public String[][] processTeamData(double[][] rawData) {
            String[][] results = new String[rawData.length][4];
            for (int i = 0; i < rawData.length; i++) {
                double weight = rawData[i][0];
                double height = rawData[i][1];
                String[] bmiInfo = calculateSingleBMI(weight, height);
                results[i][0] = String.valueOf(height); // Height (cm)
                results[i][1] = String.valueOf(weight); // Weight (kg)
                results[i][2] = bmiInfo[0];             // BMI value
                results[i][3] = bmiInfo[1];             // Status
            }
            return results;
        }
        public void displayTable(String[][] data) {
            System.out.println("\n" + "=".repeat(65));
            System.out.printf("%-10s | %-12s | %-12s | %-10s | %-15s\n",
                    "Person", "Height(cm)", "Weight(kg)", "BMI", "Status");
            System.out.println("-".repeat(65));

            for (int i = 0; i < data.length; i++) {
                System.out.printf("Member %-3d | %-12s | %-12s | %-10s | %-15s\n",
                        (i + 1), data[i][0], data[i][1], data[i][2], data[i][3]);
            }
            System.out.println("=".repeat(65));
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            BMI analysis = new BMI();

            double[][] teamData = new double[10][2];

            System.out.println("Enter health data for 10 team members:");
            for (int i = 0; i < 10; i++) {
                System.out.println("Member " + (i + 1) + ":");
                System.out.print("Enter Weight (kg): ");
                teamData[i][0] = sc.nextDouble();
                System.out.print("Enter Height (cm): ");
                teamData[i][1] = sc.nextDouble();
            }
            String[][] finalReport = analysis.processTeamData(teamData);
            analysis.displayTable(finalReport);
            sc.close();
        }
}
