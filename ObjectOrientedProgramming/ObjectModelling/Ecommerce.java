package ObjectModelling;

import java.util.ArrayList;

/*
this class represents the Product entity.
it is modeled using AGGREGATION because a product exists 
independently of any specific order or customer.
*/
class Product {
    private String productName;
    private double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

/*
this class represents the Order entity.
it acts as the communication bridge. it AGGREGATES products,
meaning it collects existing products into a specific transaction.
*/
class Order {
    private int orderId;
    private ArrayList<Product> orderedProducts;

    Order(int orderId) {
        this.orderId = orderId;
        this.orderedProducts = new ArrayList<>();
    }

    // method to add an existing product to this order
    public void addProduct(Product product) {
        orderedProducts.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : orderedProducts) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: #" + orderId);
        for (Product p : orderedProducts) {
            System.out.println("  - " + p.getProductName() + ": $" + p.getPrice());
        }
        System.out.println("Total Amount: $" + calculateTotal());
    }
}

/*
this class represents the Customer entity.
it initiates COMMUNICATION by placing an order. it maintains 
an ASSOCIATION with its order history.
*/
class CustomerCart {
    private String customerName;
    private String email;
    private ArrayList<Order> orderHistory;

    CustomerCart(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
        this.orderHistory = new ArrayList<>();
    }

    /*
    this method demonstrates object communication.
    the customer 'places' an order, creating a new Order object
    and associating it with themselves.
    */
    public void placeOrder(Order order) {
        orderHistory.add(order);
        System.out.println(customerName + " successfully placed Order #" + 
                           " (History updated)");
    }

    public void viewProfile() {
        System.out.println("Customer Profile: " + customerName + " (" + email + ")");
        System.out.println("Purchase History:");
        for (Order o : orderHistory) {
            o.displayOrderDetails();
            System.out.println("---");
        }
    }
}

/*
the driver class demonstrates the full flow of an e-commerce platform
combining association, aggregation, and communication.
*/
public class Ecommerce{
    public static void main(String[] args) {
        // 1. Independent Products (Aggregation potential)
        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Wireless Mouse", 25.50);
        Product p3 = new Product("Monitor", 300.00);

        // 2. Customer initialization
        CustomerCart customer = new CustomerCart("Aayush", "aayush@example.com");

        // 3. Placing first order (Communication)
        Order order1 = new Order(5001);
        order1.addProduct(p1);
        order1.addProduct(p2);
        customer.placeOrder(order1);

        // 4. Placing second order
        Order order2 = new Order(5002);
        order2.addProduct(p3);
        customer.placeOrder(order2);

        System.out.println("\n--- Final Platform State ---");
        customer.viewProfile();
    }
}