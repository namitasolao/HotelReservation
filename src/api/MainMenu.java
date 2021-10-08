package api;

import model.IRoom;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainMenu {

    public static void main(String args[]) {
        new MainMenu().showMainMenu();
    }

    public static String askCutomerEmail(){
        Scanner scanner  =new Scanner(System.in);
        String email ="";
        while(true) {
            System.out.println("Enter your email");
            email = scanner.next();
            if (!HotelResource.validateEmail(email)) {
                System.out.println("Please enter email in format name@domain.com");
                continue;
            } else break;
        }
        return email;
    }

    public static Date askCheckInOutDate(String inOut){
        while(true) {
            try {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter "+inOut+" date mm/dd/yyyy example 01/21/2021");
                Date inputDate = new SimpleDateFormat("MM/dd/yyyy").parse(scanner2.next());
                return inputDate;
            } catch (Exception e) {
                System.out.println("Please enter a valid date!");
                continue;
            }
        }
    }

    public static String getCustomerDetails(){
        Scanner scanner = new Scanner(System.in);
        String email =" ";
        while(true) {
            System.out.println("Do you have an account with us? Y/N");
            String input = scanner.next();
            switch (input.toUpperCase()) {
                case "Y":
                  email = askCutomerEmail();
                   //showMainMenu();
                    break;
                case "N":
                    System.out.println("Please press 3 and create an account before making a reservation!");
                    break;
                default: {
                    System.out.println("Please enter valid input!");
                    continue;
                }
            }
            break;
        }
        return email;
    }

    public static void creatCustomerAccount(){
        String firstName = "";
        String lastName = "";
        String email = "";
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the firstname");
            firstName = scanner.next();
            System.out.println("Enter the lastname");
            lastName = scanner.next();
            email = askCutomerEmail();
        } catch (Exception e) {
            System.out.println("Please enter the correct value!");
        }
        HotelResource.creatACustomer(firstName , lastName , email);
    }

    public static void showMainMenu() {
        System.out.println("\n ------------------------------------------ \n"+
                           "Welcome to the Hotel Reservation Application \n"+
                           "------------------------------------------ \n"+
                            "1. Find and reserve a room \n" +
                            "2. See my reservations \n" +
                            "3. Create an account \n" +
                            "4. Admin \n" +
                            "5. Exit \n"+
                           "------------------------------------------ \n");
        try {
            Scanner scanner = new Scanner(System.in);
            Integer input = scanner.nextInt();
            String email = "";
            Date  checkIn;
            //LocalDate date;
            Date checkOut;

            /** 1. Find and reserve a room **/
            if (input == 1) {
                Boolean bookRoom = false;
                while(true){
                   checkIn = askCheckInOutDate("check in");
                   checkOut = askCheckInOutDate("check out");
                   if(checkIn.compareTo(checkOut) != -1) {
                       System.out.println("Check out date is smaller than the check in date. Please enter correct values!");
                       continue;
                   }
                   break;
               }
                Collection<IRoom> availableRooms = HotelResource.findARoom(checkIn, checkOut);
                while(true) {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Would you like to book a room? Y/N");
                    String yesNo = scanner2.next();
                    switch (yesNo.toUpperCase(Locale.ROOT)) {
                        case "Y": {
                            bookRoom = true;
                            email = getCustomerDetails();
                            break;
                        }
                        case "N":
                            break;
                        default: {
                            System.out.println("Please enter correct value!");
                            continue;
                        }
                    }
                    break;
                }
                if( bookRoom == true) {
                    String bookRoomNumber = " ";
                    while (true) {
                        try {
                            System.out.println("What room number would you like to book?");
                            bookRoomNumber = scanner.next();

                            if (!availableRooms.contains(HotelResource.getRoom(bookRoomNumber))) {
                                System.out.println("Please select from available rooms!");
                                continue;
                            } else
                                break;
                        }catch (Exception e){
                            System.out.println("Please select from available rooms!");
                            continue;
                        }
                    }
                    HotelResource.bookARoom(checkIn, checkOut, email, HotelResource.getRoom(bookRoomNumber));
                }
                showMainMenu();

                /** 2. See my reservations **/
            } else if (input == 2) {
                while(true) {
                    email = askCutomerEmail();
                    if (!HotelResource.customerExists(email)) {
                        System.out.println("Customer does not exists!");
                        showMainMenu();
                    }
                    break;
                }
                HotelResource.getCustomerReservations(email);
                showMainMenu();

            /** 3. Create an account **/
            } else if (input == 3) {
                creatCustomerAccount();
                showMainMenu();

            /** 4. Admin **/
            } else if (input == 4) {
                 AdminMenu.showAdminMenu();
            } else if (input == 5) {
                return;
            }
            else {
                System.out.println("Please enter a correct number!");
                showMainMenu();
            }
        }catch (Exception e){
            System.out.println("Please enter a valid number!"+e.getStackTrace() + " "+e.getMessage());

            showMainMenu();
        }
    }
}
