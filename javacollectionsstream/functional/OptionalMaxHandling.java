/**
 * This Program uses the Optional API to handle potential null or
 * empty results from a stream operation.
 * * @author gopal
 */
package functional;

import java.util.*;

public class OptionalMaxHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 22, 8, 91, 44);
        List<Integer> emptyList = new ArrayList<>();

        System.out.println("Processing numbers: " + findMax(numbers));
        System.out.println("Processing empty list: " + findMax(emptyList));
    }

    /**
     * Finds the maximum value in a list using Streams and Optional.
     */
    public static String findMax(List<Integer> list) {
        // max() returns an Optional<Integer> because the list might be empty
        Optional<Integer> maxVal = list.stream().max(Integer::compare);

        // orElse() provides a fallback value if the Optional is empty
        return maxVal.map(String::valueOf)
                .orElse("No value present (List is empty)");
    }
}