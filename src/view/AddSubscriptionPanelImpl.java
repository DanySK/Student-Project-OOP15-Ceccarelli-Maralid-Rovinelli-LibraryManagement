package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.observer.AddSubscriptionObserver;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddSubscriptionPanelImpl extends JPanel implements AddSubscriptionPanel, ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtSurname;
	private JLabel lblTitle;
	private JLabel lblAccountHolder;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblType;
	private JButton btnAddSubcription;
	private AddSubscriptionObserver observer;
	private JButton btnClear;
	private JTextField txtType;

	/**
	 * Create the panel.
	 */
	public AddSubscriptionPanelImpl() {
		this.setLayout(null);
		setBackground(SystemColor.activeCaption);

		lblTitle = new JLabel("Abbonamenti");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setBounds(10, 11, 880, 51);
		add(lblTitle);

		lblAccountHolder = new JLabel("Dati intestatario:");
		lblAccountHolder.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		lblAccountHolder.setBounds(30, 115, 260, 14);
		add(lblAccountHolder);

		lblName = new JLabel("Nome:");
		lblName.setFont(new Font("Calibri", Font.ITALIC, 13));
		lblName.setBounds(30, 140, 171, 14);
		add(lblName);

		lblSurname = new JLabel("Cognome:");
		lblSurname.setFont(new Font("Calibri", Font.ITALIC, 13));
		lblSurname.setBounds(30, 196, 171, 14);
		add(lblSurname);

		txtName = new JTextField();
		txtName.setBounds(30, 165, 171, 20);
		add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.setBounds(30, 220, 171, 20);
		add(txtSurname);
		txtSurname.setColumns(10);

		lblType = new JLabel("Tipo abbonamento");
		lblType.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		lblType.setBounds(30, 251, 171, 14);
		add(lblType);

		btnAddSubcription = new JButton("Aggiungi abbonameto");
		btnAddSubcription.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		btnAddSubcription.setBounds(30, 307, 180, 70);
		btnAddSubcription.addActionListener(this);
		add(btnAddSubcription);

		btnClear = new JButton("Pulisci tutto");
		btnClear.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBounds(251, 115, 125, 50);
		btnClear.addActionListener(this);
		add(btnClear);
		
		txtType = new JTextField();
		txtType.setEnabled(false);
		txtType.setEditable(false);
		txtType.setBounds(30, 276, 171, 20);
		add(txtType);
		txtType.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		if (isPressed == btnClear) {
			this.clearPanel();
		} else if (isPressed == btnAddSubcription) {
			this.observer.addNewSubcriptionClicked(txtName.getText(), txtSurname.getText());
		}

	}

	@Override
	public void attachObserver(AddSubscriptionObserver observer) {
		this.observer = observer;

	}

	@Override
	public void clearPanel() {
		this.txtName.setText("");
		this.txtSurname.setText("");
	}
}
