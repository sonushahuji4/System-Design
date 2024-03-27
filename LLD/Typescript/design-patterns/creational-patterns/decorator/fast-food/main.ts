import { Burger } from "./burger";
import { CheeseDecorator } from "./cheese-decorator";
import { PaneerDecorator } from "./paneer-decorator";
import { Pizza } from "./pizza";



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

// INotifier notifier = new SMSNotifier(
//                         new EmailNotifier(
//                             new Notifier()));

        
