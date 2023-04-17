package com.example.backend.service.emoployeeService;


import com.example.backend.entity.Employee;


import java.util.List;


public interface EmployeeService {


    List<Employee> findAllUsers();

    void deleteEmployee(String id);

    Employee updateEmployee(String id, Employee employee);

    Employee addEmployee(Employee employee);
}


