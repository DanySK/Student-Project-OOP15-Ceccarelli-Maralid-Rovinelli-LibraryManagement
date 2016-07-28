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

public class MainViewImpl extends JFrame 
		       implements MainView,ActionListener, WindowListener{
	private NorthPanel northPanel;
	private ViewObserver observer;
	private JLabel heading;
	private JMenuItem [] menuItem;
	private JMenuBar menuBar;
	private JFileChooser fileChooser;
	private JMenu menu;
	
	public MainViewImpl() {
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(new BorderLayout(0,0));
		this.setTitle("Library - Managment");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*disabilitazione del ridimensionamento per evitare eventuali problemi nella 
	 	visualizzazione della GUI*/
		this.setResizable(false);
		this.setSize(800, 650);
	
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMessage(String message) {
		// TODO Auto-generated method stub
		
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
