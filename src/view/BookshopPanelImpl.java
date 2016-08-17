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
import java.io.IOException;
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
		try {
			this.setAllBooks();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		if (isPressed == btnAddBook) {

			/*
			 * double price = -1; String cell; String titolo = "";
			 * if (tblAllBooks.getSelectedRow() == -1) { cell = "";
			 * } else { cell =
			 * tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(),
			 * 0).toString(); } int quantity =
			 * Integer.parseInt(txtAmount.getText()); price =
			 * this.observer.uploadBooks(titolo, quantity);
			 * txtTotalPrice.setText(Double.parseDouble(
			 * txtTotalPrice.getText()) + price + ""); int ammount =
			 * Integer.parseInt(txtAmount.getText()); String title =
			 * cell; modelSelectedBooks.addRow(new Object[]{});
			 */
			
			
			String title = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 0).toString();
			String author = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 1).toString();
			String publicationYear = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 2).toString();
			String ammount = txtAmount.getText();
			String[] str = { title, author, publicationYear, ammount };
			((DefaultTableModel) modelSelectedBooks).addRow(str);
			System.out.println(title + " " + author + " " + publicationYear + " " + ammount);
			String price = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 3).toString();
			double doublePrice = Double.parseDouble(price);
			tblSelectedBooks.repaint();
			txtTotalPrice.setText(String.valueOf(Double.parseDouble(txtTotalPrice.getText())
					+ (Integer.parseInt(txtAmount.getText()) * doublePrice)));
		} else {
			if (isPressed == btnAdd && this.observer.getStocksOfTheShop(
					tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 0).toString()) > Integer
							.parseInt(txtAmount.getText())) {
				txtAmount.setText(String.valueOf(Integer.parseInt(txtAmount.getText()) + 1));
			} else {
				JOptionPane.showMessageDialog(null,
						"Attenzione quantità massima disponibile già raggiunta!", "Attenzione",
						JOptionPane.PLAIN_MESSAGE);
			}

			if (isPressed == btnRemove) {
				if (Integer.parseInt(txtAmount.getText()) > 1) {
					txtAmount.setText(String.valueOf(Integer.parseInt(txtAmount.getText()) - 1));
				} else {
					JOptionPane.showMessageDialog(null,
							"Attenzione quantità minima gia' impostata!");
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

	public void setAllBooks() throws ClassNotFoundException, IOException {
		Map<BookModel, Integer> tmp = this.observer.getBookInShop();
		int i = 0;

		for (BookModel entry : tmp.keySet()) {

			Object[] obj = { entry.getTitle(), entry.getAuthor(), entry.getyearOfPublication(),
					entry.getPrice(), tmp.values().toArray()[i] };
			((DefaultTableModel) modelAllBooks).addRow(obj);
			/*
			 * ((DefaultTableModel) modelAllBooks).addRow(new
			 * Object[]{entry.getTitle(),entry.getAuthor(),
			 * entry.getyearOfPublication(),entry.getPrice()});
			 */
			tblAllBooks.repaint();
			System.out.println("ciccia1 " + tmp.values().toArray()[i]);
			i++;
		}
	}
}
