/**
 * This program identifies the key associated with the maximum value
 * in a Map. It iterates through the entry set to track the largest value found.
 *
 * @author gopal
 */
package collections.mapinterface;


import java.util.HashMap;
import java.util.Map;

public class MaxValueKey {

    /**
     * Finds the key with the highest integer value.
     *
     * @param map The map to search.
     * @return The key with the maximum value, or null if map is empty.
     */
    public static String findMaxKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 10);
        input.put("B", 20);
        input.put("C", 15);

        System.out.println("Map: " + input);
        System.out.println("Key with highest value: " + findMaxKey(input));
    }
}