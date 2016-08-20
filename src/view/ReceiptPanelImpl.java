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
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.BookModel;
import view.observer.RecepitObserver;

public class ReceiptPanelImpl extends JPanel implements ReceiptPanel, ActionListener {

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
	private JLabel lblSubscription;

	/**
	 * Create the panel.
	 */
	public ReceiptPanelImpl() {
		setBackground(SystemColor.inactiveCaption);
		this.setLayout(null);
		modelReport = new DefaultTableModel(new Object[][] {}, new String[] { "Titolo", "Quantita'", "Prezzo" });

		scpReport = new JScrollPane();
		scpReport.setEnabled(false);
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
		txtTotalPrice.setBounds(20, 523, 161, 20);
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

		lblSubscription = new JLabel("Codice abbonamento");
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
				this.observer.saveAccountingClicked((Date) dateFormat.parse((dateFormat.format(currentDate))),
						cmbTypeOfPayment.getSelectedIndex(), txtSubscriptionCode.getText().toString());
			} catch (NumberFormatException | ParseException e1) {

				e1.printStackTrace();
			}
		}
	}

	@Override
	public void attachObserver(RecepitObserver observer) {
		this.observer = observer;
		this.setRecepit();

	}

	@Override
	public void setRecepit() {
		clearTable(modelReport);
		Map<BookModel, Integer> tmp = this.observer.getPurchaseRecap();
		int i = 0;

		for (BookModel entry : tmp.keySet()) {
			if (entry.getTitle() == null) {

			} else {
				Object[] obj = { entry.getTitle(), tmp.values().toArray()[i],
						entry.getPrice() * (Integer) tmp.values().toArray()[i] };
				((DefaultTableModel) modelReport).addRow(obj);
				tblReport.repaint();
				i++;
			}
		}
		if (tblReport.getRowCount() > 0) {
			tblReport.setRowSelectionInterval(0, 0);
		}
	}

	private void clearTable(DefaultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Attenzione", JOptionPane.PLAIN_MESSAGE);
	}
}
