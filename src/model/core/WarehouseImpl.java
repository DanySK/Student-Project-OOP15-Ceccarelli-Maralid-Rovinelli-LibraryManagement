package model.core;

import java.util.HashMap;
import java.util.Map;

import model.BookModel;

public class WarehouseImpl implements ShopAndWarehouseModel {
    private Map<BookModel,Integer> warehouse = new HashMap<BookModel,Integer>();
    @Override
    public void addNewBookInLibrary(BookModel b) {
        if(warehouse.containsKey(b)){
            warehouse.replace(b, warehouse.get(b), warehouse.get(b).intValue()+1);
        }else{
            warehouse.put(b, 1);
        }   
    
    }

}
