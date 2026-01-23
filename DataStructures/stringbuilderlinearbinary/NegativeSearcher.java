package stringbuilderlinearbinary;

/*
this class performs a linear search on an integer array to locate
the first negative number. it checks each element sequentially
until the condition is met or the array ends.
*/
public class NegativeSearcher {

    //method to find index of first negative integer
    public int findFirstNegative(int[] arr) {
        //handle empty array
        if (arr == null) return -1;

        //iterate sequentially through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; //return index as soon as found
            }
        }
        return -1; //not found
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30, -5, 40, -10};
        NegativeSearcher searcher = new NegativeSearcher();
        System.out.println("First negative index: " + searcher.findFirstNegative(data));
    }
}