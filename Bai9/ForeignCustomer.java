import java.util.Date;

public class ForeignCustomer extends Customer {
    private String Nationality;

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public ForeignCustomer(String customerCode, String name, String invoiceDate, int amount, int unitPrice, int kindOfCustomer, String nationality) {
        super(customerCode, name, invoiceDate, amount, unitPrice, kindOfCustomer);
        Nationality = nationality;
    }

    public int Total(int newUnitPrice){
        int Total = this.Amount * newUnitPrice;
        return Total;

    }
}
