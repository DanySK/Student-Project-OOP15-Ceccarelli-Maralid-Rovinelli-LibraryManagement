package controller;

import model.Model;
import model.StreamImpl;
import model.StreamModel;
import view.AddBookPanelImpl;
import view.LoginPanelImpl;
import view.BookshopPanelImpl;
import view.MainView;
import view.NorthPanel;
import view.NorthPanelImpl;
import view.observer.NorthPanelObserver;
import view.observer.ViewObserver;

import java.io.IOException;

import model.BookImpl;
import model.BookModel;
import model.EmployeeModel;

public class Controller implements NorthPanelObserver, ViewObserver{
	private Model model;
	private MainView mainView;
	private StreamModel<Integer, EmployeeModel> smEmployee;
	private StreamModel<BookModel, Integer> smBook;
	
	/**
	 * Crea un nuovo Controller senza dare alcun parametro come input.
	 * 
	 * @param model
	 *            il model utilizzato per salvare i dati
	 */
	public Controller(Model model) {
			this.model = model;
			smEmployee = new StreamImpl<Integer, EmployeeModel>();
			smBook = new StreamImpl<BookModel, Integer>();
	}


	public void setView(MainView mainView) {
		this.mainView = mainView;
		this.mainView.attachObserver(this);
		NorthPanel northpanel = (NorthPanelImpl) this.mainView.getNorthPanel();
		northpanel.attachObserver(this);
	}
	
	/*public void createLoginPanel() {
		LoginPanelImpl lp = new LoginPanelImpl();
		LoginPanelController lpc = new LoginPanelController(this.mainView, model);
		lpc.setView(lp);
		this.mainView.replaceMainPanel(lp);
	}*/
	
	@Override
	public void changeLogStatus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void buttonHomeClicked() {
		BookshopPanelImpl bsp = new BookshopPanelImpl();
		BookshopController bsc = new BookshopController(this.mainView, model);
		bsc.setView(bsp);
		this.mainView.replaceMainPanel(bsp);
		
	}
	
	@Override
	public void buttonLoginClicked() {
		LoginPanelImpl lp = new LoginPanelImpl();
		LoginPanelController lpc = new LoginPanelController(this.mainView, model);
		lpc.setView(lp);
		this.mainView.replaceMainPanel(lp);
	}

	@Override
	public void exitCommand() {
		saveData();
		System.exit(0);
	}

	@Override
	public void saveData() {
		smEmployee.writeFile("Employees.dat", model.employees().getEmployees());
		smBook.writeFile("BooksInWareHouse.dat", model.warehouse().getBooks());
	}

	@Override
	public void saveData(String path) {
		// TODO Auto-generated method stub
		System.out.println("Siamo qui");
	}

	@Override
	public void dataLoad() {
		// TODO Auto-generated method stub
		try {
		    
			model.employees().updateEmployees(smEmployee.readFile("Employees.dat"));
			for(int i = 0;i<model.employees().getEmployees().size();i++){
	            System.out.println(model.employees().getEmployees().get(i).getUsername());
			}
		    model.warehouse().update(smBook.readFile("BooksInWareHouse.dat"));
		    //System.out.println(model.warehouse().getBooks().);
		    for ( BookModel key : model.warehouse().getBooks().keySet() ) {
		        System.out.println( key.getTitle());
		    }
		    /*for(int y = 0; y<model.warehouse().getBooks().size(); y++){
		    	System.out.println(model.warehouse().getBooks().get);
		    }*/
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dataLoad(String path) {
		// TODO Auto-generated method stub
		
	}
	
	//DA TOGLIERE
	@Override
	public void OpenAddBookClick() {
		AddBookPanelImpl ab = new AddBookPanelImpl();
		InsertBookController ibc = new InsertBookController(model);
		ibc.setView(ab);
		this.mainView.replaceMainPanel(ab);
	}


}
