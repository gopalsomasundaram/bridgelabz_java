package ClassAndObject.Level2;

public class MovieTicket {
    String movieName = "Inception";
    int seatNumber;
    int price;

    void bookTicket(int seat, int ticketPrice) {
        seatNumber = seat;
        price = ticketPrice;
        System.out.println("Ticket Booked Successfully");
    }

    void displayTicket() {
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Ticket Price : " + price);
    }

    public static void main(String[] args) {
        MovieTicket obj = new MovieTicket();

        obj.bookTicket(25, 300);
        obj.displayTicket();
    }
}
