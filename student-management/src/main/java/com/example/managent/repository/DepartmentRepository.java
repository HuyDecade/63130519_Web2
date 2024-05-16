package com.example.managent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managent.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findAll();
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh tại đây nếu cần thiết
}