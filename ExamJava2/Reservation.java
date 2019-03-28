package ARS;

import java.util.PriorityQueue;

public class Reservation extends PriorityQueue<Passenger> {


    public boolean add (Passenger passenger){
        super.add(passenger);
        return true;
    }

    public void clear (){
        super.clear();
    }

    public Passenger peek(){
        boolean isEmpty = super.isEmpty();
        if(isEmpty == false){
            Passenger passenger = super.element();
            return passenger;
        }
        else {
            return null;
        }

    }

    public Passenger poll(){
        boolean isEmpty = super.isEmpty();
        if(isEmpty == false){
            return super.poll();
        }
        else {
            return null;
        }
    }

    public void put(Passenger passenger){

    }

    public boolean remove(Passenger passenger){
        super.remove(passenger);
        return true;
    }
}
