package view;

import view.observer.NorthPanelObserver;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class NorthPanelImpl extends JPanel implements NorthPanel, ActionListener {
	public static final String LOGIN = "Login";
	public static final String LOGOuT = "Logout";
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
		btnHome.setBounds(25, 390, 115, 30);

		btnLog = new JButton(LOGIN);
		btnLog.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnLog.setBounds(25, 390, 115, 30);

		this.add(btnHome);
		this.add(btnLog);

		btnLog.addActionListener(this);
		btnHome.addActionListener(this);

		this.setPreferredSize(new Dimension(800, 150));

		logTxt = new JTextArea("");
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
	public void setObserver(NorthPanelObserver observer) {
	}

	@Override
	public void clearPanel() {
		this.logTxt.setText("");
	}

	@Override
	public void diaplayLoggedEmployee(String nome, String cognome) {
		this.logTxt.setText("Benvenuto!\r\n" + nome + " " + cognome);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object buttonSelected = e.getSource();
		if (buttonSelected == btnLog) {
			this.observer.changeLogStatus();
		} else if (buttonSelected == btnHome) {
			this.observer.buttomHomeClicked();
		}

	}

}
