package model;

import model.core.EmployeesImpl;
import model.core.EmployeesModel;
import model.core.InvoicesImpl;
import model.core.InvoicesModel;
import model.core.ShopAndWarehouseModel;
import model.core.ShopImpl;
import model.core.WarehouseImpl;

public class LibraryImpl implements LibraryModel {
    
    ShopAndWarehouseModel shop = new ShopImpl();
    ShopAndWarehouseModel warehouse = new WarehouseImpl();
    EmployeesModel emplyees = new EmployeesImpl();
    InvoicesModel invoices = new InvoicesImpl();
   
   
  
   
    
    
    
   
    
   
        
        
    
   /* public void addNewBookInLibrary(BookModel b,Integer i,Integer quantity) {
        if (i == SHOP){
            if(shop.containsKey(b)){
                shop.replace(b, shop.get(b), shop.get(b).intValue()+quantity);
            }else{
                shop.put(b, quantity);
            }   
        } else if (i == WAREHOUSE) {
            if(warehouse.containsKey(b)){
                warehouse.replace(b, warehouse.get(b), warehouse.get(b).intValue()+quantity);
            }else{
                shop.put(b, quantity);
            }   
        }
        
    }*/
 
    
    
    
    
}
