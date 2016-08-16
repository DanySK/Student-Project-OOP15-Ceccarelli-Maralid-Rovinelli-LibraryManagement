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

import view.observer.ViewObserver;


public class MainViewImpl extends JFrame implements MainView, ActionListener, WindowListener {
	private NorthPanelImpl northPanel;
	private ViewObserver observer;
	private JMenuBar menuBar;
	private JFileChooser fileChoosen;
	private JMenuItem mntmExit;
	private JMenuBar menuBar_1;
	private JMenu mnNewMenu;
	private JMenuItem mntmCercaLibro;
	private JMenuItem mntmCarrello;
	private JMenuItem mntmGestisciAbbonamenti;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmOrdinaScorte;
	private JMenuItem mntmSalva;
	private JMenuItem mntmApri;
	private JMenu mnFile;
	private JMenuItem mntmAddEmployee;
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmRelocateBooks;

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

		fileChoosen = new JFileChooser();

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
		
		/*mntmSalva = new JMenuItem("Salva");
		mntmSalva.addActionListener(this);

		mntmSalva = new JMenuItem("Salva");
		mntmSalva.addActionListener(this);
		mnFile.add(mntmSalva);
		
		mntmApri = new JMenuItem("Apri");
		mntmApri.addActionListener(this);

		mntmApri = new JMenuItem("Apri");
		mntmApri.addActionListener(this);		
		mnFile.add(mntmApri);*/
		
				
		mntmAddEmployee = new JMenuItem("Aggiungi dipendente");
		mnFile.add(mntmAddEmployee);

		mntmExit = new JMenuItem("Esci");		
		mnFile.add(mntmExit);
		mntmExit.addActionListener(this);

		mnNewMenu = new JMenu("Negozio");
		menuBar_1.add(mnNewMenu);
		

		mntmCercaLibro = new JMenuItem("Cerca libro");
		mnNewMenu.add(mntmCercaLibro);
		mntmCercaLibro.addActionListener(this);

		mntmGestisciAbbonamenti = new JMenuItem("Gestisci abbonamenti");
		mnNewMenu.add(mntmGestisciAbbonamenti);
		mntmGestisciAbbonamenti.addActionListener(this);

		mnNewMenu_1 = new JMenu("Magazzino");
		menuBar_1.add(mnNewMenu_1);
		

		mntmOrdinaScorte = new JMenuItem("Ordina scorte");
		mnNewMenu_1.add(mntmOrdinaScorte);
		mntmOrdinaScorte.addActionListener(this);
		
		mntmRelocateBooks = new JMenuItem("Tasferisci libri");
		mnNewMenu_1.add(mntmRelocateBooks);
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
		  } else if (isPressed == mntmCercaLibro){   
		   this.observer.bookShopClicked();
		  }else if (isPressed == mntmGestisciAbbonamenti){
		   this.observer.addSubscriptionClicked();
		  }else if(isPressed == mntmOrdinaScorte){
		   this.observer.addBooksClicked();
		  }else if(isPressed == mntmAddEmployee){
		   this.observer.addEmployeeClicked();
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
}