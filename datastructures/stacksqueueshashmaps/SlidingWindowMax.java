package stacksqueueshashmaps;

import java.util.Deque;
import java.util.LinkedList;

/*
this class finds the maximum value in every sliding window of size k.
it utilizes a deque (Double Ended Queue) to store indices of
useful elements, maintaining them in decreasing order of values.
*/
public class SlidingWindowMax {

    //method to find maximums in sliding windows
    public void findMax(int[] arr, int k) {
        int n = arr.length;
        //deque to store indices
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //remove indices that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            //remove indices of elements smaller than current element
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            //add current element index
            dq.offerLast(i);
            //print front of deque as max once window is fully formed
            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }

    //main function to test sliding window
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMax obj = new SlidingWindowMax();
        System.out.print("Window Maximums: ");
        obj.findMax(arr, k);
    }
}