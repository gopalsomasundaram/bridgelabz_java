/**
 * This program inverts a Map such that values become keys.
 * Since multiple original keys might share the same value,
 * the new map stores a List of keys for each value.
 *
 * @author gopal
 */
package collections.mapinterface;

import java.util.*;

public class MapInverter {

    /**
     * Inverts a map by grouping original keys under their corresponding values.
     *
     * @param source The original map to invert.
     * @return A new map where values point to lists of original keys.
     */
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> source) {
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            // Initialize the list if the value is seen for the first time
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        System.out.println("Original: " + input);
        System.out.println("Inverted: " + invertMap(input));
    }
}