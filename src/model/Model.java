package model;

import model.core.EmployeesModel;
import model.core.InvoicesModel;
import model.core.ShopAndWarehouseModel;

public interface Model {

	 public ShopAndWarehouseModel shop();
	 public ShopAndWarehouseModel warehouse();
	 public EmployeesModel employees();
	 public InvoicesModel invoices();
   
    
}
