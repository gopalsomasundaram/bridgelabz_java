package EncapsulationAndInheritance;

import java.util.ArrayList;

/*
the Reservable interface handles the 'on-hold' logic.
this is an interface because some items (like reference-only materials)
might not be reservable.
*/
interface Reservable {
    void reserveItem(String memberId);
    boolean checkAvailability();
}

/*
the LibraryItem class is abstract, serving as the blueprint.
it uses encapsulation to protect borrower details.
*/
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String currentBorrowerId; // encapsulated sensitive data

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // getters for common fields
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // encapsulated logic for managing borrower data
    protected void setBorrower(String memberId) {
        this.currentBorrowerId = memberId;
    }

    protected String getBorrower() {
        return (currentBorrowerId != null) ? currentBorrowerId : "None";
    }

    // abstract method: forces subclasses to define
    public abstract int getLoanDuration();

    // concrete method: shared logic for displaying details
    public void getItemDetails() {
        System.out.println("[" + itemId + "] Title: " + title + " | Author: " + author);
    }
}

/*
Book subclass: standard loan duration and reservable.
*/
class Book extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // books can be kept for 3 weeks
    }

    @Override
    public void reserveItem(String memberId) {
        this.isReserved = true;
        System.out.println("Book '" + getTitle() + "' has been reserved for Member: " + memberId);
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved && getBorrower().equals("None");
    }
}

/*
Magazine subclass: shorter loan duration, usually not reservable.
*/
class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // magazines are 1-week loans
    }
}

/*
DVD subclass: high-demand items with short loans and reservable.
*/
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // DVDs are limited to 3 days
    }

    @Override
    public void reserveItem(String memberId) {
        this.isReserved = true;
        System.out.println("DVD '" + getTitle() + "' put on hold for Member: " + memberId);
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved && getBorrower().equals("None");
    }
}

/*
the driver class demonstrates the polymorphic management of the library.
*/
public class LibraryManagement{
    public static void main(String[] args) {
        ArrayList<LibraryItem> catalog = new ArrayList<>();

        // adding different types to the general LibraryItem list
        catalog.add(new Book("B-101", "Effective Java", "Joshua Bloch"));
        catalog.add(new Magazine("M-202", "National Geographic", "Various Authors"));
        catalog.add(new DVD("D-303", "Inception", "Christopher Nolan"));

        System.out.println("--- Library Catalog & Loan Policies ---");
        System.out.println("---------------------------------------");

        for (LibraryItem item : catalog) {
            item.getItemDetails();
            System.out.println("Allowed Loan Period: " + item.getLoanDuration() + " days");

            //using 'instanceof' to check if an item supports reservations.
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                System.out.println("Status: " + (res.checkAvailability() ? "Available for Reserve" : "On Hold"));
            } else {
                System.out.println("Status: Reference-only / No reservation available.");
            }
            System.out.println("---------------------------------------");
        }
    }
}
