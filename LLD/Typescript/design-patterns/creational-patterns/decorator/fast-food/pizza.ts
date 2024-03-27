export class Pizza implements MenuItem {
    
    cost = 200;

    getDescription(): void {
        console.log("Pizza item is added")
    }

    getCost(): number {
        return this.cost;
    }
}