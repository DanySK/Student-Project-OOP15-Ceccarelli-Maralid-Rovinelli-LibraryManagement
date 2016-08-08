package model;

public class CustomerImpl extends PersonImpl implements CustomerModel {

    private static final long serialVersionUID = 1L;
    private long telefonCustomers;
    
    public CustomerImpl(String taxCode, String name, String surname, String email,long telefonCustomers) {
        super(taxCode, name, surname, email);
      this.telefonCustomers = telefonCustomers;
    }

   
    public long getTelefonCustomers() {
        return telefonCustomers;
    }

    
    public void setTelefonCusomers(long telefon) {
       this.telefonCustomers = telefon;

    }

}
