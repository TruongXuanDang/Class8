package Assignment7.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx_demo.Main;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class CountApp implements Initializable{
    public TextField txtCount;
//    public Label labelCountApp;
//    public Button buttonRestart;
//    public Button buttonBegin;
//    public Button buttonPause;
    public Label labelNumber;
    public RadioButton radioVi;
    public RadioButton radioUs;
    public static String lang = "us";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        labelCountApp.setText(Main.resourceBundle.getString("labelCountApp"));
//        buttonRestart.setText(Main.resourceBundle.getString("buttonRestart"));
//        buttonBegin.setText(Main.resourceBundle.getString("buttonBegin"));
//        buttonBegin.setText(Main.resourceBundle.getString("buttonPause"));
//
        if(lang.equals("us")){
            radioVi.setSelected(false);
            radioUs.setSelected(true);
        }
        else {
            radioVi.setSelected(true);
            radioUs.setSelected(false);
        }
    }

    public void beginAction()  {

        labelNumber.setText("1");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=100 ; i++) {
                    String number = Integer.toString(i);

                    labelNumber.setText(number);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

    }

    public void changeVi() throws Exception{
        lang="vi";
        Main.resourceBundle = ResourceBundle.getBundle("Assignment7.languages.message",new Locale("vi","VN"));
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/countapp.fxml"));

        Main.mainStage.setTitle(Main.resourceBundle.getString("login_title"));

        Main.mainStage.getScene().setRoot(root);

    }

    public void changeUs() throws Exception{
        lang="us";
        Main.resourceBundle = ResourceBundle.getBundle(
                "Assignment7.languages.message",
                new Locale("en","US"));
        Parent root = FXMLLoader.load(getClass()
                .getResource("../fxml/countapp.fxml"));
        Main.mainStage.setTitle(Main.resourceBundle.getString("login_title"));

        Main.mainStage.getScene().setRoot(root);

    }
}
