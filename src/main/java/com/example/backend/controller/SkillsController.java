package com.example.backend.controller;

import com.example.backend.entity.Skills;
import com.example.backend.service.skills.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills/")
@CrossOrigin()
public class SkillsController {

    @Autowired
    private SkillsService skillService;

    //addSkill
    @PostMapping("add")
    public ResponseEntity<?> addSkill(@RequestBody Skills skills){
        return ResponseEntity.ok(skillService.addSkill(skills));
    }

    @GetMapping("getSkills")
    public ResponseEntity<?> getAllSkills(){
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @GetMapping("getSkillById/{id}")
    public ResponseEntity<?> getSkillById(@PathVariable Long id){
        return ResponseEntity.ok(skillService.getSkillById(id));
    }

}
