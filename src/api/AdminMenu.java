package api;

import java.util.Scanner;

public class AdminMenu {
public static void main(String args[]){
    new AdminMenu().showAdminMenu();
}

    public void showAdminMenu() {
        System.out.println("1. See all Customers \n"+
                           "2. See all Rooms \n"+
                           "3. See all Reservations \n"+
                           "4. Add a Room \n"+
                           "5. Back to Main Menu \n"+ // retujrn back to main menu
                           "6. Populate test data");
//    //Provide a menu option from the Admin menu to populate the system with test data (Customers, Rooms and Reservations).
        try {
            Scanner scanner = new Scanner(System.in);
            int inputNumber = scanner.nextInt();

            if(inputNumber == 1) {}
            else if(inputNumber == 2){}
            else  if (inputNumber == 3){}
            else  if (inputNumber == 4){}
            else  if (inputNumber == 5){
                new MainMenu().showMainMenu();
            }
            else  if (inputNumber == 6){}
        } catch (Exception e){
            System.out.println("Please enter a valid number!");
            showAdminMenu();
        }
    }
}
