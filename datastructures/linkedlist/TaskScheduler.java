package linkedlist;

import java.util.Scanner;

/*
this class defines the individual nodes used in the circular linked list
to represent a task. it contains data members for taskId, taskName,
priority, and dueDate. it also contains a reference to the next node
which helps maintain the circular link.
*/
class TaskNode {
    //method attributes storing relevant task data
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    //reference to the next node in the circular list
    TaskNode next;

    //parameterized constructor
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

/*
this class contains and implements the main functions of the circular
linked list. it manages task nodes by ensuring the last node always
points back to the head. it includes methods for adding at different
positions, removing by ID, searching, and interactive traversal.
*/
class TaskList {
    //attribute (head of circular linked list default value null)
    private TaskNode head;

    //constructor to initialize empty list
    TaskList() {
        head = null;
    }

    //method to add a node to the start of the circular list
    void addAtStart(int taskId, String taskName, int priority, String dueDate) {
        //creating new node
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        //handling case where list is empty
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }
        //traversing to the last node to update its next pointer
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    //method to add a node to the end of the circular list
    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        //if list is empty use addAtStart logic
        if (head == null) {
            addAtStart(taskId, taskName, priority, dueDate);
            return;
        }
        //traversing to the end to append the new node
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    //method to add a node at a particular position
    void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        //case where list is empty
        if (head == null) {
            System.out.println("list is empty, adding node as head");
            addAtStart(taskId, taskName, priority, dueDate);
            return;
        }
        //validate position input
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        //case where position is head
        if (position == 1) {
            addAtStart(taskId, taskName, priority, dueDate);
            return;
        }

        int count = 1;
        TaskNode temp = head;
        //traverse until node preceding the target position
        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }
        //check if position is reachable
        if (count < position - 1) {
            System.out.println("Error: Position out of bounds.");
            return;
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //method to remove a task node using its ID
    void removeByTaskId(int taskId) {
        //handle case where list is empty
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }

        TaskNode temp = head;
        //case where head node needs to be removed
        if (head.taskId == taskId) {
            //handle single node list
            if (head.next == head) {
                head = null;
                return;
            }
            //finding tail to update its next pointer to the new head
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
            return;
        }

        //traverse to find the node preceding the target ID
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        //perform deletion if ID exists in list
        if (temp.next == head) {
            System.out.println("The task id is not present");
            return;
        }
        temp.next = temp.next.next;
    }

    //method for interactive step-by-step traversal
    void viewTasksAndMove() {
        if (head == null) {
            System.out.println("There are no nodes in the list");
            return;
        }
        System.out.println("press enter to go to the next task");
        Scanner scanner = new Scanner(System.in);
        TaskNode temp = head;
        int count = 1;

        //iterate until the last node is reached
        while (temp.next != head) {
            System.out.println("Task No: " + count + "; Task name: " + temp.taskName);
            scanner.nextLine();
            count++;
            temp = temp.next;
        }
        //displaying the final node in the circular queue
        System.out.println("this is the last Task node in the linked list");
        System.out.println("Task No: " + count + "; Task name: " + temp.taskName);
    }

    //method to search and print nodes with specific priority
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
        TaskNode temp = head;
        //traversing the circular list to find all matches
        do {
            if (temp.priority == priority) {
                printNode(temp);
            }
            temp = temp.next;
        } while (temp != head);
    }

    //helper method to print details of a single task node
    void printNode(TaskNode node) {
        System.out.println("Task ID: " + node.taskId);
        System.out.println("Task Name: " + node.taskName);
        System.out.println("priority: " + node.priority);
        System.out.println("Due Date: " + node.dueDate);
        System.out.println("------------------------");
    }

    //method to print all nodes currently in the list
    void printLinkedList() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        TaskNode temp = head;
        //looping through the circle once
        do {
            printNode(temp);
            temp = temp.next;
        } while (temp != head);
    }
}

/*
this class implements the main function of the task scheduler. it
creates a TaskList object and performs addition, removal, and
search operations to demonstrate circular linked list functionality.
*/
public class TaskScheduler {
    public static void main(String[] args) {
        //object creation
        TaskList obj = new TaskList();

        //populating the scheduler with tasks
        obj.addAtStart(1, "run 1", 9, "12-01-2026");
        obj.addAtEnd(2, "run 2", 8, "13-01-2026");
        obj.addAtEnd(3, "run 3", 7, "14-01-2026");
        obj.addAtPosition(4, "run 4", 6, "15-01-2026", 2);

        //performing removal and search operations
        obj.removeByTaskId(4);
        obj.printLinkedList();
        obj.searchByPriority(7);
    }
}