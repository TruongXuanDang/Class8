package ARS;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        Reservation reservation = new Reservation();
        int flag =0;
        do {
            System.out.println("1. Add reservation");
            System.out.println("2. Modify passenger records");
            System.out.println("3. Display passenger records");
            System.out.println("4. Exit");
            System.out.println("Choose an option");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("ReservationID: ");
                    int id = scanner.nextInt();
                    System.out.println("PassengerName: ");
                    String passengerName = scanner.next();
                    System.out.println("Address: ");
                    String address = scanner.next();
                    System.out.println("Phone: ");
                    String phone = scanner.next();
                    System.out.println("Date of departure and return: ");
                    String date = scanner.next();
                    Passenger passenger = new Passenger(id,passengerName,address,phone,date);
                    reservation.add(passenger);
                    break;
                case 2:
                    System.out.println("ReservationID: ");
                    int idSearch = scanner.nextInt();
                    System.out.println("PassengerName: ");
                    String passengerNameSearch = scanner.next();
                    System.out.println("Address: ");
                    String addressSearch = scanner.next();
                    System.out.println("Phone: ");
                    String phoneSearch = scanner.next();
                    System.out.println("Date of departure and return: ");
                    String dateSearch = scanner.next();

                    Iterator<Passenger> iteratorReservationSearch = reservation.iterator();
                    while (iteratorReservationSearch.hasNext()){
                        Passenger iteratorPassenger = iteratorReservationSearch.next();
                        if(iteratorPassenger.reservationID == idSearch){
                            reservation.remove(iteratorPassenger);
                            Passenger passengerSearch = new Passenger(idSearch,passengerNameSearch,addressSearch,phoneSearch,dateSearch);
                            reservation.add(passengerSearch);
                        }
                    }
                    break;
                case 3:
                    Iterator<Passenger> iteratorReservation = reservation.iterator();
                    while (iteratorReservation.hasNext()){
                         iteratorReservation.next().show();
                    }
                    break;
                case 4:

                    flag = 1;
                    break;

            }
        }
        while (flag ==0);

    }
}
