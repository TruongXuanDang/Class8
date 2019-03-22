package Assignment6;

import javafx.concurrent.ScheduledService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        DAOPhoneBook daoPhoneBook = DAOPhoneBook.getInstance();
        int flag = 0;
        do {

            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Show all");
            System.out.println("5. Search");
            System.out.println("6. Exit");
            System.out.println("Please choose an option");
            int choice = scanner.nextInt();
                switch (choice){
                    case 1:

                        daoPhoneBook.insert(createNewPhoneBook(scanner));
                        break;
                    case 2:
                        PhoneBook phoneBook = createNewPhoneBook(scanner);
                        if(daoPhoneBook.searchid(phoneBook.id)!= null){
                            daoPhoneBook.update(phoneBook);
                        }
                        else {
                            System.out.println("Do not exist this id");
                        }
                        break;
                    case 3:
                        int identity = scanner.nextInt();
                        daoPhoneBook.delete(daoPhoneBook.searchid(identity));
                        break;
                    case 4:
                        print(daoPhoneBook.list());
                        break;
                    case 5:
                        String username = scanner.next();
                        print(daoPhoneBook.searchname(username));
                        break;
                    case 6:
                        flag = 1;
                        break;
                }

        }
        while (flag ==0);
    }

    public static PhoneBook createNewPhoneBook(Scanner scanner){
        PhoneBook phoneBook = null;
        System.out.println("ID: ");
        int id = scanner.nextInt();
        System.out.println("USER ID:");
        int userId = scanner.nextInt();
        System.out.println("PHONE: ");
        String phone = scanner.next();
        System.out.println("STATUS: ");
        int status = scanner.nextInt();
        phoneBook = new PhoneBook(id,userId,phone,status);
        return phoneBook;
    }

    public static void print(ArrayList<PhoneBook> phoneBookArrayList){
        System.out.print("ID");
        System.out.print("\t");
        System.out.print("USER ID");
        System.out.print("\t");
        System.out.print("TELEPHONE");
        System.out.print("\t");
        System.out.print("STATUS");
        System.out.println();
        for (int i = 0; i < phoneBookArrayList.size(); i++) {
            System.out.print(phoneBookArrayList.get(i).id);
            System.out.print("\t");
            System.out.print(phoneBookArrayList.get(i).user_id);
            System.out.print("\t");
            System.out.print(phoneBookArrayList.get(i).telephone);
            System.out.print("\t");
            System.out.print(phoneBookArrayList.get(i).status);
            System.out.println();
        }
    }
}
