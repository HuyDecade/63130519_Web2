package com.example.managent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managent.model.Department;
import com.example.managent.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void updateDepartment(Department departmentDetails) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentDetails.getId());
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setCode(departmentDetails.getCode());
            department.setName(departmentDetails.getName());
            // Cập nhật các trường thông tin khác nếu cần
            departmentRepository.save(department);
        }
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}