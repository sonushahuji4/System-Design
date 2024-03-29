// Step One
class User{
    private name: string;

    constructor(builder: Builder){
        this.name = builder.getName();
    }

    public getName():String{
        return this.name;
    } 
}
// Step 2
class Builder{
    private name: string;

    private constructor(){
        this.name = "";
    }

    public setName(name: string){
        this.name = name;
        return this;
    }

    public getName():string{
        return this.name;
    }

    public static builder(): Builder{
        return new Builder();
    }

    public build(): User{
        return new User(this);
    }
}

// Step Three
const user = Builder.builder()
                .setName("Sonu")
                .build();
console.log("User :",user);