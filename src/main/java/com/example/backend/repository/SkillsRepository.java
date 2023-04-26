package com.example.backend.repository;

import com.example.backend.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface SkillsRepository extends JpaRepository<Skills, Long>{

    @Modifying
    @Transactional
    void deleteSkillById(Long id);
}



