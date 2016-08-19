package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.BookImpl;
import model.BookModel;
import view.observer.BookshopObserver;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class BookshopPanelImpl extends JPanel implements BookshopPanel, ActionListener {

	private static final long serialVersionUID = 1L;
	private BookshopObserver observer;
	private DefaultTableModel modelAllBooks;
	private DefaultTableModel modelSelectedBooks;
	private JTable tblAllBooks;
	private JTable tblSelectedBooks;
	private JScrollPane scpAllBooks;
	private JScrollPane scpSelectedBooks;
	private JTextField txtAmount;
	private JLabel lblAmount;
	private JButton btnAddBook;
	private JButton btnRemoveBook;
	private JButton btnPurchaseIt;
	private JLabel lblTitle;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblTotalPrice;
	private JLabel lblTotalPriceAmount;
	private JLabel lblCurrencies;

	public BookshopPanelImpl() {
		setBackground(SystemColor.inactiveCaption);
		this.setLayout(null);

		modelAllBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Genere", "Anno P.", "Prezzo", "Copie" });
		modelSelectedBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Genere", "Anno P.", "Prezzo", "Copie" });

		scpAllBooks = new JScrollPane();
		scpAllBooks.setEnabled(false);
		scpAllBooks.setBounds(10, 87, 377, 379);
		add(scpAllBooks);

		tblAllBooks = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scpAllBooks.setViewportView(tblAllBooks);
		tblAllBooks.setModel(modelAllBooks);
		tblAllBooks.getColumnModel().getColumn(0).setPreferredWidth(74);
		tblAllBooks.getColumnModel().getColumn(1).setPreferredWidth(66);
		tblAllBooks.getColumnModel().getColumn(2).setPreferredWidth(126);
		tblAllBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblAllBooks.setFont(new Font("Calibri", Font.PLAIN, 13));
		tblAllBooks.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		scpSelectedBooks = new JScrollPane();
		scpSelectedBooks.setEnabled(false);
		scpSelectedBooks.setBounds(502, 87, 375, 379);
		add(scpSelectedBooks);

		tblSelectedBooks = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scpSelectedBooks.setViewportView(tblSelectedBooks);
		tblSelectedBooks.setModel(modelSelectedBooks);
		tblSelectedBooks.getColumnModel().getColumn(0).setPreferredWidth(74);
		tblSelectedBooks.getColumnModel().getColumn(1).setPreferredWidth(66);
		tblSelectedBooks.getColumnModel().getColumn(2).setPreferredWidth(126);
		tblSelectedBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblSelectedBooks.setFont(new Font("Calibri", Font.PLAIN, 13));
		tblSelectedBooks.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		lblTitle = new JLabel("BookShop");
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setBackground(SystemColor.inactiveCaption);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setBounds(10, 11, 880, 65);
		add(lblTitle);

		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setText("1");
		txtAmount.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtAmount.setEnabled(false);
		txtAmount.setEditable(false);
		txtAmount.setBounds(396, 142, 43, 42);
		add(txtAmount);
		txtAmount.setColumns(10);

		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnAdd.setBounds(449, 118, 43, 43);
		btnAdd.addActionListener(this);
		add(btnAdd);

		btnRemove = new JButton("-");
		btnRemove.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnRemove.setBounds(449, 172, 43, 43);
		btnRemove.addActionListener(this);
		add(btnRemove);

		lblAmount = new JLabel("Quantità");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblAmount.setBounds(389, 87, 95, 14);
		add(lblAmount);

		btnAddBook = new JButton("Aggiungi");
		btnAddBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnAddBook.setBounds(396, 240, 95, 49);
		btnAddBook.addActionListener(this);
		add(btnAddBook);

		btnRemoveBook = new JButton("Togli");
		btnRemoveBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnRemoveBook.setBounds(396, 300, 96, 49);
		btnRemoveBook.addActionListener(this);
		add(btnRemoveBook);

		btnPurchaseIt = new JButton("Procedi con l'acquisto");
		btnPurchaseIt.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		btnPurchaseIt.setBounds(568, 494, 309, 49);
		btnPurchaseIt.addActionListener(this);
		add(btnPurchaseIt);

		lblTotalPrice = new JLabel("Spesa totale:");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTotalPrice.setBounds(397, 356, 95, 14);
		add(lblTotalPrice);

		lblTotalPriceAmount = new JLabel("0");
		lblTotalPriceAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceAmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		lblTotalPriceAmount.setBounds(397, 386, 52, 29);
		add(lblTotalPriceAmount);

		lblCurrencies = new JLabel("Euro");
		lblCurrencies.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrencies.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		lblCurrencies.setBounds(459, 381, 43, 38);
		add(lblCurrencies);

	}

	@Override
	public void attachObserver(BookshopObserver observer) {
		this.observer = observer;
		this.setAllBooks();
	}

	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		int selectedAmount = (int) modelAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 5);
		int newAmount = Integer.parseInt(txtAmount.getText());
		if (isPressed == btnAddBook) {

			String title = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 0).toString();
			String author = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 1).toString();
			String literaryGenre = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 2).toString();
			String publicationYear = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 3).toString();
			String price = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 4).toString();
			String ammount = txtAmount.getText();

			String[] str = { title, author, literaryGenre, publicationYear, price, ammount };
			((DefaultTableModel) modelSelectedBooks).addRow(str);

			lblTotalPriceAmount
					.setText(setTotalPrice(Integer.parseInt(txtAmount.getText()),
							(double) modelAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
									4),
							Double.parseDouble(lblTotalPriceAmount.getText())));

			modelAllBooks.setValueAt(
					(Integer) modelAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 5)
							- Integer.parseInt(txtAmount.getText()),
					tblAllBooks.getSelectedRow(), 5);
			tblSelectedBooks.repaint();
			txtAmount.setText("1");
			if (tblSelectedBooks.getRowCount() > 0) {
				tblSelectedBooks.setRowSelectionInterval(0, 0);
			}
		} else {
			if (isPressed == btnAdd) {
				if (selectedAmount > newAmount)
					txtAmount.setText(String.valueOf(Integer.parseInt(txtAmount.getText()) + 1));
				else if (selectedAmount == 0) {
					displayMessage("Non ci sono piu libri del tipo scelto");
				} else {
					displayMessage("Quantità massima già raggiunta");
				}
			} else if (isPressed == btnRemove) {
				if (newAmount > 1) {
					txtAmount.setText(String.valueOf(Integer.parseInt(txtAmount.getText()) - 1));
				} else {
					displayMessage("Attenzione quantità minima gia' impostata!");
				}
			}
		}
		if (isPressed == btnPurchaseIt) {
			Map<BookModel, Integer> purchaseList = null;
			for (int i = 0; i < tblSelectedBooks.getRowCount(); i++) {
				BookModel book = new BookImpl();
				book.setTitle(tblSelectedBooks.getValueAt(i, 0).toString());
				book.setAuthor(tblSelectedBooks.getValueAt(i, 1).toString());
				book.setLiteraryGenre(tblSelectedBooks.getValueAt(i, 2).toString());
				book.setYearOfPublication((Integer)tblSelectedBooks.getValueAt(i, 3));
				book.setPrice((Double)tblSelectedBooks.getValueAt(i, 4));
				purchaseList.put(book,(Integer)tblSelectedBooks.getValueAt(i, 5));
				System.out.println(purchaseList);

			}
			this.observer.shopPurchaseItClicked(purchaseList);

		} else if (isPressed == btnRemoveBook) {
			clearSelectedBooks();
		}
	}

	@Override
	public void clearSelectedBooks() {
		for (int i = 0; i < modelAllBooks.getRowCount(); i++) {
			if (modelAllBooks.getValueAt(i, 0)
					.equals(modelSelectedBooks.getValueAt(tblSelectedBooks.getSelectedRow(), 0))
					&& modelAllBooks.getValueAt(i, 1)
							.equals(modelSelectedBooks.getValueAt(
									tblSelectedBooks.getSelectedRow(), 1))
					&& modelAllBooks.getValueAt(i, 3).toString().equals(modelSelectedBooks
							.getValueAt(tblSelectedBooks.getSelectedRow(), 3).toString())) {

				int oldValue = (Integer) modelAllBooks.getValueAt(i, 5);
				int newValue = Integer.parseInt((String) modelSelectedBooks
						.getValueAt(tblSelectedBooks.getSelectedRow(), 5));
				modelAllBooks.setValueAt(newValue + oldValue, i, 5);
				modelSelectedBooks.removeRow(tblSelectedBooks.getSelectedRow());
				lblTotalPriceAmount.setText(
						setTotalPrice(-newValue, (Double) modelAllBooks.getValueAt(i, 4),
								Double.parseDouble(lblTotalPriceAmount.getText())));
				break;
			}
		}
		if (tblSelectedBooks.getRowCount() > 0) {
			tblSelectedBooks.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void addSelectedBook() {
		for (int i = 0; i < modelAllBooks.getRowCount(); i++) {
			if (modelAllBooks.getValueAt(i, 0)
					.equals(modelSelectedBooks.getValueAt(tblSelectedBooks.getSelectedRow(), 0))
					&& modelAllBooks.getValueAt(i, 1)
							.equals(modelSelectedBooks.getValueAt(
									tblSelectedBooks.getSelectedRow(), 1))
					&& modelAllBooks.getValueAt(i, 3).toString().equals(modelSelectedBooks
							.getValueAt(tblSelectedBooks.getSelectedRow(), 3).toString())) {

				int oldValue = (Integer) modelAllBooks.getValueAt(i, 5);
				int newValue = Integer.parseInt((String) modelSelectedBooks
						.getValueAt(tblSelectedBooks.getSelectedRow(), 5));
				modelAllBooks.setValueAt(newValue + oldValue, i, 5);
				modelSelectedBooks.removeRow(tblSelectedBooks.getSelectedRow());
				lblTotalPriceAmount.setText(
						setTotalPrice(-newValue, (Double) modelAllBooks.getValueAt(i, 4),
								Double.parseDouble(lblTotalPriceAmount.getText())));
				break;
			}
			/*
			 * String title =
			 * tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
			 * 0).toString(); String author =
			 * tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
			 * 1).toString(); String literaryGenre =
			 * tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
			 * 2).toString(); String publicationYear =
			 * tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
			 * 3).toString(); String price =
			 * tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
			 * 4).toString(); String ammount = txtAmount.getText();
			 * 
			 * String[] str = { title, author, literaryGenre,
			 * publicationYear, price, ammount };
			 * ((DefaultTableModel) modelSelectedBooks).addRow(str);
			 * 
			 * lblTotalPriceAmount
			 * .setText(setTotalPrice(Integer.parseInt(txtAmount.
			 * getText()), (double)
			 * modelAllBooks.getValueAt(tblAllBooks.getSelectedRow()
			 * , 4),
			 * Double.parseDouble(lblTotalPriceAmount.getText())));
			 * 
			 * modelAllBooks.setValueAt( (Integer)
			 * modelAllBooks.getValueAt(tblAllBooks.getSelectedRow()
			 * , 5) - Integer.parseInt(txtAmount.getText()),
			 * tblAllBooks.getSelectedRow(), 5);
			 * tblSelectedBooks.repaint(); txtAmount.setText("1");
			 * if (tblSelectedBooks.getRowCount() > 0) {
			 * tblSelectedBooks.setRowSelectionInterval(0, 0); } }
			 * if (tblSelectedBooks.getRowCount() > 0) {
			 * tblSelectedBooks.setRowSelectionInterval(0, 0);
			 */}

	}

	public void setAllBooks() {
		clearTable(modelAllBooks);
		Map<BookModel, Integer> tmp = this.observer.getBookInShop();
		int i = 0;

		for (BookModel entry : tmp.keySet()) {
			if (entry.getTitle() == null) {

			} else {
				Object[] obj = { entry.getTitle(), entry.getAuthor(), entry.getLiteraryGenre(),
						entry.getyearOfPublication(), entry.getPrice(),
						tmp.values().toArray()[i] };
				((DefaultTableModel) modelAllBooks).addRow(obj);
				tblAllBooks.repaint();
				i++;
			}
		}
		if (tblAllBooks.getRowCount() > 0) {
			tblAllBooks.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Attenzione", JOptionPane.PLAIN_MESSAGE);
	}

	String setTotalPrice(int amount, double price, double previousPrice) {
		String totalPrice;
		if (previousPrice > 0) {
			totalPrice = String.valueOf(previousPrice + (amount * price));
		} else {
			totalPrice = String.valueOf(amount * price);
		}
		return totalPrice;
	}

	private void clearTable(DefaultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

}
