package model.core;

import java.util.Map;

import model.InvoiceModel;

public interface InvoicesModel {

    public void updateInvoices(Map<Integer,InvoiceModel> invoices);
    public void addNewInvoice(InvoiceModel invoice);
    public Map<Integer,InvoiceModel> getInvoices();
}
