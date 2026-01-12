package Arrays.Level2;

import java.util.Scanner;
public class Marks2D {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();
        float[][] arr = new float[n][3];
        for(int i =0;i<n;++i){
            System.out.printf("Enter the physics marks of student at index %d: ",i);
            arr[i][0] = scanner.nextFloat();
            System.out.printf("Enter the chemistry marks of student at index %d: ",i);
            arr[i][1] = scanner.nextFloat();
            System.out.printf("Enter the math marks of student at index %d: ",i);
            arr[i][2] = scanner.nextFloat();
            if(arr[i][0] < 0 || arr[i][1] < 0 || arr[i][2] < 0){
                System.out.println("Invalid Input, enter again");
                i--;
            }
        }
        float[] percentage = new float[n];
        char[] grade = new char[n];
        for(int i = 0;i<n;++i) {
            percentage[i] = ((arr[i][0] + arr[i][1] + arr[i][2]) / 3);
            if (percentage[i] >= 80.0f) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70.0f) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60.0f) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50.0f) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40.0f) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
            System.out.printf("Student at index %d has percentage %.1f and Grade: %c",i,percentage[i],grade[i]);
        }
    }
}
