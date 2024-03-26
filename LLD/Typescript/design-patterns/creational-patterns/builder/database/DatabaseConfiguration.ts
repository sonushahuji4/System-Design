import { DatabaseConfigurationBuilder } from "./DatabaseConfigurationBuilder";

export class DatabaseConfiguration{
    private databaseUrl: string;
    private username: string;
    private password: string;
    private maxConnection: number;
    private enableCache: boolean;
    private isReadOnly: boolean;

    constructor(builder: DatabaseConfigurationBuilder){
        this.databaseUrl = builder.getDatabaseUrl();
        this.username = builder.getUsername();
        this.password = builder.getPassword();
        this.maxConnection = builder.getMaxConnection();
        this.enableCache = builder.getIsEnableCache();
        this.isReadOnly = builder.getIsReadOnly();
    }
}