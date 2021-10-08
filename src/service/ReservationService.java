package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import dataCollection.RoomDB;
import dataCollection.ReservationDB;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    public static Collection<IRoom> getAllRooms(){
       return RoomDB.getAllRooms();
    }

    public static boolean roomExists(String roomNumber){
        if (RoomDB.getRoom(roomNumber) == null)
            return false;
        return true;
    }

    public static void addRoom(IRoom room){
        RoomDB.addRoom(room.getRoomnumber() , room);
    }

    public static IRoom getRoom(String roomId){
       return RoomDB.getRoom(roomId);
    }

    public static Reservation reserveARoom(Date checkInDate , Date checkOutDate , Customer customer , IRoom room){
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        ReservationDB.addAReservation( newReservation);
        return newReservation;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> allRooms =  RoomDB.getAllRooms();
        Collection<Reservation> allReservations = ReservationDB.getAllReservations();
        Collection<IRoom> availableRooms = new ArrayList<IRoom>();
        boolean firstRun = true;

        try {
            while (true) {
                for (IRoom room : allRooms) {
                    availableRooms.add(room);
                }
                for (IRoom room : allRooms) {
                    String roomID = room.getRoomnumber();
                    for (Reservation res : allReservations) {
                        if ((roomID == res.getRoom().getRoomnumber()) &&
                                (!(checkInDate.before(res.getCheckInDate()) && checkOutDate.before(res.getCheckInDate())) &&
                                !(checkInDate.after(res.getCheckOutDate()) && checkOutDate.after(res.getCheckOutDate())))
                        ) {
                            availableRooms.remove(room);
                        }
                    }
                }
                //if no room is available then serach for next 7 days
                if (availableRooms.isEmpty() && firstRun) {
                    System.out.println("Rooms are not available for the given dates. \nChecking availablity for next 7 days!");
                    Calendar c = Calendar.getInstance();
                    c.setTime(checkInDate);
                    c.add(Calendar.DAY_OF_MONTH, 7);
                    checkInDate = c.getTime();

                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(checkOutDate);
                    c2.add(Calendar.DAY_OF_MONTH, 7);
                    checkOutDate = c.getTime();

                    firstRun = false;
                    continue;
                } else
                    break;
            }
            for (IRoom availRooms : availableRooms) {
                System.out.println(availRooms);
            }
        }catch (Exception e){
            System.out.println("Error "+e.getStackTrace()+ " "+ e.getMessage());
        }
        return availableRooms;
    }

    public static Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> customerReservations = new ArrayList<Reservation>();
        for (Reservation reservation : ReservationDB.getAllReservations()){
            if(reservation.getCustomer().equals( customer)){
                customerReservations.add(reservation);
            }
        }
        return customerReservations;

    }
    public static void printAllReservations(){
        Collection<Reservation> allReservations = ReservationDB.getAllReservations();
        if(allReservations.isEmpty()){
            System.out.println("No reservations found!");
            return;
        }
        for(Reservation reservation : allReservations){
            System.out.println(reservation.toString());
        }
    }

    public static void printAllRooms() {
        for (IRoom rooms : RoomDB.getAllRooms()) {
            System.out.println(rooms.toString());
        }
    }
}
