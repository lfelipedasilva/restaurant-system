package DAO.Factory;

import DAO.Implementation.OrderDaoJDBC;
import DAO.Implementation.OrderItemDaoJDBC;
import DAO.Implementation.ProductDaoJDBC;
import DAO.OrderDAO;
import DAO.OrderItemDAO;
import DAO.ProductDAO;
import db.DB;

import java.sql.Connection;

public class DaoFactory {
    public static ProductDAO createProductDao(Connection conn) {
        return new ProductDaoJDBC(conn);
    }

    public static OrderDAO createOrderDao(Connection conn) {
        return new OrderDaoJDBC(conn);
    }

    public static OrderItemDAO createOrderItemDao(Connection conn) {
        return new OrderItemDaoJDBC(conn);
    }

}
