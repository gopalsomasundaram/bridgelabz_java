package ConstructorsAccessModifiers.Level2;
/*
 * This class demonstrates using a static variable as an Object Counter.
 */
public class Product {
    //Attributes
    String productName;
    int price;

    // static variable to count
    static int totalProducts = 0;

    // Constructor to count products (increments totalProducts everytime it is called)
    Product(String name, int p) {
        productName = name;
        price = p;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
    }

    // Class (static) method
    static void displayTotalProducts() {
        System.out.println("Total Products : " + totalProducts);
    }

    public static void main(String[] args) {
        //totalProducts becomes 1
        Product p1 = new Product("Laptop", 50000);

        //totalProducts becomes 2
        Product p2 = new Product("Mouse", 500);

        p1.displayProductDetails();
        System.out.println();

        p2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
