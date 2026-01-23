package stringbuilderlinearbinary;

/*
this class finds the starting and ending indices of a target
element in a sorted array using two variations of binary search.
this is useful for finding the range of a value in $O(\log N)$.
*/
public class RangeFinder {

    //helper method to perform binary search for a specific boundary
    private int findBound(int[] arr, int target, boolean isFirst) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                //if finding first, look left; if finding last, look right
                if (isFirst) right = mid - 1;
                else left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public void findRange(int[] arr, int target) {
        int first = findBound(arr, target, true);
        int last = findBound(arr, target, false);
        System.out.println("First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        new RangeFinder().findRange(arr, 2);
    }
}