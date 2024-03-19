/** Dependency Inversion Principle (DIP): */

/**
 * The Dependency Inversion Principle is the last of the five SOLID principles. 
 * It emphasizes two main points: high-level modules should not depend on low-level modules, both should depend on abstractions. 
 * Abstractions should not depend on details, details should depend on abstractions.
 */

 // Understanding DIP:

 /**
  * 1. High-level modules: These are modules that contain your application's business logic. They deal with the overall flow of your application.
  * 2. Low-level modules: These are modules that deal with specific implementation details, like interacting with databases, file systems, or external APIs.
  * 3. Abstractions: These are interfaces or abstract classes that define a contract without specifying the implementation details.
  */

 /**
  * DIP promotes loose coupling between modules in a system by ensuring that higher-level modules do not directly depend on lower-level modules. 
  * Instead, both should depend on abstractions, allowing for flexibility and ease of change.
  */

  /** Example One */

/** Low Level Modules */
class DataAccess {
    getData(): any {
        // Implementation to retrieve data
        return "Data from database";
    }
}

/** High Level Modules */
class BusinessLogic {
    private dataAccess: DataAccess;

    constructor(dataAccess: DataAccess) {
        this.dataAccess = dataAccess;
    }

    processData(): void {
        const data = this.dataAccess.getData();
        console.log("Processing data:", data);
    }
}

const dataAccess = new DataAccess();
const businessLogic = new BusinessLogic(dataAccess);
businessLogic.processData();

/** Issues
 * 1. High Level Module is depenedent on Low Level Module
 * 2. If any things changes in Low Level modules, will impact the high level modules, which violets OCP
 */

/** Solution
 * 1. High Level Module, instead of depending on Low Level module, it should depend on Abstraction (interface)
 * 2. Low Level Module, should also depend on Abstraction (interface)
 */

 // Abstraction (Interface)
interface DataAccessInterface {
    getData(): any;
}

// Low Level Modules which depends on Abstraction (Interface) : Implement DataAccess class that implements DataAccessInterface
class DataAccess implements DataAccessInterface {
    getData(): any {
        // Implementation to retrieve data
        return "Data from database";
    }
}

// High Level Modules which depends on Abstraction (Interface)  Implement BusinessLogic class that depends on DataAccessInterface
class BusinessLogic {
    private dataAccess: DataAccessInterface;

    constructor(dataAccess: DataAccessInterface) {
        this.dataAccess = dataAccess;
    }

    processData(): void {
        const data = this.dataAccess.getData();
        console.log("Processing data:", data);
    }
}

// Usage
const dataAccess = new DataAccess();
const businessLogic = new BusinessLogic(dataAccess);
businessLogic.processData();



/** Example Two */

/**
 * To implement the DIP you should:
 * 1. Write the interfaces for low-level implementation that high-level classes will need, these interfaces are part of the high level.
 * 2. Make high-level classes dependent on these interfaces, instead of making them dependent on low-level concrete classes.
 */

 class Email {
    sendEmail(message: string): void {
        console.log(`Sending email notification: ${message}`);
    }
}

class Sms {
    sendSMS(message: string): void {
        console.log(`Sending SMS notification: ${message}`);
    }
}

class Notification {
    private email: Email;
    private sms: Sms;

    constructor() {
        this.email = new Email();
        this.sms = new Sms();
    }

    sendNotification(message: string): void {
        this.email.sendEmail(message);
        this.sms.sendSMS(message);
    }
}

// Usage
const notification = new Notification();
notification.sendNotification("Hello!");

// Issues:
/**
 * a. High Coupling:
 *  1. Notification class directly depends on the concrete implementations (Email and Sms), violating DIP.
 *  2. Any change in Email or Sms implementation will require modification in Notification, leading to high coupling.
 * b. Violation of Open-Closed Principle (OCP):
 *  1. Adding a new notification type requires modification of Notification class, violating OCP.
 */

 /** Step 2: Refactored Implementation (Using DIP) */

 interface IMessage {
    sendMessage(message: string): void;
}

class Email implements IMessage {
    sendMessage(message: string): void {
        console.log(`Sending email notification: ${message}`);
    }
}

class Sms implements IMessage {
    sendMessage(message: string): void {
        console.log(`Sending SMS notification: ${message}`);
    }
} 

class Notification {
    private messageServices: IMessage[];

    constructor(messageServices: IMessage[]) {
        this.messageServices = messageServices;
    }

    sendNotification(message: string): void {
        this.messageServices.forEach(service => service.sendMessage(message));
    }
}

// Usage
const emailService = new Email();
const smsService = new Sms();
const notification = new Notification([emailService, smsService]);
notification.sendNotification("Hello!");


/** Link: https://h-benkachoud.medium.com/dependency-inversion-principle-dip-fc489ac42f4e */