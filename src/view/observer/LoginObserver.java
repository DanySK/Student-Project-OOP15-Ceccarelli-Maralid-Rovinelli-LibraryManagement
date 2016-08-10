package view.observer;

public interface LoginObserver {
	/**
	 * metodo utilizzato per caricare la view per la registrazione di un
	 * nuovo dipendete
	 */
	void registerEmployeeClicked();
	/**
	 * permette di effettuare l'accesso tramite uno username ed una password
	 * 
	 * @param username
	 * @param cs
	 * */
	void loginEmployee(String username, char[] password);

}
