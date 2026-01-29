/**
 * This program reverses the elements of a Queue. Since a Queue is
 * FIFO (First-In-First-Out) and a Stack is LIFO (Last-In-First-Out),
 * we use a Stack as an intermediate container to flip the order.
 *
 * @author gopal
 */
package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    /**
     * Reverses the given queue using a stack.
     *
     * @param queue The queue to be reversed.
     * @return The same queue instance with elements in reverse order.
     */
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Move all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Move all elements back from stack to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Original: [10, 20, 30]");
        System.out.println("Reversed: " + reverse(q));
    }
}