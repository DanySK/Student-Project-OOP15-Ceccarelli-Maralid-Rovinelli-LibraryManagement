package view.observer;

public interface LoginObserver {
	/**
	 * metodo per effettuare l'accesso come dipendente tramite username e password
	 * 
	 * @param username
	 * @param password
	 * */
	void loginEmployeeClicked (String username, char [] password );
	/**
	 * metodo utilizzato per caricare la view per la registrazione di un nuovo dipendete 
	 * */
	void registerEmployeeClicked ();
    void loginEmployee(String username, char[] password);
}
