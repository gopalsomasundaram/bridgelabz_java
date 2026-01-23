package stacksqueueshashmaps;

import java.util.Stack;

/*
this class provides a recursive solution to sort a stack in ascending
order. it uses the call stack to hold elements and a helper method
to insert elements back into their correct sorted position.
*/
public class RecursiveStackSort {

    //method to initiate recursive sorting
    public void sort(Stack<Integer> s) {
        //base case: empty stack is sorted
        if (s.isEmpty()) return;

        //remove top element
        int temp = s.pop();
        //sort remaining stack
        sort(s);
        //insert the removed element back in order
        sortedInsert(s, temp);
    }

    //helper method to insert element into sorted stack
    private void sortedInsert(Stack<Integer> s, int x) {
        //if stack is empty or x is greater than top, push x
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        //otherwise, pop top and recurse
        int temp = s.pop();
        sortedInsert(s, x);
        //push back the popped element
        s.push(temp);
    }

    //main function to test recursive sorting
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);

        RecursiveStackSort sorter = new RecursiveStackSort();
        sorter.sort(s);

        //displaying sorted stack
        System.out.println("Sorted Stack: " + s);
    }
}