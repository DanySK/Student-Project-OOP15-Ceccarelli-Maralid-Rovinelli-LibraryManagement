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

public class ReceiptPanelController implements RecepitObserver {

	private Model model;
	private ReceiptPanel view;
	private Map<BookModel, Integer> purchaseList = new HashMap<BookModel, Integer>();
	private InvoiceModel invoice;

	public ReceiptPanelController(Model model, Map<BookModel, Integer> purchaseList) {
		this.model = model;
		this.purchaseList = purchaseList;
	}

	public void setView(ReceiptPanel rp) {
		this.view = rp;
		this.view.attachObserver(this);
	}

	@Override
	public void saveAccountingClicked(Date today, int payment) {
		int prova = 0;
		invoice = new InvoiceImpl(purchaseList, today, payment);
		model.invoices().addNewInvoice(invoice);
		purchaseList.forEach((book, amount) -> {
			model.shop().replaceQuantity(
					model.shop().searchBook(book.getTitle(), book.getAuthor(), book.getyearOfPublication()), 
					model.shop().getBookQuantity(model.shop().searchBook(book.getTitle(), book.getAuthor(), book.getyearOfPublication())) - amount);
					//model.subscriptions().getASubscription(num).addBook(amount);
		});
	}

	public double getTotal() {
		return invoice.getTotal();
	}

	public Map<BookModel, Integer> getPurchaseRecap() {
		return purchaseList;
	}

}
