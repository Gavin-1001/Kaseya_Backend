package com.example.backend.repository;

import com.example.backend.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skills, Long> {
}
