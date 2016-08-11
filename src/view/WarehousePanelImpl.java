package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WarehousePanelImpl extends JPanel implements WarehousePanel, ActionListener {

	/**
	 * Create the panel.
	 */
	
	private JTable allBooks;
	private DefaultTableModel modelAllBooks;
	private JScrollPane scrAllBooks;
	public WarehousePanelImpl() {
		this.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
