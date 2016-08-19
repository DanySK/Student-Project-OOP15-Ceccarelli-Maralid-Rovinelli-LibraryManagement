package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.BookModel;
import model.InvoiceImpl;
import model.InvoiceModel;
import model.Model;
import view.ReceiptPanel;
import view.observer.RecepitObserver;

public class ReceiptPanelController implements RecepitObserver{

	private Model model;
	private ReceiptPanel view;
	private Map<BookModel, Integer> purchaseList = new HashMap<BookModel, Integer>();
	
	public ReceiptPanelController(Model model, Map<BookModel, Integer> purchaseList) {
		this.model = model;
		this.purchaseList = purchaseList;
	}
	
	public void setView(ReceiptPanel rp){
		this.view = rp;
		this.view.attachObserver(this);
	}
	@Override
	public void saveAccountingClicked(Date today, double money, String type) {
		InvoiceModel invoice = new InvoiceImpl(purchaseList, today, 1);
		model.invoices().addNewInvoice(invoice);
		System.out.println(invoice.getTotal());
		System.out.println(invoice.getPaymentMethod());
		System.out.println(invoice.getDate());
		System.out.println(invoice.getReceipt());
	}

}
