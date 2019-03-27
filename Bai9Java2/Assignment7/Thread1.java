package Assignment7;

public class Thread1  {

    public int amount = 0;
    public void runAmount(int amount )  {

        for (int i = 0; i <=100 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
