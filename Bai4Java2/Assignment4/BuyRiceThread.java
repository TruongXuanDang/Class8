package Assignment4;

public class BuyRiceThread extends Thread {
    public RiceAmount riceAmount = new RiceAmount();
    public BuyRiceThread(RiceAmount riceAmount){
        this.riceAmount = riceAmount;
    }
    public void run(){
        this.riceAmount.buyRice(4000);
    }
}
