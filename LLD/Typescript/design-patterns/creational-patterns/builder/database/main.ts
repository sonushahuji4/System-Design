import { DatabaseConfigurationBuilder } from "./DatabaseConfigurationBuilder";

const databaseConfiguration = DatabaseConfigurationBuilder.builder()
                                .setDatabaseUrl("http:localhost/")
                                .setUsername("database")
                                .setPassword("password")
                                .setMaxConnection(10)
                                .setIsEnableCache(true)
                                .setIsReadOnly(true)
                                .build();

console.log("databaseConfiguration :",databaseConfiguration);