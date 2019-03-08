package Homework;

public class Thread1 implements Runnable  {

    public void run() {
        for (int i = 1; i <= 50; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1);
            }
            catch (Exception e){};

        }
    }
}
