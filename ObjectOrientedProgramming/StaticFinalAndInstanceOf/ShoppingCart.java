package StaticFinalAndInstanceOf;

/**
 * this class is used to demonstrate the following:
 * static - to apply a universal discount across all products in the cart
 * final - to protect the unique product ID from being modified after creation
 * this - to ensure clarity when assigning values in the constructor
 */
class Product {
    // static members
    static double discountPercentage = 10.0; // default 10% discount

    // instance members
    final int productID;
    String productName;
    double price;
    int quantity;

    // parameterized constructor
    Product(int productID, String productName, double price, int quantity) {
        /* using 'this' resolves the ambiguity between the local 
           parameters and the instance variables 
        */
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // static method to update the discount for all products
    static void updateDiscount(double newDiscount) {
        discountPercentage = newDiscount;
        System.out.println("Global discount updated to: " + discountPercentage + "%");
    }

    // method to display product details and calculated total
    void displayProductDetails() {
        double totalBeforeDiscount = price * quantity;
        double savings = (totalBeforeDiscount * discountPercentage) / 100;
        double finalPrice = totalBeforeDiscount - savings;

        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Unit Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Final Price (after " + discountPercentage + "% discount): " + finalPrice);
        System.out.println();
    }
}

/**
 * this class contains the main logic to simulate the shopping cart
 * and validates objects using the instanceof operator
 */
public class ShoppingCart{
    public static void main(String[] args) {
        // updating global discount via static method before creating products
        Product.updateDiscount(15.0);
        System.out.println();

        // creating product objects
        Product item1 = new Product(501, "Mechanical Keyboard", 120.0, 1);
        Product item2 = new Product(502, "Gaming Mouse", 60.0, 2);

        // validating item1 using instanceof
        if (item1 instanceof Product) {
            System.out.println("Object Verified: Processing product details...");
            item1.displayProductDetails();
        }

        // processing item2
        if (item2 instanceof Product) {
            item2.displayProductDetails();
        }
    }
}