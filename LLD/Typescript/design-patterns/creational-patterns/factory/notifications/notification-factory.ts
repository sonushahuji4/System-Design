import { EmailNotification } from "./email-notification";
import { Notification } from "./notification";
import { NotificationType } from "./notification-type";
import { PushNotification } from "./push-notification";
import { SmsNotification } from "./sms-notification";

export class NotificationFactory {
    public static getNotification(type: NotificationType, message: string, recipient: string, sender: string): Notification | null {
        switch(type) {
            case NotificationType.EMAIL: 
                return new EmailNotification(recipient, sender, message);
            case NotificationType.PUSH: 
                return new PushNotification(recipient, message);
            case NotificationType.SMS: 
                return new SmsNotification(recipient, message);
            default:
                return null; // Handle the case where type doesn't match any of the known types
        }
    }
}
