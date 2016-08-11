package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InvoiceImpl implements InvoiceModel {

    private Map<Integer,BookModel> receipt = new HashMap<Integer,BookModel>();
    private double total = 0;
    private Date date ;
    private String address;
   
    public InvoiceImpl(){
        
    }
    @Override
    public Map<Integer, BookModel> getReceipt() {
       return this.receipt;
    }

    @Override
    public double getTotal() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Date getDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAddress() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAddress(String address) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDate(Date date) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addItem(BookModel book) {
        // TODO Auto-generated method stub

    }

}
