package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.observer.AddBookObserver;

import javax.swing.JButton;
//da aggiungere i controlli sulle textField
public class AddBookPanelImpl extends JPanel implements AddBookPanel, ActionListener {

	/**
	 * Create the panel.
	 */
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPrice;
	private JTextField txtAmmount;
	private JTextField txtTotalPrice;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblLiteraryGenre;
	private JLabel lblPrice;
	private JLabel lblYear;
	private JLabel lblPanelTitle;
	private JLabel lblAmmount;
	private JComboBox cmbLiteraryGenre;
	private JComboBox cmbYear;
	private static final long serialVersionUID = 1L;
	private JLabel lblMessage;
	private JButton btnRemoveOne;
	private JButton btnAddBook;
	private JButton btnRemoveTen;
	private JButton btnAddTen;
	private JButton btnAddOne;
	private AddBookObserver observer;
	
	public AddBookPanelImpl() {
		this.setLayout(null);
		setBackground(SystemColor.activeCaption);

		lblTitle = new JLabel("Titolo:");
		lblTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 77, 154, 17);
		add(lblTitle);

		lblAuthor = new JLabel("Autore:");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblAuthor.setBounds(436, 77, 154, 17);
		add(lblAuthor);

		lblLiteraryGenre = new JLabel("Genere:");
		lblLiteraryGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiteraryGenre.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblLiteraryGenre.setBounds(230, 78, 154, 14);
		add(lblLiteraryGenre);

		lblYear = new JLabel("Anno:");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblYear.setBounds(10, 163, 154, 14);
		add(lblYear);

		cmbLiteraryGenre = new JComboBox();
		cmbLiteraryGenre.setFont(new Font("Calibri", Font.ITALIC, 13));
		cmbLiteraryGenre.setBounds(230, 103, 154, 20);
		cmbLiteraryGenre.addItem("Fanatscienza");
		cmbLiteraryGenre.addItem("Storico");
		cmbLiteraryGenre.addItem("Noire");
		cmbLiteraryGenre.addItem("Horror");
		add(cmbLiteraryGenre);

		cmbYear = new JComboBox();
		cmbYear.setFont(new Font("Calibri", Font.ITALIC, 13));
		cmbYear.setBounds(10, 188, 154, 20);
		add(cmbYear);

		txtTitle = new JTextField();
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtTitle.setBounds(10, 105, 154, 20);
		add(txtTitle);
		txtTitle.setColumns(10);

		txtAuthor = new JTextField();
		txtAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuthor.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtAuthor.setBounds(436, 105, 154, 20);
		add(txtAuthor);
		txtAuthor.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtPrice.setBounds(230, 188, 154, 20);
		add(txtPrice);
		txtPrice.setColumns(10);

		lblPrice = new JLabel("Prezzo singolo:");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblPrice.setBounds(230, 163, 154, 14);
		add(lblPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrice.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setEnabled(false);
		txtTotalPrice.setBounds(10, 274, 154, 20);
		add(txtTotalPrice);
		txtTotalPrice.setColumns(10);

		lblAmmount = new JLabel("Totale:");
		lblAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblAmmount.setBounds(10, 249, 154, 14);
		add(lblAmmount);

		lblPanelTitle = new JLabel("Ordina libro");
		lblPanelTitle.setForeground(new Color(255, 69, 0));
		lblPanelTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle.setBounds(10, 11, 580, 55);
		add(lblPanelTitle);

		lblMessage = new JLabel("");
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Calibri", Font.ITALIC, 13));
		lblMessage.setBounds(10, 323, 580, 144);
		add(lblMessage);

		btnAddBook = new JButton("Aggiungi libri");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		btnAddBook.setBounds(230, 249, 154, 63);
		btnAddBook.addActionListener(this);
		add(btnAddBook);

		txtAmmount = new JTextField();
		txtAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmmount.setFont(new Font("Calibri", Font.ITALIC, 13));
		txtAmmount.setText("1");
		txtAmmount.setEditable(false);
		txtAmmount.setEnabled(false);
		txtAmmount.setBounds(436, 188, 154, 20);
		add(txtAmmount);
		txtAmmount.setColumns(10);

		lblAmmount = new JLabel("Quantità:");
		lblAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmmount.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblAmmount.setBounds(436, 163, 154, 14);
		add(lblAmmount);

		btnRemoveOne = new JButton("-");
		btnRemoveOne.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnRemoveOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoveOne.setBounds(436, 252, 56, 23);
		btnRemoveOne.addActionListener(this);
		add(btnRemoveOne);

		btnRemoveTen = new JButton("--");
		btnRemoveTen.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnRemoveTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveTen.setBounds(436, 286, 56, 23);
		btnRemoveTen.addActionListener(this);
		add(btnRemoveTen);

		btnAddTen = new JButton("++");
		btnAddTen.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnAddTen.setBounds(534, 289, 56, 23);
		btnAddTen.addActionListener(this);
		add(btnAddTen);

		btnAddOne = new JButton("+");
		btnAddOne.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		btnAddOne.setBounds(534, 252, 56, 23);
		btnAddOne.addActionListener(this);
		add(btnAddOne);

		txtTitle = new JTextField();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		if (isPressed == btnAddOne) {
			txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) + 1));
		} else if (isPressed == btnAddTen) {
			txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) + 10));
		} else if (isPressed == btnRemoveOne && Integer.parseInt(txtAmmount.getText()) > 1) {
			txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) - 1));
		}else if (isPressed == btnRemoveOne && Integer.parseInt(txtAmmount.getText()) > 10){
			txtAmmount.setText(String.valueOf(Integer.parseInt(txtAmmount.getText()) - 10));
		}else if (isPressed == btnAddBook){
			observer.addBookClick();
		}
	}

	@Override
	public void displayMessage(String message) {
		lblMessage.setText(message);

	}

	@Override
	public void attachObserver(AddBookObserver observer) {
		this.observer = observer;
		
	}

	@Override
	public void clearView() {
		txtAmmount.setText("1");
		txtAuthor.setText("");
		txtTitle.setText("");
		txtPrice.setText("");
		txtTotalPrice.setText("");
	}

	public void setYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = year - 16; i >= year - 100; i--) {
			cmbYear.addItem(i);
		}
	}

	@Override
	public double setTotalPrice(int ammount, double price) {
		return ammount * price;
	}

	
}
