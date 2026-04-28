package DAO;

import Objects.Order;

public interface OrderDAO {
    void addOrder(Order order);
    void update(Order order);
    void findById(Integer id);

}
