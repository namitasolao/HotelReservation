package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import dataCollection.RoomDB;
import dataCollection.ReservationDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {

    private static final ReservationService instance = new ReservationService();

    public static ReservationService getInstance() {
        return instance;
    }

    public Collection<IRoom> getAllRooms(){
       return RoomDB.getAllRooms();
    }

    public boolean roomExists(String roomNumber){
        if (RoomDB.getRoom(roomNumber) == null)
            return false;
        return true;
    }

    public void addRoom(IRoom room){
        RoomDB.addRoom(room.getRoomnumber() , room);
    }

    public IRoom getRoom(String roomId){
       return RoomDB.getRoom(roomId);
    }

    public Reservation reserveARoom(Date checkInDate , Date checkOutDate , Customer customer , IRoom room){
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        ReservationDB.addAReservation( newReservation);
        return newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> allRooms =  RoomDB.getAllRooms();
        Collection<Reservation> allReservations = ReservationDB.getAllReservations();
        Collection<IRoom> availableRooms = new ArrayList<IRoom>();

        try {
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
            printAvailableRooms(availableRooms);
        }catch (Exception e){
            System.out.println("Error "+e.getStackTrace()+ " "+ e.getMessage());
        }
        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> customerReservations = new ArrayList<Reservation>();
        for (Reservation reservation : ReservationDB.getAllReservations()){
            if(reservation.getCustomer().equals( customer)){
                customerReservations.add(reservation);
            }
        }
        return customerReservations;

    }
    public void printAllReservations(){
        Collection<Reservation> allReservations = ReservationDB.getAllReservations();
        if(allReservations.isEmpty()){
            System.out.println("No reservations found!");
            return;
        }
        for(Reservation reservation : allReservations){
            System.out.println(reservation.toString());
        }
    }

    public void printAllRooms() {
        for (IRoom rooms : RoomDB.getAllRooms()) {
            System.out.println(rooms.toString());
        }
    }

     void printAvailableRooms(Collection<IRoom> availableRooms){
        for (IRoom availRooms : availableRooms) {
            System.out.println(availRooms);
        }
    }
}
