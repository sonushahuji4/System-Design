import { Invoice, InvoiceType } from "./invoice";


export interface InvoicePrototypeRegistry {
    addPrototype(invoice: Invoice): void;
    getPrototype(type: InvoiceType): Invoice;
    clone(type: InvoiceType): Invoice;
}

export class InvoiceRegistryImpl implements InvoicePrototypeRegistry {
    private invoices: Map<InvoiceType, Invoice> = new Map();

    // The addPrototype method is used to add an invoice to the registry
    public addPrototype(invoice: Invoice): void {
        this.invoices.set(invoice.getType(), invoice);
    }

    // The getPrototype method is used to get an invoice from the registry
    public getPrototype(type: InvoiceType): Invoice {
        const invoice = this.invoices.get(type);
        if (invoice) {
            return invoice;
        } else {
            throw new Error(`Invoice with type ${type} not found.`);
        }
    }

    // The clone method is used to clone an invoice from the registry
    public clone(type: InvoiceType): Invoice {
        const invoice = this.invoices.get(type);
        if (invoice) {
            return invoice.cloneObject();
        } else {
            throw new Error(`Invoice with type ${type} not found.`);
        }
    }
}