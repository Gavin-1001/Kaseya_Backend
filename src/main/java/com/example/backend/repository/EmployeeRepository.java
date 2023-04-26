package com.example.backend.repository;

import com.example.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Modifying
    @Transactional
    void deleteEmployeeById(String id);
}

