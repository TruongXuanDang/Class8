package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonModel {
    ArrayList<Person> people = new ArrayList<>();

    public void insertPeople(int no){
        Scanner scanner = new Scanner(System.in);
        Person person =new Person() {
            @Override
            public void toString2() {

            }
        };

        System.out.println("Id: ");
        int id = scanner.nextInt();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        if(no ==1){
            scanner.nextLine();
            System.out.println("Age: ");
            int age = scanner.nextInt();

            person = new Student(id,name,age);
        }
        else if(no ==2){
            scanner.nextLine();
            System.out.println("Salary: ");
            int salary = scanner.nextInt();

            person = new Employee(id,name,salary);
        }


        people.add(person);
    }


    public void printPeople(ArrayList<Person> people){
        for (int i = 0; i < people.size(); i++) {
            people.get(i).toString2();
        }
    }
}
