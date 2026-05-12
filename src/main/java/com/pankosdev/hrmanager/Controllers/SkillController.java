package com.pankosdev.hrmanager.Controllers;

import com.pankosdev.hrmanager.DOTs.SkillDTO;
import com.pankosdev.hrmanager.Entities.Skill;
import com.pankosdev.hrmanager.Services.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService)
    {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> getAllSkills()
    {
        return skillService.getAllSkills();
    }

    @PostMapping
    public Skill postSkill(SkillDTO skillDTO)
    {

    }
}
