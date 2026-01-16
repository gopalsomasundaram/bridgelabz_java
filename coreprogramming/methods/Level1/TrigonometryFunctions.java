package methods.Level1;
import java.lang.Math;
import java.util.Scanner;
/*
 * This class calculates the sine, cosine, and tangent of an angle.
 * It demonstrates:
 * 1. Converting degrees to radians.
 * 2. Returning multiple results via an array.
 * 3. Utilizing the java.lang.Math utility class.
 */
public class TrigonometryFunctions {
    public double[] calculateTrigonometricFunctions(double angle){
        // Converts to Radians = Degrees * (PI / 180)
        double rad = Math.toRadians(angle);
        double[] arr = new double[3];

        //Library Calls
        arr[0] = Math.sin(rad);
        arr[1] = Math.cos(rad);
        arr[2] = Math.tan(rad);
        return arr;
    }
    public static void main(String[ ] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the angle in degree: ");
        double angle = scanner.nextDouble();
        TrigonometryFunctions obj = new TrigonometryFunctions();
        double[] result = obj.calculateTrigonometricFunctions(angle);
        //Output the results
        System.out.println("sin of given: "+result[0]);
        System.out.println("cos of given: "+result[1]);
        System.out.println("tan of given: "+result[2]);
        scanner.close();
    }
}
