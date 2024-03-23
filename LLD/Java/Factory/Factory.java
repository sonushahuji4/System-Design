
/**
 * 1. Shape is a interface, which has a method draw()
 * 2. subclasses like circle, rectangle, square implements the Shape interface and defines the draw() method or function inside the class
 * 3. I need to create an object based on some condition
 * /*/
 

/** Factory Method Examples  */

public Shape interface {
    draw();
}

public class Circle implements Shape {
    public void draw(){
        System.out.println("Cirlce object");
    }
}

public class Rectangle implements Shape {
    public void draw(){
        System.out.println("Rectangle object");
    }
}

public class Square implements Shape {
    public void draw(){
        System.out.println("Square object");
    }
}

public class ShapeFactory {
    Shape getShape(String input){
        switch(input){
            case "CIRCLE":
                return new Circle();
            
            case "RECTANGLE":
                return new Rectangle();
            
            case "SQUARE":
                return new Square();
            
            default: return null;
        }
    }
}
