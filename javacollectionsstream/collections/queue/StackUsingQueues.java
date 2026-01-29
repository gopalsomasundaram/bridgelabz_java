/**
 * This class implements Stack behavior (LIFO) using two Queues (FIFO).
 * The push operation is made costly to ensure the newest element is
 * always at the front of the primary queue.
 *
 * @author gopal
 */
package collections.queue;


import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    /**
     * Pushes an element onto the stack.
     * @param x The value to push.
     */
    public void push(int x) {
        // Add to empty q2
        q2.add(x);

        // Move everything from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap the names of the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop element: " + stack.pop()); // Output: 3
    }
}