package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.BookModel;

public class WarehouseImpl implements ShopAndWarehouseModel {
    
    private Map<BookModel,Integer> warehouse = new HashMap<BookModel,Integer>();
    
    @Override/** aggiunge un nuovo libro al magazzino*/
    public void addNewBookInLibrary(BookModel b) {
        if(warehouse.containsKey(b)){
            warehouse.replace(b, warehouse.get(b), warehouse.get(b).intValue()+1);
        }else{
            warehouse.put(b, 1);
        }   
    
    }
    @Override/**ritorna una mappa del magazzino*/
    public Map<BookModel, Integer> getBooks() {
       return this.warehouse;
    }
    @Override/**aggiorna la mappa*/
    public void update(Map<BookModel, Integer> booksInLibrary) {
        this.warehouse = booksInLibrary;
        
    }
    @Override
    /**aggiorna la quantità di quel libro*/
    public void replaceQuantity(BookModel b, int quantity) {
        warehouse.replace(b, quantity);
        
    }
    @Override
    /**ritorna la quantità di quel libro*/
    public Integer getBookQuantity(BookModel b) {
        int quantity = 0;
        Iterator<BookModel> it = warehouse.keySet().iterator();
        while(it.hasNext()){
            if(it.next().equals(b)){
            quantity = warehouse.get(it.next());    
            }
          }
        return quantity;
    }

}
