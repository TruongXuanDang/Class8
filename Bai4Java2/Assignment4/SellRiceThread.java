package Assignment4;

public class SellRiceThread extends Thread {
    public RiceAmount riceAmount = new RiceAmount();
    public SellRiceThread (RiceAmount riceAmount){

        this.riceAmount = riceAmount;
    }
    public void run(){

        this.riceAmount.sellRice(3000);
    }
}
