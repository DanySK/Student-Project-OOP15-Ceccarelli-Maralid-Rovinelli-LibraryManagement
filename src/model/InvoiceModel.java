package model;
import java.util.Date;
import java.util.Map;

public interface InvoiceModel {
    /** Restituisce gli articoli dello scontrino fiscale fatto */
    public Map<Integer, BookModel> getReceipt();
    /** Restituisce il totale dello scontrino*/
    public double getTotal();
    /** restituisce la data dell'emissione della ricevuta*/
    public Date getDate();
    /**restituisce il luogo di emissione*/
    public String getAddress();
    
    /**setta il luogo di emissione della ricevuta*/
    public void setAddress(String address);
    /** setta la data di emissione*/
    public void setDate(Date date);
    /**setta un nuovo articolo nello scontrino */
    public void addItem(BookModel book);
    /**
     * this method remove a book at the invoice
     * @param book
     */
    public void removeItem(BookModel book);
   
    /*public void addItems(String item,Integer quantity);
    public void addItems(String item,Integer quantity,Integer price);*/
}
