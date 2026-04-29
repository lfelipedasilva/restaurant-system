package DAO.Factory;

import DAO.Implementation.OrderDaoJDBC;
import DAO.Implementation.OrderItemDaoJDBC;
import DAO.Implementation.ProductDaoJDBC;
import DAO.OrderDAO;
import DAO.OrderItemDAO;
import DAO.ProductDAO;
import db.DB;

public class DaoFactory {
    public static void createProductDao() {
        ProductDAO productDAO = new ProductDaoJDBC(DB.getConnection());
    }

    public static void createOrderDao() {
        OrderDAO orderDAO = new OrderDaoJDBC(DB.getConnection());
    }

    public static void createOrderItemDao() {
        OrderItemDAO orderItemDAO = new OrderItemDaoJDBC(DB.getConnection());
    }

}
