package Assignment7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Assignment;

import java.util.ResourceBundle;

public class Main extends Application {
    public static void main (String [] args){
        launch(args);
    }

    public static Stage mainStage;
    public static ResourceBundle resourceBundle;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.mainStage = primaryStage;

        Main.resourceBundle = ResourceBundle.getBundle("Assignment7.languages.message");

        Parent root = FXMLLoader.load(getClass().getResource("fxml/countapp.fxml"));
        Scene scene = new Scene(root,600,400);
        primaryStage.setTitle(resourceBundle.getString("login_title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
