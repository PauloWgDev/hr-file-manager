package com.pankosdev.hrmanager.Services;

import com.pankosdev.hrmanager.DOTs.SkillDTO;
import com.pankosdev.hrmanager.Entities.Skill;
import com.pankosdev.hrmanager.Repositories.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository)
    {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills()
    {
        return skillRepository.findAll();
    }
}
