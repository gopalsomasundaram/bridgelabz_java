package methods.Level3;

import java.util.Scanner;
import java.lang.Math;
/*
 * This class checks if three points are collinear and calculates the
 * area of the triangle formed by them using coordinate geometry. for
 * collinear points the area will also be 0
 */
public class CollinearAndTriangleArea {
    // Logic: If Slope(AB) == Slope(BC) == Slope(AC), points are collinear.
    boolean isCollinear(int x1,int y1,int x2, int y2, int x3, int y3){
        // Slope formula: (y2 - y1) / (x2 - x1)
        double ab = ((double)y2-(double)y1)/((double)x2-(double)x1);
        double bc = ((double)y3-(double)y2)/((double)x3-(double)x2);
        double ac = ((double)y3-(double)y1)/((double)x3-(double)x1);
        // If slopes are equal, the points are collinear
        if((int) ab == (int) bc && (int) bc == (int) ac){
            return true;
        }else{
            return false;
        }
    }
    double calcAreaTriangle(int x1,int y1,int x2, int y2, int x3, int y3){
        // Formula: 0.5 * |x1(y2-y3) + x2(y3-y1) + x3(y1-y2)|
        return (0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
    }
    public static void main(String[ ] args){
        Scanner scanner = new Scanner(System.in);
        int x1,x2,x3,y1,y2,y3;
        // Gathering input for 3 points (x, y)
        System.out.println("Enter point x1");
        x1 = scanner.nextInt();
        System.out.println("Enter point y1");
        y1 = scanner.nextInt();
        System.out.println("Enter point x2");
        x2 = scanner.nextInt();
        System.out.println("Enter point y2");
        y2 = scanner.nextInt();
        System.out.println("Enter point x3");
        x3 = scanner.nextInt();
        System.out.println("Enter point y3");
        y3 = scanner.nextInt();
        CollinearAndTriangleArea obj = new CollinearAndTriangleArea();

        // Check and Display Collinearity
        if(obj.isCollinear(x1,y1,x2,y2,x3,y3)){
            System.out.println("The given points are collinear");
        }

        // Calculate and Display Area
        System.out.println("Area of triangle "+Math.abs(obj.calcAreaTriangle(x1,y1,x2,y2,x3,y3)));
        scanner.close();
    }
}
