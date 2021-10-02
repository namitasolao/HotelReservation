package api;
import java.util.Scanner;

public class MainMenu {
    public void showMainMenu() {
        System.out.println( "1. Find and reserve a room \n " +
                            "2. See my reservations \n" +
                            "3. Create an account \n" +
                            "4. Admin \n" +   ///open the admin menu
                            "5. Exit"); //exit the application);
        try {
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextInt() == 1) {
                System.out.println("1");
            } else if (scanner.nextInt() == 2) {
            } else if (scanner.nextInt() == 3) {
            } else if (scanner.nextInt() == 4) {
            } else if (scanner.nextInt() == 5) {
                //System.exit(0);
                return;
            }
        }catch (Exception e){
            System.out.println("Please enter a valid number");
            showMainMenu();
        }



    }

    public static void main(String args[]) {
        new MainMenu().showMainMenu();
    }
}
