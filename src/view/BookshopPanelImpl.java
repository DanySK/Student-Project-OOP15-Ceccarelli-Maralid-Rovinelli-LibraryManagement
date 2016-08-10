package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

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
import java.awt.event.ActionEvent;

public class BookshopPanelImpl extends JPanel implements BookshopPanel, ActionListener {

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
	private JButton btnAddToCart;
	private JLabel lblTitle;
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField txtTotalPrice;
	private JLabel lblTotalPrice;

	public BookshopPanelImpl() {
		setBackground(SystemColor.inactiveCaption);
		this.setLayout(null);

		modelAllBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Anno P.", "Prezzo" });
		modelSelectedBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Anno P.", "N#" });

		scpAllBooks = new JScrollPane();
		scpAllBooks.setBounds(10, 87, 230, 379);
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
		scpSelectedBooks.setBounds(360, 87, 230, 305);
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
		lblTitle.setBackground(SystemColor.inactiveCaption);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setBounds(10, 11, 580, 65);
		add(lblTitle);

		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setText("1");
		txtAmount.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtAmount.setEnabled(false);
		txtAmount.setEditable(false);
		txtAmount.setBounds(254, 141, 43, 42);
		add(txtAmount);
		txtAmount.setColumns(10);

		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnAdd.setBounds(307, 117, 43, 43);
		btnAdd.addActionListener(this);
		add(btnAdd);

		btnRemove = new JButton("-");
		btnRemove.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnRemove.setBounds(307, 171, 43, 43);
		btnRemove.addActionListener(this);
		add(btnRemove);

		lblAmount = new JLabel("Quantità");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblAmount.setBounds(250, 87, 100, 14);
		add(lblAmount);

		btnAddBook = new JButton("Aggiungi");
		btnAddBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnAddBook.setBounds(250, 237, 100, 49);
		btnAddBook.addActionListener(this);
		add(btnAddBook);

		btnRemoveBook = new JButton("Togli");
		btnRemoveBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnRemoveBook.setBounds(250, 297, 100, 49);
		btnRemoveBook.addActionListener(this);
		add(btnRemoveBook);

		btnAddToCart = new JButton("Aggiungi al carrello");
		btnAddToCart.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		btnAddToCart.setBounds(360, 417, 230, 49);
		btnAddToCart.addActionListener(this);
		add(btnAddToCart);

		lblTotalPrice = new JLabel("Spesa totale:");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTotalPrice.setBounds(250, 357, 100, 14);
		add(lblTotalPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setEnabled(false);
		txtTotalPrice.setFont(new Font("Calibri", Font.ITALIC, 12));
		txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrice.setBounds(254, 372, 96, 20);
		add(txtTotalPrice);
		txtTotalPrice.setColumns(10);
		

		
	}
	
	@Override
	public void attachObserver(BookshopObserver observer) {
		this.observer = observer;

	}

	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		if (isPressed == btnAddBook) {
			double price = -1;
			String cell;
			String titolo="";
			if (tblAllBooks.getSelectedRow() == -1) {
				cell = "";
			} else {
				cell = tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 0).toString();
			}
			int quantity = Integer.parseInt(txtAmount.getText());
			price = this.observer.uploadBooks(titolo,quantity );
			txtTotalPrice.setText(Double.parseDouble(txtTotalPrice.getText()) + price + "");
			int ammount = Integer.parseInt(txtAmount.getText());
			String title = cell;
			//modelSelectedBooks.addRow(arg0);
			tblSelectedBooks.repaint();
		} else {
			if (isPressed == btnAdd && this.observer.getStocksOfTheShop(
					tblAllBooks.getValueAt(tblAllBooks.getSelectedRow(), 0).toString()) > Integer
							.parseInt(txtAmount.getText())) {
				txtAmount.setText(String.valueOf(Integer.parseInt(txtAmount.getText()) + 1));
			} else {
				JOptionPane.showMessageDialog(null,
						"Attenzione quantità massima disponibile già raggiunta!");
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
		if(isPressed==btnAddToCart ){
			this.observer.ShopCartClicked();
		}else if (isPressed==btnRemoveBook){
			modelSelectedBooks.removeRow(tblSelectedBooks.getSelectedRow());
		}
	}
	@Override
	public void clearSelectedBooks() {
		for (int i = modelSelectedBooks.getRowCount() - 1; i >= 0; i--) {
			modelSelectedBooks.removeRow(i);
		}
		
	}
}
