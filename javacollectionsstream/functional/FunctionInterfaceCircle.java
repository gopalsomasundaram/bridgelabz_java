/**
 * This Program uses the Function interface to map a numeric input
 * to a calculated output.
 * * @author gopal
 */
package functional;

import java.util.function.Function;

public class FunctionInterfaceCircle {
    public static void main(String[] args) {
        // Function<Input, Output>: takes an Integer (radius), returns a Double (area)
        Function<Integer, Double> areaCalc = radius -> Math.PI * radius * radius;

        int r = 7;
        // apply() triggers the functional logic
        System.out.println("Area for radius " + r + " is: " + areaCalc.apply(r));
    }
}