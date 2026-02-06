/**
 * This Program demonstrates the BiFunction interface which accepts
 * two inputs to produce a single result.
 * * @author gopal
 */
package functional;

import java.util.function.BiFunction;

public class BiFunctionConcatenation {
    public static void main(String[] args) {
        // BiFunction<T, U, R>: takes two Strings, returns a concatenated String
        BiFunction<String, String, String> concatWithSpace = (s1, s2) -> s1 + " " + s2;

        String result = concatWithSpace.apply("Functional", "Programming");
        System.out.println("Concatenated String: " + result);
    }
}