import { QueryBuilder } from "./query-builder";

// {}
export class Builder {
    private select: string = "";
    private from: string = "";
    private where: string = "";
    private join: string = "";
    private orderBy: string = "";
    private groupBy: string = "";

    private constructor(){}

    // setter
    public setSelect(select: string): Builder{
        this.select = select;
        return this;
    }

    public setFrom(from: string): Builder{
        this.from = from;
        return this;
    }

    public setWhere(where: string): Builder{
        this.where = where;
        return this;
    }

    public setJoin(join: string): Builder{
        this.join = join;
        return this;
    }

    public setOrderBy(orderBy: string): Builder{
        this.orderBy = orderBy;
        return this;
    }

    public setGroupBy(groupBy: string): Builder{
        this.groupBy = groupBy;
        return this;
    }
   
    // getter
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

    public static builder(): Builder{
        return new Builder();
    }

    public build(): QueryBuilder {
        return new QueryBuilder(this);
    }
}