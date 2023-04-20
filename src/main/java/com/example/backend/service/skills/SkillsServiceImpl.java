package com.example.backend.service.skills;

import com.example.backend.entity.Skills;
import com.example.backend.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public Skills addSkill(Skills skills) {
        return skillsRepository.save(skills);
    }


}
