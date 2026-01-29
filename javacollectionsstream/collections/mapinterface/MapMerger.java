/**
 * This program merges two maps. If a key exists in both maps,
 * the values are summed together using the Map merge method.
 *
 * @author gopal
 */
package collections.mapinterface;


import java.util.HashMap;
import java.util.Map;

public class MapMerger {

    /**
     * Merges two maps and sums values for overlapping keys.
     *
     * @param map1 The first map.
     * @param map2 The second map.
     * @return A new map containing merged data.
     */
    public static Map<String, Integer> mergeAndSum(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);

        // Merge map2 into result; if key exists, add the old and new values
        map2.forEach((key, value) ->
                result.merge(key, value, Integer::sum)
        );

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A", 1); m1.put("B", 2);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("B", 3); m2.put("C", 4);

        System.out.println("Merged Map: " + mergeAndSum(m1, m2));
    }
}