package stringbuilderlinearbinary;

/*
this class searches for a target value in a 2D matrix where rows
and columns are sorted. it treats the matrix as a virtual 1D
array to perform binary search in $O(\log(M \times N))$ time.
*/
public class MatrixSearcher {

    //method to search target in a 2D sorted matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        //virtual 1D binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //convert 1D index back to 2D coordinates
            int midVal = matrix[mid / cols][mid % cols];

            if (midVal == target) return true;
            else if (midVal < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {15, 18, 20}
        };
        MatrixSearcher searcher = new MatrixSearcher();
        System.out.println("Target 10 found: " + searcher.searchMatrix(matrix, 10));
    }
}