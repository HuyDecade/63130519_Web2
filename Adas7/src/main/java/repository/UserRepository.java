package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
