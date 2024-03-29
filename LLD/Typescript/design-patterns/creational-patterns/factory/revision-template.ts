// Step One
interface Shape{
    draw(): void;
}

// Step Two
class Circle implements Shape {
    public draw(): void{
        console.log("Cirlce object");
    }
}

class Rectangle implements Shape {
    public draw(): void{
        console.log("Rectangle object");
    }
}

class Square implements Shape {
    public draw(): void{
        console.log("Square object");
    }
}


// Step Three
class ShapeFactory{
    static getShape(input: string): Shape | null{
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


// Step Four
const circle = ShapeFactory.getShape("CIRCLE");
const rectangle = ShapeFactory.getShape("RECTANGLE");
const square = ShapeFactory.getShape("SQUARE");