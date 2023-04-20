package com.example.backend.controller;

import com.example.backend.entity.Employee;
import com.example.backend.requests.Request;
import com.example.backend.service.emoployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin()
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("employees")
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(employeeService.findAllUsers());
        //http://localhost:8080/api/employees
    }


    @DeleteMapping("employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
        //http://localhost:8080/api/employees/6
    }

    @PutMapping("employees/{id}")
    public Employee updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
        //http://localhost:8080/api/employees/2
    }

    //http://localhost:8080/api/employees
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody Request request){
        return ResponseEntity.ok(employeeService.addTestEmployee(request));

        //json payload for request
    }



}
