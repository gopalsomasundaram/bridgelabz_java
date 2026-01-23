package stacksqueueshashmaps;

import java.util.HashMap;

/*
this class solves the two sum problem by returning the indices
of the two numbers that add up to a target sum. it uses a
hash map to store values and their indices for $O(1)$ lookup
as the array is iterated.
*/
public class TwoSumIndices {

    //method to find indices of the two sum pair
    public int[] findIndices(int[] nums, int target) {
        //map to store value and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //if complement exists in map, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            //otherwise, add current value and index to map
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    //main function to test two sum index retrieval
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSumIndices obj = new TwoSumIndices();
        int[] result = obj.findIndices(nums, target);

        if (result.length == 2) {
            System.out.println("Indices found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}