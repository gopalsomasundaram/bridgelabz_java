package linkedlist;

/*
this class defines the individual nodes used in the circular linked list
to represent a booked ticket. it contains data members for ticketId,
customerName, movieName, seatNumber, and bookingTime. it also contains
a reference to the next node to maintain the circular chain.
*/
class TicketNode {
    //method attributes storing relevant ticket data
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    //reference to the next ticket in the circular queue
    TicketNode next;

    //parameterized constructor
    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

/*
this class contains and implements the main functions of the ticket
reservation system. it uses a circular linked list where the tail
points back to the head. it maintains head and tail pointers to
allow for efficient additions at the end and ticket removals.
*/
class TicketReservationSystem {
    //attributes for head and tail of the circular list
    private TicketNode head = null;
    private TicketNode tail = null;

    //1. method to add a new ticket reservation at the end of the circular list
    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        //creating new ticket node
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        //handling case where circular list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    //2. method to remove a ticket reservation by Ticket ID
    void removeTicket(int ticketId) {
        //handle case where system is empty
        if (head == null) {
            System.out.println("System is empty. No tickets to remove.");
            return;
        }

        TicketNode curr = head, prev = tail;
        //traverse the circular list until the matching ID is found
        do {
            if (curr.ticketId == ticketId) {
                //handling removal if list contains only one node
                if (head == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                System.out.println("Ticket ID " + ticketId + " removed successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    //3. method to display all currently booked tickets in the system
    void displayTickets() {
        //handle empty list case
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        System.out.println("\n--- Current Booked Tickets ---");
        //traversing the circle once and printing details for each ticket
        do {
            System.out.println("ID: " + temp.ticketId + " | Customer: " + temp.customerName +
                    " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber);
            temp = temp.next;
        } while (temp != head);
    }

    //4. method to search for a ticket by Customer Name or Movie Name
    void searchTicket(String query) {
        //check if list is empty
        if (head == null) return;
        TicketNode temp = head;
        boolean found = false;
        //loop through the circular list to find all matching queries
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found: ID " + temp.ticketId + ", Seat " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tickets found for: " + query);
    }

    //5. method to calculate the total number of booked tickets in the list
    int getTotalTickets() {
        //handle empty system
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        //iterating once through the circle to count total nodes
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

/*
this class implements the main function for the ticket system. it
creates a TicketReservationSystem object and performs addition,
removal, and search operations to simulate a real booking environment.
*/
public class TicketSystem {
    public static void main(String[] args) {
        //object creation
        TicketReservationSystem system = new TicketReservationSystem();

        //1. adding ticket reservations to the system
        system.addTicket(1001, "Alice", "Avatar", "A1", "10:00 AM");
        system.addTicket(1002, "Bob", "Inception", "B5", "12:30 PM");
        system.addTicket(1003, "Charlie", "Avatar", "A2", "10:00 AM");

        //3. displaying initial ticket list
        system.displayTickets();

        //5. calculating total booked tickets
        System.out.println("\nTotal Booked: " + system.getTotalTickets());

        //4. searching for a specific movie or customer
        System.out.println("\nSearching for 'Avatar':");
        system.searchTicket("Avatar");

        //2. removing a reservation by its unique ID
        system.removeTicket(1002);

        //final display to show updated list status
        system.displayTickets();
    }
}