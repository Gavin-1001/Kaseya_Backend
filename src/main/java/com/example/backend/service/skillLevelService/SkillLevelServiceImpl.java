package com.example.backend.service.skillLevelService;

import com.example.backend.entity.Skills;

import com.example.backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillLevelServiceImpl implements SkillLevelService{

    @Autowired
    private SkillRepository skillLevelRepository;


    @Override
    public Skills addSkill(Skills skillsLevel) {
        return skillLevelRepository.save(skillsLevel);
    }
}
