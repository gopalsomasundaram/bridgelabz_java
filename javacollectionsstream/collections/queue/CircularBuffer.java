/**
 * This program implements a fixed-size Circular Buffer using an array.
 * When the buffer is full, new elements overwrite the oldest ones.
 *
 * @author gopal
 */
package collections.queue;

import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
    }

    /**
     * Inserts an element into the buffer. Overwrites oldest if full.
     * @param val The value to insert.
     */
    public void insert(int val) {
        buffer[tail] = val;

        if (count == size) {
            // Buffer is full, move head to overwrite oldest
            head = (head + 1) % size;
        } else {
            count++;
        }

        tail = (tail + 1) % size;
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(head + i) % size] + (i == count - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4); // Overwrites 1

        cb.display(); // Output: [2, 3, 4]
    }
}