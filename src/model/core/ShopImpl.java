package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.BookModel;
/**
 * This class represents the class of the shop 
 * 
 * @author Mattia.Rovinelli
 *
 */

public class ShopImpl implements ShopAndWarehouseModel {
    private Map<BookModel,Integer> shop = new HashMap<BookModel,Integer>();
    
    public void update(Map<BookModel,Integer> booksInLibrary){
        this.shop = booksInLibrary;
    }
   
    public void addNewBookInLibrary(BookModel book) {
        if(shop.containsKey(book)){
                shop.replace(book, shop.get(book), shop.get(book).intValue()+1);
            }else{
                shop.put(book, 1);
            }   
        }
   
    public void replaceQuantity(BookModel book,int quantity){
        if(shop.containsKey(book)){
       shop.replace(book, quantity);
        }else{
            shop.put(book, quantity);
        }
     }
   
    public Map<BookModel,Integer> getBooks(){
        return this.shop;
    }
    
    public Integer getBookQuantity(BookModel book){
        int quantity = 0;
        Iterator<BookModel> it = shop.keySet().iterator();
        while(it.hasNext()){
            if(it.next().equals(book)){
            quantity = shop.get(it.next());    
            }
          }
        return quantity;
    }
}
