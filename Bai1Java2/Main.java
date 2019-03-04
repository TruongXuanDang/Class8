package HomeworkClass1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int flag = 0;
        int choice;
        PhoneDetail phoneDetail1 = new PhoneDetail("a","12345");
        PhoneDetail phoneDetail2 = new PhoneDetail("c","21345");
        PhoneDetail phoneDetail3 = new PhoneDetail("b","31245");
        phoneBook.PhoneList.add(phoneDetail1);
        phoneBook.PhoneList.add(phoneDetail2);
        phoneBook.PhoneList.add(phoneDetail3);
        do{
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String nameDetail = scanner.nextLine();
                    System.out.println("Phone: ");
                    String phone = scanner.nextLine();

                    phoneBook.insertPhone(nameDetail,phone);
                    showAll(phoneBook.PhoneList);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Delete Name: ");
                    String deleteName = scanner.nextLine();
                    phoneBook.removePhone(deleteName);
                    showAll(phoneBook.PhoneList);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Update Name: ");
                    String updateName = scanner.nextLine();
                    System.out.println("Update Phone: ");
                    String updatePhone = scanner.nextLine();
                    phoneBook.updatePhone(updateName,updatePhone);
                    showAll(phoneBook.PhoneList);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Search Name: ");
                    String searchName = scanner.nextLine();
                    phoneBook.searchPhone(searchName);
                    break;
                case 5:
                    showAll(phoneBook.sort(phoneBook.PhoneList));
                    break;
                case 6:
                    flag = 1;
                    break;
            }
        }
        while (flag==0);
    }

    public static void showAll(List<PhoneDetail> phoneDetailList){
        for (int i = 0; i < phoneDetailList.size(); i++) {
            System.out.print("Name: "+phoneDetailList.get(i).name);
            System.out.print("\t");
            System.out.print("Phone: "+phoneDetailList.get(i).phone);
            System.out.println();
        }
    }
}
