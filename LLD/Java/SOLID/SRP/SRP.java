/** 
 * Single Responsibility Principle (SRP):
 * The Single Responsibility Principle states that a class should have only one reason to change
 * In other words, a class should have only one responsibility or should be concerned with only one aspect of the software's functionality. */

 /** Example 1 */
 /**
  * This class violates the SRP because it has two responsibilities: reading and writing files.
  * If there's a change in how files are read or written, we'll have to modify this class, which goes against the principle. */

 public class FileManager {

    public void readFile(String fileName) {
       
    }
    
    public void writeFile(String fileName, String data) {
       
    }
}

/** 
 * Now, each class has only one responsibility: FileReader reads files, and FileWriter writes files. 
 * This adheres to the Single Responsibility Principle because if there are changes in how files are read or written, we only need to modify the respective class.
*/
public class FileRead {

    public void readFile(String fileName) {
       
    }
}

public class FileWriter {

    public void writeFile(String fileName, String data) {
       
    }
}

/** Example 2 */

/**
 * Certainly! Let's consider a real-world scenario of managing employees in a company. 
 * We'll start with a class that violates the Single Responsibility Principle, and then refactor it to adhere to SRP.
 */

 class Employee {

    private String name;
    private String department;
    private double salary;

    // Methods for different responsibilities mixed together
    public void calculateSalary() {
        // Calculate salary logic
    }

    public void saveToDatabase() {
        // Save employee to database logic
    }

    public void generateReport() {
        // Generate employee report logic
    }
}

/**
 * In the above example, the Employee class has multiple responsibilities: 
 * calculating salary, saving to the database, and generating a report. 
 * This violates SRP because if any of these responsibilities change, the Employee class will need to be modified.
 */

 class Employee {
    private String name;
    private String department;
    private double salary;

    // Getters and setters for name, department, salary

    // Other methods specific to employee management
}

class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        // Calculate salary logic
        return employee.getSalary();
    }
}

class DatabaseManager {
    public void saveToDatabase(Employee employee) {
        // Save employee to database logic
    }
}

class ReportGenerator {
    public void generateReport(Employee employee) {
        // Generate employee report logic
    }
}

/**
 * In this refactored version:
 * Employee class is responsible only for managing employee data.
 * SalaryCalculator class is responsible for calculating the salary of an employee.
 * DatabaseManager class is responsible for saving an employee to the database.
 * ReportGenerator class is responsible for generating a report for an employee.
 * Each class has a single responsibility and will change only if that particular aspect of the system changes. 
 * This adheres to the Single Responsibility Principle, making the code easier to understand, maintain, and extend.
 */


 /** Quesition that comes in my mind is that, so each class will have one method or function ? */

 /**
  * No, that's not what I'm saying. The Single Responsibility Principle (SRP) states that a class should have only one reason to change, not necessarily only one method or function. 
  * A class can have multiple methods or functions as long as they are all related to the same responsibility. However, if a class starts accumulating methods or functions that handle different responsibilities, it violates the SRP.
  * For example, in the refactored example above, each class (`SalaryCalculator`, `DatabaseManager`, `ReportGenerator`) has multiple methods, but all of these methods are related to a single responsibility. The `SalaryCalculator` class deals with salary calculation, the `DatabaseManager` class deals with database operations, and the `ReportGenerator` class deals with report generation. So, each class adheres to the SRP. 
  * The key is to ensure that each class has a clear and focused responsibility, and its methods or functions are all related to that responsibility. This helps in making the code more modular, maintainable, and easier to understand.
  */

  /**
   * Here, we have three methods: saveEmployeeToDatabase, updateEmployeeInDatabase, and deleteEmployeeFromDatabase. 
   * All these methods are responsible for performing different database operations related to employee management.
   * Each of the methods saveEmployee, updateEmployee, and deleteEmployee are indeed different methods. However, they are all related to the same responsibility, which is managing employees in the database.
   * In other words, the responsibility of the EmployeeDatabaseManager class is to handle database operations specifically related to employees, such as saving, updating, and deleting employee records. 
   * Each method within this class serves this single responsibility, thus adhering to the Single Responsibility Principle (SRP).
   */

  class DatabaseManager {

    public void saveEmployeeToDatabase(Employee employee) {
        // Save employee details to the database
    }

    public void updateEmployeeInDatabase(Employee employee) {
        // Update employee details in the database
    }

    public void deleteEmployeeFromDatabase(Employee employee) {
        // Delete employee details from the database
    }
}


/** Example 3 */

public class Bird {
    public String type;
    public Integer wings;
    public String colour;
    public String name;

    public void fly() {

    }

    public void eat() {

    }

    public void makeSound(String type){
        if(type == "pigeon"){

        } else if(type == "parrot"){

        } else if(type == "cukoo"){

        } //... imagine having different 1000 times typef of birds., in that case 1000 if else statement would be there
    }
}
/**
 * Not easy to read and understand, since if else statement could be more than 1000 etc, maintaining would be very difficult
 * No readibility
 * Complex Texting
 * It violates SRP principles
 */


 /** How To Identify if it Violates SRP
  * 1. Methods having too many if else statments, Exceptions : When if-else statment is a part of algo or a part of business logic.
  * 2. Methods performing more than it names suggests, getUserFromDb -> validateUser(), ConnectToDb(), CheckIfUserExist(), FetchUserFromDb() etc
  */

  /** Version One */

  public class Bird {
    public abstract void fly();
    public abstract void makeSound();
  }

  /** here, have one base class and then for each bird class extend base class and implements it's method since each bird will have it's own way of making fly and sound etc */

  public class Pigeon extends Bird {
    public void fly(){}
    public void makeSound(){}
  }

  public class Kukoo extends Bird {
    public void fly(){}
    public void makeSound(){}
  }

  /** each sub class has to implement all the methods of parent or base class
   * Pigeon cannot fly but kukoo can fly.
   * why do implement the fly() method in Pigeon class ? that's why interface comes in the picture
   */


   /** Above issue is beign solved using Interface */

   /**
    * Sure, let's refactor the `Bird` class to better adhere to the Single Responsibility Principle (SRP) based on these attributes and actions:

```java
public class Bird {
    private String name;
    private boolean hasWings;
    private String color;
    
    public Bird(String name, boolean hasWings, String color) {
        this.name = name;
        this.hasWings = hasWings;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean hasWings() {
        return hasWings;
    }
    
    public String getColor() {
        return color;
    }
}

public interface Flyable {
    void fly();
}

public interface Swimmable {
    void swim();
}

public interface Walkable {
    void walk();
}

public interface Singable {
    void sing();
}

public class Eagle extends Bird implements Flyable, Walkable {
    public Eagle(String name, String color) {
        super(name, true, color);
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }

    @Override
    public void walk() {
        System.out.println("Eagle is walking");
    }
}

public class Penguin extends Bird implements Swimmable, Walkable {
    public Penguin(String name, String color) {
        super(name, false, color);
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    public void walk() {
        System.out.println("Penguin is walking");
    }
}
```

In this refactored version:

- The `Bird` class only contains attributes related to birds (name, hasWings, color) and basic getters.
- We introduce separate interfaces (`Flyable`, `Swimmable`, `Walkable`, `Singable`) to represent different actions that birds can perform.
- Concrete bird classes (`Eagle`, `Penguin`) extend the `Bird` class and implement the relevant interfaces based on their capabilities.
- Each concrete bird class is responsible for implementing specific actions it can perform, adhering to SRP.

This refactoring adheres to SRP by separating concerns and ensuring that each class and interface has a single responsibility. 
The `Bird` class focuses on representing bird attributes, 
while concrete bird classes and interfaces handle specific behaviors related to flying, swimming, walking, and singing.
    */

public class Bird {

    private String name;
    private boolean hasWings;
    private String color;
    
    public Bird(String name, boolean hasWings, String color) {
        this.name = name;
        this.hasWings = hasWings;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean hasWings() {
        return hasWings;
    }
    
    public String getColor() {
        return color;
    }
}

public interface Flyable {
    void fly();
}

public interface Swimmable {
    void swim();
}

public interface Walkable {
    void walk();
}

public interface Singable {
    void sing();
}

public class Eagle extends Bird implements Flyable, Walkable {
    public Eagle(String name, String color) {
        super(name, true, color);
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }

    @Override
    public void walk() {
        System.out.println("Eagle is walking");
    }
}

public class Penguin extends Bird implements Swimmable, Walkable {
    public Penguin(String name, String color) {
        super(name, false, color);
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    public void walk() {
        System.out.println("Penguin is walking");
    }
}

/** Good Article To Read On This Topic */
/** Link : https://h-benkachoud.medium.com/srp-single-responsability-principle-a19cfe02d3ed */