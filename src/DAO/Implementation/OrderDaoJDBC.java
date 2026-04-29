package DAO.Implementation;

import DAO.OrderDAO;
import Objects.Enums.Status_Order;
import Objects.Order;
import db.DB;
import db.DbException;

import java.sql.*;
import java.time.LocalDate;

public class OrderDaoJDBC implements OrderDAO {
    private Connection conn;

    public OrderDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addOrder(Order order) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO orders (date_order, status_order) VALUES (?, ?)");
            st.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            st.setString(2, String.valueOf(Status_Order.PEDING));
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void updateStatus(Integer id, Status_Order statusOrder) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE orders SET status_order = ? WHERE id = ?");
            st.setString(1, String.valueOf(statusOrder));
            st.setInt(2, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public String findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Order order = new Order();
        try {
            st = conn.prepareStatement("SELECT * FROM PRODUCTS WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt("id"), LocalDate.parse(rs.getString("date_order")),
                        Status_Order.valueOf(rs.getString("status_order")));
            }
            return order.toString();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }
}
