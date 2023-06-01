package com.example.backend.controller;

import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.service.emoployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin()
@Validated
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("employees")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(employeeService.findAllUsers());
        //http://localhost:8080/api/employees
    }

    // Send form as a list
    @PostMapping("employees")
    public ResponseEntity<?> addEmployee(@RequestBody @Valid List<Employee> employee) {
        return ResponseEntity.ok(employeeRepository.saveAll(employee));
        //http://localhost:8080/api/employees
    }

//    @PostMapping("employees")
//    public ResponseEntity<Employee> addEmployee( @RequestBody @Valid Employee employee){
//        return new ResponseEntity<>(employeeService.addEmployeeTest(employee), HttpStatus.CREATED);
//        //http://localhost:8080/api/employees
//    }


    @PutMapping("employees/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable String id) {
        Employee updatedStudent = employeeService.updateEmployee(id, employee);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedStudent);
        }
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
        //http://localhost:8080/api/employees/6
    }


}
