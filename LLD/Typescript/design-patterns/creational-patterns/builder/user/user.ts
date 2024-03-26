import { Builder } from "./builder";

export class User{
    private name: string;

    constructor(builder: Builder){
        this.name = builder.getName();
    }

    public getName():String{
        return this.name;
    } 
}