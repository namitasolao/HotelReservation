package dataCollection;

import model.Reservation;
import java.util.*;

public class ReservationDB {
    //protected static Map<String , Reservation> reservationTable = new HashMap<String , Reservation>();
    final static Set<Reservation> reservationTable = new HashSet<>();

    public static Collection<Reservation> getAllReservations (){
        return reservationTable;
    }

    public static void addAReservation(Reservation newReservation){
        reservationTable.add(newReservation);
    }
}
