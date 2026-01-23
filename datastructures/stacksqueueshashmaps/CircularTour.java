package stacksqueueshashmaps;

/*
this class solves the circular tour problem to find the starting
petrol pump that allows a truck to complete a full circuit.
it uses a greedy approach to track balance and deficiency in $O(N)$.
*/
public class CircularTour {

    //method to find the index of the starting petrol pump
    public int findStart(int[] petrol, int[] distance) {
        int start = 0;
        int deficiency = 0;
        int balance = 0;

        //iterate through each pump
        for (int i = 0; i < petrol.length; i++) {
            balance += (petrol[i] - distance[i]);
            //if balance is negative, reset start point
            if (balance < 0) {
                deficiency += balance;
                start = i + 1;
                balance = 0;
            }
        }

        //if total petrol is sufficient for total distance, return start
        return (balance + deficiency >= 0) ? start : -1;
    }

    //main function to test circular tour logic
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        CircularTour obj = new CircularTour();
        int startNode = obj.findStart(petrol, distance);

        if (startNode == -1) System.out.println("No circular tour possible.");
        else System.out.println("Start at petrol pump index: " + startNode);
    }
}