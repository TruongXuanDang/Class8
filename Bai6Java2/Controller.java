package Assignment5;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Observable;
import java.util.ResourceBundle;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{
	
	public TableColumn<User,Integer> id;
	public TableColumn<User,String> username;
	public TableColumn<User,String> email;
	public TableColumn<User,Integer> status;
	
	public TableView tableView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		Connector connector = new Connector();
		String sql = "SELECT * FROM user";
		
		try {
			ResultSet rs = connector.getQuery(sql);
			ObservableList<User> list = FXCollections.observableArrayList();
			while(rs.next()){
				Integer id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				Integer status = rs.getInt("status");
				User user = new User(id, username, email, status);
				list.add(user);
				
			}
			tableView.setItems(list);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
	}
}
