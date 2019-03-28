package ARS;

import java.util.Comparator;

public class Passenger implements Comparable {
    public int reservationID;
    public String passengerName;
    public String address;
    public String phone;
    public String dateOfDepartureAndReturn;

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfDepartureAndReturn() {
        return dateOfDepartureAndReturn;
    }

    public void setDateOfDepartureAndReturn(String dateOfDepartureAndReturn) {
        this.dateOfDepartureAndReturn = dateOfDepartureAndReturn;
    }

    public Passenger(int reservationID, String passengerName, String address, String phone, String dateOfDepartureAndReturn) {
        this.reservationID = reservationID;
        this.passengerName = passengerName;
        this.address = address;
        this.phone = phone;
        this.dateOfDepartureAndReturn = dateOfDepartureAndReturn;
    }

    public void show(){
        System.out.println("Reservation ID: "+this.reservationID);
        System.out.println("Passenger Name: "+this.passengerName);
        System.out.println("Address: "+this.address);
        System.out.println("Phone: "+this.phone);
        System.out.println("Date Of Departure And Return: "+this.dateOfDepartureAndReturn);
    }

    @Override
    public int compareTo(Object o) {
        return passengerName.compareTo(((Passenger) o).getPassengerName());
    }
}
