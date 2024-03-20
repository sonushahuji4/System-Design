/** 
 * Prototype
 * The prototype pattern is a creational design pattern that can be used to create objects that are similar to each other. 
 * The pattern is used to avoid the cost of creating new objects by cloning an existing object and avoiding dependencies on the class of the object that needs to be cloned.
 * Prototype allows us to hide the complexity of making new instances from the client. 
 * The concept is to copy an existing object rather than creating a new instance from scratch, something that may include costly operations. The existing object acts as a prototype and contains the state of the object. The newly copied object may change same properties only if required. 
 * This approach saves costly resources and time, especially when object creation is a heavy process.
 */

/** Idea to use
 * /** Idea to Use
 * Suppose you have a task that involves fetching data from a database and then performing some heavy processing which takes more than 10 minutes.
 * Once it is processed and gives you the output.
 * This task is used in 4 different places, with this function or method being called at each place providing the same details.
 * Every time you call the method or function at each place, it takes time to process the task.
 * This operation is time-consuming and expensive.
 * To resolve this issue, we can make use of the Prototype Design Pattern, which will help you clone the data and provide it wherever it is needed instead of processing the task each time.
 */

 Student originalStudent = new Student("name","age","batch");
 Student copyStudent = new Student();
 copyStudent.setName();
 copyStudent.setAge();
 copyStudent.setBatch();

 /** Disadvantages
  * 1. Client needs to know about all the attibutes of the students. (Tightly coupled)
  * 2. Student might have private attribute which is not accesible from outside the class.
  * 3. If new attribute is added or removed, multple places changes would be needed.
  */

/** Solution
 * 1.Give the responsibility of copy the object to the object itself.
 */

public interface Prototype<T>{
    T clone();
}  

public class BlackSheep implements Prototype<Sheep>{
    private String name;

    public BlackSheep(String name){
        this.name = name;
    }

    public Sheep clone() {
        return new BlackSheep(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Sheep blackSheep = new BlackSheep("black-sheep");

        Sheep cloneBlackSheep = blackSheep.clone();
        cloneBlackSheep.setName("Cloned-Black-Sheep");
    }
}

/** Links: 
 * 1. https://medium.com/@thecodebean/prototype-design-pattern-implementation-in-java-b4b900f1ad9a
 * 2. https://refactoring.guru/design-patterns/prototype
 *  */

/** Prototype Registry
 * The prototype pattern can be extended to use a registry of pre-defined prototypes. 
 * The registry can be used to store a set of pre-defined prototypes. The client code can then request a clone of a prototype from the registry instead of creating a new object from scratch. 
 * The registry can be implemented as a key-value store where the key is the name of the prototype and the value is the prototype object.
 */

 /** Examples
  * For example, we might want to create different types of users. 
  * A user with a Student role, a user with a Teacher role, and a user with an Admin role. 
  * Each such different type of user might have some fields that are specific to the type so the fields to be copied might be different. 
  * We can create a registry of pre-defined prototypes for each of these roles.
  */


interface UserRegistry {
    User getPrototype(UserRole role);
    void addPrototype(UserRole role, User user);
}

// Now we can implement the UserRegistry interface and store the pre-defined prototypes in a map.

class UserRegistryImpl implements UserRegistry {
    private Map<UserRole, User> registry = new HashMap<>();

    @Override
    public User getPrototype(UserRole role) {
        return registry.get(role).clone();
    }

    @Override
    public void addPrototype(UserRole role, User user) {
        registry.put(role, user);
    }
}

// The client code can request a prototype from the registry, clone it, and modify it as per its needs.

UserRegistry registry = new UserRegistryImpl();
registry.addPrototype(UserRole.STUDENT, new Student("John", "Doe", "john@doe.in", "1234567890", UserRole.STUDENT, "CS"));

User user = registry.getPrototype(UserRole.STUDENT);
user.setId(1);