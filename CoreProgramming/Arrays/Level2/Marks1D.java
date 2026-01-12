package Arrays.Level2;

import java.util.Scanner;
public class Marks1D {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();
        float[] physics = new float[n];
        float[] chemistry = new float[n];
        float[] math = new float[n];
        float[] percentage = new float[n];
        char[] grade = new char[n];
        for(int i =0;i<n;++i){
            System.out.printf("Enter the physics marks of student at index %d: ",i);
            physics[i] = scanner.nextFloat();
            System.out.printf("Enter the chemistry marks of student at index %d: ",i);
            chemistry[i] = scanner.nextFloat();
            System.out.printf("Enter the math marks of student at index %d: ",i);
            math[i] = scanner.nextFloat();
            if(chemistry[i] < 0 || math[i] < 0 || physics[i] < 0){
                System.out.println("Invalid Input, enter again");
                i--;
            }
        }
        for(int i = 0;i<n;++i) {
            percentage[i] = ((physics[i] + chemistry[i] + math[i]) / 3);
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
