package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.observer.RecepitObserver;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ReceiptPanelImpl extends JPanel implements ReceiptPanel, ActionListener {
	private JTable tblReport;
	private DefaultTableModel modelReport;
	private JScrollPane scpReport;
	private JButton btnMakePurchase;
	private JLabel lblNewLabel;
	private JComboBox cmbTypeOfPayment;
	private RecepitObserver observer;
	private JTextField txtTotalPrice;
	private JLabel lblTotalPrice;

	/**
	 * Create the panel.
	 */
	public ReceiptPanelImpl() {
		setBackground(SystemColor.inactiveCaption);
		this.setLayout(null);
		modelReport = new DefaultTableModel(new Object[][] {}, new String[] { "Titolo", "Prezzo" });

		scpReport = new JScrollPane();
		scpReport.setBounds(10, 74, 230, 359);
		add(scpReport);

		tblReport = new JTable();
		tblReport.setBackground(SystemColor.inactiveCaption);
		scpReport.setViewportView(tblReport);
		tblReport.setModel(modelReport);
		scpReport.setBackground(SystemColor.inactiveCaption);
		tblReport.getColumnModel().getColumn(0).setPreferredWidth(74);
		tblReport.getColumnModel().getColumn(1).setPreferredWidth(66);
		tblReport.getColumnModel().getColumn(2).setPreferredWidth(126);
		tblReport.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblReport.setFont(new Font("Calibri", Font.ITALIC, 14));
		tblReport.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		lblNewLabel = new JLabel("BookShop inc");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 585, 52);
		add(lblNewLabel);

		btnMakePurchase = new JButton("Effettua acquisto");
		btnMakePurchase.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		btnMakePurchase.setBounds(382, 367, 161, 50);
		btnMakePurchase.addActionListener(this);
		add(btnMakePurchase);

		cmbTypeOfPayment = new JComboBox();
		cmbTypeOfPayment.setFont(new Font("Calibri", Font.ITALIC, 13));
		cmbTypeOfPayment.setBounds(382, 204, 160, 20);
		cmbTypeOfPayment.addItem("Contanti");
		cmbTypeOfPayment.addItem("Carta di credito");
		cmbTypeOfPayment.addItem("Bancomat");
		add(cmbTypeOfPayment);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txtTotalPrice.setEnabled(false);
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setBounds(382, 177, 161, 20);
		// calcolo del totale tramite i dati presi dalla view
		// BookShopImpl
		add(txtTotalPrice);
		txtTotalPrice.setColumns(10);

		lblTotalPrice = new JLabel("Totale:");
		lblTotalPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTotalPrice.setBounds(382, 163, 161, 14);
		add(lblTotalPrice);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date today = null;
		Date currentDate = Calendar.getInstance().getTime();
		if (isPressed == btnMakePurchase) {
			try {
				this.observer.saveAccountingClicked(
						today = (Date) dateFormat.parse((dateFormat.format(currentDate))),
						Double.parseDouble(txtTotalPrice.getText()),
						cmbTypeOfPayment.getSelectedItem().toString());
			} catch (NumberFormatException | ParseException e1) {

				e1.printStackTrace();
			}
		}
	}

	@Override
	public void WriteList() {
		// da capire come portare i dati dalla view BookShopImpl

	}

	@Override
	public void attachObserver(RecepitObserver observer) {
		this.observer = observer;

	}
}
