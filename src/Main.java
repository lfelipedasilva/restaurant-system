import Menus.MainMenu;
import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();

        MainMenu mainMenu = new MainMenu(conn);
        mainMenu.RunSystem();

    }
}
