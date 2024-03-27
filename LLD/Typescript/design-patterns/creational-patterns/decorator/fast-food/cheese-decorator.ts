// {}
export class CheeseDecorator implements MenuItem{

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