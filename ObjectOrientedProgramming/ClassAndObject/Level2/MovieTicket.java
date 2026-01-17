package ClassAndObject.Level2;
/*
 * This class models a Movie Ticket booking process.
 * It demonstrates how to assign values to instance variables
 * through a specific business logic method.
 */
public class MovieTicket {
    //Instance Variables
    String movieName = "Inception";
    int seatNumber;
    int price;
    // This method takes parameters and assigns them to the object's fields.
    void bookTicket(int seat, int ticketPrice) {
        seatNumber = seat;
        price = ticketPrice;
        System.out.println("Ticket Booked Successfully");
    }
    //Reporting method
    void displayTicket() {
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Ticket Price : " + price);
    }

    public static void main(String[] args) {
        //Instantiation
        MovieTicket obj = new MovieTicket();
        //Method Call
        obj.bookTicket(25, 300);
        obj.displayTicket();
    }
}
