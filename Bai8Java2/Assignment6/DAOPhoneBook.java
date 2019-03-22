package Assignment6;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DAOPhoneBook implements DAOInterface<PhoneBook> {
    public static DAOPhoneBook instance;
    private DAOPhoneBook(){

    }

    @Override
    public ArrayList<PhoneBook> list() {
        Connector connector = Connector.getInstance();

        String sql = "SELECT * FROM `phonebook`";
        try {
            ArrayList<PhoneBook> phoneBookArrayList = new ArrayList<>();
            ResultSet rs = connector.statement.executeQuery(sql);
            while (rs.next()){
                Integer id  = rs.getInt("id");
                Integer user_id = rs.getInt("user_id");
                String telephone = rs.getString("telephone");
                Integer status = rs.getInt("status");

                phoneBookArrayList.add(new PhoneBook(id,user_id,telephone,status));

            }
            return phoneBookArrayList;
        } catch (SQLException e) {

        }
        return null;

    }

    @Override
    public void update(PhoneBook phoneBook) {
        Connector connector = Connector.getInstance();
        String sql = "UPDATE `phonebook` SET `user_id`='"+phoneBook.user_id+"',`telephone`='"+phoneBook.telephone+"',`status`= '"+phoneBook.status+"' WHERE `id`='"+phoneBook.id+"'";
        try {
            connector.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PhoneBook phoneBook) {
        Connector connector = Connector.getInstance();
        String sql = "DELETE FROM `phonebook`  WHERE `id`='"+phoneBook.id+"'";
        try {
            connector.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(PhoneBook phoneBook) {
        Connector connector = Connector.getInstance();
        String sql = "INSERT INTO `phonebook`(`id`, `user_id`, `telephone`, `status`) VALUES ('"+phoneBook.id+"','"+phoneBook.user_id+"','"+phoneBook.telephone+"','"+phoneBook.status+"')";
        try {
            connector.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PhoneBook> searchname(String username) {
        Connector connector = Connector.getInstance();

        String sql = "SELECT phonebook.id,phonebook.user_id,phonebook.telephone,phonebook.status,user.username FROM `phonebook` LEFT JOIN `user`ON phonebook.user_id = user.id WHERE user.username = '"+username+"'";
        try {
            ArrayList<PhoneBook> phoneBookArrayList = new ArrayList<>();
            ResultSet rs = connector.statement.executeQuery(sql);
            while (rs.next()){
                Integer identity = rs.getInt("id");
                Integer user_id = rs.getInt("user_id");
                String telephone = rs.getString("telephone");
                Integer status =rs.getInt("status");

                phoneBookArrayList.add(new PhoneBook(identity,user_id,telephone,status));
            }
            return phoneBookArrayList;
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public PhoneBook searchid(int id) {
        Connector connector = Connector.getInstance();

        String sql = "SELECT * FROM `phonebook` WHERE `id`='"+id+"'";
        try {
            PhoneBook phoneBook = null;
            ResultSet rs = connector.statement.executeQuery(sql);
            while (rs.next()){
                Integer identity = rs.getInt("id");
                Integer user_id = rs.getInt("user_id");
                String telephone = rs.getString("telephone");
                Integer status =rs.getInt("status");

                phoneBook = new PhoneBook(identity,user_id,telephone,status);
                return phoneBook;
            }
        } catch (SQLException e) {
        }
        return null;

    }

    public static DAOPhoneBook getInstance(){
        if(instance == null){
            instance = new DAOPhoneBook();
        }
        return instance;
    }
}
