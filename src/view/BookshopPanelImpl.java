package view;

import javax.swing.JPanel;

import view.observer.BookshopObserver;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class BookshopPanelImpl extends JPanel implements BookshopPanel{

	/**
	 * Create the panel.
	 */
	JButton btnAddToCart;
	JLabel lblNewLabel;
	JLabel lblBooksList;
	JButton btnAddToSelected;
	JList listSelectedBooks;
	JList listTotalBooks;
	
	public BookshopPanelImpl() {
		
		btnAddToCart = new JButton("Metti nel carrello");
		btnAddToCart.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		add(btnAddToCart);
		
		lblNewLabel = new JLabel("Libri selezionati");
		lblNewLabel.setFont(new Font("Calibri", Font.ITALIC, 14));
		add(lblNewLabel);
		
		lblBooksList = new JLabel("Libri presenti in libreria");
		lblBooksList.setFont(new Font("Calibri", Font.ITALIC, 14));
		add(lblBooksList);
		
		btnAddToSelected = new JButton("Aggiungi");
		btnAddToSelected.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		add(btnAddToSelected);
		
		listSelectedBooks = new JList();
		add(listSelectedBooks);
		
		listTotalBooks = new JList();
		add(listTotalBooks);

	}

	@Override
	public void clearBooksList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSelectedBookList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachObserver(BookshopObserver observer) {
		// TODO Auto-generated method stub
		
	}

}
