package controller;

import java.util.Map;

import model.BookModel;
import model.Model;
import view.BookshopPanel;
import view.MainView;
import view.ReceiptPanelImpl;
import view.observer.BookshopObserver;

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
		maninView.replaceMainPanel(ri);
	}

	@Override
	public Map<BookModel, Integer> getBookInShop() {
		Map<BookModel, Integer> booksInShop = model.shop().getBooks();//Get all book into the shop
		return booksInShop;
	}
}