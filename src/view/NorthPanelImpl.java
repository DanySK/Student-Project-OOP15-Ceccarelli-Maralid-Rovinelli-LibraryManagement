package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import view.observer.NorthPanelObserver;

public class NorthPanelImpl extends JPanel implements NorthPanel, ActionListener {
	
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	public static final String HOME = "Home";
	private NorthPanelObserver observer;
	private JButton btnHome;
	private JButton btnLog;
	private JTextArea logTxt;
	private static final long serialVersionUID = 1;

	public NorthPanelImpl() {
		super();
		setBackground(new Color(255, 255, 255));// bianco
		this.setLayout(null);

		btnHome = new JButton(HOME);
		btnHome.setEnabled(false);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnHome.setBounds(10, 42, 115, 30);

		btnLog = new JButton(LOGIN);
		btnLog.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnLog.setBounds(162, 42, 115, 30);

		this.add(btnHome);
		this.add(btnLog);

		btnLog.addActionListener(this);
		btnHome.addActionListener(this);

		this.setPreferredSize(new Dimension(600, 100));

		logTxt = new JTextArea("none");
		logTxt.setBounds(10, 7, 55, 24);
		logTxt.setFont(new Font("Calibri", Font.PLAIN, 15));
		logTxt.setEditable(false);
		add(logTxt);
	}

	@Override
	public void checkEmployeeLogin() {
		this.btnLog.setText("Logout");
		this.btnHome.setEnabled(true);
		this.btnHome.setVisible(true);

	}

	@Override
	public void checkEmployeeLogout() {
		this.btnLog.setText("Login");
		this.btnHome.setEnabled(false);
		this.btnHome.setVisible(false);
	}

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
		this.logTxt.setText("Benvenuto!\r\n" + nome + " " + cognome);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object buttonSelected = e.getSource();
		if (buttonSelected == btnLog) {
			this.observer.buttonLoginClicked();
		} else if (buttonSelected == btnHome) {
			this.observer.buttonHomeClicked();
		}

	}

}