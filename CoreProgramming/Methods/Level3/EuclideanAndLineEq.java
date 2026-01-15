package Methods.Level3;

import java.util.Scanner;
import java.lang.Math;
public class EuclideanAndLineEq {
    int calcDistance(int x1,int y1,int x2, int y2){
        return ((int)Math.sqrt((int)(Math.pow((x2-x1),2))+(int)(Math.pow((y2-y1),2))));
    }
    int[] getLineEquation(int x1,int y1,int x2, int y2){
        int[] arr = new int[2];
        double m = ((double)y2-(double)y1)/((double)x2-(double)x1);
        double b = (double)y1 - m * (double)x1;
        arr[0] = (int)m;
        arr[1] = (int)b;
        return arr;
    }
    public static void main(String[ ] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter point x1: ");
        int x1 = scanner.nextInt();
        System.out.println("Enter point y1: ");
        int y1 = scanner.nextInt();
        System.out.println("Enter point x2: ");
        int x2 = scanner.nextInt();
        System.out.println("Enter point y2: ");
        int y2 = scanner.nextInt();
        EuclideanAndLineEq obj = new EuclideanAndLineEq();
        System.out.println("The distance between given two points is: "+obj.calcDistance(x1,y1,x2,y2));
        int[] arr = obj.getLineEquation(x1,y1,x2,y2);
        System.out.printf("y = %d * x + %d",arr[0],arr[1]);
        scanner.close();
    }
}
