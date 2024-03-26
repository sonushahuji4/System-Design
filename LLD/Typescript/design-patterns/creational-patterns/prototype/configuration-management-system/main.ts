import { Configuration, ConfigurationType } from "./configuration";
import { ConfigurationPrototypeRegistryImpl } from "./configuration-prototype-registryImpl";


// Creating prototype configurations
const basicConfig = new Configuration("blue", true, "English", false, 12, "Arial", ConfigurationType.BASIC);
const advancedConfig = new Configuration("green", false, "Spanish", true, 14, "Times New Roman", ConfigurationType.ADVANCED);

// Creating registry
const registry = new ConfigurationPrototypeRegistryImpl();

// Adding prototypes to the registry
registry.addPrototype(basicConfig);
registry.addPrototype(advancedConfig);

// Cloning configurations from the registry
const clonedBasicConfig = registry.clone(ConfigurationType.BASIC);
const clonedAdvancedConfig = registry.clone(ConfigurationType.ADVANCED);

// Checking cloned configurations
console.log("Cloned Basic Configuration:", clonedBasicConfig);
console.log("Cloned Advanced Configuration:", clonedAdvancedConfig);
