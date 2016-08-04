package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import view.observer.AddEmployeeObserver;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddEmployeeImpl extends JPanel implements AddEmployee, ActionListener {

	private AddEmployeeObserver observer;
	private JLabel lblTitle;
	private JTextField txtName;
	private JTextField txtSurname;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtHouseNumber;
	private JTextField txtTaxCode;
	private JTextField txtTelephone;
	private JLabel lblCity;
	private JLabel lblAddress;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblStreet;
	private JLabel lblHouseNumber;
	private JLabel lblTelephone;
	private JLabel lblTaxCode;
	private JLabel lblBirthDay;
	private JComboBox cmbDay;
	private JComboBox cmbMonth;
	private JComboBox cmbYear;
	private JButton btnAddEmployee;
	private JButton btnClear;
	private JLabel lblMessage;
	private JLabel lblEmail;
	private JTextField txtEmail;

	public AddEmployeeImpl() {
		setBackground(SystemColor.activeCaption);
		this.setLayout(null);

		lblTitle = new JLabel("Aggiunta Dipendente");
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 580, 48);
		add(lblTitle);

		lblName = new JLabel("Nome:");
		lblName.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblName.setBounds(28, 83, 143, 14);
		add(lblName);

		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtName.setBounds(28, 101, 143, 20);
		add(txtName);
		txtName.setColumns(10);

		lblSurname = new JLabel("Cognome:");
		lblSurname.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblSurname.setBounds(28, 132, 140, 14);
		add(lblSurname);

		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtSurname.setBounds(28, 147, 143, 20);
		add(txtSurname);
		txtSurname.setColumns(10);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblUsername.setBounds(28, 178, 143, 14);
		add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtUsername.setBounds(28, 192, 143, 20);
		add(txtUsername);
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(28, 223, 143, 14);
		add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtPassword.setBounds(28, 237, 143, 20);
		add(txtPassword);

		lblAddress = new JLabel("Indirizzo:");
		lblAddress.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblAddress.setBounds(28, 268, 143, 14);
		add(lblAddress);

		txtCity = new JTextField();
		txtCity.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtCity.setBounds(28, 300, 86, 20);
		add(txtCity);
		txtCity.setColumns(10);

		txtStreet = new JTextField();
		txtStreet.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtStreet.setBounds(123, 300, 86, 20);
		add(txtStreet);
		txtStreet.setColumns(10);

		txtHouseNumber = new JTextField();
		txtHouseNumber.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtHouseNumber.setBounds(220, 300, 44, 20);
		add(txtHouseNumber);
		txtHouseNumber.setColumns(10);

		lblCity = new JLabel("città");
		lblCity.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setBounds(28, 288, 86, 14);
		add(lblCity);

		lblStreet = new JLabel("via");
		lblStreet.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblStreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreet.setBounds(123, 288, 86, 14);
		add(lblStreet);

		lblHouseNumber = new JLabel("N#");
		lblHouseNumber.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblHouseNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumber.setBounds(220, 288, 44, 14);
		add(lblHouseNumber);

		lblTaxCode = new JLabel("Codice Fiscale:");
		lblTaxCode.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTaxCode.setBounds(28, 331, 143, 14);
		add(lblTaxCode);

		txtTaxCode = new JTextField();
		txtTaxCode.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtTaxCode.setBounds(28, 348, 143, 20);
		add(txtTaxCode);
		txtTaxCode.setColumns(10);

		lblTelephone = new JLabel("telefono:");
		lblTelephone.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTelephone.setBounds(358, 101, 143, 14);
		add(lblTelephone);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(358, 121, 143, 20);
		add(txtTelephone);
		txtTelephone.setColumns(10);

		lblBirthDay = new JLabel("Anno di nascita:");
		lblBirthDay.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblBirthDay.setBounds(358, 151, 143, 14);
		add(lblBirthDay);

		cmbDay = new JComboBox();
		cmbDay.setToolTipText("");
		cmbDay.setBounds(358, 171, 50, 20);
		add(cmbDay);

		cmbMonth = new JComboBox();
		cmbMonth.setBounds(418, 171, 50, 20);
		
		add(cmbMonth);

		cmbYear = new JComboBox();
		cmbYear.setBounds(475, 171, 95, 20);
		add(cmbYear);

		btnAddEmployee = new JButton("Aggiungi dipendente");
		btnAddEmployee.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnAddEmployee.setBounds(358, 264, 170, 40);
		add(btnAddEmployee);

		btnClear = new JButton("Pulisci");
		btnClear.setFont(new Font("Calibri", Font.ITALIC, 14));
		btnClear.setBounds(475, 451, 115, 38);
		add(btnClear);
		
		lblMessage = new JLabel("");
		lblMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessage.setVerticalAlignment(SwingConstants.TOP);
		lblMessage.setForeground(Color.RED);
		lblMessage.setBackground(Color.BLACK);
		lblMessage.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblMessage.setBounds(181, 348, 271, 141);
		add(lblMessage);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblEmail.setBounds(358, 199, 212, 14);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.ITALIC, 10));
		txtEmail.setBounds(358, 217, 212, 20);
		add(txtEmail);
		txtEmail.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object btnIsPressed = e.getSource();
		String address;
		int telephoneNumber;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat hireDate = new SimpleDateFormat();
				
		Date birthDate;
		if (btnIsPressed == btnAddEmployee) {
			try {
				this.observer.saveEmployee(txtName.getText(), txtSurname.getText(),
						(address=txtCity.getText()+" "+ txtStreet.getText()+" "+txtHouseNumber.getText()),
						txtUsername.getText(),txtPassword.getPassword(),txtEmail.getText(),
						telephoneNumber=Integer.parseInt(txtTelephone.getText()),txtTaxCode.getText(),
						birthDate=(Date)dateFormat.parse(cmbYear.getSelectedItem()+"/"+cmbMonth.getSelectedItem()+"/"+cmbDay.getSelectedItem()),hireDate);
						
						
			} catch (NumberFormatException | ParseException e1) {
				this.displayMessage("Si prega di riempire in modo adeguato tutti i campi presenti ");
				//implementare l'eccezione del parse
						}
		} else if (btnIsPressed == btnClear) {
			this.cleanInterface();
		}
	}

	@Override
	public void cleanInterface() {
		this.txtName.setText("");
		this.txtSurname.setText("");
		this.txtUsername.setText("");
		this.txtPassword.setText("");
		this.txtCity.setText("");
		this.txtStreet.setText("");
		this.txtHouseNumber.setText("");
		this.txtTaxCode.setText("");
		this.txtEmail.setText("");
		this.txtTelephone.setText("");
		this.cmbDay.setSelectedItem("");
		this.cmbMonth.setSelectedItem("");
		this.cmbYear.setSelectedItem("");
		this.lblMessage.setText("");
	}

	@Override
	public void attachObserver(AddEmployeeObserver observer) {
		this.observer = observer;
	}

	@Override
	public void displayMessage(String message) {
		lblMessage.setText(message);
	}
}
