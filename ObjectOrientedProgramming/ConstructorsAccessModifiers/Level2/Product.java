package ConstructorsAccessModifiers.Level2;

public class Product {
    String productName;
    int price;

    // static variable to count
    static int totalProducts = 0;

    // Constructor to count products
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
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);

        p1.displayProductDetails();
        System.out.println();

        p2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
