import { Builder } from "./builder";

const query = Builder.builder()
                .setSelect("columnName")
                .setFrom("tableName")
                .setWhere("condition")
                .setJoin("tableName")
                .setOrderBy("columnName")
                .setGroupBy("columnName")
                .build();

console.log("query :",query);