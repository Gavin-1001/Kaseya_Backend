package com.example.backend.service.emoployeeService;


import com.example.backend.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> findAllUsers();

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);
}


