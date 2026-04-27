package DAO;

import Objects.Product;

public interface ProductDAO {
    void addProduct(Product product);
    void removeProduct(Product product);
    void findAll();
}
