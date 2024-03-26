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

















/**
# Connection Pool

## Problem Statement

You are tasked with designing a connection pool for a database management module of a complex software application. The connection pool is responsible for managing database connections efficiently to avoid unnecessary overhead and ensure optimal resource usage. To prevent multiple instances of the connection pool manager and ensure thread-safe access to connections, you need to implement the Singleton design pattern along with the connection pool management functionality.

## Assignment

Your task is to implement the `ConnectionPool` interface that follows the Singleton design pattern to manage a pool of database connections.

### Part 1: Implementing Singleton and Connection Pool

1. **Implement the Singleton design pattern**: Create a class that implements the `ConnectionPool` interface. Implement the Singleton design pattern within this class to ensure that only one instance of the connection pool manager can exist within the program.

2. **Implement the `getInstance(int maxConnections)` and `resetInstance()` methods**: Implement the `getInstance(int maxConnections)` method in the `ConnectionPoolSolution` class. This method should return the singleton instance of the connection pool manager class. Also, implement the `resetInstance()` method to reset the singleton instance to `null`.

### Part 2: Connection Pool Management

In connection pooling, the aim is to efficiently handle a group of database connections. This ensures optimal resource usage and effective sharing of connections across different parts of the software.

> Here's an analogy to help you understand the concept of connection pooling. Imagine a library with a large collection of books. The library has a shelf where all the books are kept. When a reader wants to borrow a book, they go to the shelf, pick up the book, and take it to a reading table. When they are done reading, they return the book to the shelf. The library keeps track of which books are available and which ones are currently being used by readers.

You have to implement the following methods:

- `void initializePool()`: This method is responsible for initializing the connection pool. It should create a fixed number of connections and add them to the pool. Use the `DummyConnection` class to create dummy connections. Store the connections in a data structure of your choice, but you will have to track which connections are available and which ones are currently in use.
- `Connection getConnection()`: This method is responsible for providing a connection to the caller. It should return a connection from the pool of available connections. Once a connection is returned, it should be marked as "unavailable" so that other parts of the software don't use it.
- `void releaseConnection(Connection connection)`: This method is responsible for releasing a connection back to the pool. It should mark the connection as "available" so that other parts of the software can use it.
- `int getAvailableConnectionsCount()`: Implement this method to count how many "available" connections remain in the pool.
- `int getTotalConnectionsCount()`: This method is about determining the total number of connections, whether they are currently in use or not.

### Instructions

1. Implement the `ConnectionPool` interface and the required methods as specified above.
2. Ensure that your implementation follows the Singleton design pattern and provides proper connection pool management.
3. Run the provided test cases in the `ConnectionPoolTest` class to verify the correctness of your implementation.
 */

 
package com.assignment.question;

public class DatabaseConnection {
}

package com.assignment.question;


public interface ConnectionPool {

    void initializePool();

    DatabaseConnection getConnection();

    void releaseConnection(DatabaseConnection connection);

    int getAvailableConnectionsCount();

    int getTotalConnectionsCount();

}


package com.assignment.question;
import java.util.Queue;
import java.util.LinkedList;

public class ConnectionPoolImpl implements ConnectionPool {

    private static ConnectionPoolImpl connectionPool = null;
    private final int maxConnections;
    private Queue<DatabaseConnection> dbQueue;

    private ConnectionPoolImpl(int maxConnections){
        this.maxConnections = maxConnections;
        this.dbQueue = new LinkedList<>();
        initializePool();
    }

    public static ConnectionPoolImpl getInstance(int maxConnections){
        if(connectionPool == null){
            synchronized(ConnectionPoolImpl.class){
                if(connectionPool == null){
                    connectionPool = new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return connectionPool;
    }

    public static void resetInstance(){
        connectionPool = null;
    }

    @Override
    public void initializePool() {
        for(int i = 0; i < maxConnections; i++){
            dbQueue.add(new DatabaseConnection());
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        return dbQueue.poll();
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        dbQueue.add(connection);
    }

    @Override
    public int getAvailableConnectionsCount() {
        return dbQueue.size();
    }

    @Override
    public int getTotalConnectionsCount() {
        return maxConnections;
    }
}

