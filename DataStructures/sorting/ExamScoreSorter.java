package sorting;


/*
this class implements the selection sort algorithm to organize exam
scores in ascending order. selection sort works by repeatedly
identifying the minimum element from the unsorted part of the array
and placing it at the beginning. it maintains two subarrays: the
part which is already sorted and the remaining unsorted part.
*/
public class ExamScoreSorter {

    //method to perform selection sort on an array of scores
    public void sortByScore(int[] scores) {
        int n = scores.length;

        //one by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            //assume the current position is the minimum
            int minIndex = i;

            //iterate through the unsorted part to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            //swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    //helper method to print the array of scores
    public void printScores(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    /*
    this main method implements the entry point for the program. it
    initializes an array of student exam scores, creates an instance
    of ExamScoreSorter, and demonstrates the sorting functionality.
    */
    public static void main(String[] args) {
        //initializing an unsorted array of exam scores
        int[] scores = {78, 92, 45, 88, 61, 99, 53};

        //object creation
        ExamScoreSorter sorter = new ExamScoreSorter();

        System.out.println("Exam scores before sorting:");
        sorter.printScores(scores);

        //calling the selection sort method
        sorter.sortByScore(scores);

        System.out.println("Exam scores after sorting (Ascending):");
        sorter.printScores(scores);
    }
}