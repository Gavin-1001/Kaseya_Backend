package com.example.backend.service.emoployeeService;


import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllUsers() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
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

            //skill level
            if (Objects.nonNull(employee.getEmployeeSkillLevel()) && !"".equalsIgnoreCase(employee.getEmployeeSkillLevel())) {
                updateEmployee.setEmployeeSkillLevel(employee.getEmployeeSkillLevel());
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


}
