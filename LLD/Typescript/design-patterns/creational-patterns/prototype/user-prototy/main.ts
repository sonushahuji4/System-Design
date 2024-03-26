import { User, UserType } from "./user ";
import { UserPrototypeRegistryImpl } from "./user-prototype-registry-Impl";


// Creating prototype users
const adminUser = new User(1, "admin", "admin@example.com", "Admin User", 30, UserType.ADMIN);
const readerUser = new User(2, "reader", "reader@example.com", "Reader User", 25, UserType.READER);
const writerUser = new User(3, "writer", "writer@example.com", "Writer User", 28, UserType.WRITER);

// Creating registry
const registry = new UserPrototypeRegistryImpl();

// Adding prototypes to the registry
registry.addPrototype(adminUser);
registry.addPrototype(readerUser);
registry.addPrototype(writerUser);

// Cloning users from the registry
const clonedAdminUser = registry.clone(UserType.ADMIN);
const clonedReaderUser = registry.clone(UserType.READER);
const clonedWriterUser = registry.clone(UserType.WRITER);

// Checking cloned users
console.log("Cloned Admin User:", clonedAdminUser);
console.log("Cloned Reader User:", clonedReaderUser);
console.log("Cloned Writer User:", clonedWriterUser);
