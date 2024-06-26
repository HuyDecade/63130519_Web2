package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Các phương thức tùy chỉnh nếu cần
}