/** ------------------------------------------ |Creational Design Patterns| ------------------------------------------- */

/** A : Singleton Design Pattern */

/**
 * Designation: Singleton Design Pattern
 * 
 * Applications:
 * - Ensures that a class has only one instance and provides a global point of access to it.
 * - Useful for scenarios such as database connections, logging, caching, thread pools, etc.
 * 
 * Where and When to Use:
 * - When you want to restrict instantiation of a class to only one object.
 * - When you want to provide a single point of access to that instance.
 * 
 * Code Example:
 */

/** Template One (Lazy Loading) */
class Singleton {
    private static instance: Singleton;

    // Private constructor to prevent instantiation from outside
    private constructor() {}

    // Static method to get the singleton instance
    public static getInstance(): Singleton {
        // If instance doesn't exist, create a new one
        if (!Singleton.instance) {
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
}

/** Template Two (Early Loading) */
class DatabaseConnection {
    // Instance is initialized when class is loaded
    private static instance = new DatabaseConnection();

    // Private constructor to prevent instantiation from outside
    private constructor() {}

    // Static method to get the singleton instance
    public static getInstance(): DatabaseConnection {
        return DatabaseConnection.instance;
    }
}

/** Template Three (Lazy Loading with null check) */
class DatabaseConnection {
    private static instance: DatabaseConnection;

    // Private constructor to prevent instantiation from outside
    private constructor() {}

    // Static method to get the singleton instance
    public static getInstance(): DatabaseConnection {
        // If instance doesn't exist, create a new one
        if (!DatabaseConnection.instance) {
            DatabaseConnection.instance = new DatabaseConnection();
        }
        return DatabaseConnection.instance;
    }
}

/** Template Four (Thread-safe Lazy Loading with double-checked locking) */
class DatabaseConnection {
    private static instance: DatabaseConnection;

    // Private constructor to prevent instantiation from outside
    private constructor() {}

    // Static method to get the singleton instance
    public static getInstance(): DatabaseConnection {
        // Double-checked locking to ensure thread safety
        if (!DatabaseConnection.instance) {
            synchronized (DatabaseConnection.class) {
                if (!DatabaseConnection.instance) {
                    DatabaseConnection.instance = new DatabaseConnection();
                }
            }
        }
        return DatabaseConnection.instance;
    }
}


/** B : Builder Design Pattern */

/**
 * Designation: Builder Design Pattern
 * 
 * Applications:
 * - Used when the construction of a complex object is separated from its representation.
 * - Allows for the creation of different representations using the same construction process.
 * 
 * Where and When to Use:
 * - When the algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
 * - When the construction process must allow different representations for the object that's constructed.
 * 
 * Code Example:
 */

// Step One: Define the product class
class User {
    private name: string;

    constructor(builder: Builder) {
        this.name = builder.getName();
    }

    public getName(): string {
        return this.name;
    }
}

// Step Two: Define the builder class
class Builder {
    private name: string;

    // Private constructor to prevent external instantiation
    private constructor() {
        this.name = "";
    }

    // Setter methods to set properties of the product
    public setName(name: string): Builder {
        this.name = name;
        return this;
    }

    // Getter method to retrieve the constructed product
    public getName(): string {
        return this.name;
    }

    // Static method to create a new builder instance
    public static builder(): Builder {
        return new Builder();
    }

    // Method to build the product using the builder's state
    public build(): User {
        return new User(this);
    }
}

// Step Three: Use the builder to construct the product
const user = Builder.builder()
    .setName("Sonu")
    .build();
console.log("User :", user);



/** C : Prototype Design Pattern */

/**
 * Designation: Prototype Design Pattern
 * 
 * Applications:
 * - Used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects.
 * - Avoids the need for costly creation operations by creating new objects by copying an existing object, known as the prototype.
 * 
 * Where and When to Use:
 * - When the classes to instantiate are specified at runtime.
 * - When instances of a class can have one of only a few different combinations of state.
 * 
 * Code Example:
 */

// Step One: Define the enumeration for user types
enum UserType {
    ADMIN,
    READER,
    WRITER
}

// Step Two: Define the prototype interface
interface Prototype<T> {
    clone(): T;
}

// Step Three: Define the concrete prototype class
class User implements Prototype<User> {
    private email: string;
    private type: UserType;

    constructor(email: string, type: UserType) {
        this.email = email;
        this.type = type;
    }

    public getType(): UserType {
        return this.type;
    }

    public clone(): User {
        return new User(this.email, this.type);
    }
}

// Step Four: Define the prototype registry interface
interface PrototypeRegistry {
    addPrototype(user: User): void;
    getPrototype(type: UserType): User;
    clone(type: UserType): User;
}

// Step Five: Implement the prototype registry
class Registry implements PrototypeRegistry {
    private users: Map<UserType, User> = new Map();

    public addPrototype(user: User): void {
        this.users.set(user.getType(), user);
    }

    public getPrototype(type: UserType): User {
        const specificUser = this.users.get(type);
        if (specificUser) {
            return specificUser;
        } else {
            throw new Error(`Users with type ${type} not found.`);
        }
    }

    public clone(type: UserType): User {
        const specificUser = this.users.get(type);
        if (specificUser) {
            return specificUser.clone();
        } else {
            throw new Error(`Users with type ${type} not found.`);
        }
    }
}

// Step Six: Use the prototype registry to create and clone users
const adminUser = new User("admin@example.com", UserType.ADMIN);
const readerUser = new User("reader@example.com", UserType.READER);
const writerUser = new User("writer@example.com", UserType.WRITER);

const registry = new Registry();
registry.addPrototype(adminUser);
registry.addPrototype(readerUser);
registry.addPrototype(writerUser);

const clonedAdminUser = registry.clone(UserType.ADMIN);
const clonedReaderUser = registry.clone(UserType.READER);
const clonedWriterUser = registry.clone(UserType.WRITER);



/** D : Factory Design Pattern */

/**
 * Designation: Factory Design Pattern
 * 
 * Applications:
 * - Used when a class cannot anticipate the class of objects it must create.
 * - When the class delegates responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.
 * 
 * Where and When to Use:
 * - When a class cannot anticipate the class of objects it must create.
 * - When a class wants its subclasses to specify the objects it creates.
 * 
 * Code Example:
 */

// Step One: Define the interface for shapes
interface Shape {
    draw(): void;
}

// Step Two: Implement concrete shape classes
class Circle implements Shape {
    public draw(): void {
        console.log("Circle object");
    }
}

class Rectangle implements Shape {
    public draw(): void {
        console.log("Rectangle object");
    }
}

class Square implements Shape {
    public draw(): void {
        console.log("Square object");
    }
}

// Step Three: Create the factory class
class ShapeFactory {
    public static getShape(input: string): Shape | null {
        switch (input) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}

// Step Four: Use the factory to create objects
const circle = ShapeFactory.getShape("CIRCLE");
const rectangle = ShapeFactory.getShape("RECTANGLE");
const square = ShapeFactory.getShape("SQUARE");



/** E : Abstract Factory Design Pattern */

/**
 * Designation: Abstract Factory Design Pattern
 * 
 * Applications:
 * - Used when a system must be independent of how its products are created, composed, and represented.
 * - When a system must be configured with one of multiple families of products.
 * 
 * Where and When to Use:
 * - When a system should be independent of how its products are created, composed, and represented.
 * - When a system should be configured with one of multiple families of products.
 * 
 * Code Example:
 */

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





/** ------------------------------------------ |Structural Design Patterns| ------------------------------------------- */


/** A : Adapter Design Pattern */

/**
 * The Adapter design pattern allows incompatible interfaces to work together. 
 * In your example with PhonePe UPI app and different banks, let's say each bank has its own unique interface for processing UPI transactions. 
 * However, PhonePe app expects a standardized interface for processing UPI transactions.
 * 
 * To bridge the gap between the incompatible interfaces of the banks and the PhonePe app, you can use the Adapter pattern. Here's how you can apply it:
 *  1. Define the Target Interface: This is the interface that the client (PhonePe app) expects. In this case, it could be an interface like UPIService with methods such as makePayment() and requestBalance().
 *  2. Implement Adaptees: Adaptees are the existing interfaces that you want to adapt. Each bank (HDFC, YES, SBI, ICICI) would have its own interface for processing UPI transactions. These interfaces are the adaptees in this scenario.
 *  3. Create Adapters: Adapters are classes that implement the target interface (UPIService) while internally delegating the work to the adaptee. Each adapter would be responsible for converting the method calls from the PhonePe app into calls that the respective bank's interface can understand.
 * 
 */

// Target interface expected by PhonePe app
interface UPIService {
    makePayment(amount: number, recipient: string): void;
    requestBalance(): number;
}

// Adaptee interface for HDFC bank
interface HDFC_UPI {
    pay(amount: number, recipientAccount: string): void;
    checkBalance(): number;
}

// Adaptee interface for YES bank
interface YES_UPI {
    sendMoney(amount: number, beneficiary: string): void;
    getBalance(): number;
}

// Adapters for HDFC bank
class HDFCAdapter implements UPIService {
    private hdfcUPI: HDFC_UPI;

    constructor(hdfcUPI: HDFC_UPI) {
        this.hdfcUPI = hdfcUPI;
    }

    makePayment(amount: number, recipient: string): void {
        this.hdfcUPI.pay(amount, recipient);
    }

    requestBalance(): number {
        return this.hdfcUPI.checkBalance();
    }
}

// Adapters for YES bank
class YESAdapter implements UPIService {
    private yesUPI: YES_UPI;

    constructor(yesUPI: YES_UPI) {
        this.yesUPI = yesUPI;
    }

    makePayment(amount: number, recipient: string): void {
        this.yesUPI.sendMoney(amount, recipient);
    }

    requestBalance(): number {
        return this.yesUPI.getBalance();
    }
}

// Client code (PhonePe app)
const amount = 100;
const recipient = "recipient@example.com";

// Using HDFC bank adapter
const hdfcUPI: HDFC_UPI = new HDFC_UPIImpl(); // Assume implementation exists
const hdfcAdapter: UPIService = new HDFCAdapter(hdfcUPI);
hdfcAdapter.makePayment(amount, recipient);
console.log("Balance after transaction:", hdfcAdapter.requestBalance());

// Using YES bank adapter
const yesUPI: YES_UPI = new YES_UPIImpl(); // Assume implementation exists
const yesAdapter: UPIService = new YESAdapter(yesUPI);
yesAdapter.makePayment(amount, recipient);
console.log("Balance after transaction:", yesAdapter.requestBalance());


/**
 * 1. UPIService represents the interface expected by the PhonePe app.
 * 2. HDFC_UPI and YES_UPI represent the interfaces provided by HDFC and YES banks, respectively.
 * 3. HDFCAdapter and YESAdapter are adapters that bridge the gap between the bank interfaces and the UPIService.
 * 4. The PhonePe app can now use the same interface (UPIService) to interact with different banks, thanks to the adapters.
 */



/** B : Decorator Design Pattern */
/**
 * Designation:
 * The Decorator pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. 
 * It is used to extend or augment the behavior of objects in a flexible and reusable way.
 * 
 * 
 * Applications:
    1. Extending functionality: Decorator pattern allows adding new functionality to an object without altering its structure.
    2. Dynamic behavior: It enables adding or removing responsibilities to objects at runtime.
    3. Multiple combinations: Decorators can be combined in various ways to create different combinations of behaviors.
    4. Open/Closed Principle: It promotes the Open/Closed Principle by allowing classes to be open for extension but closed for modification.

 *
 * Where and When to Use:
    1. When you need to add new functionality to objects dynamically without affecting other instances of the same class.
    2. When subclassing to extend behavior is impractical or when too many subclasses would result.
    3. When you want to avoid the use of inheritance to extend functionality, as it can lead to a class explosion with multiple subclasses.
    4. When you want to add or remove responsibilities from objects at runtime.
    5. When you need to provide a flexible way to configure or assemble objects with different combinations of behaviors.
    6. When you want to adhere to the Open/Closed Principle, allowing classes to be easily extended with new functionality without modifying existing code.
 */

// Step One
interface MenuItem{
    getDescription():void;
    getCost():number;
}

// Step Two
class Burger implements MenuItem {
    
    cost = 100;

    getDescription(): void {
        console.log("Burger item is added")
    }

    getCost(): number {
        return this.cost;
    }
}

class Pizza implements MenuItem {
    
    cost = 200;

    getDescription(): void {
        console.log("Pizza item is added")
    }

    getCost(): number {
        return this.cost;
    }
}


// Step Three
class CheeseDecorator implements MenuItem{

    cost: number = 100;
    wrapper: MenuItem;

    constructor(wrapper: MenuItem){
        this.wrapper = wrapper;
    }

    public getDescription(): void {
        this.wrapper.getDescription();
        console.log("Cheese addon is added");
    } 

    getCost(): number {
        return this.wrapper.getCost() + this.cost;
    }
}

class PaneerDecorator implements MenuItem{

    cost: number = 100;
    wrapper: MenuItem;

    constructor(wrapper: MenuItem){
        this.wrapper = wrapper;
    }

    public getDescription(): void {
        this.wrapper.getDescription();
        console.log("Paneer addon is added");
    } 

    getCost(): number {
        return this.wrapper.getCost() + this.cost;
    }
}


// Step Five
const pizza: MenuItem = new CheeseDecorator(new PaneerDecorator(new Pizza()));
const burger: MenuItem = new PaneerDecorator(new CheeseDecorator(new Burger()));

pizza.getDescription();
console.log("Item total is "+pizza.getCost() + "Rs");

console.log("********");

burger.getDescription();
console.log("Item total is "+burger.getCost() + "Rs");

const burg: MenuItem = new Burger(); // ordering only burger
const cheese: MenuItem = new CheeseDecorator(burg); // ordering cheese + burger
const item: MenuItem = new PaneerDecorator(cheese); // adding addon on (cheese + burger)

// Real world example for use-case
// INotifier notifier = new SMSNotifier(
//                         new EmailNotifier(
//                             new Notifier()));

        
/** C : Facade Design Pattern */

/**

Designation:
The Facade pattern is a structural design pattern that provides a simplified interface to a complex system of classes, interfaces, or subsystems. It encapsulates a group of interfaces in a higher-level interface, making it easier to use and reducing dependencies between clients and subsystems.

Applications:
1. Simplifying complex systems: Facade pattern provides a simplified interface to a complex system, hiding its complexities from clients.
2. Encapsulation: It encapsulates the complex interactions and dependencies of multiple subsystems behind a single interface.
3. Promoting loose coupling: Facade promotes loose coupling between clients and subsystems by reducing direct dependencies.
4. Providing a unified interface: It presents a unified interface to a set of interfaces in a subsystem, making it easier to use for clients.
5. Enhancing maintainability: Facade pattern improves the maintainability of the codebase by isolating changes in subsystems behind a single interface.

Where and When to Use:
1. When you want to provide a simple interface to a complex system or set of subsystems.
2. When you need to reduce dependencies between clients and subsystems by providing a unified interface.
3. When the complexity of a system needs to be hidden from clients to improve usability and maintainability.
4. When you want to decouple client code from the implementation details of subsystems, allowing for easier changes and updates.
5. When you need to refactor or modularize existing code by encapsulating related functionality behind a facade.

Code Example:
*/

// Subsystem A
class SubsystemA {
    public operationA(): void {
        console.log("Subsystem A operation");
    }
}

// Subsystem B
class SubsystemB {
    public operationB(): void {
        console.log("Subsystem B operation");
    }
}

// Facade
class Facade {
    private subsystemA: SubsystemA;
    private subsystemB: SubsystemB;

    constructor() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
    }

    public operation(): void {
        console.log("Facade operation:");
        this.subsystemA.operationA();
        this.subsystemB.operationB();
    }
}

// Client
const facade = new Facade();
facade.operation();

/*
Output:
Facade operation:
Subsystem A operation
Subsystem B operation
*/


/** D : Flyweight Design Pattern */

/** 

Designation:
The Flyweight pattern is a structural design pattern that aims to minimize memory usage and improve performance by sharing common parts of objects between multiple objects. It achieves this by splitting objects into intrinsic and extrinsic states, where intrinsic states are shared among multiple objects, and extrinsic states are unique to each object.

Applications:
1. Memory optimization: Flyweight pattern helps in reducing memory usage by sharing common parts of objects.
2. Performance optimization: By reusing shared intrinsic states, Flyweight pattern improves performance by reducing object creation overhead.
3. Large number of objects: It is useful when dealing with a large number of objects that have common parts but differ in some attributes.
4. Immutable objects: Flyweight pattern works well with immutable objects where shared states can be safely reused.
5. Caching: It can be used for caching frequently used objects or data to improve performance.

Where and When to Use:
1. When your application needs to create a large number of similar objects that share common parts.
2. When memory usage is a concern, and you want to optimize memory consumption by sharing common states.
3. When the performance of object creation and initialization is critical, and you want to minimize overhead by reusing shared states.
4. When you need to represent large datasets efficiently, and many objects can be represented by sharing common data.
5. When you want to implement a caching mechanism to store and reuse objects or data.


Intrinsic State:

The intrinsic state represents the shared, immutable part of the flyweight object. This part of the object is independent of its context or how it's used. Intrinsic state is typically stored within the flyweight object and shared among multiple instances. It remains constant throughout the lifetime of the flyweight object.
Examples of intrinsic state include properties or attributes that are common to multiple objects, such as color, texture, or shape.
In the code example provided earlier, the intrinsicState property of the ConcreteFlyweight class represents the intrinsic state shared among multiple flyweight objects.


Extrinsic State:

The extrinsic state represents the unique, context-dependent part of the flyweight object. This part varies based on how the flyweight object is used or its specific context within the application.
Extrinsic state is not stored within the flyweight object but is instead passed as a parameter when performing operations on the flyweight. Each client object provides its own extrinsic state when interacting with the flyweight.
Examples of extrinsic state include properties or attributes that differ among instances of the flyweight object, such as position, size, or orientation.
In the code example, the operation method of the ConcreteFlyweight class accepts the extrinsic state as a parameter and uses it in conjunction with the intrinsic state to perform operations. The extrinsic state (extrinsicState) is unique to each client object and is passed when invoking the operation method.

Code Example:
*/

// Flyweight interface
interface Flyweight {
    operation(extrinsicState: number): void;
}

// Concrete Flyweight
class ConcreteFlyweight implements Flyweight {
    private intrinsicState: number;

    constructor(intrinsicState: number) {
        this.intrinsicState = intrinsicState;
    }

    operation(extrinsicState: number): void {
        console.log(`ConcreteFlyweight: Intrinsic state ${this.intrinsicState}, Extrinsic state ${extrinsicState}`);
    }
}

// Flyweight Factory
class FlyweightFactory {
    private flyweights: { [key: string]: Flyweight } = {};

    getFlyweight(key: string): Flyweight {
        if (!(key in this.flyweights)) {
            this.flyweights[key] = new ConcreteFlyweight(parseInt(key));
        }
        return this.flyweights[key];
    }
}

// Client
const factory = new FlyweightFactory();
const flyweight1 = factory.getFlyweight("1");
const flyweight2 = factory.getFlyweight("2");

flyweight1.operation(100);
flyweight2.operation(200);

/*
Output:
ConcreteFlyweight: Intrinsic state 1, Extrinsic state 100
ConcreteFlyweight: Intrinsic state 2, Extrinsic state 200
*/
