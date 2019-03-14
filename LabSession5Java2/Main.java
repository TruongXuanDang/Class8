package LabSession5;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        connectDatabase();

    }

    public static void watchStudentList(Statement statement){
        String sql = "SELECT * FROM student";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.print("ID: "+resultSet.getInt("id"));
                System.out.print("\t\t");
                System.out.print("Name: "+resultSet.getString("name"));
                System.out.print("\t\t");
                System.out.print("Age: "+resultSet.getInt("age"));
                System.out.print("\t\t");
                System.out.print("Mark: "+resultSet.getInt("mark"));
                System.out.println("\t\t");
            }
        }catch (SQLException e){};

    }

    public static void insertStudent(Statement statement,Scanner scanner){
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Mark: ");
        int mark = scanner.nextInt();
        String sql = "INSERT INTO student(name,age,mark) VALUES('"+name+"','"+age+"','"+mark+"')";
        try {
            statement.executeUpdate(sql);
        }
        catch (SQLException e){};

    }

    public static void deleteStudent(Statement statement,Scanner scanner){

        System.out.println("ID: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM student WHERE id='"+id+"'";
        try {
            statement.executeUpdate(sql);
        }
        catch (SQLException e){};
    }

    public static void connectDatabase (){
        Scanner scanner = new Scanner(System.in);


        try {
            Class.forName("com.mysql.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/t1806e";
            String DB_USER = "root";
            String DB_PASS = "";

            Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            Statement statement = conn.createStatement();

            menu(scanner,statement);

        }
        catch (Exception e){}
    }

    public static void menu(Scanner scanner,Statement statement){
        int flag = 0;
        do {
            System.out.println("1. Watch Studentlist");
            System.out.println("2. Insert Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.println("Please choose a value: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    watchStudentList(statement);
                    break;
                case 2:
                    insertStudent(statement,scanner);
                    break;
                case 3:
                    deleteStudent(statement,scanner);
                    break;
                case 4:
                    flag =1;
                    break;
            }

        }while (flag ==0);
    }
}
