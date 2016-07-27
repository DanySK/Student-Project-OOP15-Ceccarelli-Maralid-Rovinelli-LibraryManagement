package model;

public class CustomersImpl extends AbstractPerson implements Customers {

   
    
   

    private static final long serialVersionUID = 1L;
    private long telefonCustomers;
    
    public CustomersImpl(String taxCode, String name, String surname, String email,long telefonCustomers) {
        super(taxCode, name, surname, email);
      this.telefonCustomers = telefonCustomers;
    }

    /** metodo per prelevare il numero di telefono*/
    public long getTelefonCustomers() {
        return telefonCustomers;
    }

    /** metodo per settare un numero di telefono*/
    public void setTelefonCusomers(long telefon) {
       this.telefonCustomers = telefon;

    }

}
