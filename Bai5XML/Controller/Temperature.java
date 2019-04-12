package Controller;

public class Temperature {
    private String timeObject;
    private Double temp;
    private Double tempMin;
    private Double tempMax;

    public Temperature(String timeObject, Double temp, Double tempMin, Double tempMax) {
        this.timeObject = timeObject;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public String getTimeObject() {
        return timeObject;
    }

    public void setTimeObject(String timeObject) {
        this.timeObject = timeObject;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }
}
