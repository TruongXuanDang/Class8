package Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class HourlyWeather implements Initializable {
    public Label labelCityName;
    public TextArea textAreaWeather;

    public String city_name;
    public ArrayList<Temperature> hourlyTemperature= new ArrayList<Temperature>();

    private void setValue() throws Exception
    {
        String url="http://api.openweathermap.org/data/2.5/forecast?q=Hanoi,vn&appid=09a71427c59d38d6a34f89b47d75975c&units=metric";
        URL objUrl = new URL(url);
        HttpURLConnection conn= (HttpURLConnection)objUrl.openConnection();
//        System.out.println("Response code: "+conn.getResponseCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = new String();
        String inputLine;
        while ((inputLine =  bufferedReader.readLine())!=null){
            response+= inputLine;
        }
//        System.out.println(response);
        Object object = JSONValue.parse(response);

        JSONObject jsonObject = (JSONObject)object;
        JSONObject cityObject = (JSONObject)jsonObject.get("city");
        city_name =(String) cityObject.get("name");
//        System.out.println("City: "+city_name);

        JSONArray jsArray  = (JSONArray)  jsonObject.get("list");
        for (int i = 0; i < jsArray.size(); i++) {
            JSONObject hourlyObject = (JSONObject) jsArray.get(i);
            String timeObject = (String) hourlyObject.get("dt_txt");

            JSONObject mainObject = (JSONObject)hourlyObject.get("main");
            Double temp = (Double)mainObject.get("temp");
            Double tempMin = (Double)mainObject.get("temp_min");
            Double tempMax = (Double)mainObject.get("temp_max");

            hourlyTemperature.add(new Temperature(timeObject,temp,tempMin,tempMax));
//            System.out.println("Time: "+timeObject+"\t"+"Temp: "+temp+"\t\t"+"Temp min: "+tempMin+"\t\t"+"Temp max: "+tempMax);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String msg="The hourly weather of Hanoi: ";

        try {
            this.setValue();
        } catch (Exception e) {

        }

        for (int i = 0; i < hourlyTemperature.size(); i++) {
            msg=msg+"\nTime: "+hourlyTemperature.get(i).getTimeObject()
                    +"\t\tTemp: "+hourlyTemperature.get(i).getTemp()
                    +"\t\tTemp Min: "+hourlyTemperature.get(i).getTempMin()
                    +"\t\tTemp Max: "+hourlyTemperature.get(i).getTempMax()
            ;
        }
        msg=msg+"\nThanks for watching!";
        labelCityName.setText(city_name);
        textAreaWeather.setText(msg);
    }
}
