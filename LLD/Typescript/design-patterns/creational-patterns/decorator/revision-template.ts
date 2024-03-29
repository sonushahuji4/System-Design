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

        
