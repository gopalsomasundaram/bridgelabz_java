package stringbuilderlinearbinary;

/*
this class finds the rotation point (the minimum element) in a
sorted array that has been rotated. it uses binary search to
achieve $O(\log N)$ time complexity.
*/
public class RotationPointFinder {

    //method to find the index of the smallest element
    public int findPivot(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        //binary search logic
        while (left < right) {
            int mid = left + (right - left) / 2;

            //if mid element is greater than right, pivot is on the right
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                //pivot is on the left including mid
                right = mid;
            }
        }
        return left; //index of rotation point
    }

    public static void main(String[] args) {
        int[] rotated = {4, 5, 6, 7, 1, 2, 3};
        RotationPointFinder finder = new RotationPointFinder();
        int index = finder.findPivot(rotated);
        System.out.println("Rotation point index: " + index + " (Value: " + rotated[index] + ")");
    }
}