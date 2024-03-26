export enum UserType {
    ADMIN,
    READER,
    WRITER
}

interface ClonableObject<T> {
    cloneObject(): T;
}

export class User implements ClonableObject<User> {
    private userId: number;
    private username: string;
    private email: string;
    private displayName: string;
    private age: number;
    private type: UserType;

    constructor(userId: number, username: string, email: string, displayName: string, age: number, type: UserType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.age = age;
        this.type = type;
    }

    public getUserId(): number {
        return this.userId;
    }

    public getUsername(): string {
        return this.username;
    }

    public getEmail(): string {
        return this.email;
    }

    public getDisplayName(): string {
        return this.displayName;
    }

    public getAge(): number {
        return this.age;
    }

    public getType(): UserType {
        return this.type;
    }

    public cloneObject(): User {
        return new User(this.userId, this.username, this.email, this.displayName, this.age, this.type);
    }
}

