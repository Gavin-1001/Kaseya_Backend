package com.example.backend.controller;

import com.example.backend.entity.Skills;
import com.example.backend.service.skillLevelService.SkillLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills/")
@CrossOrigin()
public class SkillsController {

    @Autowired
    private SkillLevelService skillsLevelService;

    //addSkill
    @PostMapping("add")
    public ResponseEntity<?> addSkill(@RequestBody Skills skills){
        return ResponseEntity.ok(skillsLevelService.addSkill(skills));
    }


    //deleteSkill


}
