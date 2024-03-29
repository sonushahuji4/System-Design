// Enums
enum NotificationType {
    EMAIL,
    PUSH,
    SMS
}

// Template Classes
abstract class NotificationTemplate {
    protected message: string;

    constructor(message: string) {
        this.message = message;
    }

    public abstract applyTemplate(): string;
    public abstract notificationType(): NotificationType;
}

class EmailNotificationTemplate extends NotificationTemplate {
    constructor(message: string) {
        super(message);
    }

    public applyTemplate(): string {
        console.log("Applying Email notification template");
        return this.message;
    }

    public notificationType(): NotificationType {
        return NotificationType.EMAIL;
    }
}

class PushNotificationTemplate extends NotificationTemplate {
    constructor(message: string) {
        super(message);
    }

    public applyTemplate(): string {
        console.log("Applying Push notification template");
        return this.message;
    }

    public notificationType(): NotificationType {
        return NotificationType.PUSH;
    }
}


// Notification Classes
abstract class Notification {
    protected recipient: string;
    protected template: NotificationTemplate;

    constructor(recipient: string, template: NotificationTemplate) {
        this.recipient = recipient;
        this.template = template;
    }

    public abstract notificationType(): NotificationType;
    public abstract sendNotification(): void;

    public getRecipient(): string {
        return this.recipient;
    }

    public getTemplate(): NotificationTemplate {
        return this.template;
    }
}

class EmailNotification extends Notification {
    private sender: string;

    constructor(recipient: string, sender: string, template: NotificationTemplate) {
        super(recipient, template);
        this.sender = sender;
    }

    public sendNotification(): void {
        console.log(`Email sent to ${this.getRecipient()} from ${this.sender}`);
        console.log(`Message: ${this.getTemplate().applyTemplate()}`);
    }

    public notificationType(): NotificationType {
        return NotificationType.EMAIL;
    }
}

class PushNotification extends Notification {
    constructor(recipient: string, template: NotificationTemplate) {
        super(recipient, template);
    }

    public sendNotification(): void {
        console.log(`Push notification sent to device ${this.getRecipient()}`);
        console.log(`Message: ${this.getTemplate().applyTemplate()}`);
    }

    public notificationType(): NotificationType {
        return NotificationType.PUSH;
    }
}

// Sender Classes
abstract class NotificationSender {
    protected notification: Notification;

    constructor(notification: Notification) {
        this.notification = notification;
    }

    public abstract send(): void;
    public abstract notificationType(): NotificationType;

    public getNotification(): Notification {
        return this.notification;
    }
}

class EmailNotificationSender extends NotificationSender {
    constructor(notification: Notification) {
        super(notification);
    }

    public send(): void {
        console.log("Sending Email notification to " + this.notification.getRecipient());
    }

    public notificationType(): NotificationType {
        return NotificationType.EMAIL;
    }
}

class PushNotificationSender extends NotificationSender {
    constructor(notification: Notification) {
        super(notification);
    }

    public send(): void {
        console.log("Sending Push notification to " + this.notification.getRecipient());
    }

    public notificationType(): NotificationType {
        return NotificationType.PUSH;
    }
}

// Factory Classes  
abstract class NotificationFactory {
    public abstract notificationType(): NotificationType;
    public abstract createNotification(recipient: string, sender: string, template: NotificationTemplate): Notification;
    public abstract createTemplate(templateName: string): NotificationTemplate;
    public abstract createSender(notification: Notification): NotificationSender;
}

class EmailNotificationFactory extends NotificationFactory {
    public notificationType(): NotificationType {
        return NotificationType.EMAIL;
    }

    public createNotification(recipient: string, sender: string, template: NotificationTemplate): Notification {
        return new EmailNotification(recipient, sender, template);
    }

    public createTemplate(templateName: string): NotificationTemplate {
        return new EmailNotificationTemplate(templateName);
    }

    public createSender(notification: Notification): NotificationSender {
        return new EmailNotificationSender(notification);
    }
}

class PushNotificationFactory extends NotificationFactory {
    public notificationType(): NotificationType {
        return NotificationType.PUSH;
    }

    public createNotification(recipient: string, sender: string, template: NotificationTemplate): Notification {
        return new PushNotification(recipient, template);
    }

    public createTemplate(templateName: string): NotificationTemplate {
        return new PushNotificationTemplate(templateName);
    }

    public createSender(notification: Notification): NotificationSender {
        return new PushNotificationSender(notification);
    }
}


// main.ts


// Create email notification factory
const emailFactory = new EmailNotificationFactory();

// Create email notification template
const emailTemplate: NotificationTemplate = emailFactory.createTemplate("Welcome to our platform!");

// Create email notification
const emailNotification = emailFactory.createNotification("user@example.com", "admin@example.com", emailTemplate);

// Create push notification factory
const pushFactory = new PushNotificationFactory();

// Create push notification template
const pushTemplate: NotificationTemplate = pushFactory.createTemplate("New updates available!");

// Create push notification
const pushNotification = pushFactory.createNotification("device-id", pushTemplate);

// Send notifications
emailNotification.sendNotification();
pushNotification.sendNotification();
