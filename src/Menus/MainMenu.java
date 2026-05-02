package Menus;

import Service.RestaurantService;

import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;

public class MainMenu {
    private Connection conn;
    private Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private RestaurantService restaurantService = new RestaurantService();

    public MainMenu(Connection conn) {
        this.conn = conn;
    }

    public void RunSystem() {
        restaurantService.createSystem(conn);
        while (true) {
            try {
                System.out.println("===== Restaurant System =====");
                System.out.println("1 - Administrator area \n2 - Cash Register \n0 - Quit");
                System.out.print("Option: ");
                int option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        AdmnistratorMenu admnistratorMenu = new AdmnistratorMenu(sc, conn);
                        admnistratorMenu.runAdmnistratorMenu();
                        break;
                    case 2:
                        break;
                    case 0:
                        System.out.println("Leaving...");
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                sc.nextLine();
            }
        }

    }
}
