package service;

import java.util.List;

import model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    // Các phương thức khác liên quan đến sản phẩm
}