import { DatabaseConfiguration } from "./DatabaseConfiguration";

export class DatabaseConfigurationBuilder{
    
    private databaseUrl: string;
    private username: string;
    private password: string;
    private maxConnection: number;
    private enableCache: boolean;
    private isReadOnly: boolean;

    private constructor(){
        this.databaseUrl = "";
        this.username = "";
        this.password = "";
        this.maxConnection = 4;
        this.enableCache = false;
        this.isReadOnly = false;
    }

    // Setter
    public setDatabaseUrl(databaseUrl: string): DatabaseConfigurationBuilder {
        this.databaseUrl = databaseUrl;
        return this;
    }

    public setUsername(username: string): DatabaseConfigurationBuilder {
        this.username = username;
        return this;
    }

    public setPassword(password: string): DatabaseConfigurationBuilder {
        this.password = password;
        return this;
    }

    public setMaxConnection(maxConnection: number): DatabaseConfigurationBuilder {
        this.maxConnection = maxConnection;
        return this;
    }

    public setIsEnableCache(enableCache: boolean): DatabaseConfigurationBuilder {
        this.enableCache = enableCache;
        return this;
    }

    public setIsReadOnly(isReadOnly: boolean): DatabaseConfigurationBuilder {
        this.isReadOnly = isReadOnly;
        return this;
    }

    // getter
    public getDatabaseUrl(): string {
        return this.databaseUrl;
    }

    public getUsername(): string {
        return this.username;
    }

    public getPassword(): string {
        return this.password;
    }

    public getMaxConnection(): number {
        return this.maxConnection;
    }

    public getIsEnableCache(): boolean {
        return this.enableCache;
    }

    public getIsReadOnly(): boolean {
        return this.isReadOnly;
    }

    public static builder():DatabaseConfigurationBuilder{
        return new DatabaseConfigurationBuilder();
    }

    public build(): DatabaseConfiguration{
        return new DatabaseConfiguration(this);
    }
}