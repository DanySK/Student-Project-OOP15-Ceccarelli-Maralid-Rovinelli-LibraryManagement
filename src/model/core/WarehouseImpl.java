package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import model.BookModel;
/**
 * this class represents the warehose of library
 * 
 * @author Mattia.Rovinelli
 *
 */
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
    @Override
    public Map<BookModel, Integer> getBooks() {
       return this.warehouse;
    }
    @Override
    public void update(Map<BookModel, Integer> booksInLibrary) {
        this.warehouse = booksInLibrary;
        
    }
    @Override
   
    public void replaceQuantity(BookModel b, int quantity) {
        warehouse.replace(b, quantity);
        
    }
    @Override
    
    public Integer getBookQuantity(BookModel b) {
        int quantity = 0;
        Iterator<Entry<BookModel,Integer>> it = warehouse.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<BookModel, Integer> pair = (Entry<BookModel, Integer>) it.next();
            if(pair.getKey().equals(b)){
                quantity = pair.getValue();
            }
        }
        return quantity;
     
    }

}
