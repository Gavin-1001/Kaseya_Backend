package com.example.backend.service.emoployeeService;


import com.example.backend.entity.Employee;


import java.util.List;


public interface EmployeeService {


    List<Employee> findAllUsers();

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee addEmployee(Employee employee);
}


