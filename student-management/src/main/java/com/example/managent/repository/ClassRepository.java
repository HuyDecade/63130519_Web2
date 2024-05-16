package com.example.managent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managent.model.Classes;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {

	Classes save(Classes classes);
    // Các phương thức tùy chỉnh có thể được thêm vào ở đây nếu cần

	List<Classes> findAll();

	
}