package com.example.backend.controller;

import com.example.backend.entity.Employee;
import com.example.backend.service.emoployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        //http://localhost:8080/api/employees
    }

    @PostMapping("employees")
    public ResponseEntity<?> addEmployee(Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
        //http://localhost:8080/api/employees/6
    }

    @PutMapping("employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
        //http://localhost:8080/api/employees/2
    }


//testing delete afterwards
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from a secure url";
    }





}
