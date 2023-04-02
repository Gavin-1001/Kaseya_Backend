package com.example.backend.controller;

import com.example.backend.entity.Employee;
import com.example.backend.exception.UsernameExistsException;
import com.example.backend.service.emoployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @PostMapping("/employees") //create employee
//    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)  {
//        Employee newEmployee = employeeService.addEmployee(employee);
//        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
//    }


    @GetMapping("employees")
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(employeeService.findAllUsers());
    }

    @PostMapping("employees")
    public ResponseEntity<?> createUser(){
        return ResponseEntity.ok(employeeService.addEmployee());
    }








    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from a secure url";
    }

//    @GetMapping("/Employees")
//    public ResponseEntity<List<Employee>> getEmployees(){
//        List<Employee> employees = employeeService.findAllEmployees();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }





}
