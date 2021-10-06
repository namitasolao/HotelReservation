package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

public class HotelResource {
    //Provide a static reference

    public static boolean customerExists(String email){
       return CustomerService.customerExists(email);
    }
    //public static Customer getCustomer(String email){
    //}

      public static void creatACustomer(String firstName , String lastName , String email){
        if(CustomerService.customerExists(email)){
            System.out.println("Customer already exists!");
        } else {
            CustomerService.addCustomer(email, firstName, lastName);
            System.out.println("Account created!");
        }
      }

//    public IRoom getRoom(String roomNumber){}
   //public Reservation bookARoom(Date checkInDate , Date checkOutDate , String customerEmail , IRoom room ){}

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        Collection<Reservation> customerReservations = ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));
        if(customerReservations.isEmpty()){
            System.out.println("No reservations found for this customer!");
        }
        return customerReservations;
    }

    public static Collection<IRoom> findARoom(Date checkInDate , Date checkOutDate) { //Customize the find-a-room method to search for paid rooms or free rooms.
        return ReservationService.findRooms(checkInDate , checkOutDate);
    }

//    //Allow the users to input how many days out the room recommendation should search if there are no available rooms.
}

