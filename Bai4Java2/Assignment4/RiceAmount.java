package Assignment4;

public class RiceAmount {
    public int riceAmount = 1000;
    public synchronized void buyRice(int amountOfRice){
        this.riceAmount+=amountOfRice;
        System.out.println(Thread.currentThread().getName()+" -Buy successful the amount: "+amountOfRice);
        try {
            notify();
        }
        catch (Exception e){};
    }
    public synchronized void sellRice(int amountOfRice){
        if(this.riceAmount<amountOfRice){
            System.out.println("Not enough rice");
            try {
                wait();
            }
            catch (Exception e){};
        }
        this.riceAmount-=amountOfRice;
        System.out.println(Thread.currentThread().getName()+" -Sell successful the amount: "+amountOfRice);
    }
}
