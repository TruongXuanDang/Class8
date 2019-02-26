import java.util.Date;
import java.util.Scanner;

public class VietnamCustomer extends Customer {
    private int KindOfVietnamCustomer;
    private int Quote;
    Scanner scanner = new Scanner(System.in);

    public int getKindOfVietnamCustomer() {
        return KindOfVietnamCustomer;
    }

    public void setKindOfVietnamCustomer(int kindOfVietnamCustomer) {
        KindOfVietnamCustomer = kindOfVietnamCustomer;
    }

    public int getQuote() {
        return Quote;
    }

    public void setQuote(int quote) {
        Quote = quote;
    }

    public VietnamCustomer(String customerCode, String name, String invoiceDate, int amount, int unitPrice, int kindOfCustomer, int kindOfVietnamCustomer, int quote) {
        super(customerCode, name, invoiceDate, amount, unitPrice, kindOfCustomer);
        KindOfVietnamCustomer = kindOfVietnamCustomer;
        Quote = quote;
    }

    public int Total (int newUnitPrice){
        int Total=0;
        if(this.Amount<=this.Quote){
            Total=this.Amount*this.UnitPrice;
        }
        else {
            Total=this.Quote*this.UnitPrice+(this.Amount-this.Quote)*newUnitPrice;
        }
        return Total;
    }


}
