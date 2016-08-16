package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import view.observer.LoginObserver;
import view.observer.NorthPanelObserver;
import java.awt.SystemColor;

public class NorthPanelImpl extends JPanel implements NorthPanel, ActionListener {

	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	public static final String HOME = "Home";
	private NorthPanelObserver observer;
	private JButton btnHome;
	private JButton btnLogin;
	private JTextArea logTxt;
	private static final long serialVersionUID = 1;
	private JButton btnNewButton;
	private LoginObserver loginObserver;
	private JButton btnLogout;

	public NorthPanelImpl() {
		super();
		setBackground(SystemColor.inactiveCaption);// bianco
		this.setLayout(null);
		

		btnHome = new JButton(HOME);
		btnHome.setBackground(SystemColor.inactiveCaptionBorder);
		btnHome.setEnabled(false);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnHome.setBounds(10, 42, 115, 30);

		btnLogin = new JButton(LOGIN);
		btnLogin.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogin.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnLogin.setBounds(162, 42, 115, 30);

		this.add(btnHome);
		this.add(btnLogin);

		btnLogin.addActionListener(this);
		btnHome.addActionListener(this);

		this.setPreferredSize(new Dimension(900, 100));

		logTxt = new JTextArea("none");
		logTxt.setBackground(SystemColor.inactiveCaption);
		logTxt.setBounds(10, 7, 580, 24);
		logTxt.setFont(new Font("Calibri", Font.PLAIN, 15));
		logTxt.setEditable(false);
		add(logTxt);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(430, 46, 89, 23);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		btnLogout = new JButton("Logout");
		btnLogout.setEnabled(false);
		btnLogout.setFont(new Font("Calibri", Font.ITALIC, 13));
		btnLogout.setBounds(162, 42, 115, 30);
		btnLogout.addActionListener(this);
		add(btnLogout);
		btnLogout.setVisible(false);
		btnLogout.setEnabled(false);
	}

	/*
	 * public void checkEmployeeLogin() {
	 * 
	 * this.btnLog.setText("Logout"); this.btnHome.setEnabled(true);
	 * this.btnHome.setVisible(true);
	 * 
	 * }
	 * 
	 * 
	 * public void checkEmployeeLogout() { this.btnLog.setText("Login");
	 * this.btnHome.setEnabled(false); this.btnHome.setVisible(false); }
	 */

	@Override
	public void attachObserver(NorthPanelObserver observer) {
		this.observer = observer;
	}

	@Override
	public void clearPanel() {
		this.logTxt.setText("");
	}

	@Override
	public void displayLoggedEmployee(String nome, String cognome) {
		this.logTxt.setText("Benvenuto: " + nome + " " + cognome);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		/*if (loginObserver.loginFlag() == true) {
			btnLogin.setEnabled(false);
			btnLogin.setVisible(false);
			btnLogout.setEnabled(true);
			btnLogout.setVisible(true);
		} else {
			btnLogin.setEnabled(true);
			btnLogin.setVisible(true);
			btnLogout.setEnabled(false);
			btnLogout.setVisible(false);
		}*/
		if (isPressed == btnLogin) {
			this.observer.buttonLoginClicked();
		} else if (isPressed == btnHome) {
			this.observer.buttonHomeClicked();
		} else if (isPressed == btnNewButton) {
			observer.OpenAddBookClick();
		}

	}
}