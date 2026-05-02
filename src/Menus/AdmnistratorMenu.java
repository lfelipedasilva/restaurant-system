package Menus;

import DAO.Factory.DaoFactory;
import DAO.ProductDAO;
import Objects.Product;

import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;

public class AdmnistratorMenu {
    private Scanner sc;
    private Connection conn;

    public AdmnistratorMenu(Scanner sc, Connection conn) {
        this.sc = sc;
        this.conn = conn;
    }

    public void runAdmnistratorMenu() throws Exception {
        ProductDAO productDAO = DaoFactory.createProductDao(conn);
        System.out.println("===============================");
        System.out.println("         ADMIN AREA");
        System.out.println("===============================");

        while (true) {
            try {
                System.out.println("1 - Add product \n2 - Remove product \n3 - Update product price \n0 - Return");
                System.out.print("option: ");
                int op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        System.out.print("Enter the product name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter the Price: ");
                        Double price = sc.nextDouble();
                        sc.nextLine();
                        productDAO.addProduct(new Product(null, name, price));
                        System.out.println("Product added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter the ID to remove the product from the menu: ");
                        Integer id = sc.nextInt();
                        sc.nextLine();
                        productDAO.removeProduct(id);
                        break;
                    case 3:
                        System.out.println("Enter the product ID and price to change it: ");
                        System.out.print("ID: ");
                        Integer idUpdate = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Price: ");
                        Double newPrice = sc.nextDouble();
                        sc.nextLine();
                        productDAO.updatePrice(idUpdate, newPrice);
                        break;
                    case 0:
                        System.out.println("leaving the admin area...");
                        return;
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getMessage());
            }

        }

    }
}
