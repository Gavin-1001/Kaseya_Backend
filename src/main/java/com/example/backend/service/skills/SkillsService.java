package com.example.backend.service.skills;

import com.example.backend.entity.Skills;

import java.util.List;

public interface SkillsService {
    Skills addSkill(Skills skills);

    List<Skills> getAllSkills();

    Skills getSkillById(Long id);


    void deleteSkill(Long id);
}
