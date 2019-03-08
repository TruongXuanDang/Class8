package Exercise1;

public class Main {
    public static void main (String [] args){
        SubThread subThread = new SubThread();
        subThread.start();
        subThread.setName("myJavaThread");
        System.out.println(subThread.getName());

    }
}
