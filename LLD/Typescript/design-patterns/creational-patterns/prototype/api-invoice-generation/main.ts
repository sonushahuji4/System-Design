import { Invoice, InvoiceType } from "./invoice";
import { InvoiceRegistryImpl } from "./invoice-registry-Impl";

// Creating prototype invoices
const salesInvoice = new Invoice(1, "John Doe", 100.0, "Credit Card", InvoiceType.SALES);
const purchaseInvoice = new Invoice(2, "Jane Smith", 200.0, "PayPal", InvoiceType.PURCHASE);

// Creating registry
const registry = new InvoiceRegistryImpl();

// Adding prototypes to the registry
registry.addPrototype(salesInvoice);
registry.addPrototype(purchaseInvoice);

// Cloning invoices from the registry
const clonedSalesInvoice = registry.clone(InvoiceType.SALES);
const clonedPurchaseInvoice = registry.clone(InvoiceType.PURCHASE);

// Checking cloned invoices
console.log("Cloned Sales Invoice:", clonedSalesInvoice);
console.log("Cloned Purchase Invoice:", clonedPurchaseInvoice);
