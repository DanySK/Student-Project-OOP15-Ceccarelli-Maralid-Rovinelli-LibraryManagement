package model;

import model.core.EmployeesModel;
import model.core.InvoicesModel;
import model.core.ShopAndWarehouseModel;

public interface Model {

	public ShopAndWarehouseModel getShop();
	 public ShopAndWarehouseModel getWarehouse();
	 public EmployeesModel getEmployees();
	 public InvoicesModel getInvoices();
   
    
}
