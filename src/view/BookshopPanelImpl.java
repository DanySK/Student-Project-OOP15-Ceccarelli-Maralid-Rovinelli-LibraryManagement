package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

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
	private JTextField txtTotalPrice;
	private JLabel lblTotalPrice;

	public BookshopPanelImpl() {
		setBackground(SystemColor.inactiveCaption);
		this.setLayout(null);

		modelAllBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Anno P.", "Prezzo", "quantità" });
		modelSelectedBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Anno P.", "N#" });

		scpAllBooks = new JScrollPane();
		scpAllBooks.setBounds(10, 87, 352, 379);
		add(scpAllBooks);

		tblAllBooks = new JTable();
		scpAllBooks.setViewportView(tblAllBooks);
		tblAllBooks.setModel(modelAllBooks);
		tblAllBooks.getColumnModel().getColumn(0).setPreferredWidth(74);
		tblAllBooks.getColumnModel().getColumn(1).setPreferredWidth(66);
		tblAllBooks.getColumnModel().getColumn(2).setPreferredWidth(126);
		tblAllBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblAllBooks.setFont(new Font("Calibri", Font.PLAIN, 13));
		tblAllBooks.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		scpSelectedBooks = new JScrollPane();
		scpSelectedBooks.setBounds(568, 87, 309, 379);
		add(scpSelectedBooks);

		tblSelectedBooks = new JTable();
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
		txtAmount.setBounds(414, 143, 43, 42);
		add(txtAmount);
		txtAmount.setColumns(10);

		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnAdd.setBounds(467, 119, 43, 43);
		btnAdd.addActionListener(this);
		add(btnAdd);

		btnRemove = new JButton("-");
		btnRemove.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnRemove.setBounds(467, 173, 43, 43);
		btnRemove.addActionListener(this);
		add(btnRemove);

		lblAmount = new JLabel("Quantità");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblAmount.setBounds(372, 88, 186, 14);
		add(lblAmount);

		btnAddBook = new JButton("Aggiungi");
		btnAddBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnAddBook.setBounds(372, 241, 186, 49);
		btnAddBook.addActionListener(this);
		add(btnAddBook);

		btnRemoveBook = new JButton("Togli");
		btnRemoveBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnRemoveBook.setBounds(372, 301, 186, 49);
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
		lblTotalPrice.setBounds(372, 357, 186, 14);
		add(lblTotalPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setText("0");
		txtTotalPrice.setEnabled(false);
		txtTotalPrice.setFont(new Font("Calibri", Font.ITALIC, 12));
		txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrice.setBounds(376, 372, 182, 20);
		add(txtTotalPrice);
		txtTotalPrice.setColumns(10);
	}

	@Override
	public void attachObserver(BookshopObserver observer) {
		this.observer = observer;
		this.setAllBooks();
	}

	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		int selectedAmount = (int) modelAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 4);
		int newAmount = Integer.parseInt(txtAmount.getText());
		if (isPressed == btnAddBook) {
			String title = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 0).toString();
			String author = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 1).toString();
			String publicationYear = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 2).toString();
			String ammount = txtAmount.getText();
			String[] str = { title, author, publicationYear, ammount };
			((DefaultTableModel) modelSelectedBooks).addRow(str);

			txtTotalPrice.setText(setTotalPrice(Integer.parseInt(txtAmount.getText()),
					(double) modelAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 3),
					Double.parseDouble(txtTotalPrice.getText())));

			modelAllBooks.setValueAt(
					(Integer) modelAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 4)
							- Integer.parseInt(txtAmount.getText()),
					tblAllBooks.getSelectedRow(), 4);
			tblSelectedBooks.repaint();
			txtAmount.setText("1");
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
			this.observer.shopPurchaseItClicked();

		} else if (isPressed == btnRemoveBook) {
			modelSelectedBooks.removeRow(tblSelectedBooks.getSelectedRow());
		}
	}

	@Override
	public void clearSelectedBooks() {
		for (int i = modelSelectedBooks.getRowCount() - 1; i >= 0; i--) {
			modelSelectedBooks.removeRow(i);			
		}

	}

	public void setAllBooks(){
		Map<BookModel, Integer> tmp = this.observer.getBookInShop();
		int i = 0;

		for (BookModel entry : tmp.keySet()) {

			Object[] obj = { entry.getTitle(), entry.getAuthor(), entry.getyearOfPublication(),
					entry.getPrice(), tmp.values().toArray()[i] };
			((DefaultTableModel) modelAllBooks).addRow(obj);
			tblAllBooks.repaint();
			System.out.println("ciccia1 " + tmp.values().toArray()[i]);
			i++;
		}
		tblAllBooks.setRowSelectionInterval(0, 0);
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
}
