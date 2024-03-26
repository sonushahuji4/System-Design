enum ConfigurationType {
    BASIC,
    ADVANCED,
    CUSTOM,
    DEFAULT
}

interface ClonableObject<T> {
    cloneObject(): T;
}

class Configuration implements ClonableObject<Configuration> {
    private themeColor: string;
    private autoSave: boolean;
    private language: string;
    private darkMode: boolean;
    private fontSize: number;
    private fontFamily: string;
    private type: ConfigurationType;

    constructor(themeColor: string, autoSave: boolean, language: string, darkMode: boolean, fontSize: number, fontFamily: string, type: ConfigurationType) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;
    }

    public cloneObject(): Configuration {
        return new Configuration(this.themeColor, this.autoSave, this.language, this.darkMode, this.fontSize, this.fontFamily, this.type);
    }

    public getType(): ConfigurationType {
        return this.type;
    }
}

export { Configuration, ConfigurationType};