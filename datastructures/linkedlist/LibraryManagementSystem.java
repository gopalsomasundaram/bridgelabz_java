package LinkedList;

/*
this class defines the individual nodes used in the linked list
it contains the required data members title, author, genre,
bookId, and isAvailable. it also contains references to the next and
the previous nodes.
*/
class BookNode {
    //method attributes storing relevant data
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    //references to the next and the previous node
    BookNode next, prev;

    //parameterized constructor
    BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

/*
this class contains and implements the main functions of the linked
list. it uses the node class to allow for storage of book data and
manipulates references to both head and tail for bidirectional traversal.
it includes methods for adding, removing, searching, and updating nodes.
*/
class LibraryList {
    //attributes for head and tail of the doubly linked list
    private BookNode head;
    private BookNode tail;

    //method to add node to the start of the linked list
    void addAtStart(String title, String author, String genre, int bookId, boolean isAvailable) {
        //creating new node
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        //handling case where list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //method to add node to the end of the linked list
    void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        //creating new node
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        //handling case where list is empty
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //method to add node at a particular position
    void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        //case where position is invalid
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        //case where position is head
        if (position == 1) {
            addAtStart(title, author, genre, bookId, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode temp = head;
        int count = 1;

        //traverse the list until node before the given position
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        //if temp is null, the position is out of bounds
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        //if temp is at the tail, use addAtEnd logic
        if (temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }

        //linking the new node between temp and temp.next
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    //method to remove a book record by book ID
    void removeByBookId(int bookId) {
        //handle case where list is empty
        if (head == null) return;

        BookNode temp = head;
        //traverse until book ID is found
        while (temp != null) {
            if (temp.bookId == bookId) {
                //handling removal if node is head
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                }
                //handling removal if node is tail
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                //handling removal if node is in middle
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID " + bookId + " not found.");
    }

    //method to search for a book by title
    void searchByTitle(String title) {
        BookNode temp = head;
        //traverse and compare titles ignoring case
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    //method to search for books by author
    void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        //traverse and print all books by the given author
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    //method to update availability status of a book
    void updateAvailability(int bookId, boolean status) {
        BookNode temp = head;
        //traverse to find node with target ID
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    //method to count the total number of books in the list
    int countBooks() {
        int count = 0;
        BookNode temp = head;
        //traverse entire list and increment count
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //method to print all movie records in forward order
    void displayForward() {
        System.out.println("Displaying Forward:");
        BookNode temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    //method to print all movie records in reverse order
    void displayReverse() {
        System.out.println("Displaying Reverse:");
        BookNode temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    //helper method to print details of a single book node
    private void printBook(BookNode book) {
        System.out.println("ID: " + book.bookId + " | Title: " + book.title + " | Author: " + book.author +
                " | Genre: " + book.genre + " | Status: " + (book.isAvailable ? "Available" : "Borrowed"));
    }
}

/*
this class implements the main function of the file. it creates an
object of LibraryList and performs addition, removal, searching,
and updates to simulate a library management system.
*/
public class LibraryManagementSystem {
    public static void main(String[] args){
        //object creation
        LibraryList obj = new LibraryList();

        //adding objects to the linked list
        obj.addAtStart("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", "Historical Fiction", 1, true);
        obj.addAtStart("The Night Circus", "Erin Morgensten", "Fantasy", 2, true);
        obj.addAtStart("Where the Crawdads sing", "Delia Owens", "Mystery", 3, false);
        obj.addAtEnd("Dark Matter", "Blake Crouch", "Historical Fiction", 4, true);
        obj.addAtPosition("The Martian", "Andy weir", "science fiction", 5, false, 2);

        //removing a book record by ID
        obj.removeByBookId(1);

        //searching for records by author or title
        obj.searchByAuthor("Blake Crouch");
        obj.searchByTitle("Dark Matter");

        //updating availability status
        obj.updateAvailability(3, true);

        //printing all records in both directions
        obj.displayForward();
        obj.displayReverse();

        //displaying the total book count
        System.out.println("Total number of books = " + obj.countBooks());
    }
}