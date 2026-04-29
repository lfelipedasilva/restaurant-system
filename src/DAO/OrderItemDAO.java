package DAO;

import Objects.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    void addOrderItem(OrderItem orderItem);
    List<OrderItem> findAll(Integer id);



}
