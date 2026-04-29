package DAO.Implementation;

import DAO.OrderItemDAO;
import Objects.OrderItem;
import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoJDBC implements OrderItemDAO {
    private Connection conn;

    public OrderItemDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO orderitems (order_id, product_id, quantity, purchase_price) VALUES (?, ?, ?, ?)");
            st.setInt(1, orderItem.getOrder_id());
            st.setInt(2, orderItem.getProduct_id());
            st.setDouble(3, orderItem.getQuantity());
            st.setDouble(4, orderItem.getPurchase_price());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<OrderItem> findAll(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<OrderItem> listaOrderItems = new ArrayList<>();

        try {
            st = conn.prepareStatement("SELECT * from orderitems WHERE order_id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                listaOrderItems.add(new OrderItem(rs.getInt("product_id"),
                        rs.getInt("order_id"), rs.getInt("quantity"), rs.getDouble("purchase_price")));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return listaOrderItems;
    }
}
