import { NotificationType } from "./notification-type";
import { Notification } from "./notification";

export class PushNotification implements Notification {

    recipient: string;
    message: string;

    constructor(recipient: string, message: string){
        this.recipient = recipient;
        this.message = message;
    }

    public getRecipient(): string{
        return this.recipient;
    }

    public getMessage(): string{
        return this.message;
    }

    public sendNotification(): void{
        console.log("Push notification sent to device " + this.recipient);
        console.log("Message: " + this.message);
    }

    public getNotificationType(): NotificationType{
        return NotificationType.PUSH;
    }
}