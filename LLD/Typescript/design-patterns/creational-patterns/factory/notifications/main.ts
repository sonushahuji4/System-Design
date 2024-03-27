import { NotificationFactory } from "./notification-factory";
import { NotificationType } from "./notification-type";


// Create notifications using the factory
const emailNotification = NotificationFactory.getNotification(NotificationType.EMAIL, "Hello from Email", "recipient@example.com", "sender@example.com");
const pushNotification = NotificationFactory.getNotification(NotificationType.PUSH, "Hello from Push", "recipient", "");
const smsNotification = NotificationFactory.getNotification(NotificationType.SMS, "Hello from SMS", "1234567890", "");

// Output notifications
console.log("Email Notification:", emailNotification);
console.log("Push Notification:", pushNotification);
console.log("SMS Notification:", smsNotification);
