package javafx_demo.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx_demo.Config;
import javafx_demo.Connector;
import javafx_demo.Main;

import java.io.IOException;
import java.sql.SQLException;

public class Register {
    public TextField txtUsername;
    public TextField txtEmail;
    public TextField txtPassword;


    public void registerAction () throws SQLException{
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        String sql = "INSERT INTO `user`(`username`, `email`, `password`, `status`) VALUES ('"+username+"','"+email+"','"+password+"',0)";
        Connector connector = new Connector();
        connector.statement.executeUpdate(sql);

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Config.registerBack));
            Main.mainStage.getScene().setRoot(root);
            return;
        } catch (IOException e) {

        }
    }

    public void backAction() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(Config.registerBack));
        } catch (IOException e) {

        }
        Main.mainStage.getScene().setRoot(root);
    }


}
