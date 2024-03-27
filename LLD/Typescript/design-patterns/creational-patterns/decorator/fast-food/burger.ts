export class Burger implements MenuItem {
    
    cost = 100;

    getDescription(): void {
        console.log("Burger item is added")
    }

    getCost(): number {
        return this.cost;
    }
}