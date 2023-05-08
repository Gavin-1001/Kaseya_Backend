package com.example.backend.controller;

import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.requests.EmployeeDto;
import com.example.backend.requests.Request;
import com.example.backend.service.emoployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin()
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
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(employeeService.findAllUsers());
        //http://localhost:8080/api/employees
    }

    @PostMapping("employees")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody List<Employee> employee){
        return ResponseEntity.ok(employeeRepository.saveAll(employee));
        //http://localhost:8080/api/employees
    }

//    @PostMapping("employees")
//    public ResponseEntity<Employee> addEmployee( @RequestBody @Valid EmployeeDto employeeRequest){
//        return new ResponseEntity<>(employeeService.addEmployee(employeeRequest), HttpStatus.CREATED);
//        //http://localhost:8080/api/employees
//    }

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


}
