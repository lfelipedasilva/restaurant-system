package DAO;

import Objects.Enums.Status_Order;
import Objects.Order;

public interface OrderDAO {
    void addOrder(Order order);
    void updateStatus(Integer id, Status_Order statusOrder);
    String findById(Integer id);

}
