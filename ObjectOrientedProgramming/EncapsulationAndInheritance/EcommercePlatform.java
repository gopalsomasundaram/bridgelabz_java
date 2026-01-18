package EncapsulationAndInheritance;

import java.util.ArrayList;

/*
the Taxable interface defines the contract for tax calculations.
this allows us to apply tax logic selectively to specific product types.
*/
interface Taxable {
    double calculateTax(double price);
    String getTaxDetails();
}

/*
the Product class is the abstract foundation.
it uses encapsulation (private fields) to ensure data integrity.
*/
abstract class Product {
    private String productId;
    private String name;
    private double price;

    // constructor to initialize the common product state
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // getters and setters for encapsulation
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if(price >= 0) this.price = price;
    }

    /* abstract method: forces subclasses to define their
       specific discount policies.
    */
    public abstract double calculateDiscount();

    public void displayBasicInfo() {
        System.out.println("Product: " + name + " [" + productId + "]");
    }
}

/*
Electronics class implements both the Product template and Taxable contract.
*/
class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% flat discount for electronics
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.18; // 18% GST/Tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax (18%)";
    }
}

/*
Clothing class follows the same structure but with different percentages.
*/
class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.25; // 25% seasonal discount
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.05; // 5% apparel tax
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax (5%)";
    }
}

/*
Groceries class is a Product but might not be Taxable in some regions.
*/
class Groceries extends Product {
    public Groceries(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% grocery discount
    }
}

/*
the driver class handles the polymorphism and final price logic.
*/
public class EcommercePlatform {

    //polymorphic method: processes any Product reference.
    public static void processOrder(ArrayList<Product> cart) {
        System.out.println("--- Order Summary ---");
        for (Product p : cart) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = 0;

            // check if the current product implements the Taxable interface
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax(price);
            }

            double finalPrice = price + tax - discount;

            p.displayBasicInfo();
            System.out.println("Base Price: $" + price);
            System.out.println("Tax Applied: $" + tax);
            System.out.println("Discount: -$" + discount);
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("---------------------");
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> myCart = new ArrayList<>();

        myCart.add(new Electronics("E-404", "Smartphone", 800.0));
        myCart.add(new Clothing("C-102", "Denim Jacket", 120.0));
        myCart.add(new Groceries("G-88", "Organic Coffee", 15.0));

        processOrder(myCart);
    }
}