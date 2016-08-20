package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.BookModel;
import model.InvoiceImpl;
import model.InvoiceModel;
import model.Model;
import view.BookshopPanelImpl;
import view.MainView;
import view.ReceiptPanel;
import view.observer.RecepitObserver;

/**
 * @author erik_
 *
 */
public class ReceiptPanelController implements RecepitObserver {

	private Model model;
	private MainView mainView;
	private ReceiptPanel view;
	private Map<BookModel, Integer> purchaseList = new HashMap<BookModel, Integer>();
	private InvoiceModel invoice;

	public ReceiptPanelController(MainView mainView, Model model, Map<BookModel, Integer> purchaseList) {
		this.mainView = mainView;
		this.model = model;
		this.purchaseList = purchaseList;
	}

	public void setView(ReceiptPanel rp) {
		this.view = rp;
		this.view.attachObserver(this);
	}

	@Override
	public void saveAccountingClicked(Date today, int payment, String subscriptionId) {
		invoice = new InvoiceImpl(purchaseList, today, payment);
		model.invoices().addNewInvoice(invoice);
		purchaseList.forEach((book, amount) -> {
			model.shop().replaceQuantity(
					model.shop().searchBook(book.getTitle(), book.getAuthor(), book.getyearOfPublication()),
					model.shop().getBookQuantity(
							model.shop().searchBook(book.getTitle(), book.getAuthor(), book.getyearOfPublication()))
							- amount);
			if (!subscriptionId.equals(""))
				model.subscriptions().getASubscription(Integer.parseInt(subscriptionId)).addBook(amount);
		});
		this.view.displayMessage("Acquisto effettuato");
		BookshopPanelImpl bsp = new BookshopPanelImpl();
		BookshopController bsc = new BookshopController(this.mainView, model);
		bsc.setView(bsp);
		this.mainView.replaceMainPanel(bsp);
	}

	public double getTotal() {
		return invoice.getTotal();
	}

	public Map<BookModel, Integer> getPurchaseRecap() {
		return purchaseList;
	}

}
