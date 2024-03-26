import { User, UserType } from "./user ";

interface UserPrototypeRegistry {
    addPrototype(user: User): void;
    getPrototype(type: UserType): User;
    clone(type: UserType): User;
}

export class UserPrototypeRegistryImpl implements UserPrototypeRegistry {
    private users: Map<UserType, User> = new Map();

    // The addPrototype method is used to add a user to the registry
    public addPrototype(user: User): void {
        this.users.set(user.getType(), user);
    }

    // The getPrototype method is used to get a user from the registry
    public getPrototype(type: UserType): User {
        const users = this.users.get(type);;
        if (users) {
            return users;
        } else {
            throw new Error(`Users with type ${type} not found.`);
        }
    }

    // The clone method is used to clone a user from the registry
    public clone(type: UserType): User {
        const users = this.users.get(type);
        if (users) {
            return users.cloneObject();
        } else {
            throw new Error(`Users with type ${type} not found.`);
        }
    }
}
