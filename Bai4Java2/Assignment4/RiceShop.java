package Assignment4;

public class RiceShop {
    public static void main(String [] args){
        RiceAmount riceAmount = new RiceAmount();
        BuyRiceThread buyRiceThread1 = new BuyRiceThread(riceAmount);
        buyRiceThread1.setName("BuyThread1");
        BuyRiceThread buyRiceThread2 = new BuyRiceThread(riceAmount);
        buyRiceThread2.setName("BuyThread2");
        SellRiceThread sellRiceThread1 = new SellRiceThread(riceAmount);
        sellRiceThread1.setName("SellThread1");
        SellRiceThread sellRiceThread2 = new SellRiceThread(riceAmount);
        sellRiceThread2.setName("SellThread2");

        sellRiceThread1.start();
        buyRiceThread1.start();
        sellRiceThread2.start();

//        buyRiceThread2.start();

    }
}
