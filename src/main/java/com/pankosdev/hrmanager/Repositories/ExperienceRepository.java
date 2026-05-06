package com.pankosdev.hrmanager.Repositories;

import com.pankosdev.hrmanager.Entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
