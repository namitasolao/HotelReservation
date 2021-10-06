package api;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import service.CustomerService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {

    public static void main(String args[]) {
        //CustomerService.addCustomer("az@az.com" , "a" , "z");
        new MainMenu().showMainMenu();
    }

    public void getCustomerDetails(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Do you have an account with us? Y/N");
            String input = scanner.next();
            switch (input.toUpperCase()) {
                case "Y":
                    System.out.println("Enter your email");
                    String email = scanner.next();
                    if (!CustomerService.validateEmail(email)){
                        System.out.println("Email is not registered!");
                        continue;
                    }
                    break;
                case "N":
                    break;
                default: {
                    System.out.println("Please enter valid input!");
                    continue;
                }
            }
            break;
        }





    }

    public void showMainMenu() {
        System.out.println("------------------------------------------ \n"+
                           "Welcome to the Hotel Reservation Application \n"+
                           "------------------------------------------ \n"+
                            "1. Find and reserve a room \n" +
                            "2. See my reservations \n" +
                            "3. Create an account \n" +
                            "4. Admin \n" +   ///open the admin menu
                            "5. Exit \n"+ //exit the application);
                           "------------------------------------------ \n");
        try {
            Scanner scanner = new Scanner(System.in);
            Integer input = scanner.nextInt();
            String email = "";
            Date checkIn;
            Date checkOut;
            if (input == 1) {
                DateTimeFormatter dateFormat =DateTimeFormatter.ofPattern("mm/dd/yyyy");
                while(true) {
                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Enter checkin date mm/dd/yyyy example 01/02/2021");
                        //LocalDate.parse(scanner2.next(), dateFormat);
                        //checkIn = scanner2.next();
                    } catch (Exception e) {
                        System.out.println("Please enter a valid date!");
                        continue;
                    }
                    break;
                }
                while(true) {
                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Enter checkin date mm/dd/yyyy example 01/21/2021");
                        checkOut = new SimpleDateFormat("dd/mm/yyyy").parse(scanner2.next());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid date!");
                        continue;
                    }
                    break;
                }
                HotelResource.findARoom(checkIn , checkOut);
                while(true) {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Would you like to book a room? Y/N");
                    String yesNo = scanner2.next();
                    switch (yesNo.toUpperCase(Locale.ROOT)) {
                        case "Y":
                            getCustomerDetails();
                            break;
                        case "N":

                        default: {
                            System.out.println("Please enter correct value!");
                            continue;
                        }
                    }
                    break;
                }

                /** 2. See my reservations **/
            } else if (input == 2) {
                while(true) {
                    System.out.println("Please enter your email");
                    Scanner scanner2 = new Scanner(System.in);
                     email = scanner2.next();

                    if (!CustomerService.validateEmail(email)) {
                        System.out.println("Please enter a valid email id");
                        continue;
                    }

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
                String firstName = "";
                String lastName = "";
                email = "";

                try {
                        System.out.println("Enter the firstname");
                        firstName = scanner.next();
                        System.out.println("Enter the lastname");
                        lastName = scanner.next();
                        System.out.println("Enter the email");
                        email = scanner.next();
                } catch (Exception e) {
                    System.out.println("Please enter the correct value!");
                }
                if (!CustomerService.validateEmail(email)) {
                    System.out.println("Please enter correct email!");
                }

                HotelResource.creatACustomer(firstName , lastName , email);
                showMainMenu();

            /** 4. Admin **/
            } else if (input == 4) {
                 AdminMenu.showAdminMenu();
            } else if (input == 5) {
                //System.exit(0);
                return;
            }
        }catch (Exception e){
            System.out.println("Please enter a valid number");
            showMainMenu();
        }
    }
}
