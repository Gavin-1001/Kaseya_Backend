package com.example.backend.service.emoployeeService;


import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.requests.EmployeeDto;
import com.example.backend.requests.Request;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;


@Service
@Builder
@Data
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


//test the GET skills endpoint

    @Override
    public List<Employee> findAllUsers() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Employee updateEmployee = employeeRepository.findById(id).get();


            //first name
            if (Objects.nonNull(employee.getEmployeeFirstName()) && !"".equalsIgnoreCase(employee.getEmployeeFirstName())) {
                updateEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
            }

            //last name
            if (Objects.nonNull(employee.getEmployeeLastName()) && !"".equalsIgnoreCase(employee.getEmployeeLastName())) {
                updateEmployee.setEmployeeLastName(employee.getEmployeeLastName());
            }

            //date of birth
            if (Objects.nonNull(employee.getEmployeeDateOfBirth()) && !"".equalsIgnoreCase(String.valueOf(employee.getEmployeeDateOfBirth()))) {
                updateEmployee.setEmployeeDateOfBirth(employee.getEmployeeDateOfBirth());
            }

            //email address
            if (Objects.nonNull(employee.getEmployeeEmailAddress()) && !"".equalsIgnoreCase(String.valueOf(employee.getEmployeeEmailAddress()))) {
                updateEmployee.setEmployeeEmailAddress(employee.getEmployeeEmailAddress());
            }


            //isActive
            if (Objects.nonNull(employee.getIsActive()) && !"".equalsIgnoreCase(String.valueOf(employee.getIsActive()))) {
                updateEmployee.setIsActive(employee.getIsActive());
            }

            //employeeAge
            if (Objects.nonNull(employee.getEmployeeAge()) && !"".equalsIgnoreCase(String.valueOf(employee.getEmployeeAge()))) {
                updateEmployee.setEmployeeAge(employee.getEmployeeAge());
            }
        return employeeRepository.save(updateEmployee);
    }


//    @Override
//    public Employee addEmloyee(@RequestBody EmployeeDto employeeRequest) {
//        Employee employee = Employee.builder()
//                .employeeFirstName(employeeRequest.getEmployeeFirstName())
//                .employeeLastName(employeeRequest.getEmployeeLastName())
//                .employeeEmailAddress(employeeRequest.getEmployeeEmailAddress())
//                .employeeDateOfBirth(employeeRequest.getEmployeeDateOfBirth())
//                .isActive(employeeRequest.getIsActive())
//                .employeeAge(employeeRequest.getEmployeeAge())
//                .build();
//        return employeeRepository.save(employee);
//    }




    @Override
    public Employee addTestEmployee(Request request) {
        return employeeRepository.save(request.getEmployee());
    }

}
