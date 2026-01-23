package sorting;

/*
this class implements the counting sort algorithm to organize student
ages in ascending order. counting sort is a non-comparison based
sorting algorithm that works in $O(N + K)$ time, where K is the range
of the input. it works by counting the occurrences of each unique
value and using those counts to determine the correct position of
each element in the output array.
*/
public class StudentAgeSorter {

    //method to perform counting sort on an array of ages
    public void sortByAge(int[] ages) {
        int n = ages.length;

        //given range is 10 to 18
        int min = 10;
        int max = 18;
        int range = max - min + 1;

        //step 1: create a count array to store frequency of each age
        int[] count = new int[range];
        int[] output = new int[n];

        //storing the count of each age
        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }

        //step 2: modify the count array to store cumulative counts
        //this indicates the actual position of the age in the output array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        //step 3: build the output array by placing ages in correct positions
        //traversing backwards to maintain stability of the sort
        for (int i = n - 1; i >= 0; i--) {
            int age = ages[i];
            int position = count[age - min] - 1;
            output[position] = age;
            count[age - min]--;
        }

        //step 4: copy the sorted output array back to the original ages array
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    //helper method to print the array of student ages
    public void printAges(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    /*
    this main method implements the entry point for the program. it
    initializes an array of student ages (within the range 10-18),
    creates an instance of StudentAgeSorter, and demonstrates the
    counting sort functionality.
    */
    public static void main(String[] args) {
        //initializing an unsorted array of student ages
        int[] studentAges = {15, 12, 18, 10, 15, 14, 12, 11, 17, 13};

        //object creation
        StudentAgeSorter sorter = new StudentAgeSorter();

        System.out.println("Student ages before sorting:");
        sorter.printAges(studentAges);

        //calling the counting sort method
        sorter.sortByAge(studentAges);

        System.out.println("Student ages after sorting (Ascending):");
        sorter.printAges(studentAges);
    }
}