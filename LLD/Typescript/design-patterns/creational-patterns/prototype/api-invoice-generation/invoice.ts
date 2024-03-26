export enum InvoiceType {
    SALES,
    PURCHASE,
    SERVICE
}


interface ClonableObject<T> {
    cloneObject(): T;
}

export class Invoice implements ClonableObject<Invoice> {
    private invoiceId: number;
    private customerName: string;
    private amount: number;
    private paymentMethod: string;
    private type: InvoiceType;

    constructor(invoiceId: number, customerName: string, amount: number, paymentMethod: string, type: InvoiceType) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.type = type;
    }

    public getInvoiceId(): number {
        return this.invoiceId;
    }

    public getCustomerName(): string {
        return this.customerName;
    }

    public getAmount(): number {
        return this.amount;
    }

    public getPaymentMethod(): string {
        return this.paymentMethod;
    }

    public getType(): InvoiceType {
        return this.type;
    }

    public cloneObject(): Invoice {
        return new Invoice(this.invoiceId, this.customerName, this.amount, this.paymentMethod, this.type);
    }
}