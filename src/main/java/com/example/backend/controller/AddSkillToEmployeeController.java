package com.example.backend.controller;


import com.example.backend.entity.AddSkillToEmployeeModel;
import com.example.backend.service.addSkillToEmployee.AddSkillToEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addSkillToEmployee")

public class AddSkillToEmployeeController {

    @Autowired
    private AddSkillToEmployeeService addSkillToEmployeeService;

    @PostMapping
    public ResponseEntity<?> saveAddSkillToEmployee(@RequestBody AddSkillToEmployeeModel addSkillToEmployeeModel){
        return new ResponseEntity<>(addSkillToEmployeeService.saveASTES(addSkillToEmployeeModel), HttpStatus.CREATED);
    }


}
