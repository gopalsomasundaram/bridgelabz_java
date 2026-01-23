package stacksqueueshashmaps;

import java.util.HashSet;

/*
this class calculates the length of the longest sequence of
consecutive integers in an unsorted array. it uses a hash set
for fast lookups and ensures each element is processed only
twice, resulting in $O(N)$ performance.
*/
public class LongestSequence {

    //method to find the length of the longest consecutive sequence
    public int findLongest(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        //populate set with all array elements
        for (int num : arr) set.add(num);

        int longest = 0;

        for (int num : arr) {
            //check if num is the start of a sequence (no num-1 exists)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                //count consecutive elements following currentNum
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                //update maximum streak found
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    //main function to test longest sequence logic
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        LongestSequence obj = new LongestSequence();
        System.out.println("Length of longest consecutive sequence: " + obj.findLongest(arr));
    }
}
