package ConstructorsAccessModifiers.Level1;

public class HotelBooking {
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
        HotelBooking b1 = new HotelBooking(); // default
        b1.displayData();

        System.out.println();

        HotelBooking b2 = new HotelBooking("Rahul", "Deluxe", 3); // parameterized
        b2.displayData();

        System.out.println();

        HotelBooking b3 = new HotelBooking(b2); // copy
        b3.displayData();
    }
}
