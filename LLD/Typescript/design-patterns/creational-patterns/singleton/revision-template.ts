/** Template One */
class Singleton {
    
    /**
     * private : Making instance private ensuring that it can only be accessed with Singleton class itself.
     * static : Making instance static means it belongs to class itself rather than instances of the classes.  This ensures that there is only one instance of "instance" shared across all instances of the class
     */
    private static instance: Singleton;

    /**
     * private : Making the constructor "private" prevents instantiation of the class from outside.
     */
    private constructor() {}


    public static getInstance(): Singleton {
        if(!Singleton.instance){
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
}

/** Template Two (Early Loading) */
class DatabaseConnection{
    private static instance = new DatabaseConnection();
    private constructor() {};
    public static getInstance(): DatabaseConnection {
        return DatabaseConnection.instance;
    }
}

/** Template Three */
class DatabaseConnection{
    private static instance : DatabaseConnection;
    private constructor(){};
    public static getInstance(): DatabaseConnection{
        if(!DatabaseConnection.instance){
            DatabaseConnection.instance = new DatabaseConnection();
        }
        return DatabaseConnection.instance;
    }
}

/** Template Four (Take care of "synchronized" ) */
class DatabaseConnection {
    private static instance: DatabaseConnection;
    private constructor() {}
    public static getInstance(): DatabaseConnection {
        if (!DatabaseConnection.instance) {
            synchronized (DatabaseConnection.class) {
                if (!DatabaseConnection.instance) {
                    DatabaseConnection.instance = new DatabaseConnection();
                }
            }
        }
        return DatabaseConnection.instance ;
    }
}