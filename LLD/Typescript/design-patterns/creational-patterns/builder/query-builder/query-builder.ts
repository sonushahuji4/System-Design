import { Builder } from "./builder";

export class QueryBuilder {
    private select: string;
    private from: string;
    private where: string;
    private join: string;
    private orderBy: string;
    private groupBy: string;

    constructor(builder: Builder) {
        this.select = builder.getSelect();
        this.from = builder.getFrom();
        this.where = builder.getWhere();
        this.join = builder.getJoin();
        this.orderBy = builder.getOrderBy();
        this.groupBy = builder.getGroupBy();
    }
}