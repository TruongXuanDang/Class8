import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int id=0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        Student student5 = new Student(1,"A",25,"Hanoi",9);
        Student student6=new Student(2,"Trung",16,"Namdinh",6);
        Student student7 = new Student(3,"E",17,"Hoabinh",7);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        int flag = 0;
        do {
            System.out.println("1. Add student");
            System.out.println("2. Edit student by id");
            System.out.println("3. Delete student by id");
            System.out.println("4. Sort student by gpa");
            System.out.println("5. Sort student by name");
            System.out.println("6. Show student");
            System.out.println("0. Exit");
            System.out.println("Please choose a number:");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Student student = AddStudent(students);
                    students.add(student);
                    ShowStudent(students);
                    break;
                case 2:
                    Student student1=FindStudent(students);
                    EditStudent(student1);
                    ShowStudent(students);
                    break;
                case 3:
                    Student student2 = FindStudent(students);
                    students.remove(student2);
                    ShowStudent(students);
                    break;
                case 4:
                    SortStudentByGPA(students);
                    ShowStudent(students);
                    break;
                case 5:
                    SortStudentByName(students);
                    ShowStudent(students);
                    break;
                case 6:
                    ShowStudent(students);
                    break;
                case 0:
                    flag=1;
                    break;
            }

        }
        while (flag == 0);


    }

    public static Student AddStudent(ArrayList<Student>students){

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Address: ");
        String address = scanner1.nextLine();
        System.out.println("GPA: ");
        double gpa=scanner.nextDouble();
        id=students.size()+1;

        Student student = new Student(id,name,age,address,gpa);
        return student;

    }

    public static Student FindStudent(ArrayList<Student> students){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find student having id: ");
        Student student=new Student();
        int idNo = scanner.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).Id ==idNo){
                student =students.get(i);
                break;
            }
        }
        return student;
    }

    public static void EditStudent(Student student){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("New Name:");
        String name = scanner.nextLine();
        System.out.println("New Age:");
        int age = scanner.nextInt();
        System.out.println("New Address:");
        String address = scanner1.nextLine();
        System.out.println("New GPA:");
        Double gpa = scanner.nextDouble();

        student.Name = name;
        student.Age=age;
        student.Address = address;
        student.GPA=gpa;
    }

    public static void ShowStudent(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            System.out.print("Id: "+students.get(i).Id+"   ");
            System.out.print("Name: "+students.get(i).Name+"   ");
            System.out.print("Age: "+students.get(i).Age+"   ");
            System.out.print("Address: "+students.get(i).Address+"   ");
            System.out.print("GPA: "+students.get(i).GPA+"   ");
            System.out.println();
        }
    }

    public static void SortStudentByGPA(ArrayList<Student> students){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGPA().compareTo(o2.getGPA());
            }
        });
    }

    public static void SortStudentByName(ArrayList<Student> students){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
