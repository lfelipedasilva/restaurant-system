package Service;

import DAO.Factory.DaoFactory;

import java.sql.Connection;

public class RestaurantService {

    public RestaurantService() {
    }

    public void createSystem(Connection conn) {
        DaoFactory.createProductDao(conn);
        DaoFactory.createOrderDao(conn);
        DaoFactory.createOrderItemDao(conn);
    }


}
