package Exercise1;

public class SubThread extends Thread {
    public void run(){
        int count = 0;

        for (int j = 2; count<=10; j++) {

            try {
                if(checkPrime(j)==true){
                    System.out.println(j);
                    count++;
                    Thread.sleep(1500);
                }


            }catch (InterruptedException e){}

            if(count==10){
                break;
            }
        }
        



    }

    public boolean checkPrime (int number){
        boolean result = false;
        int count = 0;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i==0){
                count++;
            }
        }
        if(count==0){
            result =true;
        }
        return result;
    }
}
