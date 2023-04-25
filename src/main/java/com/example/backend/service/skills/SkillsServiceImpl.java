package com.example.backend.service.skills;

import com.example.backend.entity.Skills;
import com.example.backend.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public Skills addSkill(Skills skills) {
        return skillsRepository.save(skills);
    }

    @Override
    public List<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }

    @Override
    public Skills getSkillById(Long id) {
        return skillsRepository.findById(id).orElse(null);
    }




}
