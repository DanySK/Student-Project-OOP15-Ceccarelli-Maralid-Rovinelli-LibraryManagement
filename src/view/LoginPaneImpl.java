package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import view.observer.LoginObserver;

public class LoginPaneImpl extends JPanel implements LoginPanel, ActionListener {

	private static final long serialVersionUID = 1;
	private JButton btnLogin;
	private JButton btnClear;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private LoginObserver observer;

	public LoginPaneImpl() {
		super();
		this.setBackground(Color.WHITE);
		this.setLayout(null);// utilizzo il mainview per i riferimenti

		lbUsername = new JLabel();
		lbUsername.setFont(new Font("Calibri", Font.ITALIC, 14));
		lbUsername.setText("Username:");
		lbUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lbUsername.setBounds(90, 145, 85, 25);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Calibri", Font.ITALIC, 14));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(80, 145, 160, 20);

		lbPassword = new JLabel();
		lbPassword.setFont(new Font("Calibri", Font.ITALIC, 14));
		lbPassword.setText("Password:");
		lbPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbPassword.setBounds(270, 145, 85, 25);

		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(260, 145, 160, 20);

		btnLogin = new JButton();
		btnLogin.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnLogin.setBounds(170, 195, 120, 40);
		btnLogin.setText("Accedi");

		btnClear = new JButton();
		btnClear.setFont(new Font("Calibri", Font.ITALIC, 13));
		btnClear.setBounds(170, 240, 150, 25);
		btnClear.setText("Pulisci tutto");

		this.add(lbUsername);
		this.add(txtUsername);
		this.add(lbPassword);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(btnClear);

	}

	@Override
	public void clearLogin() {
		this.txtUsername.setText("");
		this.txtPassword.setText("");

	}

	@Override
	public void attachObserver(LoginObserver observer) {
		this.observer=observer;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();

		if (isPressed == btnLogin) {
			this.observer.loginEmployee(txtUsername.getText(), new String(txtPassword.getPassword()));
		} else if (isPressed == btnClear) {
			this.clearLogin();
		}
	}

}
