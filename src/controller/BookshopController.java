package controller;

import java.util.Map;

import model.BookModel;
import model.Model;
import view.BookshopPanel;
import view.MainView;
import view.ReceiptPanelImpl;
import view.observer.BookshopObserver;

/**
 * @author erik_
 *
 */
public class BookshopController implements BookshopObserver {

	private Model model;
	private MainView maninView;
	private BookshopPanel view;

	public BookshopController(MainView mainView, Model model) {
		this.maninView = mainView;
		this.model = model;

	}

	public void setView(BookshopPanel bp) {
		this.view = bp;
		this.view.attachObserver(this);
	}

	@Override
	public void shopPurchaseItClicked(Map<BookModel, Integer> purchaseList) {
		ReceiptPanelImpl ri = new ReceiptPanelImpl();
		ReceiptPanelController rc = new ReceiptPanelController(model, purchaseList);
		rc.setView(ri);
		this.maninView.replaceMainPanel(ri);
	}

	@Override
	public Map<BookModel, Integer> getBookInShop() {
		Map<BookModel, Integer> booksInShop = model.shop().getBooks();
		return booksInShop;
	}
}