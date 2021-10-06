package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    //provide a static reference

//    public Customer getCustomer(String customerEmail){}
    public static void addRoom(List<IRoom> rooms){
        for(IRoom room : rooms){
            ReservationService.addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms(){
        Collection<IRoom> allRooms = ReservationService.getAllRooms();
        if(allRooms.isEmpty()){
            System.out.println("No rooms found!");
            AdminMenu.showAdminMenu();
        }
        ReservationService.printAllRooms();
        return allRooms;
    }

    public static Collection<Customer> getAllCustomers(){
        Collection<Customer> allCustomers = CustomerService.getAllCustomers();
        if(allCustomers.isEmpty()){
            System.out.println("No customers found!");
            AdminMenu.showAdminMenu();
        }
        for(Customer customer : allCustomers){
            System.out.println(customer.toString());
        }
        return allCustomers;

    }
    public static void displayAllReservations(){
        ReservationService.printAllReservations();
    }
}
