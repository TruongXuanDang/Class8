import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        int flag =0;
        do{
            System.out.println("1. Insert invoices");
            System.out.println("2. Show all invoices");
            System.out.println("3. Average total of foreign customers");
            System.out.println("4. Show invoices in January 2019");
            System.out.println("5. Exit");
            System.out.println("Please choose a value:");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Customer customer = InsertCustomer();
                    customers.add(customer);
                    ShowCustomer(customers);
                    break;
                case 2:
                    ShowCustomer(customers);
                    break;
                case 3:
                    int Total = AverageTotalOfForeigner(customers);
                    System.out.println(Total);
                    break;
                case 4:
                    InvoiceOfJan2019(customers);
                    break;
                case 5:
                    flag=1;
                    break;
            }
        }
        while (flag==0);

    }

    public static Customer InsertCustomer(){
        Scanner scanner = new Scanner(System.in);
        Variable variable = new Variable();
        Customer customer = new Customer() {
            @Override
            int Total(int newUnitPrice) {
                return 0;
            }
        };
        int kindOfCustomer=0;

        System.out.println("Customer Code: ");
        String customerCode = scanner.nextLine();
        System.out.println("Name: ");
        String customerName = scanner.nextLine();
        System.out.println("Date: ");
        String customerInvoiceDate = scanner.nextLine();
        System.out.println("Amount: ");
        int customerAmount = scanner.nextInt();
        System.out.println("Unit Price: ");
        int customerUnitPrice = scanner.nextInt();

        System.out.println("Kind of Customer: ");
        System.out.println("1. Vietnam customer");
        System.out.println("2. Foreign customer");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Kind of VietNam customer:");
                int VietnamCustomerKind = scanner.nextInt();
                System.out.println("Quote: ");
                int VietnamCustomerQuote = scanner.nextInt();
                kindOfCustomer = 1;
                customer = new VietnamCustomer(customerCode,customerName,customerInvoiceDate,customerAmount,customerUnitPrice,kindOfCustomer,VietnamCustomerKind,VietnamCustomerQuote);

                break;
            case 2:
                System.out.println("Foreign customer nationality:");
                String ForeignCustomerNationality = scanner.nextLine();
                kindOfCustomer=2;
                customer = new ForeignCustomer(customerCode,customerName,customerInvoiceDate,customerAmount,customerUnitPrice,kindOfCustomer,ForeignCustomerNationality);

                break;
        }
        return customer;
    }

    public static void ShowCustomer(ArrayList<Customer> customers){
        Variable variable = new Variable();
        int amount = 0;
        int kindOfCustomer = 0;
        int newUnitPrice=0;
        for (int i = 0; i < customers.size(); i++) {

            int Total=0;
            String KindOfCustomerName="";
            if(customers.get(i).KindOfCustomer==1){
                KindOfCustomerName ="Vietnamese";
            }
            else if(customers.get(i).KindOfCustomer==2){
                KindOfCustomerName ="Foreign";
            }

            System.out.print("Customer Kind: "+KindOfCustomerName+"   ");
            System.out.print("Code: "+customers.get(i).CustomerCode+"   ");
            System.out.print("Name: "+customers.get(i).Name+"   ");
            System.out.print("Invoice Date: "+customers.get(i).InvoiceDate+"   ");
            System.out.print("Amount: "+customers.get(i).Amount+"   ");
            System.out.print("Unit Price: "+customers.get(i).UnitPrice+"   ");
            System.out.println("Substring of Date: "+customers.get(i).InvoiceDate.substring(2,8)+"   ");
            amount = customers.get(i).Amount;
            kindOfCustomer=customers.get(i).KindOfCustomer;
            newUnitPrice=variable.SetNewUnitPrice(amount,kindOfCustomer);
            System.out.print("Total: "+customers.get(i).Total(newUnitPrice));
            System.out.println();
        }

    }

    public static int AverageTotalOfForeigner(ArrayList<Customer> customers){
        int Total=0;
        int UnitTotal=0;
        Variable variable = new Variable();
        int amount = 0;
        int kindOfCustomer = 0;
        int newUnitPrice=0;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).KindOfCustomer==2){
                amount = customers.get(i).Amount;
                kindOfCustomer=customers.get(i).KindOfCustomer;
                newUnitPrice=variable.SetNewUnitPrice(amount,kindOfCustomer);
                UnitTotal =customers.get(i).Total(newUnitPrice);
                Total+=UnitTotal;
            }
        }
        return Total;
    }

    public static void InvoiceOfJan2019(ArrayList<Customer> customers){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).InvoiceDate.substring(2,8).equals("012019")){
                int Total=0;
                String KindOfCustomerName="";
                if(customers.get(i).KindOfCustomer==1){
                    KindOfCustomerName ="Vietnamese";
                }
                else if(customers.get(i).KindOfCustomer==2){
                    KindOfCustomerName ="Foreign";
                }
                System.out.print("Customer Kind: "+KindOfCustomerName+"   ");
                System.out.print("Code: "+customers.get(i).CustomerCode+"   ");
                System.out.print("Name: "+customers.get(i).Name+"   ");
                System.out.print("Invoice Date: "+customers.get(i).InvoiceDate+"   ");
                System.out.print("Amount: "+customers.get(i).Amount+"   ");
                System.out.print("Unit Price: "+customers.get(i).UnitPrice+"   ");
                System.out.println("Substring of Date: "+customers.get(i).InvoiceDate.substring(2,8)+"   ");
                System.out.println();
            }
            else {
                System.out.println("false");
            };
        }
    }

}
