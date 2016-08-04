package view.observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface AddEmployeeObserver {
	/**
	  * metodo per salvare i dati di un nuovo dipendnte su un file di testo
	  * 
	  * @param name
	  * @param username
	  * @param address
	  * @param username
	  * @param password 
	  * @param email
	  * @param telephoneNumber
	  * @param taxCode
	  * @param birthDate
	  * @param hireDate
	  **/
	void saveEmployee(String name, String surname, String address,
			String username, char [] password, String email, 
			int telephoneNumber, String taxCode, Date birthDate,
			SimpleDateFormat hireDate);
	
	/**
	 * metodo per creare un messaggio per il risultato del salvataggio di un dipendente nuovo
	 * 
	 * @param message
	 **/
	void DisplayMessage(String message);

	
}
