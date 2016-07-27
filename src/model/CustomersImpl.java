package model;

public class CustomersImpl extends AbstractPerson implements Customers {

   
    
    public CustomersImpl(String taxCode, String name, String surname, String email) {
        super(taxCode, name, surname, email);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;
    private long telefonCustomers;

    @Override
    public long getTelefonCustomers() {
        return telefonCustomers;
    }

    @Override
    public void setTelefonCusomers(long telefon) {
       this.telefonCustomers = telefon;

    }

}
