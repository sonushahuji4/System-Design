import { User } from "./user";

// Step 1
export class Builder{
    
    // Step 2
    private name: string;

    // Step 3
    private constructor(){
        this.name = "";
    }

    // Step 4
    public setName(name: string){
        this.name = name;
        return this;
    }

    public getName():string{
        return this.name;
    }

    // Step 5
    public static builder(): Builder{
        return new Builder();
    }

    // Step 6
    public build(): User{
        return new User(this);
    }
}