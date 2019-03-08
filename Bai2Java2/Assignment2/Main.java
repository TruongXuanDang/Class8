package Assignment2;

public class Main {
    public static void main(String [] args){
        Generic<Integer> generic = new Generic<>();
        for (int i = 1; i <= 10; i++) {
            generic.arrayList.add(i);
        }
        for (int i = 0; i < generic.arrayList.size(); i++) {
            System.out.println(generic.arrayList.get(i));
        }
    }
}
