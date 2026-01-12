package Arrays.Level2;

import java.util.Scanner;
public class ZaraBonus {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double[] oldSalary = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalary = new double[10];
        double[] bonusAmount = new double[10];
        double totalBonus =0 ,totalOldSalary =0 ,totalNewSalary =0;
        System.out.println("Enter the old Salary of the 10 employees");
        for(int i = 0;i<10;++i){
            oldSalary[i] = scanner.nextDouble();
            if(oldSalary[i]<=0){
                System.out.println("Invalid input, enter valid salary");
                i--;
            }
        }
        System.out.println("Enter the years of Service for the 10 employees");
        for(int i = 0;i<10;++i){
            yearsOfService[i] = scanner.nextDouble();
            if(yearsOfService[i]<=0){
                System.out.println("Invalid input, enter valid years of Service");
                i--;
            }
        }
        for(int i = 0;i<10;++i){
            if(yearsOfService[i]>5){
                bonusAmount[i] = oldSalary[i] * 0.05;

            }else{
                bonusAmount[i] = oldSalary[i] * 0.05;
            }
            newSalary[i] = oldSalary[i] + bonusAmount[i];
            totalBonus +=bonusAmount[i];
            totalOldSalary += oldSalary[i];
            totalNewSalary += newSalary[i];
        }
        System.out.printf("Total Bonus payout is %.1f,\n Total Old Salary is %.1f\n Total New Salary is %.1f\n",totalBonus,totalOldSalary,totalNewSalary);

        scanner.close();
    }
}
