package model;

import model.core.EmployeesImpl;
import model.core.EmployeesModel;
import model.core.InvoicesImpl;
import model.core.InvoicesModel;
import model.core.ShopAndWarehouseModel;
import model.core.ShopImpl;
import model.core.WarehouseImpl;

public class ModelImpl implements Model {
    
	private ShopAndWarehouseModel shop;
    private ShopAndWarehouseModel warehouse;
    private EmployeesModel employees;
    private InvoicesModel invoices;
    
    public ModelImpl(){
    	shop = new ShopImpl();
    	warehouse = new WarehouseImpl();
    	employees =new EmployeesImpl();
    	invoices = new InvoicesImpl();
    }
    
    public ShopAndWarehouseModel getShop() {
    	return this.shop;
    }
    
    public ShopAndWarehouseModel getWarehouse() {
    	return this.warehouse;
    }
    
    public EmployeesModel getEmployees() {
    	return this.employees;
    }
    
    public InvoicesModel getInvoices() {
    	return this.invoices;
    }
   
   
  
   
    
    
    
   
    
   
        
        
    
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
