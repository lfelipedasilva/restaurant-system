package DAO.Implementation;

import DAO.ProductDAO;
import Objects.Product;
import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC implements ProductDAO {
    private Connection conn;

    public ProductDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addProduct(Product product) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO products (name_prod, price) VALUES (?, ?)");
            st.setString(1, product.getName());
            st.setDouble(2, product.getPrice());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void removeProduct(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM products WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void updatePrice(Integer id, Double price) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE products SET price = ? WHERE id = ?");
            st.setInt(1, id);
            st.setDouble(2, price);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> cardapio = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM PRODUCTS");
            rs = st.executeQuery();
            if (rs.next()) {
                cardapio.add(new Product(rs.getInt("id"), rs.getString("name_prod"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return cardapio;
    }
}
