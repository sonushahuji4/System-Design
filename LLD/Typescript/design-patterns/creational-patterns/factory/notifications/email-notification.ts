import { NotificationType } from "./notification-type";
import { Notification } from "./notification";

export class EmailNotification implements Notification{
    recipient: string;
    sender: string;
    message: string;

    constructor(recipient: string, sender: string, message: string){
        this.recipient = recipient;
        this.sender = sender;
        this.message = message;
    }

    public getRecipient(): string{
        return this.recipient;
    }

    public getSender(): string{
        return this.sender;
    }

    public getMessage(): string{
        return this.message;
    }

    public sendNotification(): void{
        console.log("Email sent to " + this.recipient + " from " + this.sender);
        console.log("Message: " + this.message);
    }

    public getNotificationType(): NotificationType{
        return NotificationType.EMAIL;
    }
}