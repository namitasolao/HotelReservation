package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static model.RoomType.*;

public class AdminResource {
    public static void createTestData(){
        // customer
        HotelResource.creatACustomer("Andrew", "S." ,"andrew@domain.com");
        // room
        IRoom newRoom = new Room("TestRoom1", 30.35, SINGLE);
        List<IRoom> newTestRoom = new ArrayList<IRoom>();
        newTestRoom.add(newRoom);
        addRoom(newTestRoom);

        try {
            //reservation
            Date checIn = new SimpleDateFormat("MM/dd/yyyy").parse("01/03/2021");
            Date checOut = new SimpleDateFormat("MM/dd/yyyy").parse("01/13/2021");
            ReservationService.getInstance().reserveARoom(checIn, checOut, HotelResource.getCustomer("andrew@domain.com"), newRoom);
        }catch (Exception e){
            System.out.println("Error in parsing date :"+e.fillInStackTrace());
        }
    }

    public static void addRoom(List<IRoom> rooms){
        for(IRoom room : rooms){
            ReservationService.getInstance().addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms(){
        Collection<IRoom> allRooms = ReservationService.getInstance().getAllRooms();
        if(allRooms.isEmpty()){
            System.out.println("No rooms found!");
            AdminMenu.showAdminMenu();
        }
        ReservationService.getInstance().printAllRooms();
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
        ReservationService.getInstance().printAllReservations();
    }
}
