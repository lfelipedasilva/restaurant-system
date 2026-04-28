package DAO;

import Objects.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    void removeProduct(Integer id);
    void updatePrice(Integer id, Double price);
    List<Product> findAll();
}
