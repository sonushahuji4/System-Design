// Step One
enum UserType {
    ADMIN,
    READER,
    WRITER 
}

// Step Two
interface Prototype<T>{
    clone(): T;
}

// Step Three
class User implements Prototype<User>{
    private email: string;
    private type: UserType;

    constructor(email: string, type: UserType){
        this.email = email;
        this.type = type;
    }

    public getType():UserType{
        return this.type
    }

    public clone():User{
        return new User(this.email, this.type);
    }
}

//  Step Four
interface ProtoTypeRegistory{
    addProtoType(user:User): void;
    getProtoType(type:UserType): User;
    clone(type:UserType):User;
}

// Step Five
class Registory implements ProtoTypeRegistory{
    private users: Map<UserType,User> = new Map();

    addProtoType(user: User): void {
        this.users.set(user.getType(),user);
    }

    getProtoType(type: UserType): User {
        const specificUser = this.users.get(type);;
        if (specificUser) {
            return specificUser;
        } else {
            throw new Error(`Users with type ${type} not found.`);
        }
    }
    clone(type: UserType): User {
        const specificUser = this.users.get(type);
        if (specificUser) {
            return specificUser.clone();
        } else {
            throw new Error(`Users with type ${type} not found.`);
        }
    }

}

// Step Six
const adminUser = new User("admin@example.com", UserType.ADMIN);
const readerUser = new User("reader@example.com", UserType.READER);
const writerUser = new User("writer@example.com", UserType.WRITER);

const registry = new Registory();
registry.addProtoType(adminUser);
registry.addProtoType(readerUser);
registry.addProtoType(writerUser);

const clonedAdminUser = registry.clone(UserType.ADMIN);
const clonedReaderUser = registry.clone(UserType.READER);
const clonedWriterUser = registry.clone(UserType.WRITER);