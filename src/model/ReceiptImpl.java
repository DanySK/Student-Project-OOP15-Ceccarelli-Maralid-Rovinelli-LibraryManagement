package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReceiptImpl implements Receipt {
    //primo campo della mappa è il nome dell'articolo comprato il secondo la quantità il 3 il prezzo
    Map<Integer,ArrayList<Object>> receipt = new HashMap<Integer,ArrayList<Object>>();
    private double total = 0;
    Date date ;
    String address;
    
    
    
     @Override
    public Map<Integer, ArrayList<Object>> getReceipt() {
     return this.receipt;
    }

    @Override
    public double getTotal() {
       Iterator<Integer> iterator = receipt.keySet().iterator();
       while(iterator.hasNext())
       {
         this.total += (double) receipt.get(iterator.next()).get(1);
          
       }
        return this.total;
    }

    @Override
    public void addItem(String nameItem, double unitPrice) {
        ArrayList<Object> item = new ArrayList<Object>();
        item.add(0,nameItem);
        item.add(1, unitPrice);
        receipt.put(receipt.size()+1,item);
        
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

  
        
}

 


