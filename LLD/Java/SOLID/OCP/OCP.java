/**
 * The Open/Closed Principle states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. 
 * This means that the behavior of a module should be extendable without modifying its source code.
 */

 /** Exaple One */

public class Shape {
    public double area() {
        return 0; // Default implementation for unknown shapes
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

/**
 * Shape class is the base or the parent class, it has a method area()
 * When shape class is extended in the sub-class then sub class has to implement all it's methods
 * Now suppose if you add another method in base class "Shape", all it's child class which has extended the base class to implement that method.
 * This Violates the open clossed priciple.
 * 
 * 3. Solve the Issue:
 * 2. Identify the Issue:
The issue with this implementation is that if we need to add a new shape, such as a triangle, 
we would have to modify the Shape class to include the area calculation for the triangle. 
This violates the Open/Closed Principle because the Shape class is not closed for modification.
 */

 /**
To address the issue, we can apply the Open/Closed Principle by introducing an abstraction layer using interfaces.
  */

public interface Shape {
    double area();
}

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

/** 
 * 4. Perfect Solution:
In this perfect solution, the Shape interface is open for extension, as we can easily add new shapes by implementing this interface without modifying existing code.
 */
public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

/**
 * Explanation:

We introduced the Shape interface to define the behavior of shapes.
Each shape class (Circle, Rectangle, Triangle) implements the Shape interface and provides its specific implementation of the area() method.
When we need to add a new shape (in this case, Triangle), we simply create a new class that implements the Shape interface without modifying existing code. 
This adheres to the Open/Closed Principle, as the Shape interface is open for extension but closed for modification.
 */


 /** Conclusion
  * 
  After going through this concept, I've understood that in order to comply with the Open/Closed Principle, 
  one should not define methods in the base class. Instead, interfaces should be used for it
  */


  /** Good And Easy Article to read on this topic */
  /** Link : https://h-benkachoud.medium.com/ocp-open-closed-principle-ecc2ce89bf7f */