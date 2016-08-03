package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.observer.AddEmployeeObserver;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class AddEmployeeImpl extends JPanel implements AddEmployee, ActionListener {
	JLabel lblTitle;
	JDatePicker hireDate;

	public AddEmployeeImpl() {
		setBackground(SystemColor.activeCaption);
		this.setLayout(null);

		lblTitle = new JLabel("Aggiunta Dipendente");
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 580, 48);
		add(lblTitle);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void cleanInterface() {

	}

	@Override
	public void attachObserver(AddEmployeeObserver observer) {

	}

	@Override
	public void displayMessage(String message) {

	}
}
