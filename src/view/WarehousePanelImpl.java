package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import view.observer.WarehouseObserver;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WarehousePanelImpl extends JPanel implements WarehousePanel, ActionListener {

	/**
	 * Create the panel.
	 */
	private WarehouseObserver observer;
	private JTable tblAllBooks;
	private DefaultTableModel modelAllBooks;
	private JScrollPane scpAllBooks;
	private JTextField txtAmmount;
	private JLabel lblWareHouseTitle;
	private JLabel lblAmmount;
	private JButton btnRemoveOne;
	private JButton btnRemoveTen;
	private JButton btnAddOne;
	private JButton btnAddTen;
	private JButton btnAddToWareHouse;
	private static final long serialVersionUID = 1L;

	public WarehousePanelImpl() {
		setBackground(SystemColor.activeCaption);
		this.setLayout(null);
		modelAllBooks = new DefaultTableModel(new Object[][] {},
				new String[] { "Titolo", "Autore", "Anno P.", "Prezzo", "Rimanenze" });
		scpAllBooks = new JScrollPane();
		scpAllBooks.setBounds(10, 88, 383, 379);
		add(scpAllBooks);

		tblAllBooks = new JTable();
		scpAllBooks.setViewportView(tblAllBooks);
		tblAllBooks.setModel(modelAllBooks);
		tblAllBooks.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblAllBooks.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblAllBooks.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblAllBooks.getColumnModel().getColumn(3).setPreferredWidth(50);
		tblAllBooks.getColumnModel().getColumn(4).setPreferredWidth(50);
		tblAllBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblAllBooks.setFont(new Font("Calibri", Font.PLAIN, 13));
		tblAllBooks.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		lblWareHouseTitle = new JLabel("Magazzino");
		lblWareHouseTitle.setForeground(new Color(255, 69, 0));
		lblWareHouseTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblWareHouseTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWareHouseTitle.setBounds(10, 11, 585, 66);
		add(lblWareHouseTitle);

		txtAmmount = new JTextField();
		txtAmmount.setEnabled(false);
		txtAmmount.setEditable(false);
		txtAmmount.setText("1");
		txtAmmount.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmmount.setBounds(403, 103, 192, 20);
		add(txtAmmount);
		txtAmmount.setColumns(10);

		lblAmmount = new JLabel("Quantità:");
		lblAmmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmmount.setBounds(403, 89, 192, 14);
		add(lblAmmount);

		btnRemoveOne = new JButton("-");
		btnRemoveOne.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnRemoveOne.setBounds(403, 134, 50, 50);
		btnRemoveOne.addActionListener(this);
		add(btnRemoveOne);

		btnRemoveTen = new JButton("--");
		btnRemoveTen.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnRemoveTen.setBounds(437, 188, 50, 50);
		btnRemoveTen.addActionListener(this);
		add(btnRemoveTen);

		btnAddOne = new JButton("+");
		btnAddOne.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		btnAddOne.setBounds(545, 134, 50, 50);
		btnAddOne.addActionListener(this);
		add(btnAddOne);

		btnAddTen = new JButton("++");
		btnAddTen.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		btnAddTen.setBounds(516, 189, 50, 50);
		btnAddTen.addActionListener(this);
		add(btnAddTen);

		btnAddToWareHouse = new JButton("Aggiungi al magazzino");
		btnAddToWareHouse.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		btnAddToWareHouse.setBounds(403, 297, 192, 50);
		btnAddToWareHouse.addActionListener(this);
		add(btnAddToWareHouse);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		if (isPressed == btnRemoveOne) {
			if (Integer.parseInt(txtAmmount.getText()) > 1)
				txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) - 1));
		} else if (isPressed == btnRemoveTen) {
			if (Integer.parseInt(txtAmmount.getText()) > 10) {
				txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) - 10));
			}
		} else if (isPressed == btnAddOne) {
			txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) + 1));
		} else if (isPressed == btnAddTen) {
			txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) + 10));
		} else if (isPressed == btnAddToWareHouse) {
this.observer.addBooksInWarehouseClicked(  Integer.parseInt(txtAmmount.getText()));
		}
	}

	@Override
	public void attachObserver(WarehouseObserver observer) {
		this.observer= observer;
		
	}

	@Override
	public void clearPanel() {
		txtAmmount.setText("1");
		
	}


}