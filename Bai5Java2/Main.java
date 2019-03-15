package Assignment5;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public  static  void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        connect(scanner);
    }

    public static void login(Statement statement,Scanner scanner){
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        String sql = "SELECT * FROM `user` WHERE user.username ='"+username+"' AND user.password='"+password+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if(!resultSet.isBeforeFirst()){
                System.out.println("Not appropriate username or password");
            }
            else System.out.println("Welcome");
        }catch (SQLException e){};
    }

    public static boolean checkUsernameEmail(Statement statement,String username,String email){
        Boolean check = true;
        String sql = "SELECT * FROM `user` WHERE user.username ='"+username+"' OR user.email='"+email+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if(!resultSet.isBeforeFirst()){
                check=true;

            }
            else check = false;
        }catch (SQLException e){};
        return check;
    }

    public static void register(Statement statement,Scanner scanner){
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        System.out.println("Status: ");
        int status = scanner.nextInt();
        if(checkUsernameEmail(statement,username,email)==false){
            System.out.println("You need distinct username and password");
        }
        else {
            String sql = "INSERT INTO `user`(`username`, `email`, `password`, `status`) VALUES ('"+username+"','"+email+"','"+password+"','"+status+"')";
            try {
                statement.executeUpdate(sql);
            }
            catch (SQLException e){};
        }
    }

    public static void watchUserlist(Statement statement){
        String sql = "SELECT * FROM `user`";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.print("ID: "+resultSet.getInt("id"));
                System.out.print("\t\t");
                System.out.print("Username: "+resultSet.getString("username"));
                System.out.print("\t\t");
                System.out.print("Email: "+resultSet.getString("email"));
                System.out.print("\t\t");
                System.out.print("Password: "+resultSet.getString("password"));
                System.out.print("\t\t");
                System.out.println("Status: "+resultSet.getInt("status"));
            }
        }catch (SQLException e){};
    }

    public static void deleteUser(Statement statement,Scanner scanner){
        System.out.println("ID: ");
        int id = scanner.nextInt();
        String sql ="DELETE FROM `user` WHERE USER.id = '"+id+"'";
        try {
            statement.executeUpdate(sql);
        }
        catch (SQLException e){};
    }

    public static void connect (Scanner scanner){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/t1806e";
            String DB_USER = "root";
            String DB_PASS ="";

            Connection conn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            Statement statement = conn.createStatement();

            menu(scanner,statement);

        }
        catch (Exception e){};
    }

    public static void menu(Scanner scanner, Statement statement){


        try {
            int flag = 0;
            do{
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Watch userlist");
                System.out.println("4. Delete an user");
                System.out.println("5. Exit");
                System.out.println("Please choose an option");
                int choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            login(statement,scanner);
                            break;
                        case 2:
                            register(statement,scanner);
                            break;
                        case 3:
                            watchUserlist(statement);
                            break;
                        case 4:
                            deleteUser(statement,scanner);
                            break;
                        case 5:
                            flag = 1;
                            break;
                    }

            }while (flag ==0);
        }
        catch (Exception e){};

    }
}