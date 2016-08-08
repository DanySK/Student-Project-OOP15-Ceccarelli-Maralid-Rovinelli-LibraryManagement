package model.core;

import java.util.HashMap;
import java.util.Map;

import model.BookModel;

public class ShopImpl implements ShopAndWarehouseModel {
    private Map<BookModel,Integer> shop = new HashMap<BookModel,Integer>();
    
    
    public void addNewBookInLibrary(BookModel b) {
        if(shop.containsKey(b)){
                shop.replace(b, shop.get(b), shop.get(b).intValue()+1);
            }else{
                shop.put(b, 1);
            }   
        }
}
