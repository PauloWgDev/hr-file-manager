package com.pankosdev.hrmanager.Repositories;

import com.pankosdev.hrmanager.Entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    Optional<Skill> findByName(String name);
}
