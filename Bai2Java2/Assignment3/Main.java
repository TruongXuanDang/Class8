package Assignment3;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        PersonModel personModel = new PersonModel();
        int flag = 0;
        do {
            System.out.println("1. Student");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            System.out.println("Please choose a value: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    detailChoice(1,personModel);
                    break;
                case 2:
                    detailChoice(2,personModel);
                    break;
                case 3:
                    flag=1;
                    break;
            }
        }
        while (flag==0);
    }

    public static void detailChoice(int choice,PersonModel personModel){
        Scanner scanner = new Scanner(System.in);

        int flag = 0;
        do {
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            System.out.println("Please choose a value: ");
            int option =  scanner.nextInt();

            switch (option){
                case 1:
                    personModel.insertPeople(choice);
                    break;
                case 2:
                    personModel.printPeople(personModel.people);
                    break;
                case 3:
                    flag = 1;
                    break;
            }
        }
        while (flag==0);
    }
}
