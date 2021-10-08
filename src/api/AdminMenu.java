package api;

import model.*;
import service.ReservationService;
import java.util.*;
import static model.RoomType.DOUBLE;
import static model.RoomType.SINGLE;

public class AdminMenu {

    private static List<IRoom> newRooms = new ArrayList<IRoom>();

    public static void addRoom(){
        String yesNo = "";
        Integer roomNumber =0;
        Double price = 0.0;
        RoomType roomType = SINGLE;
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                Scanner scanner2 = new Scanner(System.in);
                try {
                    System.out.println("Enter room number ");
                    roomNumber = scanner2.nextInt();
                    if (ReservationService.getInstance().roomExists(roomNumber.toString())) {
                        System.out.println("Room with this number already exists!");
                    } else {
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Please enter correct value!");
                    continue;
                }
            }

            while(true) {
                Scanner scanner2 = new Scanner(System.in);
                try {
                    System.out.println("Enter price per night ");
                    price = scanner2.nextDouble();
                    break;
                }catch (Exception e){
                    System.out.println("Please enter correct price!");
                }
            }
            while (true) {
                System.out.println("Enter room type: 1 for single bed, 2 for double bed ");
                String roomTypeInput = scanner.next();
                switch (roomTypeInput) {
                    case "1":
                        roomType = SINGLE;
                        break;
                    case "2":
                        roomType = DOUBLE;
                        break;
                    default: {
                        System.out.println("Please enter correct room type!");
                        continue;
                    }
                }
                break;
            }

            IRoom room = new Room(roomNumber.toString(), price, roomType);
            newRooms.add(room);

            while (true) {
                try {
                    System.out.println("Would you like to add another room? Y/N");
                    yesNo = scanner.next();
                    switch (yesNo.toUpperCase(Locale.US)) {
                        case "Y":
                            addRoom();
                        case "N":
                            break;
                        default: {
                            System.out.println("Please enter Y (Yes) or N (No)!");
                            continue;
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter Y (Yes) or N (No)!");
                }
            }
        } catch(Exception e){
            System.out.println("Please enter valid input!");
            showAdminMenu();
        }
    }

    public static void showAdminMenu() {
        System.out.println("\nAdmin Menu \n"+
                           "------------------------------------------ \n"+
                           "1. See all Customers \n"+
                           "2. See all Rooms \n"+
                           "3. See all Reservations \n"+
                           "4. Add a Room \n"+
                           "5. Back to Main Menu \n"+ // retujrn back to main menu
                           "6. Populate test data \n"+
                           "------------------------------------------ ");
        try {
            Scanner scanner = new Scanner(System.in);
            int inputNumber = scanner.nextInt();

            if(inputNumber == 1) {
                AdminResource.getAllCustomers();
                showAdminMenu();
            }
            else if(inputNumber == 2){
                AdminResource.getAllRooms();
                showAdminMenu();
            }
            else  if (inputNumber == 3){
                AdminResource.displayAllReservations();
                showAdminMenu();
            }
            else  if (inputNumber == 4){
                addRoom();
                AdminResource.addRoom(newRooms);
                showAdminMenu();
            }
            else  if (inputNumber == 5){
                new MainMenu().showMainMenu();
            }
            else  if (inputNumber == 6){
                AdminResource.createTestData();
                System.out.println("Test data created!");
                new AdminMenu().showAdminMenu();
            }
            else {
                System.out.println("Please enter a correct number!");
                showAdminMenu();
            }
        } catch (Exception e){
            System.out.println("Please enter a valid number!");
            showAdminMenu();
        }
    }
}
