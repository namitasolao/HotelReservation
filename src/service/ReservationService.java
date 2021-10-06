package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import myCollection.RoomsDB;
import myCollection.ReservationDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    public static Collection<IRoom> getAllRooms(){
       return RoomsDB.getAllRooms();
    }

    public static boolean roomExists(String roomNumber){
        if (RoomsDB.getRoom(roomNumber) == null)
            return false;
        return true;
    }

    public static void addRoom(IRoom room){
        RoomsDB.addRoom(room.getRoomnumber() , room);
    }

//    public IRoom getRoom(String roomId){}
    public static Reservation reserveARoom(Date checkInDate , Date checkOutDate , Customer customer , IRoom room){
        Reservation newReservation = new Reservation();
        newReservation.setCheckInDate(checkInDate);
        newReservation.setCheckOutDate(checkOutDate);
        newReservation.setCustomer(customer);
        newReservation.setRoom(room);

        ReservationDB.addAReservation(room.getRoomnumber() , newReservation);
        return newReservation;

    }
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> allRooms =  RoomsDB.getAllRooms();
        Collection<Reservation> allReservations = ReservationDB.getAllReservations();
        Collection<IRoom> availableRooms = new ArrayList<IRoom>();

        for(IRoom room : allRooms){
            String roomID = room.getRoomnumber();
            if(!allReservations.contains(roomID)){
                System.out.println(room);
                availableRooms.add(room);
            }
        }
        return availableRooms;
        }

    public static Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> customerReservations = new ArrayList<Reservation>();

        for (Reservation reservation : ReservationDB.getAllReservations()){
            if(reservation.getCustomer() == customer){
                customerReservations.add(reservation);
            }
        }
        return customerReservations;

    }
    public static void printAllReservations(){
        for(Reservation reservation : ReservationDB.getAllReservations()){
            System.out.println(reservation.toString());
        }
    }

    //Create Coolections to store and retrieve a REservation
    //provide a static reference

    //public static ReservationService service = new ReservationService();

    public static void printAllRooms() {
        for (IRoom rooms : RoomsDB.getAllRooms()) {
            System.out.println(rooms.toString());
        }
    }
}
