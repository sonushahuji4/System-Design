1. Stragy Design Pattern
2. Decorator Design Pattern
3. Observer Design Pattern
4. Singleton Design Pattern
5. Facade Design Pattern

/**
 * Facade Design Pattern
 * The Facade design pattern is a structural pattern that provides a simplified interface to a complex system of classes, interfaces, or subsystems. 
 * It hides the complexities of the underlying system and provides a unified interface that is easier to use.
 */

/**
 * Let's understand the Facade pattern with an example:
 * Suppose we have a complex system for processing orders in an e-commerce application. This system involves several subsystems such as inventory management, payment processing, shipping, and notification. Each subsystem has its own set of classes and methods.
 * Without the Facade pattern, the client code would need to interact directly with each subsystem, which can be cumbersome and error-prone. However, by using the Facade pattern, we can create a simplified interface that encapsulates the interactions with the subsystems, making it easier for clients to use the system.
 * Here's how we can implement the Facade pattern for our e-commerce order processing system:
 */

 // Subsystem: Inventory management
class InventoryManager {
    public void checkInventory(String productId) {
        // Logic to check inventory
        System.out.println("Checking inventory for product: " + productId);
    }
}

// Subsystem: Payment processing
class PaymentProcessor {
    public void processPayment(double amount) {
        // Logic to process payment
        System.out.println("Processing payment: " + amount);
    }
}

// Subsystem: Shipping
class ShippingManager {
    public void shipOrder(String address) {
        // Logic to ship order
        System.out.println("Shipping order to address: " + address);
    }
}

// Subsystem: Notification
class NotificationManager {
    public void sendNotification(String message) {
        // Logic to send notification
        System.out.println("Sending notification: " + message);
    }
}

// Facade class
class OrderProcessingFacade {
    private InventoryManager inventoryManager;
    private PaymentProcessor paymentProcessor;
    private ShippingManager shippingManager;
    private NotificationManager notificationManager;

    public OrderProcessingFacade() {
        this.inventoryManager = new InventoryManager();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingManager = new ShippingManager();
        this.notificationManager = new NotificationManager();
    }

    public void processOrder(String productId, double amount, String address) {
        inventoryManager.checkInventory(productId);
        paymentProcessor.processPayment(amount);
        shippingManager.shipOrder(address);
        notificationManager.sendNotification("Your order has been processed successfully");
    }
}

// Client code
public class FacadePatternExample {
    public static void main(String[] args) {
        OrderProcessingFacade facade = new OrderProcessingFacade();
        facade.processOrder("ABC123", 100.0, "123 Main St, City");
    }
}



/**
 * Facade Design Pattern
 * 1. Outward appearance of the building, hiding the internal complexcity.
 * 2. Facade in LLD
 *      a) Distribution of loads
 */

/**
 * 
 */