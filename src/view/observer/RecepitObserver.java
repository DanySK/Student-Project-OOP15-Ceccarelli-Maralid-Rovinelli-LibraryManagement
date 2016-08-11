package view.observer;

import java.util.Date;

public interface RecepitObserver {
	/**
	 *permette di tenere traccia di una avvenuta vendita per stilare un resoconto finale ,
	 *il parametro today salva il giorno corrente,   mouney è l'incasso metre type è 
	 *il metodo di pagamento utilizzato
	 * 
	 * @param month
	 * @param money
	 * @param type
	 **/
	void saveAccountingClicked(Date today, double money, String type);
	
}
