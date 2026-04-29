package Service;

import DAO.Factory.DaoFactory;

public class RestaurantService {
    public RestaurantService() {
    }

    public void createSystem() {
        DaoFactory.createProductDao();
        DaoFactory.createOrderDao();
        DaoFactory.createOrderItemDao();
    }


}
