package stacksqueueshashmaps;

import java.util.Stack;

/*
this class implements a queue data structure using two stacks.
it follows the FIFO (First In, First Out) principle by utilizing
one stack for pushing elements and another for popping elements,
transferring data between them only when necessary.
*/
class QueueUsingStacks {
    //attributes representing the two stacks used for queue operations
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    //constructor to initialize the two stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //method to add an element to the back of the queue
    public void enqueue(int data) {
        //always push new elements onto stack1
        stack1.push(data);
    }

    //method to remove and return the element from the front of the queue
    public int dequeue() {
        //if stack2 is empty, transfer everything from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        //handle case where both stacks are empty
        if (stack2.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        //return the top element of stack2 (front of queue)
        return stack2.pop();
    }
    //main function to demonstrate queue operations
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        //adding elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        //removing and printing elements
        System.out.println(q.dequeue()); // Output: 10
        System.out.println(q.dequeue()); // Output: 20
    }
}