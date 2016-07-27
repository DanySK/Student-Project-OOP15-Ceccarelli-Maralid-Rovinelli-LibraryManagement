package model;

public class CustomersImpl extends AbstractPerson implements Customers {

    
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
