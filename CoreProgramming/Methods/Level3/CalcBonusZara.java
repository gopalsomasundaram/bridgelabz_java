package Methods.Level3;

import java.util.Scanner;
import java.lang.Math;
public class CalcBonusZara {
    void randomSalary(int[] arr){
        for(int i = 0;i<10;++i) {
            int min = 10000;
            int max = 99999;
            arr[i] = ((int) (Math.random() * (max - min + 1) + max));
        }
    }
    void randomYearOfService(int[] arr){
        for(int i = 0;i<10;++i) {
            int min = 0;
            int max = 10;
            arr[i] = ((int) (Math.random() * (max - min + 1) + max));
        }
    }
    int[][] calcBonus(int[] salary, int[] yearsOfService){
        int[][] arr = new int[10][2];
        for(int i = 0;i<10;++i){
            if(yearsOfService[i]>5){
                arr[i][0] = (int)((double)salary[i]*0.05);
                arr[i][1] = arr[i][0] + salary[i];
            }else{
                arr[i][0] = (int)((double)salary[i]*0.02);
                arr[i][1] = arr[i][0] + salary[i];
            }
        }
        return arr;
    }
    void printData(int[][] newData, int[] oldSalary){
        int totalOldSalary=0, totalNewSalary=0, totalBonus=0;
        for(int i = 0;i<10;++i){
            totalBonus+=newData[i][0];
            totalNewSalary+=newData[i][1];
            totalOldSalary += oldSalary[i];
        }
        System.out.println("old Salary\tnew Salary\ttotal bonus");
        System.out.printf("%10d\t%10d\t%11d",totalOldSalary,totalNewSalary,totalBonus);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] salary = new int[10];
        int[] yearOfService = new int[10];
        CalcBonusZara obj = new CalcBonusZara();
        obj.randomSalary(salary);
        obj.randomYearOfService(yearOfService);
        int[][] newData =obj.calcBonus(salary,yearOfService);
        obj.printData(newData,salary);
        scanner.close();
    }
}
