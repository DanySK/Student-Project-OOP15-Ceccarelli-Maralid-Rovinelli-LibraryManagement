package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.observer.LoginObserver;
import view.observer.ViewObserver;

public class MainViewImpl extends JFrame implements MainView, ActionListener, WindowListener {
	private NorthPanelImpl northPanel;
	private ViewObserver observer;
	private JMenuBar menuBar;
	private JMenuItem mntmExit;
	private JMenuBar menuBar_1;
	private JMenu mnShop;
	private JMenuItem mntmCercaLibro;
	private JMenuItem mntmGestisciAbbonamenti;
	private JMenu mnWarehose;
	private JMenuItem mntmOrdinaScorte;
	private JMenu mnFile;
	private JMenuItem mntmAddEmployee;
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmRelocateBooks;
	private LoginObserver loginObserver = new LoginObserver() {
		
		@Override
		public void registerEmployeeClicked() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean loginFlag() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void loginEmployee(String username, char[] password) {
			// TODO Auto-generated method stub
			
		}
	};

	public MainViewImpl() {
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setTitle("Library-Managment-System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * disabilitazione del ridimensionamento per evitare eventuali
		 * problemi nella visualizzazione della GUI
		 */
		this.setResizable(false);
		this.setSize(900, 700);

		new JFileChooser();

		Container c = this.getContentPane();
		northPanel = new NorthPanelImpl();
		c.add(northPanel, BorderLayout.NORTH);

		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);

		menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		mnFile = new JMenu("File");
		menuBar_1.add(mnFile);

		/*
		 * mntmSalva = new JMenuItem("Salva");
		 * mntmSalva.addActionListener(this);
		 * 
		 * mntmSalva = new JMenuItem("Salva");
		 * mntmSalva.addActionListener(this); mnFile.add(mntmSalva);
		 * 
		 * mntmApri = new JMenuItem("Apri");
		 * mntmApri.addActionListener(this);
		 * 
		 * mntmApri = new JMenuItem("Apri");
		 * mntmApri.addActionListener(this); mnFile.add(mntmApri);
		 */

		mntmExit = new JMenuItem("Esci");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(this);

		mnShop = new JMenu("Negozio");
		mnShop.setEnabled(false);
		menuBar_1.add(mnShop);

		mntmCercaLibro = new JMenuItem("Cerca libro");
		mnShop.add(mntmCercaLibro);
		mntmCercaLibro.addActionListener(this);

		mntmGestisciAbbonamenti = new JMenuItem("Gestisci abbonamenti");
		mnShop.add(mntmGestisciAbbonamenti);
		
				mntmAddEmployee = new JMenuItem("Aggiungi dipendente");
				mnShop.add(mntmAddEmployee);
				mntmAddEmployee.addActionListener(this);
		mntmGestisciAbbonamenti.addActionListener(this);

		mnWarehose = new JMenu("Magazzino");
		mnWarehose.setEnabled(false);
		menuBar_1.add(mnWarehose);

		mntmOrdinaScorte = new JMenuItem("Ordina scorte");
		mnWarehose.add(mntmOrdinaScorte);
		mntmOrdinaScorte.addActionListener(this);

		mntmRelocateBooks = new JMenuItem("Tasferisci libri");
		mnWarehose.add(mntmRelocateBooks);
		mntmRelocateBooks.addActionListener(this);

		this.setVisible(true);

	}

	public void windowOpened(WindowEvent arg0) {
		this.observer.dataLoad();
	}

	public void windowClosing(WindowEvent arg0) {
		this.observer.saveData();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object isPressed = e.getSource();
		
		if (isPressed == mntmExit) {
			this.observer.exitCommand();
		} else if (isPressed == mntmCercaLibro) {
			this.observer.bookShopClicked();
		} else if (isPressed == mntmGestisciAbbonamenti) {
			this.observer.addSubscriptionClicked();
		} else if (isPressed == mntmOrdinaScorte) {
			this.observer.addBooksClicked();
		} else if (isPressed == mntmAddEmployee) {
			this.observer.addEmployeeClicked();
		} else if (isPressed == mntmRelocateBooks) {
			this.observer.warehouseClicked();
		}

	}

	@Override
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void replaceMainPanel(JPanel panel) {
		this.resetFrame();
		Container c = this.getContentPane();
		c.add(panel, BorderLayout.CENTER);
		this.repaint();
		panel.updateUI();
	}

	@Override
	public NorthPanel getNorthPanel() {
		return this.northPanel;
	}

	@Override
	public void attachObserver(ViewObserver observer) {
		this.observer = observer;

	}

	private void resetFrame() {
		Container c = this.getContentPane();
		c.removeAll();
		c.add(northPanel, BorderLayout.NORTH);
	}

	@Override
	public void changeLogStatus(Boolean logged) {
		if(logged == true){
			mnShop.setEnabled(true);
			mnWarehose.setEnabled(true);
		}else {
			mnShop.setEnabled(false);
			mnWarehose.setEnabled(false);
		}
		
	}
}