package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.BookModel;


public class ShopImpl implements ShopAndWarehouseModel {
    private Map<BookModel,Integer> shop = new HashMap<BookModel,Integer>();
    
    public void update(Map<BookModel,Integer> booksInLibrary){
        this.shop = booksInLibrary;
    }
   /**aggiunta di un nuovo libro nella lista */
    public void addNewBookInLibrary(BookModel b) {
        if(shop.containsKey(b)){
                shop.replace(b, shop.get(b), shop.get(b).intValue()+1);
            }else{
                shop.put(b, 1);
            }   
        }
    /** data una quantità nuova ,la sostituise a quella vecchia*/
    public void replaceQuantity(BookModel b,int quantity){
       shop.replace(b, quantity);
     }
    /**ritorna la lista completa di libri  */
    public Map<BookModel,Integer> getBooks(){
        return this.shop;
    }
    /** 
     * dato un libro ,ritorna la quantità contenuta nel magazzino
     * @param b
     * @return
     */
    public Integer getBookQuantity(BookModel b){
        int quantity = 0;
        Iterator<BookModel> it = shop.keySet().iterator();
        while(it.hasNext()){
            if(it.next().equals(b)){
            quantity = shop.get(it.next());    
            }
          }
        return quantity;
    }
}
