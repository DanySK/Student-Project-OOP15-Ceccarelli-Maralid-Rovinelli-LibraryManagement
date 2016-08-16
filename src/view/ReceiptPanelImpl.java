package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import view.observer.RecepitObserver;

public class ReceiptPanelImpl extends JPanel implements ReceiptPanel,ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTable tblReport;
	private DefaultTableModel modelReport;
	private JScrollPane scpReport;
	private JButton btnMakePurchase;
	private JLabel lblNewLabel;
	private JComboBox<String> cmbTypeOfPayment;
	private RecepitObserver observer;
	private JTextField txtTotalPrice;
	private JLabel lblTotalPrice;
	private JTextField txtSubscriptionCode;

	/**
	 * Create the panel.
	 */
	public ReceiptPanelImpl() {
		setBackground(SystemColor.inactiveCaption);
		this.setLayout(null);
		modelReport = new DefaultTableModel(new Object[][] {}, new String[] { "Titolo", "Prezzo" });

		scpReport = new JScrollPane();
		scpReport.setBounds(20, 74, 853, 418);
		add(scpReport);

		tblReport = new JTable();
		tblReport.setBackground(SystemColor.inactiveCaption);
		scpReport.setViewportView(tblReport);
		tblReport.setModel(modelReport);
		scpReport.setBackground(SystemColor.inactiveCaption);
		tblReport.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblReport.setFont(new Font("Calibri", Font.ITALIC, 14));
		tblReport.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		lblNewLabel = new JLabel("BookShop inc");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 880, 52);
		add(lblNewLabel);

		btnMakePurchase = new JButton("Effettua acquisto");
		btnMakePurchase.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnMakePurchase.setBounds(712, 518, 161, 31);
		btnMakePurchase.addActionListener(this);
		add(btnMakePurchase);

		cmbTypeOfPayment = new JComboBox<String>();
		cmbTypeOfPayment.setFont(new Font("Calibri", Font.ITALIC, 13));
		cmbTypeOfPayment.setBounds(237, 523, 160, 20);
		cmbTypeOfPayment.addItem("Contanti");
		cmbTypeOfPayment.addItem("Carta di credito");
		cmbTypeOfPayment.addItem("Bancomat");
		add(cmbTypeOfPayment);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txtTotalPrice.setEnabled(false);
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setBounds(20, 523, 161, 20);
		// calcolo del totale tramite i dati presi dalla view
		// BookShopImpl
		add(txtTotalPrice);
		txtTotalPrice.setColumns(10);

		lblTotalPrice = new JLabel("Totale:");
		lblTotalPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTotalPrice.setBounds(20, 509, 161, 14);
		add(lblTotalPrice);
		
		txtSubscriptionCode = new JTextField();
		txtSubscriptionCode.setBounds(421, 523, 161, 20);
		add(txtSubscriptionCode);
		txtSubscriptionCode.setColumns(10);
		
		JLabel lblSubscription = new JLabel("Codice abbonamento");
		lblSubscription.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblSubscription.setBounds(421, 503, 161, 14);
		add(lblSubscription);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date currentDate = Calendar.getInstance().getTime();
		if (isPressed == btnMakePurchase) {
			try {
				this.observer.saveAccountingClicked(
						(Date) dateFormat.parse((dateFormat.format(currentDate))),
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
