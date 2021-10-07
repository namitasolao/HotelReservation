package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;


public class HotelResource {

    public static boolean customerExists(String email){
       return CustomerService.customerExists(email);
    }
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }
    public static boolean validateEmail(String email){return CustomerService.validateEmail(email); }


    public static void creatACustomer(String firstName , String lastName , String email){
        if(CustomerService.customerExists(email)){
            System.out.println("Customer already exists!");
        } else {
            CustomerService.addCustomer(email, firstName, lastName);
            System.out.println("Account created!");
        }
    }

    public static IRoom getRoom(String roomNumber){
        return ReservationService.getRoom(roomNumber);
    }

   public static Reservation bookARoom(Date checkInDate , Date checkOutDate , String customerEmail , IRoom room ){
        Reservation newReservation = ReservationService.reserveARoom(checkInDate , checkOutDate , getCustomer(customerEmail) ,room);
        System.out.println(newReservation.toString());
        return newReservation;
   }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        Collection<Reservation> customerReservations = ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));
        if(customerReservations.isEmpty()){
            System.out.println("No reservations found for this customer!");
        } else {
            for(Reservation custReservations : customerReservations){
                System.out.println(custReservations);
            }
        }
        return customerReservations;
    }

    public static Collection<IRoom> findARoom(Date checkInDate , Date checkOutDate) { //Customize the find-a-room method to search for paid rooms or free rooms.
        Collection<IRoom> availableRooms = ReservationService.findRooms(checkInDate , checkOutDate);
        if(availableRooms.isEmpty()){
            System.out.println("No Rooms are available");
            MainMenu.showMainMenu();
        }
        return availableRooms;
    }

//    //Allow the users to input how many days out the room recommendation should search if there are no available rooms.
}

