package model.core;

import java.util.HashMap;
import java.util.Map;

import model.InvoiceModel;

public class InvoicesImpl implements InvoicesModel {

    private Map<Integer,InvoiceModel> invoices = new HashMap<Integer,InvoiceModel>();
    
    public void updateInvoices(Map<Integer,InvoiceModel> invoices){
        this.invoices = invoices;
    }
    public void addNewInvoice(InvoiceModel invoice){
        this.invoices.put(this.invoices.size()+1, invoice);
    }
    public Map<Integer,InvoiceModel> getInvoices(){
        return this.invoices;
    }
}
