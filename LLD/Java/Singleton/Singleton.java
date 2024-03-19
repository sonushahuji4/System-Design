/**
 * Creation Design Pattern
 * 1. How will an object be created?
 * 2. How many objects will be created? (Singleton) 
 */

 /** Singleton Pattern:
  * The Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance.
  */

  /**
   * Implementation Steps:
    1. Private Constructor: Ensure that the constructor of the Singleton class is private to prevent external instantiation.
    2. Static Instance: Create a static variable to hold the single instance of the class.
    3. Static Method: Provide a static method to access the instance. This method should create the instance if it doesn't exist, otherwise return the existing instance.
   */


  /** When does the Singleton is used 
   * 1. The Singleton pattern is used in situations where you need to ensure that there is only one instance of a class throughout the entire application lifecycle.
   * 2. When there is shared resources backing the class. 
   *    Examples : 
   *        a. Database Connection Pooling:
                In web applications or server-side applications, managing database connections efficiently is crucial for performance. 
                Using a Singleton pattern for a connection pool manager allows for the creation and management of a fixed number of database connections, 
                which can be reused across multiple requests, thus avoiding the overhead of creating new connections for each request.
   *        b. Logging System:
                Logging is an essential part of any software application for debugging, monitoring, and auditing purposes. 
                By implementing a logging system as a Singleton, all components of the application can easily access the same logging instance to record events and errors consistently. 
                This ensures that log messages are centralized and organized in a unified manner.
            c. Configuration Manager:
                Applications often require configuration settings to be accessed globally, such as database credentials, API keys, application settings, etc. 
                A Singleton configuration manager can provide a centralized point of access for reading and modifying configuration settings throughout the application. 
                This ensures that configuration settings are consistent and easily manageable.
            d. Session Management:
                In web applications, managing user sessions and authentication tokens is essential for maintaining user state and security. 
                A Singleton session manager can handle session creation, validation, and expiration, ensuring that user sessions are managed consistently and securely across different parts of the application.
            e. Cache Management:
                Caching frequently accessed data or expensive computations can significantly improve the performance of an application. 
                Implementing a cache manager as a Singleton allows for centralized control over caching strategies, expiration policies, and memory management. 
                This ensures that cached data is consistent and efficiently utilized across different components of the application.
   */


/** Understanding the creation of Singlton step by step */

/** Idea One: */

class DatabaseConnection {

    constructor() {
        // Private constructor to prevent external instantiation
    }
}

const DbConnection1 = new DatabaseConnection();
const DbConnection2 = new DatabaseConnection();
const DbConnection3 = new DatabaseConnection();
const DbConnection4 = new DatabaseConnection();

/* Here, we can create many DatabaseConnection, how can it be restricted to only one instance 
 * 1. Make the constructor as private, since private variable, methods, constructors etc can be access within class only.
 */

/** Idea Two (Constructor made private) */

class DatabaseConnection {

    private constructor() {
        // Private constructor to prevent external instantiation
    }
}

/** once, Constructor is made private then it cannot be accessed from outside the class, it will throw the error. It means, you cannot create any instance.
 * What do you do now to create a instance ?
 * Create a private method, which is static, and that method will be responsible for object creation only.
 */
const DbConnection1 = new DatabaseConnection();


/** Idea Three */

class DatabaseConnection {

    private constructor() {
        // Private constructor to prevent external instantiation
    }

    private static dbConnections () {
        return new DatabaseConnection();
    }
}

/** still we are able to create multiple, database connection */
const DbConnection1 = new DatabaseConnection();
const DbConnection2 = new DatabaseConnection();
const DbConnection3 = new DatabaseConnection();
const DbConnection4 = new DatabaseConnection();


/** Idea Four */

class DatabaseConnection {

    private static instance: DatabaseConnection;

    private constructor() {
        // Private constructor to prevent external instantiation
    }

    private static dbConnections () {
        if(DatabaseConnection.instance === null){
            DatabaseConnection.instance = new DatabaseConnection();
        }
        return DatabaseConnection.instance;
    }
}

/**  Issue with the above approch is that in multi threading environment this might fail 
 * 1. Imagine, two thread trying to access database connection at the same time, t1 and t2. It will create two instances.
 * 2. We can used synchronization keyword but there are performance issue with this also
*/


/** Idea Five */

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;

    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }
}


class DatabaseConnection {

    private static instance = new DatabaseConnection();;

    private constructor() {
        // Private constructor to prevent external instantiation
    }

    private static dbConnections () {
        return DatabaseConnection.instance;
    }
} 

/** This will approch also has some drawback.
 * 1. Imagine a applicaiton, where application has to load quickly and it does not have database related work. In that case it will wait until it has established database connections.
 * This is called EarlyLoadding
 */


 /** Final Solution */

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized(instance.class){
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            } 
        }
        return instance;
    }
}

/** add synchronized in the block level method */




/** Othere examples for Singleton use cases */

class Logger {
    private static instance: Logger;
    private logs: string[];

    private constructor() {
        this.logs = [];
    }

    public static getInstance(): Logger {
        if (!Logger.instance) {
            Logger.instance = new Logger();
        }
        return Logger.instance;
    }

    public log(message: string): void {
        const timestamp = new Date().toISOString();
        const logEntry = `${timestamp}: ${message}`;
        this.logs.push(logEntry);
        console.log(logEntry);
    }

    public getLogs(): string[] {
        return this.logs;
    }
}

// Usage
const logger1 = Logger.getInstance();
const logger2 = Logger.getInstance();

logger1.log('Log message 1');
logger2.log('Log message 2');

console.log(logger1 === logger2); // Output: true

console.log(logger1.getLogs()); // Output: [ 'timestamp: Log message 1', 'timestamp: Log message 2' ]

/************************************************** */


class SessionManager {
    private static instance: SessionManager;
    private sessions: Map<string, string>; // Map to store sessionId and userId

    private constructor() {
        this.sessions = new Map<string, string>();
    }

    public static getInstance(): SessionManager {
        if (!SessionManager.instance) {
            SessionManager.instance = new SessionManager();
        }
        return SessionManager.instance;
    }

    public createSession(sessionId: string, userId: string): void {
        this.sessions.set(sessionId, userId);
    }

    public getSessionUserId(sessionId: string): string | undefined {
        return this.sessions.get(sessionId);
    }

    public isValidSession(sessionId: string): boolean {
        return this.sessions.has(sessionId);
    }

    public expireSession(sessionId: string): void {
        this.sessions.delete(sessionId);
    }
}



/******************************************* */


class CacheManager {
    private static instance: CacheManager;
    private cache: Map<string, any>; // Map to store cached data

    private constructor() {
        this.cache = new Map<string, any>();
    }

    public static getInstance(): CacheManager {
        if (!CacheManager.instance) {
            CacheManager.instance = new CacheManager();
        }
        return CacheManager.instance;
    }

    public set(key: string, value: any): void {
        this.cache.set(key, value);
    }

    public get(key: string): any {
        return this.cache.get(key);
    }

    public has(key: string): boolean {
        return this.cache.has(key);
    }

    public delete(key: string): void {
        this.cache.delete(key);
    }

    public clear(): void {
        this.cache.clear();
    }
}

// Usage
const cacheManager1 = CacheManager.getInstance();
const cacheManager2 = CacheManager.getInstance();

console.log(cacheManager1 === cacheManager2); // Output: true

cacheManager1.set('key1', 'value1');
cacheManager1.set('key2', 'value2');

console.log(cacheManager1.get('key1')); // Output: 'value1'
console.log(cacheManager2.has('key2')); // Output: true

cacheManager2.delete('key1');
console.log(cacheManager1.has('key1')); // Output: false

cacheManager1.clear();
console.log(cacheManager2.has('key2')); // Output: false
