package javafx_demo.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx_demo.Config;
import javafx_demo.Connector;
import javafx_demo.Main;
import javafx_demo.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class List implements Initializable {

    public TableView<User> tableView;
    public TableColumn<User,Integer> id;
    public TableColumn<User,String> username;
    public TableColumn<User,String> email;
    public TableColumn<User,Integer> status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        String sql = "SELECT * FROM user";
        Connector connector = new Connector();

        try {
            ResultSet rs =  connector.statement.executeQuery(sql);
            ObservableList<User> userList = FXCollections.observableArrayList();
            while (rs.next()){
                Integer user_id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                Integer status = rs.getInt("status");

                userList.add(new User(user_id,username,email,status));
            }
            tableView.setItems(userList);
        }catch (SQLException e){}
    }

    public void registerAction() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/register.fxml"));
            Config.registerBack = "../fxml/list.fxml";
        } catch (IOException e) {

        }
        Main.mainStage.getScene().setRoot(root);
    }
}
