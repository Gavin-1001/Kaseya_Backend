package com.example.backend.service.emoployeeService;


import com.example.backend.entity.Employee;
import com.example.backend.requests.EmployeeDto;
import com.example.backend.requests.Request;


import java.util.List;


public interface EmployeeService {


    List<Employee> findAllUsers();

    void deleteEmployee(String id);

    Employee updateEmployee(String id, Employee employee);


    Employee addTestEmployee(Request request);


//   Employee addEmployee(Request request);

    //Employee addEmployee(EmployeeDto employeeRequest); use this one
}


