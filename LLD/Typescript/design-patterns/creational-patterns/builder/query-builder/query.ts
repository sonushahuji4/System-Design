/**
 * This is the query class, understand this class and design it using builder design pattern.
 */

export class Query {
    private select: string;
    private from: string;
    private where: string;
    private join: string;
    private orderBy: string;
    private groupBy: string;

    constructor(select: string, from: string, where: string, join: string, orderBy: string, groupBy: string) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.join = join;
        this.orderBy = orderBy;
        this.groupBy = groupBy;
    }

    public getSelect(): string {
        return this.select;
    }

    public getFrom(): string {
        return this.from;
    }

    public getWhere(): string {
        return this.where;
    }

    public getJoin(): string {
        return this.join;
    }

    public getOrderBy(): string {
        return this.orderBy;
    }

    public getGroupBy(): string {
        return this.groupBy;
    }
}
