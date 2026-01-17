package ConstructorsAccessModifiers.Level1;
/*
 * This class demonstrates Constructor Overloading including a Copy Constructor.
 * A copy constructor allows you to initialize a new object using another object's data.
 */
public class HotelBooking {
    //Attributes
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String g, String r, int n) {
        guestName = g;
        roomType = r;
        nights = n;
    }

    // Copy constructor
    HotelBooking(HotelBooking hb) {
        guestName = hb.guestName;
        roomType = hb.roomType;
        nights = hb.nights;
    }

    void displayData() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
    }

    public static void main(String[] args) {
        // Standard creation
        HotelBooking b1 = new HotelBooking(); // default
        b1.displayData();

        System.out.println();
        // Custom creation
        HotelBooking b2 = new HotelBooking("Rahul", "Deluxe", 3); // parameterized
        b2.displayData();

        System.out.println();
        //Using the Copy Constructor
        HotelBooking b3 = new HotelBooking(b2); // copy
        b3.displayData();
    }
}
