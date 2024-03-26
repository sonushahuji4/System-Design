import { Configuration, ConfigurationType } from "./configuration";

interface ConfigurationPrototypeRegistry {
    addPrototype(configuration: Configuration): void;
    getPrototype(type: ConfigurationType): Configuration;
    clone(type: ConfigurationType): Configuration;
}

class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {
    private configurations: Map<ConfigurationType, Configuration> = new Map();

    public addPrototype(configuration: Configuration): void {
        this.configurations.set(configuration.getType(), configuration);
    }

    public getPrototype(type: ConfigurationType): Configuration {
        const configuration = this.configurations.get(type);
        if (configuration) {
            return configuration;
        } else {
            throw new Error(`Configuration with type ${type} not found.`);
        }
    }

    public clone(type: ConfigurationType): Configuration {
        const configuration = this.configurations.get(type);
        if (configuration) {
            return configuration.cloneObject();
        } else {
            throw new Error(`Configuration with type ${type} not found.`);
        }
    }
}

export { ConfigurationPrototypeRegistry, ConfigurationPrototypeRegistryImpl };