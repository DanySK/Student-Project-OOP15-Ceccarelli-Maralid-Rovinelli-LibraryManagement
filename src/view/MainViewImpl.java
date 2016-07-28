package view;

/**
 * @author Ceccarelli
 * */
import javax.swing.*;

import view.observer.ViewObserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainViewImpl extends JFrame implements MainView, ActionListener, WindowListener {
	private NorthPanelImpl northPanel;
	private ViewObserver observer;
	private JMenuItem[] menuItem;
	private JMenuBar menuBar;
	private JFileChooser fileChoosen;
	private JMenu menu;

	public MainViewImpl() {
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setTitle("Library - Managment - System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * disabilitazione del ridimensionamento per evitare eventuali
		 * problemi nella visualizzazione della GUI
		 */
		this.setResizable(false);
		this.setSize(800, 650);

		fileChoosen = new JFileChooser();

		Container c = this.getContentPane();
		northPanel = new NorthPanelImpl();
		c.add(northPanel,BorderLayout.NORTH);

		/* 1a voce del menu */
		menu = new JMenu("File");
		menuItem = new JMenuItem[3];
		menuItem[0] = new JMenuItem("Salva", new ImageIcon("res/save.jpg"));
		menuItem[1] = new JMenuItem("Carica");
		menuItem[2] = new JMenuItem("Esci");
		for (int i = 0; i < 3; i++) {
			menuItem[i].addActionListener(this);
		}
		for (int i = 0; i < 3; i++) {
			menu.add(menuItem[i]);
		}
		menuBar.add(menu);
		/* 2a voce del menu */
		/*menu = new JMenu("Libreria");
		menuItem[0] = new JMenuItem("Cerca un Libro");
		menuItem[1] = new JMenuItem("Carrello");
		menuItem[2] = new JMenuItem("Gestione abbonamenti");
		menuBar.add(menu);
		for (int i = 0; i < 3; i++) {
			menuItem[i].addActionListener(this);
		}
		for (int i = 0; i < 3; i++) {
			menu.add(menuItem[i]);
		}
		menuBar.add(menu);
		/* 3a voce del menu */
		/*menu = new JMenu("Gestione magazzino");
		menuItem[0] = new JMenuItem("Ordina scorte");
		menuItem[0].addActionListener(this);
		menuBar.add(menu);*/
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);
		this.setVisible(true);

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.observer.saveData();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		this.observer.dataLoad();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object menuSource = arg0.getSource();
		if (menuSource == menuItem[0]) {
			if (this.fileChoosen.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				this.observer.dataLoad(this.fileChoosen.getSelectedFile()
						.getPath());
			}
		} else if (menuSource == menuItem[1]) {
			if (this.fileChoosen.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				this.observer.saveData(this.fileChoosen.getSelectedFile()
						.getPath());
			}
		} else if (menuSource == menuItem[2]) {
			this.observer.exitCommand();
		}

	}

	@Override
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);

	}

	@Override
	public void replaceMainPanel(JPanel panel) {
		// TODO Auto-generated method stub

	}

	@Override
	public NorthPanel getNorthPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attachObserver(ViewObserver observer) {
		// TODO Auto-generated method stub

	}

}
