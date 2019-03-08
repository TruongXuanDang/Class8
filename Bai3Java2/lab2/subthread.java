package Exercise2;

public class subthread implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i > 0 ; i--) {
            try{
                System.out.println(i);
                Thread.sleep(1000);;
            }
            catch (InterruptedException e){};

        }
        System.out.println("Congratulation");
    }
}
