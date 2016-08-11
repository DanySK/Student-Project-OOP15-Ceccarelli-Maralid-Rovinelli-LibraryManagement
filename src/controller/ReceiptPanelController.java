package controller;

import java.util.Date;

import model.Model;
import view.ReceiptPanel;
import view.observer.RecepitObserver;

public class ReceiptPanelController implements RecepitObserver{

	private Model model;
	private ReceiptPanel view;
	
	public ReceiptPanelController(Model model) {
		this.model = model;
	}
	
	public void setView(ReceiptPanel rp){
		this.view = rp;
		this.view.attachObserver(this);
	}
	@Override
	public void saveAccountingClicked(Date today, double money, String type) {
		// TODO Auto-generated method stub
		
	}

}
