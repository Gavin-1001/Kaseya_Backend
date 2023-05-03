package com.example.backend.service.addSkillToEmployee;


import com.example.backend.entity.AddSkillToEmployeeModel;
import com.example.backend.repository.AddSkillToEmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class AddSkillToEmployeeImpl implements AddSkillToEmployeeService{


    private final AddSkillToEmployeeRepository addSkillToEmployeeRepository;

    public AddSkillToEmployeeImpl(AddSkillToEmployeeRepository addSkillToEmployeeRepository) {
        this.addSkillToEmployeeRepository = addSkillToEmployeeRepository;
    }

    @Override
    public AddSkillToEmployeeModel saveASTES(AddSkillToEmployeeModel addSkillToEmployeeModel) {
        return addSkillToEmployeeRepository.save(addSkillToEmployeeModel) ;
    }
}
