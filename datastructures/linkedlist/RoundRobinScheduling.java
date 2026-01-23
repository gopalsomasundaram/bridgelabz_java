package linkedlist;

/*
this class defines the individual nodes used in the circular linked list
to represent a process. it contains data members for processId, burstTime,
remainingTime, priority, and various timing metrics. it also contains a
reference to the next node to maintain the circular structure.
*/
class ProcessNode {
    //attributes storing process data and timing metrics
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int arrivalTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;
    //reference to the next process in the circle
    ProcessNode next;

    //parameterized constructor to initialize process details
    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

/*
this class contains and implements the core logic for the Round Robin
scheduling algorithm. it uses a circular linked list to manage the
process queue, allowing for cyclic execution based on a time quantum
and calculating performance statistics for the scheduled processes.
*/
class RoundRobinProcessing {
    //attributes for head, tail, and size of the circular queue
    private ProcessNode head = null;
    private ProcessNode tail = null;
    private int size = 0;

    //method to add a new process to the end of the circular list
    void addProcess(int processId, int burstTime, int priority) {
        //creating new process node
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        //handling case where queue is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; //maintaining circular reference
        }
        size++;
    }

    //method to remove a process by its ID after execution
    void removeProcess(int processId) {
        //handle case where queue is empty
        if (head == null) return;

        ProcessNode curr = head, prev = tail;
        do {
            //search for the target process ID
            if (curr.processId == processId) {
                //handling removal if it is the only node
                if (size == 1) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    //method to simulate scheduling with a fixed time quantum
    void simulate(int timeQuantum) {
        //handle case where no processes exist
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int completedProcesses = 0;
        int totalProcesses = size;
        ProcessNode current = head;

        System.out.println("Starting Round Robin Scheduling (Quantum: " + timeQuantum + ")");

        //loop until all processes in the circle are finished
        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > 0) {
                //calculating execution time based on quantum
                int executeTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= executeTime;
                currentTime += executeTime;

                System.out.println("T=" + currentTime + " | Process P" + current.processId +
                        " executes for " + executeTime + "ms. Remaining: " + current.remainingTime);

                //calculating metrics if process finishes
                if (current.remainingTime == 0) {
                    current.completionTime = currentTime;
                    current.turnAroundTime = current.completionTime;
                    current.waitingTime = current.turnAroundTime - current.burstTime;
                    completedProcesses++;
                    System.out.println(">>> P" + current.processId + " Finished.");
                }
            }
            displayQueue();
            current = current.next; //moving to the next process in the circle
        }
        displayStats(totalProcesses);
    }

    //method to print the processes currently in the queue
    void displayQueue() {
        if (head == null) return;
        System.out.print("Current Queue State: ");
        ProcessNode temp = head;
        do {
            if (temp.remainingTime > 0) {
                System.out.print("[P" + temp.processId + ":" + temp.remainingTime + "] -> ");
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }

    //method to calculate and display average waiting and turnaround times
    void displayStats(int totalProcesses) {
        float totalWT = 0, totalTAT = 0;
        ProcessNode temp = head;
        System.out.println("\n--- Final Scheduling Statistics ---");
        System.out.println("PID\tBurst\tCompletion\tTAT\tWT");

        //iterating through the circular list to aggregate data
        for (int i = 0; i < totalProcesses; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%d\n", temp.processId, temp.burstTime,
                    temp.completionTime, temp.turnAroundTime, temp.waitingTime);
            totalWT += temp.waitingTime;
            totalTAT += temp.turnAroundTime;
            temp = temp.next;
        }

        //displaying final averages
        System.out.println("\nAverage Waiting Time: " + (totalWT / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTAT / totalProcesses));
    }
}

/*
this class implements the main function to demonstrate the scheduler.
it creates a RoundRobinProcessing object, populates it with processes,
and triggers the simulation with a defined time quantum.
*/
public class RoundRobinScheduling {
    public static void main(String[] args) {
        //object creation
        RoundRobinProcessing obj = new RoundRobinProcessing();

        //adding processes with ID, burst time, and priority
        obj.addProcess(1, 1, 3);
        obj.addProcess(2, 2, 2);
        obj.addProcess(3, 3, 1);

        //starting the scheduling simulation with a quantum of 1
        obj.simulate(1);
    }
}