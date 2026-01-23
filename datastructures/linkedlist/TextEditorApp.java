package LinkedList;

/*
this class defines the individual nodes used in the doubly linked list
it contains the string attribute content to store the text state
at a specific point in time. it also contains references to the next
and the previous nodes to represent redo and undo paths.
*/
class TextStateNode {
    //method attributes storing the text content
    String content;
    //references to the next (redo) and the previous (undo) state
    TextStateNode next, prev;

    //parameterized constructor
    TextStateNode(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

/*
this class contains and implements the main functions of the undo/redo
system. it manages the current state of the editor and maintains a
history of up to 10 states. it allows for adding new states, reverting
to previous ones, and moving forward again.
*/
class TextEditorHistory {
    //attributes for head, current position, and history size
    private TextStateNode head;
    private TextStateNode currentState;
    private int size;
    private final int MAX_SIZE = 10;

    //constructor to initialize the editor history
    TextEditorHistory() {
        this.head = null;
        this.currentState = null;
        this.size = 0;
    }

    //method to add a new text state to the history
    void addState(String content) {
        //creating new state node
        TextStateNode newNode = new TextStateNode(content);

        //if we are in the middle of history, clear forward redo path
        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
        } else {
            head = newNode;
        }

        //update current state pointer and increment size
        currentState = newNode;
        size++;

        //handle case where history exceeds the fixed limit of 10
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    //method to revert to the previous text state
    void undo() {
        //check if an undo operation is possible
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    //method to move forward to the next text state
    void redo() {
        //check if a redo operation is possible
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    //method to display the current text in the editor
    void displayCurrentState() {
        //handle case where editor is empty
        if (currentState == null) {
            System.out.println("Editor is currently empty.");
            return;
        }
        System.out.println("Current Text: " + currentState.content);
        System.out.println("----------------------------");
    }
}

/*
This class implements the main function to simulate a text editor.
It creates an object of TextEditorHistory and performs typing,
undoing, and redoing operations to demonstrate the history management.
*/
public class TextEditorApp {
    public static void main(String[] args) {
        //object creation
        TextEditorHistory editor = new TextEditorHistory();

        //simulating typing by adding states
        editor.addState("H");
        editor.addState("He");
        editor.addState("Hel");
        editor.addState("Hello");

        //display current content
        editor.displayCurrentState();

        //performing undo operations
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        //performing redo operation
        editor.redo();
        editor.displayCurrentState();

        //adding new state after undo clears the forward history
        editor.addState("Hello World");
        editor.displayCurrentState();

        //checking redo after a fresh action
        editor.redo();
    }
}