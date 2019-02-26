import java.util.Date;

public abstract class Customer {
    String CustomerCode;
    String Name;
    String InvoiceDate;
    int Amount;
    int UnitPrice;
    int KindOfCustomer;

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getKindOfCustomer() {
        return KindOfCustomer;
    }

    public void setKindOfCustomer(int kindOfCustomer) {
        KindOfCustomer = kindOfCustomer;
    }


    public Customer(String customerCode, String name, String invoiceDate, int amount, int unitPrice, int kindOfCustomer) {
        CustomerCode = customerCode;
        Name = name;
        InvoiceDate = invoiceDate;
        Amount = amount;
        UnitPrice = unitPrice;
        KindOfCustomer = kindOfCustomer;
    }

    public Customer(){};



    abstract int Total(int newUnitPrice);

}
