package myCollection;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationDB {
    protected static Map<String , Reservation> reservationTable = new HashMap<String , Reservation>();

    public static Collection<Reservation> getAllReservations (){
        return reservationTable.values();
    }

    public static Reservation getAReservation(String roomNumber){
        if(!reservationTable.containsKey(roomNumber))
                return new Reservation();
        return reservationTable.get(roomNumber);
    }

    public static void addAReservation(String  roomId ,Reservation newReservation){
        reservationTable.put(roomId , newReservation);
    }

//    Customer customer;
//    IRoom room;
//    Date checkInDate;
//    Date checkOutDate;

}
