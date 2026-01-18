package Inheritance;

/*
this class represents the base level (Grandparent).
it contains the fundamental data present from the moment
a customer places an order.
*/
class Order {
    String orderId;
    String orderDate;

    // constructor to initialize basic order data
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // base method to describe the state of the order
    String getOrderStatus() {
        return "Status: Order Placed on " + orderDate;
    }

    void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println(getOrderStatus());
    }
}

/*
this class represents the second level (Parent).
it extends Order, inheriting the ID and date while
adding logistical tracking information.
*/
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        // passing data up to the Order constructor
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // overriding the status to reflect the shipping phase
    @Override
    String getOrderStatus() {
        return "Status: Shipped [Tracking #: " + trackingNumber + "]";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
    }
}

/*
this class represents the third level (Child).
it extends ShippedOrder, inheriting all previous data
and adding the final delivery confirmation.
*/
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        // passing data up the chain to the ShippedOrder constructor
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // overriding the status to reflect the final completion
    @Override
    String getOrderStatus() {
        return "Status: Delivered on " + deliveryDate;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Final Delivery Confirmed.");
    }
}

/*
the driver class manages the order lifecycle through the hierarchy.
*/
public class OrderManagement{
    public static void main(String[] args) {
        /*
           creating a DeliveredOrder object.
           note that this object contains data from all three levels:
           orderId (Order), trackingNumber (ShippedOrder), and deliveryDate (DeliveredOrder).
        */
        DeliveredOrder myOrder = new DeliveredOrder(
                "ORD-9921",
                "2026-01-10",
                "TRK778899",
                "2026-01-15"
        );

        System.out.println("--- Retail Order Tracking ---");
        // this triggers the most specific version of getOrderStatus()
        myOrder.displayInfo();

        System.out.println("------------------------------------------");

        /*
           polymorphism check:
           even if we treat it as a base Order, it retains its behavior.
        */
        Order baseRef = myOrder;
        System.out.println("Accessing via base reference: " + baseRef.getOrderStatus());
    }
}