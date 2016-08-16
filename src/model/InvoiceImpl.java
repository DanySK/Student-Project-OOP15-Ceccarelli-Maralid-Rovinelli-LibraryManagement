package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class InvoiceImpl implements InvoiceModel ,Serializable{

    private static final long serialVersionUID = 1L;
    private Map<Integer,BookModel> receipt;
    private double total = 0;
    private Date date ;
    private String address;
   
    public InvoiceImpl(){
        receipt = new HashMap<Integer,BookModel>(); 
    }
    public InvoiceImpl(Map<Integer,BookModel> list,double total,Date date,String address){
      this.receipt = list;
      this.total = total;
      this.date = date;
      this.address = address;
    }
    @Override
    public Map<Integer, BookModel> getReceipt() {
       return this.receipt;
    }

    @Override
    public double getTotal() {
        Iterator<Entry<Integer,BookModel>> it = receipt.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,BookModel> book = (Entry<Integer,BookModel>) it.next();
            this.total += book.getValue().getPrice();
        }
        return total;
    }
    

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;

    }

    @Override
    public void setDate(Date date) {
        this.date = date;

    }

    @Override
    public void addItem(BookModel book) {
       receipt.put(receipt.size(), book);

    }
    public void removeItem(BookModel book){
        boolean cancel = false;
        int count = 0;
        while (cancel == false){
            if(receipt.get(count).equals(book)){
               receipt.remove(count);
               cancel = true;
            }
        }       
    }

}
