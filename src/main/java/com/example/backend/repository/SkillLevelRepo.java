package com.example.backend.repository;

import com.example.backend.entity.SkillsLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillLevelRepo extends JpaRepository<SkillsLevel, String> {
}
