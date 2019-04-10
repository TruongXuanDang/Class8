package Controller;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeWeather implements  Initializable{
    public Label labelCity;
    public Label labelMinPres;
    public Label labelMaxPres;
    public Label labelDescription;
    public String city_name;
    public Double temp;
    public Double temp_min;
    public Double temp_max;
    public String description;

    public void setValue() throws Exception
    {
        String url="https://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22";
        URL objUrl = new URL(url);
        HttpURLConnection conn= (HttpURLConnection)objUrl.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = new String();
        String inputLine;
        while ((inputLine =  bufferedReader.readLine())!=null){
            response+= inputLine;
        }
        Object object = JSONValue.parse(response);

        JSONObject jsonObject = (JSONObject)object;
        city_name =(String) jsonObject.get("name");

        JSONObject mainObject = (JSONObject)jsonObject.get("main");
        temp = (Double) mainObject.get("temp");
        temp_min= (Double)mainObject.get("temp_min");
        temp_max = (Double)mainObject.get("temp_max");

        JSONArray weatherObject = (JSONArray) jsonObject.get("weather");
        JSONObject firstWeatherObject = (JSONObject) weatherObject.get(0);
        description = (String) firstWeatherObject.get("description");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.setValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        labelCity.setText(city_name);
        labelMinPres.setText(String.valueOf(temp_min));
        labelMaxPres.setText(String.valueOf(temp_max));
        labelDescription.setText(description);
    }



    public void changeWeather() throws Exception
    {

    }
}
