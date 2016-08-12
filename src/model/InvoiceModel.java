package model;
import java.util.Date;
import java.util.Map;

public interface InvoiceModel {
    /** 
     * 1)This method returns the items on the receipt.
     * 2)return the Receipt
     * @return Map<Integer, BookModel>
     */
    public Map<Integer, BookModel> getReceipt();
    /** 
     * this method return the total of the receipt
     * @return double
     */
    public double getTotal();
    /**
     * returns the receipt issue date
     * @return
     */
    public Date getDate();
    /**
     * returns the address of the store that issued the ticket
     * @return
     */
    public String getAddress();
    
    /**
     * this method set a new address for the ticket
     * @param address
     */
    public void setAddress(String address);
    /**
     * this method return the date for the ticket
     * @param date
     */
    public void setDate(Date date);
    /**
     * this method add a new item in invoice
     * @param book
     */
    public void addItem(BookModel book);
    /**
     * this method remove a book at the invoice
     * @param book
     */
    public void removeItem(BookModel book);
   
  
}
