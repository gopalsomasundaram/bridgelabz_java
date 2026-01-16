package methods.Level2;
import java.util.Scanner;
import java.lang.Math;
/*
 * This class solves quadratic equations using the formula:
 * x = (-b ± sqrt(b^2 - 4ac)) / 2a
 * It handles real, repeated, and imaginary roots using the discriminant.
 */
public class Quadratic {
    double[] getRoot(double a,double b,double c){
        // Delta (Discriminant) = b^2 - 4ac
        double delta = ((Math.pow(b,2))-4*a*c);
        // Case 1: Imaginary roots (Delta < 0)
        if(delta<0){
            return new double[]{ };
        }
        // Case 2: One real repeated root (Delta == 0)
        else if(delta == 0){
            //single root
            double x = ((-1)*b)/(2*a);
            return new double[] {x};
        }
        // Case 3: Two distinct real roots (Delta > 0)
        else{
            //2 roots
            double x1 = (((-1)*b+(Math.sqrt(delta)))/(2*a));
            double x2 = (((-1)*b-(Math.sqrt(delta)))/(2*a));
            return new double[] {x1,x2};
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of a:");
        double a = scanner.nextDouble();
        System.out.println("Enter the value of b:");
        double b = scanner.nextDouble();
        System.out.println("Enter the value of c:");
        double c = scanner.nextDouble();

        Quadratic obj = new Quadratic();
        double[] result = obj.getRoot(a,b,c);

        // Output based on the number of roots found
        if(result.length == 0){
            System.out.println("No roots");
        }else if(result.length == 1){
            System.out.println("1 root: "+result[0]);
        }else{
            System.out.println("2 roots "+result[0]+" and "+result[1]);
        }
        scanner.close();
    }
}
