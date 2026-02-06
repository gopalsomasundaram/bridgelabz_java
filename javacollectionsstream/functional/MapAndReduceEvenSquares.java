/**
 * This Program demonstrates the Map-Reduce pattern to calculate
 * the sum of squares for filtered integers.
 * * @author gopal
 */
package functional;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceEvenSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Stream pipeline:
        // 1. filter: keep even numbers only
        // 2. map: transform each number into its square
        // 3. reduce: combine squares into a single sum starting from 0
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}