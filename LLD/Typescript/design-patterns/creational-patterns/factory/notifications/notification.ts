import { NotificationType } from "./notification-type";

export interface Notification {
    recipient: string;
    message: string;

    getRecipient(): string;
    getMessage(): string;
    sendNotification(): void;
    getNotificationType(): NotificationType;
}